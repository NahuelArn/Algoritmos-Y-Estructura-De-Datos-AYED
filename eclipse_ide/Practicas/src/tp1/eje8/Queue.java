package tp1.eje8;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> extends Sequence { // FifO
	List<T> data;

	public Queue() {
		this.data = new ArrayList<T>();
	}

	public void enqueue(T dato) { // para agregar
		data.add(dato);
	}

	public T dequeue() { // para quitar
		if (!data.isEmpty()) {
			return data.remove(0);
		} else {
			throw new IllegalStateException("La cola está vacía"); // manejo del error
		}
	}

	public T head() { // devuelve el tope
		if (!data.isEmpty()) {
			return data.get(0);
		} else {
			throw new IllegalStateException("La cola está vacía");
		}
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.size() == 0;
	}

	@Override
	public String toString() {
		String str = "[ ";
		if (!data.isEmpty()) {
			for (T d : data) {
				str += d + ", ";
			}
			str = str.substring(0, str.length() - 2) + " ]"; // Esto quita el ,]
		} else {
			str = "error flaquito, soh boludo voh? intentas imprimir una QueuEh vacia";
		}
		return str;
	}
}
