package sisarq.logic;
import java.sql.Time;

public class CalculadorTiempoEspera {

	private static final int TIEMPO_CITA=10;
	
	public static int getTiempoEsperaEnMinutos(int cantidadPacientes, int cantidadDoctores){
		if(cantidadDoctores!=0) return (cantidadPacientes*TIEMPO_CITA)/cantidadDoctores;
		else return -1;
	}
	
}
