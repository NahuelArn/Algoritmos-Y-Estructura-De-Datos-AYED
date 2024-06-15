package ResumenAlgoritmos.Practica3.eje9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp3_Practica.eje1.GeneralTree;

public class PruebaIterator<T> {
	private T data;
	private List<GeneralTree<T>> children;

	public PruebaIterator(T data) {
		this.data = data;
		this.children = new ArrayList<>();
	}

	public T getData() {
		return data;
	}

	public List<GeneralTree<T>> getChildren() {
		return children;
	}

	public void addChild(GeneralTree<T> child) {
		this.children.add(child);
	}

	public static void main(String[] args) {
		GeneralTree<Integer> root = new GeneralTree<>(12);
		GeneralTree<Integer> node1 = new GeneralTree<>(1);
		GeneralTree<Integer> node2 = new GeneralTree<>(2);
		GeneralTree<Integer> node3 = new GeneralTree<>(3);
		root.addChild(node1);
		root.addChild(node2);
		root.addChild(node3);
		List<GeneralTree<Integer>> children = root.getChildren();
		Iterator<GeneralTree<Integer>> iterador = children.iterator();
		System.out.println("		Padre: " + root.getData());
		System.out.println();
		while (iterador.hasNext()) {
			GeneralTree<Integer> child = iterador.next();
			System.out.print("Child data: " + child.getData() + " | ");
		}
	}
}
