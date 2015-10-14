package sisarq.rest;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sun.security.ntlm.Client;

import sisarq.logic.CalculadorDistancia;
import sisarq.logic.CalculadorMejoresClinicas;
import sisarq.logic.Cliente;
import sisarq.logic.ClinicaEmergencia;
import sisarq.logic.ColaEsperaConUrgencia;
import sisarq.logic.Criticidad;

@Path("/emergencia/")
public class Emergencia {

	@GET
	@Produces("text/html")
    @Path("{id}/{x}/{y}")
	public Response getStartingPage(@PathParam("id") String id, @PathParam("x") float x, @PathParam("y") float y)
	{
		ColaEsperaConUrgencia colaPrioridad = new ColaEsperaConUrgencia();
		Cliente cliente = new Cliente();
		cliente.setDocumento(Double.valueOf(id));
		cliente.setNombre("Nombre Prueba");
		cliente.setApellido("Apellido Prueba");
		cliente.setCriticidad(Criticidad.c10);	
		cliente.setUbicacionX(x);
		cliente.setUbicacionY(y);
		
		colaPrioridad.nuevoCliente(cliente);
		String respuesta =  "<h1>Estado de la cola<h1>" + colaPrioridad.muestraEstado();
		
		Cliente clienteatender = colaPrioridad.atenderCliente();
		
		CalculadorMejoresClinicas calculador= new CalculadorMejoresClinicas();
		
		ArrayList<ClinicaEmergencia> clinicas= calculador.getMejoresClinicas(clienteatender.getUbicacionX(),clienteatender.getUbicacionX());
		//respuesta = respuesta +"<br>Clinicas size "+clinicas.size();
		
		int i=0;
		for (ClinicaEmergencia clinicaEmergencia : clinicas) {
			respuesta = respuesta +"<br>Clinica Disponible "+i+": "+clinicaEmergencia.getClinica().getNombre()+"::: " + clinicaEmergencia.getPreferencia();
			i++;
		}
		respuesta = respuesta +"<br>";
		
		respuesta = respuesta+"<h1>Estado de la cola<h1>" + colaPrioridad.muestraEstado();
		return Response.status(200).entity(respuesta).build();
	}
}
