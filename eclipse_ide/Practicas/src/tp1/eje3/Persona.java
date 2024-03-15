package tp1.eje3;

public abstract class  Persona {
	private String nombre;
	private String apellido;
	private String email;
	
	//constructor 
	public Persona(String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	//getters and setters
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String tusDatos() {
		String s = "nombre: "+this.getNombre()+ " apellido: "+this.getApellido()+ "email: "+this.getEmail();
		return s;
	}
}
