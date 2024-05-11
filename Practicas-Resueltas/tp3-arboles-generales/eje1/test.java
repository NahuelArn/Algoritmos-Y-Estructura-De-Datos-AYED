package tp3_Practica.eje1;

import java.util.LinkedList;
import java.util.List;

public class test {
	public static void main(String[] args) {
//		GeneralTree<Integer> arbolGeneral = new GeneralTree<>();
//
//		arbolGeneral.setData(0);
//		System.out.println("imprime: " + arbolGeneral.isLeaf());
//		List<Integer> lista = new LinkedList<>();
//		System.out.println("Despues: " + arbolGeneral.isLeaf());
//
//		System.out.println("estado: " + (arbolGeneral.getChildren() == null));
//
//		System.out.println("bucle? : " + (arbolGeneral.hasChildren()));

		GeneralTree<String> a1 = new GeneralTree<String>("1");
		List<GeneralTree<String>> children2 = new LinkedList<GeneralTree<String>>();
		children2.add(new GeneralTree<String>("21"));
		children2.add(new GeneralTree<String>("22"));
		children2.add(new GeneralTree<String>("23"));
		GeneralTree<String> a2 = new GeneralTree<String>("2", children2);
		List<GeneralTree<String>> children3 = new LinkedList<GeneralTree<String>>();
		children3.add(new GeneralTree<String>("31"));
		children3.add(new GeneralTree<String>("32"));
		GeneralTree<String> a3 = new GeneralTree<String>("3", children3);
		List<GeneralTree<String>> childen = new LinkedList<GeneralTree<String>>();
		childen.add(a1);
		childen.add(a2);
		childen.add(a3);
		GeneralTree<String> a = new GeneralTree<String>("0", childen);
		System.out.println("Datos del Arbol Pre orden: ");
		a.preOrder();
		System.out.println();

		System.out.println("Datos del Arbol In orden: ");

//		a.inOrder();

		System.out.println();

		System.out.println("Datos del Arbol Post orden: ");

		a.postOrden();

	}
}
