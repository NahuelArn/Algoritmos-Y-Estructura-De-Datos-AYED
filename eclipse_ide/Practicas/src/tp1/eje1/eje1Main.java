package tp1.eje1;

public class eje1Main {
	//A
	public static void recorridoConFor(int a, int b) {
		System.out.println("recorridoConFor");
		for (int i = a; i <= b; i++) {
			System.out.print(i+ " " );
		}
		System.out.println();
	}
	//B
	public static void recorridoConWhile(int a, int b) {
		System.out.println("recorridoConWhile");
		while(a <= b) {
			System.out.print(a+ " ");
			a++;
		}
		System.out.println();
	}
	//C
	public static void recorridoSinEstructuraDeIteracion(int a, int b) {
		if(a <= b) {	//con condicional
			System.out.print(a+" ");
			recorridoSinEstructuraDeIteracion(a+1,b);	//recursivo
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("sarasa");
		//a
		recorridoConFor(1,5);
		//b
		recorridoConWhile(1,5);
		//c
		System.out.println("recorridoSinEstructuraDeIteracion");
		recorridoSinEstructuraDeIteracion(1,5);
	}
}
