package tp1.eje4;

public class Pruebarda {
	public static void swap1(int x, int y) { // 1 , 2
		if (x < y) {
			int tmp = x; // 1
			x = y; // 2
			y = tmp; // 1
		}
	}

	public static void swap2(Integer x, Integer y) { // 3, 4
		if (x < y) {
			int tmp = x;
			x = y;
			y = tmp;
		}
	}

	public static void main(String[] args) {
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		swap1(a, b); // hace el cambio en el modulo pero como se pasan por valor, no se da la copia
		swap2(c, d); // sigue con el mismo valor, al ser inmutables cuando asigna un valor nuevo crea
						// un nuevo enlace al valor pero una vez terminado el modulo desaparece y
						// tampoco nunca corto enlace de la primera vez
		System.out.println("a=" + a + " b=" + b); // 1, 2
		System.out.println("c=" + c + " d=" + d); // 3, 4
	}
	// b good
	// c ñao
}
