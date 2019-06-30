package Programs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/TestJson")
public class JsonService 	
{
	@GET
	@Path("/display")
	@Produces("text/plain")
	public void display() {
	   System.out.println(new Entity().toString());
	}
	
    public static void main(String args[]){
	  //System.out.println("amol is a good boy"); 
    }
   
}

class Entity
{
	private int id;
	private String name;
	private String subject;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String toString(){
		return this.id + " " + this.name + " " + this.getSubject();
	}
}

