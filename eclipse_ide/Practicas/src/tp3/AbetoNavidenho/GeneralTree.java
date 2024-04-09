package tp3.AbetoNavidenho;

import java.util.LinkedList;

public class GeneralTree<T> {
	private T dato;
	private LinkedList<GeneralTree<T>> familia;

	public GeneralTree() {

	}

	public GeneralTree(T dato) {
		this.dato = dato;
		this.familia = new LinkedList<GeneralTree<T>>();
	}

	public T getDato() {
		return dato;
	}

	public LinkedList<GeneralTree<T>> familia() {
		return familia;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public LinkedList<GeneralTree<T>> getFamilia() { // retono a la familia
		return familia;
	}

	public boolean isEmpty() {
		return (this.getDato() == null && familia.size() == 0);
	}
}
