package sisarq.logic;

import java.util.*;

public class ColaEsperaConUrgencia {

	/**
	
	* Clase interna para almacenar los datos
	
	* de un cliente con urgencia
	
	*/
	
	private static class DatosCliente implements Comparable <DatosCliente>{
	
		Cliente c;
		Urgencia urg;
		
		DatosCliente (Cliente c, Urgencia urg) {
			this.c=c;
			this.urg=urg;
		}
	
		/**
		* Comparación de clientes por su urgencia
		*/
		public int compareTo(DatosCliente otro) {
			return this.urg.compareTo(otro.urg);
		
		}

	}// final de la clase DatosCliente

	// cola del servicio
	private Queue<DatosCliente> colaEspera;
	
	/**
	* Constructor de ColaEspera
	*/
	public ColaEsperaConUrgencia() {
		colaEspera=new PriorityQueue<DatosCliente>();
	}

	
	/**
	* Nuevo cliente; se mete en la cola de espera
	*/
	public void nuevoCliente (Cliente c, Urgencia urg){
		DatosCliente datos=new DatosCliente(c,urg);
		colaEspera.add(datos);
	}

	/**
	* Atender cliente: se saca de la cola de
	* espera; retorna el cliente atendido
	*/
	public Cliente atenderCliente() throws NoSuchElementException {
		DatosCliente datos=colaEspera.remove();
		return datos.c;
	}

	/**
	* Mostrar el estado de la cola de espera
	*/

	public String muestraEstado() {
		
		String estado = "\n--No atendidos "+colaEspera.size();
		

	
		for (DatosCliente datos:colaEspera) {
			estado = estado+ "\n"+datos.c+" urgencia: "+datos.urg;
		}
		return estado;
	}
	
	/**
	 * Num clientes en espera
	 */
	public int numClientesEnEspera() {
		return colaEspera.size();
	}
}