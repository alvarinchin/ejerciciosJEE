package prueba.ejercicio7;

import java.util.Map;

import javax.servlet.http.Part;

public class UtilHtml {

	public static String generaRadio(String nombre, Map<String, String> listado, String seleccionado) {

		String res = "";

		for (String elem : listado.keySet()) {

			String checked = listado.get(elem).equals(seleccionado) ? "checked='checked'" : "";

			String etiqueta = "<label for='" + elem + "'>" + listado.get(elem) + "</label>";
			String bloque = "<input type='radio' name='" + nombre + "' value='" + listado.get(elem) + "' id='" + elem
					+ "'" + checked + ">";

			res += etiqueta + bloque + "<br>";

		}

		return res;
	}

	public static String generaCheck(String nombre, Map<String, String> listado, String[] selecccionado) {

		String res = "";

		for (String elem : listado.keySet()) {
			String checked = "";
			for (String sel : selecccionado) {
				if (listado.get(elem).equals(sel)) {
					checked = "checked=\"checked\"";
				}

			}
			String etiqueta = "<label for='" + elem + "'>" + listado.get(elem) + "</label>";
			String bloque = "<input type='checkbox' name='" + nombre + "' value='" + listado.get(elem) + "' id='" + elem
					+ "'" + checked + ">";

			res += etiqueta + bloque + "<br>";

		}

		return res;
	}

	public static String generaSelect(String nombre, Map<String, String> listado, String seleccionado) {

		String res = "<select name=\"" + nombre + "\">";

		for (String elem : listado.keySet()) {

			String checked = listado.get(elem).equals(seleccionado) ? "selected=\"selected\"" : "";
			res += "<option value=\"" + listado.get(elem) + "\" " + checked + ">" + listado.get(elem) + "</option><br>";
		}

		res += "</select>";

		return res;
	}

	public static String nombreArchivo(Part parte) {
		for (String cd : parte.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.lastIndexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
			}
		}
		return null;

	}

}
