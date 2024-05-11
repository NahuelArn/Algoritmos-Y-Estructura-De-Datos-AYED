package tp2_Arboles.eje3;

import java.util.ArrayList;

public class ContadorArbol {

	private BinaryTree<Integer> a;

	/** @param espera un arbol ya cargado **/
	public ContadorArbol(BinaryTree<Integer> a) {
		this.a = a;
	}

	private boolean esPar(int a) {
		return a % 2 == 0;
	}

	private ArrayList<Integer> recorridoEstructuraHelper(ArrayList<Integer> vD, BinaryTree<Integer> a) {
		if (a.getData() != null) {
			if (a.hasLeftChild()) {
				recorridoEstructuraHelper(vD, a.getLeftChild());
			}
			if (esPar(a.getData())) {
				vD.add(a.getData());
			}
			if (a.hasRightChild()) {
				recorridoEstructuraHelper(vD, a.getRightChild());
			}
		}

		return vD;
	}

	public ArrayList<Integer> numerosPares() {
		ArrayList<Integer> vD = new ArrayList<>();
		if (!this.a.isEmpty()) {
//			ArrayList<Integer> vD = new ArrayList<>();
			recorridoEstructuraHelper(vD, this.a);
		}
		return vD;
	}

	private ArrayList<Integer> recorridoPosOrderHelper(ArrayList<Integer> x, BinaryTree<Integer> a) { // full izquierda, derecha y medio
		if (a.getData() != null) {
			if (a.hasLeftChild()) {
				recorridoPosOrderHelper(x, a.getLeftChild());
			}
			if (a.hasRightChild()) {
				recorridoPosOrderHelper(x, a.getRightChild());
			}
			if (esPar(a.getData())) {
				x.add(a.getData());
			}
		}
		return x;
	}

	public ArrayList<Integer> numerosParesV2() {
		ArrayList<Integer> x = new ArrayList<>();
		if (!a.isEmpty()) {
			recorridoPosOrderHelper(x, this.a);
		}
		return x;
	}
}
