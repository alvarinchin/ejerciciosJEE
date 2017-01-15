package ej13;

public class Libro {
	private int isbn;
	private String titulo;
	private String categoria;

	public Libro(int isbn, String titulo, String categoria) {

		this.isbn = isbn;
		this.categoria = categoria;
		this.titulo = titulo;

	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
