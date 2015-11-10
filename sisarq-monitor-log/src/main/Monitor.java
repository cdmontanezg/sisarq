package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import service.MailSender;

public class Monitor {

	private static String RUTA_LOG = "C:/Users/template/Desktop/log.txt";
	
	public static void main(String[] args) {
		
        
            File archivo = new File(RUTA_LOG);
                 
            
            FileReader fr = null;
            BufferedReader br = null;

            try {
             
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);

                // Lectura del archivo
                String linea;
                
               
                while((linea=br.readLine())!=null){
                     if (linea.contains("ERROR")){
                    	 MailSender alerta=new MailSender();
               		  
                         String from = alerta.USER_NAME;
                         String pass = alerta.PASSWORD;
                         String[] to = { alerta.RECIPIENT }; 
                         String subject = "fallo de disponibilidad en el sistema";
                         String body = "Se ha encntrado un fallo de disponibilidad en el sistema\n"
                         		+ "Revise el log inmediatamente.\n\n"
                         		+ linea;

                         alerta.sendFromGMail(from, pass, to, subject, body); 
                     }
                }
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
                File realName = new File(archivo.getPath());
                realName.delete(); // remove the old file
                File nuevo = new File(archivo.getPath()+".temp");
                nuevo.renameTo(realName);      
            }
        }
}
