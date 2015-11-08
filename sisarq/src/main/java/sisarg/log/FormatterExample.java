package sisarg.log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FormatterExample {

	public static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
	
	public static Logger createHandle(String name){

		Handler fileHandler = null;
		Formatter simpleFormatter = null;
		try{
			// Creating FileHandler
			String sName= new SimpleDateFormat("_yyyy_MM_dd").format(new Date());
			fileHandler = new FileHandler("./" + name.trim() + "log_"+sName+".log");
			
			// Creating SimpleFormatter
			simpleFormatter = new SimpleFormatter();
			
			// Assigning handler to logger
			LOGGER.addHandler(fileHandler);
			
			// Setting formatter to the handler
			fileHandler.setFormatter(new MyFormatter());		
			
			// Setting Level to ALL
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);
			
		}catch(IOException exception){
			LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
		}
		return LOGGER;
	}
	
	public static void main(String[] args) {
		FormatterExample.createHandle("example");
		FormatterExample.LOGGER.info("INFO EXAMPLE 1");
		FormatterExample.LOGGER.info("INFO EXAMPLE 2");
	}
}
