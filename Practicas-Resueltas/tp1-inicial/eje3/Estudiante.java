package tp1.eje3;

public class Estudiante extends Persona {
	private int comision;
	private String direccion;
	//constructor
	public Estudiante(String nombre, String apellido, String email, int comision, String direccion) {
		super(nombre, apellido, email);
		this.comision = comision;
		this.direccion = direccion;
	}
	
	//getters and setters
	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String s = super.tusDatos()+ " comision: "+this.getComision()+" direccion: "+this.getDireccion();
		return s;
	}
}
