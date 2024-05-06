package tp3_Practica.eje6;

import java.util.List;

import tp3_Practica.eje5.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> estructura;

	public RedDeAguaPotable(GeneralTree<Character> estructura) {
		this.estructura = estructura;
	}

	// recorrido total, por profundidad
	private double helperCaudal(double caudal, GeneralTree<Character> a) {
//		int cantBifurcaciones = a.getChildren().size();
//		double cuantoTocaActual = caudal / cantBifurcaciones; se rompia cuando llegaba a la hoja
		double valorMin = Double.MAX_VALUE;
		if (a.isLeaf()) {
//			return Math.min(valorMin, cuantoTocaActual);
			return caudal;
		} else {
			int cantBifurcaciones = a.getChildren().size();
			double cuantoTocaActual = caudal / cantBifurcaciones;
			double cuantoLlegaAcasa;
			List<GeneralTree<Character>> childActual = a.getChildren();
			for (GeneralTree<Character> i : childActual) {
				cuantoLlegaAcasa = helperCaudal(cuantoTocaActual, i);
				valorMin = Math.min(valorMin, cuantoLlegaAcasa);
			}
		}
		return valorMin;
	}

	public double minimoCaudal(double caudal) {
		double valor = 0;
		if (estructura != null && !estructura.isEmpty()) {
			valor = helperCaudal(caudal, estructura);
		}
		return valor;
	}

}
