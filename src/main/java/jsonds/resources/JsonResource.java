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

		try {
			JsonStreamParser parser = new JsonStreamParser(new FileReader(FILENAME));
			Gson gson = new Gson();
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
