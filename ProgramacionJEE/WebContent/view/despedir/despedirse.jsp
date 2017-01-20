<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<div class="container">
	<form action="${baseURL}t7/ej18/despedirse" method="post">
		<div class="form-group">
			<input class="form-control" type="text" name="nombre">
			<button type="submit" class="bt btn-primary">Enviar</button>
		</div>
		</form>
	</div>

