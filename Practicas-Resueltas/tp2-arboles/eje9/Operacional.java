package tp2_Arboles.eje9;

public class Operacional {
	private int suma;
	private int diferencia;

	public Operacional() {
		suma = 0;
		diferencia = 0;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public int getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(int diferencia) {
		this.diferencia = diferencia;
	}

	@Override
	public String toString() {
		String s = "";
		s = " suma: " + this.suma + " diferencia: " + this.diferencia;
		return s;
	}
}
