package tp1.fallaEnJava;

public class TheBank {
	// una Queue con una implementacion de insercion al principio
	public static void main(String[] args) {
		Queue<String> casa = new Queue<>();
//		casa.primerElemento("casa");
		casa.enqueue("b");// 0
		casa.enqueue("c");// 1
		System.out.println("antes " + casa.toString());
		System.out.println(casa.head());
		casa.primerElemento("a");
		System.out.println("despues " + casa.toString());
//		antes [ b ,c ]
//		b
//		despues [ a ,b ,c ]
	}
}
