package tp1.eje3;

public class Profesor extends Persona {
	private int catedra;
	private String facultad;
	//constructor
	public Profesor(String nombre, String apellido, String email, int catedra, String facultad) {
		super(nombre, apellido, email);
		this.catedra = catedra;
		this.facultad = facultad;
	}
		
	//getters and setters
	
	public int getCatedra() {
		return catedra;
	}

	public void setCatedra(int catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos() {
		String s = super.tusDatos()+ " catedra: "+this.getCatedra()+" facultad: "+this.getFacultad();
		return s;
	}
}
