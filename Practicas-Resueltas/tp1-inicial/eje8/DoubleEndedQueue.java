package tp1.eje8;

public class DoubleEndedQueue<T> extends Queue { // "Permita encolar al inicio, ver como encararlo"
	DoubleEndedQueue() {
		super();
	}

	public void enqueueFirst(T data) {
		data.add(0, data);
	}
}
