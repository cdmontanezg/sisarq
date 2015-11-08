package sisarq.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sun.security.ntlm.Client;

import sisarg.log.FormatterExample;
import sisarq.logic.CalculadorDistancia;
import sisarq.logic.CalculadorMejoresClinicas;
import sisarq.logic.Cliente;
import sisarq.logic.Clinica;
import sisarq.logic.ClinicaEmergencia;
import sisarq.logic.ColaEsperaConUrgencia;
import sisarq.logic.Criticidad;

@Path("/emergencia/")
public class Emergencia {
	
	private static Criticidad [] arregloCriticidad = new Criticidad[]{Criticidad.c1,Criticidad.c2,Criticidad.c3,Criticidad.c4,
			Criticidad.c5,Criticidad.c6,Criticidad.c7,Criticidad.c8,Criticidad.c9,Criticidad.c10};

	private static ColaEsperaConUrgencia colaPrioridadAlta;// =
	
	private static ColaEsperaConUrgencia colaPrioridadBaja;
	
	Random randomGenerator = new Random();
	
	@GET
	@Produces("text/html")
    @Path("{id}/{x}/{y}")
	public Response getStartingPage(@PathParam("id") String id, @PathParam("x") float x, @PathParam("y") float y)
	{
		FormatterExample.createHandle("emergencia");
		FormatterExample.LOGGER.info("Nueva solicitud información clínicas Emergencia");
		
		Cliente cliente = new Cliente();
		cliente.setDocumento(Double.valueOf(id));
		cliente.setNombre("Nombre Prueba");
		cliente.setApellido("Apellido Prueba");
		
		cliente.setCriticidad(arregloCriticidad[randomGenerator.nextInt(10)]);	
		cliente.setUbicacionX(x);
		cliente.setUbicacionY(y);
		
		if(cliente.getCriticidad().compareTo(Criticidad.c4)<0){
			FormatterExample.LOGGER.info("Agregar cliente a cola de prioridad alta");
			getColaPrioridadAlta().nuevoCliente(cliente);
		} else {
			FormatterExample.LOGGER.info("Agregar cliente a cola de prioridad baja");
			getColaPrioridadBaja().nuevoCliente(cliente);
		}
		
		String respuesta =  "<h1>Estado de la cola<h1>" + colaPrioridadAlta.muestraEstado();
		
		Cliente clienteatender = getColaPrioridadAlta().atenderCliente();
		
		CalculadorMejoresClinicas calculador= new CalculadorMejoresClinicas();
		
		ArrayList<ClinicaEmergencia> clinicas= calculador.getMejoresClinicas(clienteatender.getUbicacionX(),clienteatender.getUbicacionX());
		//respuesta = respuesta +"<br>Clinicas size "+clinicas.size();
		
		int i=0;
		for (ClinicaEmergencia clinicaEmergencia : clinicas) {
			respuesta = respuesta +"<br>Clinica Disponible "+i+ ": "+clinicaEmergencia.getClinica().getNombre()+"::: " + clinicaEmergencia.getPreferencia();
			i++;
		}
		respuesta = respuesta +"<br>";
		
		respuesta = respuesta+"<h1>Estado de la cola<h1>" + colaPrioridadAlta.muestraEstado();
		return Response.status(200).entity(respuesta).build();
	}
	
	public static ColaEsperaConUrgencia getColaPrioridadAlta() {
		if(colaPrioridadAlta==null){
			colaPrioridadAlta =  new ColaEsperaConUrgencia();
		}
		return colaPrioridadAlta;
	}
	public static ColaEsperaConUrgencia getColaPrioridadBaja() {
		if(colaPrioridadBaja==null){
			colaPrioridadBaja =  new ColaEsperaConUrgencia();
		}
		return colaPrioridadBaja;
	}
}

