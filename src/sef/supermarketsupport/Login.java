package sef.supermarketsupport;

import java.sql.SQLException;

public class Login {
	 
    public static Account authenticate(String username, String password) {
        // hardcoded username and password
    	try {
    		return DatabaseOperations.authenticate(username,password);
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
        
    }
}