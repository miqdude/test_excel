package exceladdin;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/service")
public class ServiceServer {
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJson() {
		ArrayList<HashMap<String,Object>> ret = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String,Object> tmp = new HashMap<String,Object>();
		tmp.put("wow",1);
		tmp.put("hem",2);
		
		ret.add(tmp);
		
		HashMap<String,Object> tmp1 = new HashMap<String,Object>();
		tmp1.put("wow",1);
		tmp1.put("hem",2);
		
		ret.add(tmp1);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return Response.ok(gson.toJson(ret)).build();
	}
	
	@POST
	@Path("/test")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(@FormParam("param1") String nama1) {
		HashMap<String, Object> meh = new HashMap<String,Object>();
		meh.put("wew", 129);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return Response.ok(gson.toJson(meh)).build();
	}
}
