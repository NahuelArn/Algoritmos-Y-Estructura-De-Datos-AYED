package ResumenAlgoritmos.Practica3.eje2;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;

public class RecorridosAg {
	private boolean esImparMayor(int a, int n) {
		return (a > n) && (a % 2 != 0);
	}

	private void helperPreOrden(GeneralTree<Integer> a, LinkedList<Integer> lista, Integer n) {
		int valorActual = a.getData();
		if (esImparMayor(valorActual, n)) {
			lista.add(valorActual);
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> i : a.getChildren()) {
			helperPreOrden(i, lista, n);
		}
	}

	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
		LinkedList<Integer> lista = new LinkedList<>();
		if (!a.isEmpty()) {
			helperPreOrden(a, lista, n);
		}
		return lista;
	}

	private void helperInOrder(GeneralTree<Integer> a, LinkedList<Integer> lista, Integer n) {
//		List<GeneralTree<Integer>> children = a.getChildren();
		if (a.hasChildren()) {
			helperInOrder(a.getChildren().get(0), lista, n);
		}
		int valorActual = a.getData();

		if (esImparMayor(valorActual, n)) {
			lista.add(valorActual);
		}
		for (int i = 1; i < a.getChildren().size(); i++) {
			helperInOrder(a.getChildren().get(i), lista, n);
		}
	}

	public List<Integer> numerosImparesMayoresQueInOrder(GeneralTree<Integer> a, Integer n) {
		LinkedList<Integer> lista = new LinkedList<>();
		if (!a.isEmpty()) {
			helperInOrder(a, lista, n);
		}
		return lista;
	}

	private void helperPostOrden(GeneralTree<Integer> a, LinkedList<Integer> lista, Integer n) {
		for (GeneralTree<Integer> child : a.getChildren()) {
			helperPostOrden(child, lista, n);
		}
		int valorActual = a.getData();
		if (esImparMayor(valorActual, n)) {
			lista.add(valorActual);
		}
	}

	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
		LinkedList<Integer> lista = new LinkedList<>();
		if (!a.isEmpty()) {
			helperPostOrden(a, lista, n);
		}
		return lista;
	}

	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
		LinkedList<Integer> lista = new LinkedList<>();
		if (!a.isEmpty()) {
			Queue<GeneralTree<Integer>> queue = new Queue<>();
			queue.enqueue(a);
			while (!queue.isEmpty()) {
				GeneralTree<Integer> padreActual = queue.dequeue();
				if (esImparMayor(padreActual.getData(), n)) {
					lista.add(padreActual.getData());
				}
				for (GeneralTree<Integer> child : padreActual.getChildren()) { // vos te traes a los hijos y el forEach itera sobre cada hina
					queue.enqueue(child);
				}
			}
		}
		return lista;
	}

	// 25 | 15 | 30 | 10 | 35 | 20 | 40 | 45 |
	public void inOrderPrueba(GeneralTree<Integer> a) {
		if (a.hasChildren()) {
			inOrderPrueba(a.getChildren().get(0));
		}
		System.out.print(a.getData() + " | ");
		for (int i = 1; i < a.getChildren().size(); i++) {
			inOrderPrueba(a.getChildren().get(i));
		}
	}

	public static void main(String[] args) {
		// Crear el árbol general
		GeneralTree<Integer> arbol = new GeneralTree<>(10);
		GeneralTree<Integer> nodo1 = new GeneralTree<>(15);
		GeneralTree<Integer> nodo2 = new GeneralTree<>(20);
		GeneralTree<Integer> nodo3 = new GeneralTree<>(25);
		GeneralTree<Integer> nodo4 = new GeneralTree<>(30);
		GeneralTree<Integer> nodo5 = new GeneralTree<>(35);
		GeneralTree<Integer> nodo6 = new GeneralTree<>(40);
		GeneralTree<Integer> nodo7 = new GeneralTree<>(45);

		arbol.addChild(nodo1);
		arbol.addChild(nodo2);

		nodo1.addChild(nodo3);
		nodo1.addChild(nodo4);

		nodo2.addChild(nodo5);
		nodo2.addChild(nodo6);

		nodo2.addChild(nodo7);

		// IMPARESSSSSSSSSSSSSSS

		// Instanciar RecorridosAg y probar métodos
		RecorridosAg recorridos = new RecorridosAg();
		int n = 18;
		System.out.println("Prueba inOrder ");
		recorridos.inOrderPrueba(arbol);
		System.out.println();
		// PreOrden
		List<Integer> preOrdenResult = recorridos.numerosImparesMayoresQuePreOrden(arbol, n);
		System.out.println("Números impares mayores que " + n + " en PreOrden: " + preOrdenResult);

		// InOrder
		List<Integer> inOrdenResult = recorridos.numerosImparesMayoresQueInOrder(arbol, n);
		System.out.println("Números impares mayores que " + n + " en InOrder: " + inOrdenResult);

		// PostOrden
		List<Integer> postOrdenResult = recorridos.numerosImparesMayoresQuePostOrden(arbol, n);
		System.out.println("Números impares mayores que " + n + " en PostOrden: " + postOrdenResult);

		// Por Niveles
		List<Integer> porNivelesResult = recorridos.numerosImparesMayoresQuePorNiveles(arbol, n);
		System.out.println("Números impares mayores que " + n + " por Niveles: " + porNivelesResult);
	}
}
