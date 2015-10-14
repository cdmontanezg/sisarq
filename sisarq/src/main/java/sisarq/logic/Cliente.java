package sisarq.logic;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private Double documento;
	private Criticidad criticidad;
	private float ubicacionX;
	private float ubicacionY;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Double getDocumento() {
		return documento;
	}
	public void setDocumento(Double documento) {
		this.documento = documento;
	}
	public Criticidad getCriticidad() {
		return criticidad;
	}
	public void setCriticidad(Criticidad criticidad) {
		this.criticidad = criticidad;
	}
	public float getUbicacionX() {
		return ubicacionX;
	}
	public void setUbicacionX(float ubicacionX) {
		this.ubicacionX = ubicacionX;
	}
	public float getUbicacionY() {
		return ubicacionY;
	}
	public void setUbicacionY(float ubicacionY) {
		this.ubicacionY = ubicacionY;
	}
	
	
	
	
}
