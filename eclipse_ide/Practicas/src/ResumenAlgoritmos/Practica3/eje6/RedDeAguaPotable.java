package ResumenAlgoritmos.Practica3.eje6;

import java.util.List;

import tp3_Practica.eje1.GeneralTree;

public class RedDeAguaPotable {
	GeneralTree<Character> presa;

	public RedDeAguaPotable(GeneralTree<Character> presa) {
		this.presa = presa;
	}

	private double helperCaudal(double caudal, GeneralTree<Character> a) {
		if (a.isLeaf()) {
			return caudal;
		}
		double valorMin = Double.MAX_VALUE;
		double cuantoTocaActual = caudal / a.getChildren().size();
		List<GeneralTree<Character>> childActual = a.getChildren();
		for (GeneralTree<Character> i : childActual) {
			double cuantoLlegaAcasa = helperCaudal(cuantoTocaActual, i);
			valorMin = Math.min(valorMin, cuantoLlegaAcasa);

		}
		return valorMin;
	}

	public double minimoCaudal(double caudal) {
		double valor = 0;
		if (presa != null && !presa.isEmpty()) {
			valor = helperCaudal(caudal, presa);
		}
		return valor;
	}

	public static void main(String[] args) {
		// Crear instancias de GeneralTree para representar la red de agua
		GeneralTree<Character> root = new GeneralTree<>('A');
		GeneralTree<Character> nodeB = new GeneralTree<>('B');
		GeneralTree<Character> nodeC = new GeneralTree<>('C');
		GeneralTree<Character> nodeD = new GeneralTree<>('D');
		GeneralTree<Character> nodeE = new GeneralTree<>('E');
		GeneralTree<Character> nodeF = new GeneralTree<>('F');
		GeneralTree<Character> nodeG = new GeneralTree<>('G');
		GeneralTree<Character> nodeH = new GeneralTree<>('H');

		// Construir el árbol (red de agua)
		root.addChild(nodeB);
		root.addChild(nodeC);
//		root.addChild(nodeD);
//		root.addChild(nodeE);
		root.addChild(nodeD);
		nodeB.addChild(nodeE);
		nodeB.addChild(nodeF);
		nodeC.addChild(nodeG);
		nodeC.addChild(nodeH);

		// Crear una instancia de RedDeAguaPotable
		RedDeAguaPotable red = new RedDeAguaPotable(root);

		// Calcular y mostrar el caudal mínimo
		double caudalInicial = 1000.0;
		double caudalMinimo = red.minimoCaudal(caudalInicial);
		System.out.println("El caudal mínimo que recibe una casa es: " + caudalMinimo);
	}
}
