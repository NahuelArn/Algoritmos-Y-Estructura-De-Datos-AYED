package tp1.eje7;

public class PRUEBARDA {
	public static int[] metodo() {
		int vect[] = new int[5];

		for (int i = 0; i < 5; i++) {
			vect[i] = i;
		}

		return vect;
	}

	public static void main(String[] args) {
		int v[];
		v = metodo();
		for (int i = 0; i < 5; i++) {
			System.out.print(v[i]);
		}
	}
}
