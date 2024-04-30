package tp2_Arboles.eje7;

public class Estado {
	private boolean encontrado;
	
	public Estado() {
		this.encontrado = false;
	}
	
	public void setEstado(Boolean estado) {
		this.encontrado = estado;
	}
	public boolean getEstado() {
		return this.encontrado;
	}
}
