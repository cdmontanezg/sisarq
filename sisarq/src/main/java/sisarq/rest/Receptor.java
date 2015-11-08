package sisarq.rest;

import sisarq.logic.Clinica;
import sisarq.logic.ColaEsperaConUrgencia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sisarg.log.FormatterExample;

@Path("/receptor/")
public class Receptor {

	@GET
	@Produces("application/json")
    @Path("/{idClinica}/{pacientes}/{doctores}")
	public Response recibirInfo(@PathParam("pacientes") int pacientes, @PathParam("doctores") int doctores, @PathParam("idClinica") int id)
	{
		FormatterExample.createHandle("receptor");
		FormatterExample.LOGGER.info("Recibir información Disponibilidad Clínicas");
        Clinica.actualizarClinica(id, pacientes, doctores);
		return Response.status(200).build();
	}
}
