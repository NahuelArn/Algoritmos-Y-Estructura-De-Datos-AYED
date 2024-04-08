package tp1.eje9;

import java.util.ArrayList;
import java.util.List;

public class StackPila<T> extends Sequence<T> { // Lifo pila generica
	private List<T> data;

	public StackPila() {
		data = new ArrayList<T>();
	}

	public void push(T dato) { // apila
		data.add(data.size(), dato);
	}

//	public T pop() { // desapila
//		super.decSize();
//		if (!super.isEmpty()) {
//			T c = data.get(data.size() - 1);
//			data.remove(data.size() - 1);
//			return c;
//		} else {
//			return null;
//		}
//	}
	public T pop() { // desapila
		super.decSize();
		if (!super.isEmpty()) {
			T c = data.get(data.size() - 1);
			data.remove(data.size() - 1);
			return c;
		} else {
			return null;
		}
	}

	public T top() { // devuelve el tope de la pila
		if (!data.isEmpty()) {
			return data.get(data.size() - 1);
		} else {
			return null;
		}

	}
}
// public class StackPila extends Sequence { //lifo
//	private List<Character> pila;
//
//	public StackPila() {
//		pila = new LinkedList<Character>();
//	}
//
//	public void push(char c) {	//apila
//		pila.add(c);
//		super.incSize();
//	}
//
//	public Character pop() {	//desapila
//		super.decSize();	
//		if (!super.isEmpty()) {
//			char c = pila.get(pila.size() - 1);
//			pila.remove(pila.size() - 1);
//			return c;
//		} else {
//			return null;
//		}
//	}
//}
