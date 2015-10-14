package sisarq.logic;

import java.util.ArrayList;

public class Clinica {

	private static ArrayList<Clinica> clinicasList;

	String nombre;
	float posx;
	float posy;
	int numeroPacientes;
	int numeroDoctores;
	
	public Clinica(float posx, float posy, String nombre){
		this.nombre=nombre;
		this.posx=posx;
		this.posy=posy;
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

	public static ArrayList<Clinica> getClinicasList() {
		if(clinicasList==null){
			clinicasList = new ArrayList<>();
			Clinica clin= new Clinica(10, 10, "Clinica 1");
			clinicasList.add(clin);
			clin= new Clinica(20, 20, "Clinica 2");
			clinicasList.add(clin);
			clin= new Clinica(16, 10, "Clinica 3");
			clinicasList.add(clin);
			clin= new Clinica(54, 37, "Clinica 4");
			clinicasList.add(clin);
			clin= new Clinica(18, 88, "Clinica 5");
			clinicasList.add(clin);
			clin= new Clinica(8, 11, "Clinica 6");
			clinicasList.add(clin);
			clin= new Clinica(15, 9, "Clinica 7");
			clinicasList.add(clin);
			clin= new Clinica(9, 12, "Clinica 8");
			clinicasList.add(clin);
			clin= new Clinica(33, 21, "Clinica 9");
			clinicasList.add(clin);
		}
		return clinicasList;
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
