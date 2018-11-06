package exampleApp;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class PostRequest extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException  {

	     String name = request.getParameter("name");
	     
        HttpSession session = request.getSession(true); 
        session.setAttribute("hola",name); 
        System.out.println(session.getAttribute("hola"));
        //response.sendRedirect("register.jsp");
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String data = IOUtils.toString(request.getInputStream(), "UTF-8");
    	response.setContentType("application/json");
        PrintWriter out = response.getWriter();
    	//System.out.println(data);
        JSONParser parser = new JSONParser();
        HttpSession session = request.getSession(true); 
        session.setAttribute("hola","mundo"); 
        response.sendRedirect("register.jsp");

        if(data != null)
        {
        	out.println("{\"error\": \"NOT NULL\"}");
        	return;
        }
        
        
        try {
			Object obj = parser.parse(data);
			System.out.println("DATA");
			System.out.println(obj);
			System.out.println("END");
			
        } catch (ParseException e) {
			System.out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        

        //out.print("You are DATA...");
        //out.print(data);
        
        JSONObject obj = new JSONObject();

        
        out.print(obj);
        
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
            		"jdbc:mariadb://localhost:3306/Repositories_PI", "repoIo", "repoIoPass");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into Areas (name) values(?)");
 
            ps.setString(1, "Area 1");
 
            int i = ps.executeUpdate();
            if (i > 0)
                out.print("You are successfully registered...");
 
        } catch (Exception e2) {
        	out.println("Exception");
            System.out.println(e2);
        }*/
        out.close();
    }
 
}