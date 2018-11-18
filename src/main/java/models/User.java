package models;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class User 
{
	private int id;
	private String name;
	private String password;
	
	public User(int id, String name, String password) 
	{
		super();
		this.name = name;
		this.id = id;
		this.password = password;
	}
	
	public User(String name, String password) 
	{
		super();
		this.name = name;
		this.password = password;
	}
	
	public String toJSON() {
		JSONObject json = new JSONObject();
		
		json.put("id", this.id);
		json.put("name", this.name);
		json.put("password", this.password);
		
		return json.toString();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}