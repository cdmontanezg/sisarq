package sisarq.logic;

import java.util.ArrayList;
import java.util.Random;

import sisarg.log.FormatterExample;

public class Clinica {

	private static ArrayList<Clinica> clinicasList;

    private static final int NUM_CLINICAS = 80;

	String nombre;
	int id;
	float posx;
	float posy;
	int numeroPacientes;
	int numeroDoctores;
    int tiempoEspera;
	
	public Clinica(float posx, float posy, String nombre, int id){
		this.nombre=nombre;
		this.posx=posx;
		this.posy=posy;
		this.id = id;
		numeroDoctores= 0;
		numeroPacientes= 0;
	}

	public int getNumeroPacientes() {
		return numeroPacientes;
	}

	public void setNumeroPacientes(int numeroPacientes) {
		this.numeroPacientes = numeroPacientes;
	}

	public int getNumeroDoctores() {
		return numeroDoctores;
	}

	public void setNumeroDoctores(int numeroDoctores) {
		this.numeroDoctores = numeroDoctores;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

	public static ArrayList<Clinica> getClinicasList() {
		if(clinicasList==null){
			clinicasList = new ArrayList<>();
			for (int i = 0; i < NUM_CLINICAS; i++) {
				Random rnd = new Random();
				Clinica clin= new Clinica(rnd.nextInt(NUM_CLINICAS), rnd.nextInt(NUM_CLINICAS), "Clinica "+i, i);
				clinicasList.add(clin);
			}
		}
		return clinicasList;
	}

    public static void actualizarClinica(int id, int pacientes, int doctores){
    	FormatterExample.LOGGER.info("Actualizar Clínica <Pacientes: " + pacientes + "> <Doctores: " + doctores + ">");
        getClinicasList();
        clinicasList.get(id).setNumeroDoctores(doctores);
        clinicasList.get(id).setNumeroPacientes(pacientes);
        clinicasList.get(id).setTiempoEspera(CalculadorTiempoEspera.getTiempoEsperaEnMinutos(pacientes, doctores));
    }

	public String getNombre() {
		return nombre;
	}

	public float getPosx() {
		return posx;
	}

	public float getPosy() {
		return posy;
	}
}
