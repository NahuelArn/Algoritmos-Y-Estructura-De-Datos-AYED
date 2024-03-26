package tp1.eje8;

public class CircleQueue<T> extends Queue<T> { // quita el primer elemento y lo pone al final, 1 2 3 4 5 | 2 3 4 5 1

	public void shift() {
		if (data.isEmpty()) {
			throw new IllegalStateException("La cola está vacía");
		} else {
			T shiftedElement = dequeue(); // Quitamos el primer elemento de la cola
			enqueue(shiftedElement); // Lo volvemos a encolar al final
//			return shiftedElement;
		}
	}
}
