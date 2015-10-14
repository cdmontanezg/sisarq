package sisarq.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CalculadorMejoresClinicas {
	
	private static final int BAJA= 1;
	private static final int MEDIA= 2;
	private static final int ALTA= 3;
	
	private ArrayList<ClinicaEmergencia> clinicasEmergencia;
	
	@SuppressWarnings("unchecked")
	public ArrayList<ClinicaEmergencia> getMejoresClinicas(float pacientex, float pacientey){
		ArrayList<Clinica> clinicas= Clinica.getClinicasList();
		clinicasEmergencia = new ArrayList<ClinicaEmergencia>();
		int distancia= -1;
		int tiempoEspera= -1;
		int preferenciaDist= -1;
		int preferenciaTiempo= -1;
		for (Clinica clinica : clinicas) {
//			Random rnd = new Random();
//			int randmVal= rnd.nextInt(5);
//			clinica.setNumeroDoctores(randmVal);
//			randmVal= rnd.nextInt(30);
//			clinica.setNumeroPacientes(randmVal);
			distancia= CalculadorDistancia.getDistancia(clinica.getPosx(), clinica.getPosy(), pacientex, pacientey);
			tiempoEspera= CalculadorTiempoEspera.getTiempoEsperaEnMinutos(clinica.getNumeroPacientes(), clinica.getNumeroDoctores());
			preferenciaDist= analizarDistancia(distancia);
			preferenciaTiempo= analizarTiempoEspera(tiempoEspera);
			if(preferenciaDist!=-1 && preferenciaTiempo!=-1 && clinicasEmergencia.size()<3){
				ClinicaEmergencia clinEmerg= new ClinicaEmergencia(clinica, preferenciaDist+preferenciaTiempo);
				clinicasEmergencia.add(clinEmerg);
			}
			distancia= -1;
			tiempoEspera= -1;
			preferenciaDist= -1;
			preferenciaTiempo=-1;
		}
		Collections.sort(clinicasEmergencia, new Comparator<ClinicaEmergencia>(){
			@Override
			public int compare(ClinicaEmergencia ce1, ClinicaEmergencia ce2){
				return new Integer(ce2.getPreferencia()).compareTo(new Integer(ce1.getPreferencia()));
			}
		});
		return clinicasEmergencia;
	}
	
	public int analizarDistancia(int distancia){
		if(distancia>=0 && distancia<=10) return ALTA;
		if(distancia>10 && distancia<=50) return MEDIA;
		if(distancia>50) return BAJA;
		return -1;
	}
	
	public int analizarTiempoEspera(int tiempoEspera){
		if(tiempoEspera!=-1){
			if(tiempoEspera>=0 && tiempoEspera<=30) return ALTA;
			if(tiempoEspera>30 && tiempoEspera<=90) return MEDIA;
			if(tiempoEspera>90) return BAJA;
			return -1;
		}
		else return -1;
	}
	
	public static void main(String[] args) {
		CalculadorMejoresClinicas calc= new CalculadorMejoresClinicas();
		ArrayList<ClinicaEmergencia> clinicasEmergenica= calc.getMejoresClinicas(11,45);
		System.out.println("CLINICAS EMERGENCIA");
		for (ClinicaEmergencia clinicaEmergencia : clinicasEmergenica) {
			System.out.println(clinicaEmergencia.getClinica().getNombre() + "::: " + clinicaEmergencia.getPreferencia());
		}
	}
	
}
