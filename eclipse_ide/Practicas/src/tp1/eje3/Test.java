package tp1.eje3;
//
public class Test {
	public static void main(String[] args) {
		Estudiante arreglo1[] = new Estudiante[2];
		//Estudiante estudiante;
		for (int i = 0; i< 2; i++) {
/*point*/   arreglo1[i] = new Estudiante("nombre"+i,"apellido"+i,"mail"+i,1,"direccion"+i);	//era hacerlo full manual, con metodos sin Hacer constructores
		}
		Profesor arreglo2[] = new Profesor[3];

		for (int i = 0; i < 3; i++) {
/*point*/   arreglo2[i] = new Profesor("nombre", "apellido", "pepe@gmail", 2, "bellas artes");
        }
	}
}
