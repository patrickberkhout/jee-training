package training;

import javax.json.Json;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jgroups.util.*;
@Path("/service")
public class RestService {
	@GET
	@Path("/hello")
	@Produces({ "application/json" })
	public String hello() {

		// DOCS https://docs.oracle.com/javaee/7/tutorial/jsonp003.htm

		JsonObject model = Json.createObjectBuilder().add("result", "Hello, world").build();
		return model.toString();
	}
	@GET
	@Path("/jgroups")
	@Produces({ "application/json" })
	public String jgroups() {

		JsonObject model = Json.createObjectBuilder().add("Util.MAX_LIST_PRINT_SIZE", Util.MAX_LIST_PRINT_SIZE).build();
		return model.toString();
	}
}
