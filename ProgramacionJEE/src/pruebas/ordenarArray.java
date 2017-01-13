package pruebas;

public class ordenarArray {

	public static void main(String[] args) {
		int[] a = { 2, 5, 0, 7, 2, 3, 6, 8, 5 };
		int mayor = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > mayor) {
				mayor = a[i];
				i = -1;

			}
		}

		for (int i = 0; i < a.length; i++) {

			if (a[i] < a[i + 1]) {
				int aux = a[i];
				a[i] = a[i + 1];
				a[i + 1] = aux;
				i = -1;
			}
		}

		System.out.println("el mayor es" + mayor);

	}
}