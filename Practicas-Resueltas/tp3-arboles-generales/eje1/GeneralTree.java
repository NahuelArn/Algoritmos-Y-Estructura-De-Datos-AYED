package tp3_Practica.eje1;

import java.util.LinkedList;
import java.util.List;

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

	public int altura() {

		return 0;
	}

	public int nivel(T dato) {
		return 0;
	}

	public int ancho() {

		return 0;
	}

	public void preOrder() {
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

}
