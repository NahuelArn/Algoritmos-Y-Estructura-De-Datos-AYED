package tp1.fallaEnJava;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> extends Sequence {
	private List<T> data;

	public Queue() { // constructor
		data = new ArrayList<T>();
	}

	public void enqueue(T cosa) {
		data.add(cosa); // uso el add de list
	}

	public T dequeue() {
		T cosa = null;
		if (!data.isEmpty()) {
			cosa = data.remove(0);
		}
		return cosa;
	}

	public T head() { // la cabeza seria el primer elemento de la Queue
		T cosa = null;
		if (!isEmpty()) {
			cosa = data.get(0);
		}
		return cosa;
	}

	protected void primerElemento(T cosa) { // a Java le falta un nuevo modificador de acceso
		data.add(0, cosa);
	}

	@Override
	public String toString() {
		String s = "[ ";
		if (!data.isEmpty()) {
			for (T i : data) {
				s += i + " ,";
			}
			s = s.substring(0, s.length() - 2); // para eliminar el ", y el espacio (" ,") " el substring, recibe 2 parametros
												// los limites q queremos que guarde
			s += " ]";
		} else {
			s = "La Queue esta vacia";
		}

		return s;
	}

	@Override
	public int size() {
		return data.size(); // llama al size de list
	}

	@Override
	public boolean isEmpty() {
		return data.size() == 0;
	}
}
