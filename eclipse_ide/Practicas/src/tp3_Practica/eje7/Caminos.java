package tp3_Practica.eje7;

import java.util.LinkedList;
import java.util.List;

import tp3_Practica.eje5.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> arbol;

	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	/*
	 * if actual > max max = caminoActual y corto ejecucion
	 */
	private void helperPrimerCaminoLargo(GeneralTree<Integer> a, List<Integer> arbolActual, List<Integer> arbolMax) {
		if (a.isLeaf() && arbolMax.size() <= 0) {
			if (arbolActual.size() > arbolMax.size()) {
				arbolMax.clear();
				arbolMax.addAll(arbolActual);
			}
//			Math.max(arbolActual.size(), arbolMax.size());

		} else {
			List<GeneralTree<Integer>> childActual = a.getChildren();
			arbolActual.add(a.getData());
			for (GeneralTree<Integer> i : childActual) {
//				arbolActual.add(a.getData());
				helperPrimerCaminoLargo(i, arbolActual, arbolMax);
				arbolActual.remove(arbolActual.size() - 1);
			}
		}
	}

	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> arbolMax = new LinkedList<>();
		if (arbol != null && !arbol.isEmpty()) {
			List<Integer> arbolActual = new LinkedList<>();
			helperPrimerCaminoLargo(arbol, arbolActual, arbolMax);
		}
		return arbolMax;
	}
}
