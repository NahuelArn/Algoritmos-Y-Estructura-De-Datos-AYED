package ResumenAlgoritmos.Practica3.eje8;

import java.util.List;

import tp3_Practica.eje5.GeneralTree;

public class Navidad {
	private GeneralTree<Integer> arbol;

	public Navidad(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	private boolean helperAbeto(GeneralTree<Integer> a) {
		int cantHojas = 0;
		int i = 0;
		boolean cumple = true;
		List<GeneralTree<Integer>> childActual = a.getChildren();
		while (i < childActual.size() && cumple) {
			GeneralTree<Integer> o = childActual.get(i);
			if (o.isLeaf()) {
				cantHojas++;
			} else {
				cumple = helperAbeto(childActual.get(i));
			}
		}
		return cantHojas >= 3;
	}

	// wiki wiki
	public String esAbetoNavidenio() {
		String estado = "No";
		if ((arbol != null) && (!arbol.isEmpty())) {
			if (helperAbeto(arbol)) {
				estado = "Si";
			}
		}
		return estado;
	}
}
