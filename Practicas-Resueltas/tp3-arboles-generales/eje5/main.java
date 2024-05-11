package tp3_Practica.eje5;

import java.util.LinkedList;
import java.util.List;

public class main {
	public static void main(String[] args) {
		// Crear el árbol de ejemplo
		GeneralTree<Integer> raiz = new GeneralTree<>(100);

		List<GeneralTree<Integer>> children2 = new LinkedList<>();
		children2.add(new GeneralTree<>(5));
		GeneralTree<Integer> nodo2 = new GeneralTree<>(2, children2);

		List<GeneralTree<Integer>> children33 = new LinkedList<>();
		children33.add(new GeneralTree<>(6));
		children33.add(new GeneralTree<>(2));
		children33.add(new GeneralTree<>(8));
		GeneralTree<Integer> nodo33 = new GeneralTree<>(33, children33);

		List<GeneralTree<Integer>> children4 = new LinkedList<>();
		children4.add(new GeneralTree<>(6));
		children4.add(new GeneralTree<>(81));
		GeneralTree<Integer> nodo4 = new GeneralTree<>(4, children4);

		raiz.addChild(nodo2);
		raiz.addChild(nodo33);
		raiz.addChild(nodo4);

		// Verificar si 100 es ancestro de 81
		boolean esAncestro = raiz.esAncestro(100, 1211);
		System.out.println("¿100 es ancestro de 1211? " + esAncestro);
	}
}
