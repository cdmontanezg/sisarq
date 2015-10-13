package sisarq.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import sisarq.logic.ColaEsperaConUrgencia;

@Path("/emergencia/")
public class Emergencia {

	@GET
	@Produces("text/html")
	public Response getStartingPage()
	{
		ColaEsperaConUrgencia colaPrioridad = new ColaEsperaConUrgencia();
		colaPrioridad.muestraEstado();
		
		String output = "<h1>Estado de la cola<h1>" + colaPrioridad.muestraEstado();
		return Response.status(200).entity(output).build();
	}
}
