package sisarq.logic;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Logger;

import sisarg.log.FormatterExample;

public class CalculadorDistancia {

	private static Logger LOGGER = Logger.getLogger("InfoLogging");
	
	public static int getDistancia(float clinx, float cliny, float pacx, float pacy){
		int distancia=0;
		distancia= (int) Math.sqrt((Math.pow(clinx - pacx, 2))+(Math.pow(cliny - pacy, 2)));
		FormatterExample.LOGGER.info("Distancia = " + distancia);
		return distancia;
	}
	
	
	
	
}
