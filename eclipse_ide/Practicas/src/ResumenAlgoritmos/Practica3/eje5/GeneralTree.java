package ResumenAlgoritmos.Practica3.eje5;

import java.util.LinkedList;
import java.util.List;

import ResumenAlgoritmos.Practica2.eje1y2.Queue;

public class GeneralTree<T> {
	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree() {

	}

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Retorna la toda la lista con los hijos
	 * 
	 * @return
	 */
	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	/**
	 * S
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return !this.children.isEmpty(); // llama al isEmpty default de Java
	}

	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child); // va eliminando el de mas a la izquierda, es Fifo
	}

	// ----------------------------SARACATUNGAAA-PUNTO3----------------------------
	public int altura() {
		return !this.isEmpty() ? helperAltura() : -1;
	}

	private int helperAltura() {
		if (this.isLeaf()) {
			return 0;
		} else {
			int max = Integer.MIN_VALUE;
			List<GeneralTree<T>> children = this.getChildren();
			for (GeneralTree<T> child : children) {
				max = Math.max(max, child.helperAltura()); // Llamada recursiva en el hijo
			}
			return (max + 1);
		}
	}

	// ----------------------------SARACATUNGAAA-PUNTO3----------------------------
	private int helperNivel(GeneralTree<T> a, T dato, int nivelActual) {
		if (a.getData().equals(dato)) {
			return nivelActual;
		} else {
			for (GeneralTree<T> i : a.getChildren()) {
				int nivelEncontrado = helperNivel(i, dato, nivelActual + 1);
				if (nivelEncontrado != -1) {
					return nivelEncontrado;
				}
			}
		}
		return -1; // Si llego aca no encontre lo que buscaba
	}

	public int nivel(T dato) {
		int nivel = 0;
		if (!this.isEmpty()) {
			nivel = helperNivel(this, dato, 0);
		}
		return nivel != -1 ? nivel : -1; // muy necesario
	}

	// ----------------------------SARACATUNGAAA-PUNTO3----------------------------
	public int ancho() {
		if ((this.data == null) || (this.isEmpty()))
			return -1;
		else
			return helpAncho();
	}

	private int helpAncho() { // tipo pasarela, de izq a derecha agotando
		int max = 0;
		int cantNodos = 0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);// PrIMERO ENQUEA UN VALOR
		cola.enqueue(null); // DESPUES ENQUEA UN NULL

		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null) { // SI YA PUSHEO TODOS LOS HIJOS ENTONCES EL PROXIMO SERIA UN NULL DE CAMBIO DE
								// NIVEL
				cantNodos++;
				List<GeneralTree<T>> children = aux.getChildren();
				for (GeneralTree<T> child : children) { // PUSHEA A TODOS LOS HIJOS
					cola.enqueue(child);
				}
			} else {
				max = Math.max(cantNodos, max);
				if (!cola.isEmpty()) {
					cantNodos = 0;
					cola.enqueue(null);
				}
			}
		}
		return max;
	}

	// -----------------------------BusquedaDFS------------------------------------------------
	private GeneralTree<T> helperBusquedaAncestro(GeneralTree<T> a, T cosa) {
		if (a.getData().equals(cosa)) {
			return a;
		} else {
			List<GeneralTree<T>> child = a.getChildren();
			for (GeneralTree<T> i : child) {
				GeneralTree<T> resultado = helperBusquedaAncestro(i, cosa);
				if (resultado != null) {
					return resultado;
				}
			}
		}
		return null;
	}

	public boolean esAncestro(T a, T b) { // recorrido por profundidad
		boolean estado = false;
		if (!this.isEmpty()) {
			GeneralTree<T> puntero = helperBusquedaAncestro(this, a);
			if (puntero != null) { // reutilizo el mismo memtodo, encontre el A? bueno te retorno el puntero a A,
				GeneralTree<T> nodoB = helperBusquedaAncestro(puntero, b); // ahora desde A buscame B, encontraste B? entonces cumple
				if (nodoB != null) {
					estado = true;
				}
			}
		}
		return estado;
	}

	//
	public static void main(String[] args) {
		// Crear instancias de GeneralTree
		GeneralTree<String> root = new GeneralTree<>("Root");
		GeneralTree<String> node1 = new GeneralTree<>("Child1");
		GeneralTree<String> node2 = new GeneralTree<>("Child2");
		GeneralTree<String> node3 = new GeneralTree<>("GrandChild1");
		GeneralTree<String> node4 = new GeneralTree<>("GrandChild2");

		// Construir el árbol
		root.addChild(node1);
		root.addChild(node2);
		node1.addChild(node3);
		node1.addChild(node4);

		// Probar el método esAncestro
		System.out.println(root.esAncestro("Root", "GrandChild1")); // true
		System.out.println(root.esAncestro("Child1", "GrandChild2")); // true
		System.out.println(root.esAncestro("Child2", "GrandChild1")); // false
		System.out.println(root.esAncestro("GrandChild1", "Child1")); // false
	}
}
