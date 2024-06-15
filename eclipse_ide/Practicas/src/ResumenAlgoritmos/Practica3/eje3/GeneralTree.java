package ResumenAlgoritmos.Practica3.eje3;

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

	public static void main(String[] args) {
		// Crear el árbol general con datos de ejemplo
		GeneralTree<Integer> root = new GeneralTree<>(10);
		GeneralTree<Integer> child1 = new GeneralTree<>(20);
		GeneralTree<Integer> child2 = new GeneralTree<>(30);
		GeneralTree<Integer> child3 = new GeneralTree<>(40);
		GeneralTree<Integer> child4 = new GeneralTree<>(50);
		GeneralTree<Integer> child5 = new GeneralTree<>(60);

		// Construir el árbol
		root.addChild(child1);
		root.addChild(child2);
		child1.addChild(child3);
		child1.addChild(child4);
		child2.addChild(child5);

//		// Crear la instancia de la clase que contiene el método altura
//		ParcialArboles pa = new ParcialArboles();

		// Calcular y mostrar la altura del árbol
		int altura = root.altura();
		System.out.println("La altura del árbol es: " + altura);
		System.out.println("La nivel del árbol es: " + root.nivel(60));
		System.out.println("La ancho del árbol es: " + root.ancho());
	}
}
