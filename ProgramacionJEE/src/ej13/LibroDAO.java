package ej13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroDAO {

	public static boolean insertarEnFormulario(String isbn, String titulo,
			String categoria) {

		String sql = "insert into libros (isbn,titulo,categoria) values ( ?,?,?)";

		try {
			// cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}

		// conectamos con la base de datos

		try {

			Connection conector = DriverManager.getConnection(
					"jdbc:mysql://localhost/pruebasjee", "root", "");

			// preparamso la consulta
			PreparedStatement ps = conector.prepareStatement(sql);

			// ponemos los parametros en los huecos
			ps.setInt(1, Integer.parseInt(isbn));
			ps.setString(2, titulo);
			ps.setString(3, categoria);

			// ejecutamos consulta
			ps.execute();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static ResultSet selectDB() {

		String sql = "select * from libros";

		try {
			// cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

		// conectamos con la base de datos

		try {

			java.sql.Connection conector = DriverManager.getConnection(
					"jdbc:mysql://localhost/pruebasjee", "root", "");

			// preparamso la consulta
			PreparedStatement ps = conector.prepareStatement(sql);

			// ejecutamos consulta
			ResultSet rs = ps.executeQuery();

			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
