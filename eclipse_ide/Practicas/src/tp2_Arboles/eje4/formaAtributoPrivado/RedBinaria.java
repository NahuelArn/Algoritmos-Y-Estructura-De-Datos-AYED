package tp2_Arboles.eje4.formaAtributoPrivado;

public class RedBinaria {

	private BinaryTree<Integer> arbolardo;

	public RedBinaria(BinaryTree<Integer> a) {
		this.arbolardo = a;
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
		if (dato.isEmpty()) {
			return 0;
		} else {
			if (!dato.isLeaf()) {
				// estas impresiones para este caso puntual no sirven, estan mal planteadas
//				System.out.println("izq: " + dato.getLeftChild() + " derech: " + dato.getRightChild());
//				System.out.println("suma :" + (mayor(dato.getLeftChild().getData(), dato.getRightChild().getData())) + (dato.getData()));
//				System.out.println("mayor :" + mayor(dato.getLeftChild().getData(), dato.getRightChild().getData()));
//				System.out.println("dato actual: " + dato.getData());
//				System.out.println("primer retorno: " + dato.getData() + mayor(helper(dato.getLeftChild()), helper(dato.getRightChild())));
//				System.out.println("------------------------------------------");
				return dato.getData() + mayor(helper(dato.getLeftChild()), helper(dato.getRightChild()));
			} else {
				return dato.getData();
			}
		}

	}

	public int retardio() {
		int suma = 0;
		if (!arbolardo.isEmpty()) {
			suma = helper(arbolardo);
		}
		return suma;
	}
}
