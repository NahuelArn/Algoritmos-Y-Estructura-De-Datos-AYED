package tp3_Practica.eje3;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje2.Queue;

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
			children.remove(child);
	}

	public void preOrder() { // si me mandan un arbol explota pal carajo
		System.out.println(getData());
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child : children) {
			child.preOrder();
		}
	}

	private void helperInOrden(GeneralTree<Integer> a) {
		List<GeneralTree<Integer>> children = a.getChildren();
		// procesamos los primeros hijos, full izquierda
		if (a.hasChildren()) {
			helperInOrden(children.get(0));
		}
		// procesamos la raiz
		int datoActual = a.getData();
		System.out.println("dato: " + datoActual + " | ");
		// procesamos los demas hijos (omitiendo el primero (0))
		for (int i = 1; i < children.size(); i++) { // comenzamos a partir del 0+1;
			helperInOrden(children.get(i));
		}
	}

	public void inOrder(GeneralTree<Integer> a, int n) {
		if (a != null && !a.isEmpty()) {
			helperInOrden(a);
		}
	}

	public void postOrden() {
		List<GeneralTree<T>> children = this.getChildren();
		// Recorre los hijos en orden
		for (GeneralTree<T> child : children) {
			child.postOrden();
		}
		// Imprime el dato del nodo actual
		System.out.println(getData());
	}

	// ------------------------ALTURA-------------------------------------------------------

	// RECORRIDO EN PROFUNDIDAD
	private int helperAltura(GeneralTree<T> a) {
		if (a.isLeaf()) {
			return 0;
		} else {
			int nivel, max = 0;
			List<GeneralTree<T>> child = a.getChildren();
			for (GeneralTree<T> i : child) {
				nivel = i.helperAltura(a) + 1;
				max = Math.max(nivel, max);
			}
			return max;
		}
	}

	/*
	 * retorna la altura del arbol, utilizando el recorrido en profundidad
	 * return @param
	 */
	public int altura() {
		int n = 0;
		if (this != null && !this.isEmpty()) {
			n = helperAltura(this);
		}
		return n;
	}

//------------------------NIVEL-------------------------------------------------------

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
		return -1;
	}

	public int nivel(T dato) {
		int nivel = 0;
		if (this != null && !this.isEmpty()) {
			nivel = helperNivel(this, dato, 0);
		}
		return nivel != -1 ? nivel : -1;
	}

//	Por que hacer un helper? no es necesario, no necesito implementar recursividad ni tampoco es un modulo q se va reutilizar
//	private int helperAncho() {
//		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
//		int cantNodos = 0;
//		int max = 0;
//		queue.enqueue(this);
//
//		while (!queue.isEmpty()) {
//			GeneralTree<T> arbolActual = queue.dequeue();
//			cantNodos++;
//			List<GeneralTree<T>> childActual = arbolActual.getChildren();
//
//			for (GeneralTree<T> i : childActual) {
//				i.ancho();
//			}
//			Math.max(cantNodos, max);
//		}
//		return max;
//	}

	// -------------------------------ANCHO--------------------------------------------
	public int ancho() {
		int longitudMax = 0;
		if (this != null && !this.isEmpty()) { // validamos
			Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
			int cantNodos = 0;
			queue.enqueue(this); // pusheamos el padre
			while (!queue.isEmpty()) {
				cantNodos = queue.size();
				longitudMax = Math.max(cantNodos, longitudMax);
				for (int i = 0; i < cantNodos; i++) {
					GeneralTree<T> arbolActual = queue.dequeue();
					if (arbolActual.hasChildren()) {
						List<GeneralTree<T>> childActual = arbolActual.getChildren();
						for (GeneralTree<T> o : childActual) {
							queue.enqueue(o);

						}
					}

				}
			}
		}
		return longitudMax;
	}

}
