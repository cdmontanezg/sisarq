package sisarq.logic;

public class ClinicaEmergencia {
	
	private Clinica clinica;
	private int preferencia;
	
	public ClinicaEmergencia(Clinica clinica, int preferencia){
		this.clinica=clinica;
		this.preferencia=preferencia;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public int getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(int preferencia) {
		this.preferencia = preferencia;
	}
	
}
