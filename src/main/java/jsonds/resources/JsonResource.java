package jsonds.resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonStreamParser;

import jsonds.model.Flight;

@Path("/flights")
public class JsonResource {
	private static final String FILENAME = ".\\flights.json";

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFlights() {
		StringBuffer retorno = new StringBuffer("");

		try {
			JsonStreamParser parser = new JsonStreamParser(new FileReader(FILENAME));
			Gson gson = new Gson();
			while (parser.hasNext()) {
				retorno.append(gson.toJson(parser.next()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return Response.status(Response.Status.OK).entity(retorno.toString()).build();
	}

	// Read the FILENAME
	private String fileContent() {
		BufferedReader reader = null;
		StringBuffer retorno = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(FILENAME));
			String line;
			while ((line = reader.readLine()) != null) {
				retorno.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}

		return retorno.toString();
	}

	private List<Flight> get() {
		String json = fileContent();
		Gson gson = new Gson();
		Flight[] flightArray = gson.fromJson(json, Flight[].class);
		return new ArrayList<>(Arrays.asList(flightArray));
	}

	@POST
	@Path("/flight.json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFlight(String jsonFlight) {
		List<Flight> flights = get();
		String json = null;

		Gson gson = new Gson();
		Flight flight = gson.fromJson(jsonFlight, Flight.class);
		flights.add(flight);

		Writer writer = null;
		try {
			writer = new FileWriter(FILENAME);

			gson.toJson(flights, writer);
			json = gson.toJson(flight);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}

		return Response.status(Response.Status.CREATED).entity(json).build();
	}

	@POST
	@Path("/flights.json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(String jsonFlights) {
		Writer writer = null;
		try {
			writer = new FileWriter(FILENAME);
			Gson gson = new Gson();
			Flight[] flights = gson.fromJson(jsonFlights, Flight[].class);
			gson.toJson(flights, writer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}

		return Response.status(Response.Status.OK).build();
	}
}
