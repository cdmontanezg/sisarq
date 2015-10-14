package sisarq.rest;

import sisarq.logic.Clinica;
import sisarq.logic.ColaEsperaConUrgencia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/receptor/")
public class Receptor {

	@GET
	@Produces("application/json")
    @Path("/{idClinica}/{pacientes}/{doctores}")
	public Response recibirInfo(@PathParam("pacientes") int pacientes, @PathParam("doctores") int doctores, @PathParam("idClinica") int id)
	{
        Clinica.actualizarClinica(id, pacientes, doctores);
		return Response.status(200).build();
	}
}
