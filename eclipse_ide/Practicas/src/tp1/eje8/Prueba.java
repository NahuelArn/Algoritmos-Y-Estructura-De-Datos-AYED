package tp1.eje8;

//import java.util.Queue;

public class Prueba {
	public static void main(String[] args) {
		// Creamos una cola vacía utilizando LinkedList
		Queue<Integer> cola = new Queue<>();

		// Agregamos números a la cola
//		cola.enqueue(1); //
//		cola.enqueue(2);
//		cola.enqueue(3);
//
//		System.out.println("Contenido de la Queue:");
//		while (!cola.isEmpty()) {
//			System.out.println(cola.dequeue());
//		}
//		System.out.println(cola.size());
//		System.out.println(cola.toString());
		// System.out.println(cola.head());
//		CircleQueue<Integer> je = new CircleQueue<>();
//
//		je.enqueue(1);
//		je.enqueue(2);
//		je.enqueue(3);
//		System.out.println("antes" + je.toString());
//		je.shift();
//		System.out.println("despues" + je.toString());
		DoubleEndedQueue<Integer> ja = new DoubleEndedQueue<Integer>();
		ja.enqueue(1);
		ja.enqueue(2);
		ja.enqueue(3);
		System.out.println("antes ");
		System.out.println(ja.toString());
		System.out.println("despues ");
		ja.enqueueFirst(3);
		System.out.println(ja.toString());

	}
}
