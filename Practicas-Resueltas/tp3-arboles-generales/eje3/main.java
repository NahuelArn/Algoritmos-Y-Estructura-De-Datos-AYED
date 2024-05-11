package tp3_Practica.eje3;

import java.util.LinkedList;
import java.util.List;

public class main {
	public static void main(String[] args) {
		List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
//		children2.add(new GeneralTree<Integer>("21"));
//		children2.add(new GeneralTree<Integer>("22"));
//		children2.add(new GeneralTree<Integer>("23"));

		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
//		children2.add(new GeneralTree<Integer>("21"));
//		children2.add(new GeneralTree<Integer>("22"));
//		children2.add(new GeneralTree<Integer>("23"));

		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
//		children2.add(new GeneralTree<Integer>("21"));
//		children2.add(new GeneralTree<Integer>("22"));
//		children2.add(new GeneralTree<Integer>("23"));

		// le asigno los hijos al padre
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(13, children1);
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(25, children2);
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(10, children3);

		// le asigno a un hijo los padres (que ya tiene padre e hijo)
		List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
		childen.add(a1);
		childen.add(a2);
		childen.add(a3);

		GeneralTree<Integer> a = new GeneralTree<Integer>(14, childen);

		a.preOrder();

		System.out.println("casa: " + a.nivel(13));

		System.out.println("------------------");

		System.out.println("Ancho max: " + a.ancho());
	}
}
