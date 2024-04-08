
package tp1.eje9;

public class TestBalanceo {
	public static void main(String[] args) {
		System.out.println("Ingrese la cadena q solo tenga  (,),[,],{,}");
		// a: utilizo una queua
		String s1 = "([)]"; // par pero no cumple
		String s2 = "{({()}}"; // impar
		String s3 = "{()[()]}"; // cumple
//		int dimF = s.length();
//		System.out.println("dimF " + dimF);
//		for (int i = 0; i < dimF; i++) {
//			System.out.println("actual caracter: " + s.charAt(i));
//		}
		System.out.println("Ess: " + validador(s1));
		System.out.println("Ess: " + validador(s2));
		System.out.println("Ess: " + validador(s3));
	}

	public static Boolean validador(String s) {
		boolean prosigo = false;
		// boolean cumple = false;
		char cActual;
		int i = 0;
		StackPila<Character> pila = new StackPila(); // Stack<Character> stack = new Stack<Character>(); equivalente
		if ((s.length() > 1) && (s.length() % 2 == 0)) {
			prosigo = true;
			while ((i < s.length()) && (prosigo)) {
				cActual = s.charAt(i);
				if (esApertura(cActual)) {
					pila.push(cActual);
				} else {
					if (esCierre(cActual)) {
//						System.out.println("desalipia " + pila.top());
//						System.out.println("c actual " + cActual);
						if (!sonIguales(pila.pop(), cActual)) {
							prosigo = false;
						}
					}
				}
				i++;
			}

		}
		return prosigo;
	}

	public static boolean esApertura(char c) {
		return (c == '{') || (c == '[') || (c == '(');
	}

	public static boolean esCierre(char c) {
		return (c == '}') || (c == ']') || (c == ')');
	}

	public static boolean sonIguales(char a, char b) {
		boolean estado = (a == '{' && b == '}' || a == '[' && b == ']' || a == '(' && b == ')');
		return estado;
	}
}
