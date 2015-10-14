package sisarq.logic;
import java.sql.Time;

public class CalculadorDistancia {

	
	public static int getDistancia(float clinx, float cliny, float pacx, float pacy){
		int distancia=0;
		distancia= (int) Math.sqrt((Math.pow(clinx - pacx, 2))+(Math.pow(cliny - pacy, 2)));
		return distancia;
	}
	
	
	
	
}
