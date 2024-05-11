package tp2_Arboles.eje4.formaExtendiendome;

public class RedBinaria<T> extends BinaryTree<Integer> {

	public RedBinaria(Integer dato) {
		super(dato);
	}

	private int mayor(int a, int b) {
		int actual;

		if (a > b) {
			actual = a;
		} else {
			actual = b;
		}
		return actual;
	}

	private int helper(BinaryTree<Integer> dato) {
		int sumHi = 0;
		int sumHd = 0;
//		int casa2 = mayor(dato.getLeftChild().getData(), dato.getRightChild().getData() + 1);
//		int casa = mayor(dato.getLeftChild(), dato.getRightChild());
		if (dato.hasLeftChild()) {
//			System.out.println(" Imprimi!!!" + dato.getLeftChild());
//			System.out.println("77  " + dato.getData());
			sumHi = helper(dato.getLeftChild());
		}
		if (dato.hasRightChild()) {
			sumHd = helper(dato.getRightChild());
		}
//		System.out.println("izq: " + sumHi + " derech: " + sumHd);
//		System.out.println("suma :" + (mayor(sumHi, sumHd)) + (dato.getData()));
//		System.out.println("mayor :" + mayor(sumHi, sumHd));
//		System.out.println("dato actual: " + dato.getData());
//		System.out.println("------------------------------------------");

		return (mayor(sumHi, sumHd) + (dato.getData()));

	}

	public int retardio() {
		int suma = 0;
		if (!this.isEmpty()) {
			suma = helper(this);
		}
		return suma;
	}
}
