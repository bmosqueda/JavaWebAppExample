package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.User;

public class UserController 
{
	public User user;

	public UserController(User user) {
		super();
		this.user = user;
	}
	
	public static String getAll() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
            		"jdbc:mariadb://localhost:3306/test", 
            		"repoIo", 
            		"repoIoPass"
            	);
 
            PreparedStatement ps = con
            				.prepareStatement("SELECT * FROM users");
 
            //ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ArrayList<User> list = new ArrayList();
            String usersJSON = "[";
            
            while (rs.next()) {
            	User temp = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
            	list.add(temp);
            	System.out.println(temp.toJSON());
            	usersJSON += temp.toJSON() + ",";
            }
            
            char[] arr = usersJSON.toCharArray();
            arr[arr.length - 1] = ']';
            
            rs.close();
            con.close();
            
            return String.valueOf(arr);   
        } catch (Exception e2) {
            System.out.println(e2);
            return "Error";
        }
	}
}
