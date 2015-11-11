package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import service.MailSender;

public class Monitor {

	//private static String RUTA_LOG = "C:/Users/template/Desktop/log.txt";
	private static String RUTA_LOG = "/home/estudiante/log.txt";
	
	public static void main(String[] args) {
		
        
            File archivo = new File(RUTA_LOG);
                 
            
            FileReader fr = null;
            BufferedReader br = null;

            try {
             
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);

                // Lectura del archivo
                String linea;
                
                int i=0;
                int error=0;
                while((linea=br.readLine())!=null){
                     if (linea.contains("ERROR")){
                    	 error++;
                    	 MailSender alerta=new MailSender();
               		  
                         String from = alerta.USER_NAME;
                         String pass = alerta.PASSWORD;
                         String[] to = { alerta.RECIPIENT,"sarachiher@gmail.com", "af.decastro879@gmail.com","jalex10@gmail.com" }; 
                         String subject = "fallo de disponibilidad en el sistema";
                         String body = "Se ha encntrado un fallo de disponibilidad en el sistema\n"
                         		+ "Revise el log inmediatamente.\n\n"
                         		+ linea;

                         alerta.sendFromGMail(from, pass, to, subject, body); 
                     }
                     i++;
                }
                if (i==0)System.out.println("Archivo log sin datos");
                if (error==0)System.out.println("Archivo log sin errores");
            }
            catch(Exception e){
                e.printStackTrace();
            }finally{
                //Cerramos el archivo
                try{                    
                    if( null != fr ){   
                    fr.close();     
                    }
                    
                }catch (Exception e2){ 
                    e2.printStackTrace();
                }
            }
        }
}
