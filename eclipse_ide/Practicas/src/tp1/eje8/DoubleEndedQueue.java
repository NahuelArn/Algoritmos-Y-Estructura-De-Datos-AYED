package tp1.eje8;

public class DoubleEndedQueue<T> extends Queue { // "Permita encolar al inicio"
	DoubleEndedQueue() {
		super();
	}

	public void enqueueFirst(T data) {
		super.data.add(0, data);
	}
}
//antes 
//[ 1, 2, 3 ]
//despues 
//[ 3, 1, 2, 3 ]
