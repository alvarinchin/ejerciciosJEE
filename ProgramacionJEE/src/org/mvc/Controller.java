package org.mvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class Controller extends HttpServlet {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String baseURL;

	protected void ejecutar(String modo, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		this.request = request;
		this.response = response;
		this.baseURL = request
				.getRequestURL()
				.toString()
				.substring(
						0,
						request.getRequestURL().toString().length()
								- request.getRequestURI().length())
				+ request.getContextPath() + "/";
		request.setAttribute("baseUrl", this.baseURL);
		String accion;
		try {
			String[] extra = request.getPathInfo().toString().split("/");
			accion = extra[extra.length - 1]
					+ (modo.equals("get") ? "Get" : "Post");
		} catch (NullPointerException e) {
			accion = "index"+(modo.equals("get") ? "Get" : "Post");
		}

		try {

			Method funcion = this.getClass().getMethod(accion);
			funcion.invoke(this);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			response.setContentType("text/html");
			response.getWriter().println("<h1>Objeto no encontrado</h1>");
		} catch (SecurityException  e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	protected final void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		this.ejecutar("get", request, response);
	}

	protected final void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		this.ejecutar("post", request, response);
	}

}
