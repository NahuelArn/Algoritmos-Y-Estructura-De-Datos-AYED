package ResumenAlgoritmos.Practica2.eje9;

public class Contenedor {
	private int sum;
	private int dif;

	public Contenedor(int sum, int dif) {
		this.sum = sum;
		this.dif = sum;
	}

	public Contenedor() {
		this.sum = 0;
		this.dif = 0;
	}

	public void setSum(int value) {
		this.sum = value;
	}

	public int getSum() {
		return this.sum;
	}

	public void setDif(int value) {
		this.dif = value;
	}

	public int getDif() {
		return this.dif;
	}

	@Override
	public String toString() {
		String s = "";
		s = " suma: " + this.sum + " diferencia: " + this.dif;
		return s;
	}
}
