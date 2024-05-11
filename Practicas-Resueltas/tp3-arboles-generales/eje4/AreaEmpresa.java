package tp3_Practica.eje4;

public class AreaEmpresa {
	private String id;
	private int tardanza;

	public AreaEmpresa(String id, int tardanza) {
		this.id = id;
		this.tardanza = tardanza;
	}

	public String getId() {
		return id;
	}

	public int getTardanza() {
		return tardanza;
	}

}
