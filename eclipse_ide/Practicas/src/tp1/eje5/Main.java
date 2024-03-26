package tp1.eje5;

public class Main {
	// para el punto C
	private static int vectorC[];
	private static ClaseMagaibera puntoC;

	public static void main(String[] args) {
		int vector[] = { 1, 2, 3, 4, 5 };
		// A--------------------Anda Joya------------------------------------------
//		String resultado = magaiba(vector);
//		System.out.println(resultado);
		// B--------------------Anda Joya------------------------------------------
//		ClaseMagaibera puntoB = new ClaseMagaibera(); // default contructor
//		puntoB.setVector(vector);
//		opcion_b(puntoB);
//
//		System.out
//				.println("promedio: " + puntoB.getPromedio() + " min: " + puntoB.getMin() + " max: " + puntoB.getMax());

		// C-----------------------Anda joya---------------------------------------
		vectorC = vector; // copio el contendio
		puntoC = new ClaseMagaibera();
		puntoC.setVector(vectorC);
		opcion_c();
		System.out
				.println("promedio: " + puntoC.getPromedio() + " min: " + puntoC.getMin() + " max: " + puntoC.getMax());
	}

	// A
	public static String magaiba(int vector[]) {
		int max = -9999, min = 9999, suma = 0;
		for (int elemento : vector) { // tipo nombre, estructura
			if (elemento > max) {
				max = elemento;
			}
			if (elemento < min) {
				min = elemento;
			}
			suma += elemento;
		}
		return "Valores. maximo: " + max + " minimo: " + min + " promedio: " + (suma / vector.length);
	}

	// B
	public static void opcion_b(ClaseMagaibera puntoB) {
		int max = -9999, min = 9999, suma = 0;
		int[] vector = puntoB.getVector();
		for (int elemento : vector) { // tipo nombre, estructura
			if (elemento > max) {
				max = elemento;
			}
			if (elemento < min) {
				min = elemento;
			}
			suma += elemento;
		}
		puntoB.setMax(max);
		puntoB.setMin(min);
		puntoB.setPromedio(suma / vector.length);
	}

	// C
	public static void opcion_c() { // SI PODIAS RECIBIR LOS PARAMETROS.. LO ENTENDI MAL // Devuelva lo pedido sin
									// usar parámetros ni la sentencia "return". sin usar los parametros como
									// opcionn de retorno pero para comunicar Si podias
		// Variables locales para almacenar los resultados
		int max = -9999, min = 9999, suma = 0;

		// Calcular los resultados
		for (int elemento : vectorC) {
			if (elemento > max) {
				max = elemento;
			}
			if (elemento < min) {
				min = elemento;
			}
			suma += elemento;
		}

		// Crear una nueva instancia de claseMagaibera y almacenar los resultados
		puntoC.setMax(max);
		puntoC.setMin(min);
		puntoC.setPromedio(suma / vectorC.length);
	}
}
