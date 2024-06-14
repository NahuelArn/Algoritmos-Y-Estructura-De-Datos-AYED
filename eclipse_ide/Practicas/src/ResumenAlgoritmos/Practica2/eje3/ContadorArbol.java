package ResumenAlgoritmos.Practica2.eje3;

import java.util.LinkedList;

import ResumenAlgoritmos.Practica2.eje1y2.BinaryTree;

/*
 *Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden.
 * 
*/
//esto esta hecho para un arbol de Integers
public class ContadorArbol<T> {
	private BinaryTree<Integer> a;

	public ContadorArbol(BinaryTree<Integer> a) {
		this.a = a;
	}

	private boolean divisible(Integer num, Integer div) {
		return num % div == 0;
	}

	private LinkedList<Integer> recorridoInOrder(LinkedList<Integer> lista, BinaryTree<Integer> a) {
		if (!a.isEmpty()) {
			if (a.hasLeftChild()) {
				recorridoInOrder(lista, a.getLeftChild());
			}
			Integer elementoActual = a.getData();
			if (divisible(elementoActual, 2)) {
				lista.add(elementoActual);
			}
			if (a.hasRightChild()) {
				recorridoInOrder(lista, a.getRightChild());
			}
		}
		return lista;
	}

	private LinkedList<Integer> recorridoPosOrden(LinkedList<Integer> lista, BinaryTree<Integer> a) {
		if (!a.isEmpty()) {
			if (a.hasLeftChild()) {
				recorridoPosOrden(lista, a.getLeftChild());
			}
			if (a.hasRightChild()) {
				recorridoPosOrden(lista, a.getRightChild());
			}
			Integer elementoActual = a.getData();
			if (divisible(elementoActual, 2)) {
				lista.add(elementoActual);
			}
		}
		return lista;
	}

	// Metodo que devuelve los numeros pares utilizando recorrido in-order
	public LinkedList<Integer> numerosParesInOrder() {
		LinkedList<Integer> lista = new LinkedList<>();
		if (!a.isEmpty()) {
			lista = recorridoInOrder(lista, a);
		}
		return lista;
	}

	// Metodo que devuelve los numeros pares utilizando recorrido post-order
	public LinkedList<Integer> numerosParesPosOrden() {
		LinkedList<Integer> lista = new LinkedList<>();
		if (!a.isEmpty()) {
			lista = recorridoPosOrden(lista, a);
		}
		return lista;
	}
//	public LinkedList<Integer> numerosPares() {
//		LinkedList<Integer> lista = new LinkedList<>();
//		if (!a.isEmpty()) {
//			lista = new LinkedList<>();
//			recorridoInOrder(lista, a);
//			recorridoPosOrden(lista = new LinkedList<>(), a);
//		}
//		return lista;
//	}

//}

	public static void main(String[] args) {
		// Crear el árbol binario y agregar datos
		BinaryTree<Integer> tree = new BinaryTree<>(1);
		tree.addLeftChild(new BinaryTree<>(2));
		tree.addRightChild(new BinaryTree<>(3));
		tree.getLeftChild().addLeftChild(new BinaryTree<>(4));
		tree.getLeftChild().addRightChild(new BinaryTree<>(8));
		tree.getRightChild().addLeftChild(new BinaryTree<>(6));
		tree.getRightChild().addRightChild(new BinaryTree<>(7));

		// Crear una instancia de ContadorArbol y obtener números pares
		ContadorArbol contador = new ContadorArbol(tree);
		LinkedList<Integer> paresInOrder = contador.numerosParesInOrder();
		LinkedList<Integer> paresPosOrden = contador.numerosParesPosOrden();

		// Imprimir los resultados
		System.out.println("Numeros pares (InOrder): " + paresInOrder);
		System.out.println("Numeros pares (PosOrden): " + paresPosOrden);
	}
}