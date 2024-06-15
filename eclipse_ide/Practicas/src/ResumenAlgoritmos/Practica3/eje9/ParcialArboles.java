package ResumenAlgoritmos.Practica3.eje9;

import java.util.Iterator;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;

public class ParcialArboles {

	private static boolean helperSeleccion(GeneralTree<Integer> a) {
		if (a.isLeaf()) {
			return true;
		}
		int min = Integer.MAX_VALUE;
		List<GeneralTree<Integer>> children = a.getChildren();
		Iterator<GeneralTree<Integer>> iterador = children.iterator();
		boolean result = true;
		while (iterador.hasNext() && result) {// el iterator NO se salta el primer elemento
			GeneralTree<Integer> child = iterador.next();
			min = Math.min(min, child.getData());
			result = helperSeleccion(child);
		}

		return ((result) && (min == a.getData()));
	}

	public static boolean esDeSeleccion(GeneralTree<Integer> a) {
		boolean estado = false;
		if (a != null && !a.isEmpty()) {
			estado = helperSeleccion(a);
		}
		return estado;
	}

	public static void main(String[] args) {
		// Crear instancias de GeneralTree para representar el árbol
		GeneralTree<Integer> root = new GeneralTree<>(12);
		GeneralTree<Integer> node1 = new GeneralTree<>(12);
		GeneralTree<Integer> node2 = new GeneralTree<>(25);
//		GeneralTree<Integer> node3 = new GeneralTree<>(7);
//		GeneralTree<Integer> node4 = new GeneralTree<>(3);
//		GeneralTree<Integer> node5 = new GeneralTree<>(5);

		// Construir el árbol
		root.addChild(node1);
		root.addChild(node2);
//		node1.addChild(node3);
//		node1.addChild(node4);
//		node2.addChild(node5);

		// Probar el método esDeSeleccion
		System.out.println(ParcialArboles.esDeSeleccion(root)); // Debería imprimir true o false
	}
}
