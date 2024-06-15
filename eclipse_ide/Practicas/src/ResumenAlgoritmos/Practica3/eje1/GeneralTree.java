package ResumenAlgoritmos.Practica3.eje1;

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
			children.remove(child); // va eliminando el de mas a la izquierda, es Fifo
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
}
