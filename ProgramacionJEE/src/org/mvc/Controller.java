package org.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String baseURL;
	
	
	protected void ejecutar ( String modo, HttpServletRequest request,HttpServletResponse response){
		
		this.request= request;
		this.response=response;
		this.baseURL= request.getRequestURL().toString();
		
		
	}
	
	protected final void doGet(HttpServletRequest request,HttpServletResponse response){
		this.ejecutar("get", request, response);
	}
	protected final void doPost(HttpServletRequest request,HttpServletResponse response){
		this.ejecutar("post", request, response);
	}
	

}
