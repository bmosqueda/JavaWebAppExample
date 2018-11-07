package com.vogella.jersey.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class Hello {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public String sayXMLHello(@Context HttpServletRequest req) {
	  HttpSession session= req.getSession();
      System.out.println(session.getAttribute("hola"));
      if(session == null)
    	  return "{\"err\":\"NADA\"}";
    return "{\"name\":\""+session.getAttribute("hola")+"\"}";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello(@Context HttpServletRequest req) {
	  HttpSession session= req.getSession();
      System.out.println(session.getAttribute("hola"));
      if(session == null)
    	  return "{\"err\":\"NADA\"}";
    return "{\"name\":\""+session.getAttribute("hola")+"\"}";
  }

}