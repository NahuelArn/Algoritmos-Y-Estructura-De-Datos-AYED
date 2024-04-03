package tp1.eje8;

public class CircleCompleteQueue<T> extends Queue<T> { // da una vuelta de la Queue 1,2,3,4 | 4 3 2 1
	public void shiftComplete() {
		if (data.isEmpty()) {
			throw new IllegalStateException("La cola está vacía");
		} else {
			// Obtenemos el último elemento
			T lastElement = dequeue();

			// Movemos todos los elementos una posición hacia la derecha
			int size = size();
			for (int i = 0; i < size - 1; i++) {
				T currentElement = dequeue();
				enqueue(currentElement);
			}

			// Ponemos el último elemento al principio
			enqueue(lastElement);
		}
	}
}
