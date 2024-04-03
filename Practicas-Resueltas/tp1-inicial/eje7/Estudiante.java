package tp1.eje7;

public class Estudiante {
	private String nombre;
	private int legajo;

	// constructor
	public Estudiante(String nombre, int legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
	}

	// getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

}
