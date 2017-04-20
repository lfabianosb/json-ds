package jsonds.resources;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.JsonStreamParser;

@Path("/json")
public class JsonResource {
	private static final String FILENAME = ".\\flights.json";

	@GET
	@Produces("application/json")
	public String handleGreeting() {
		StringBuffer retorno = new StringBuffer("");
		
//		Flight flight = new Flight();
//		flight.setFrom("JPA");
//		flight.setTo("SAO");
//		flight.setDtDep("01/10/2017");
//		flight.setDtRet("10/11/2017");
//		flight.setPrice(12345.67f);

		Gson gson = new Gson();
		JsonStreamParser parser = null;
		try {
			parser = new JsonStreamParser(new FileReader(FILENAME));
			while (parser.hasNext()) {
				String json = gson.toJson(parser.next());
				retorno.append(json);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return retorno.toString();
	}
}
