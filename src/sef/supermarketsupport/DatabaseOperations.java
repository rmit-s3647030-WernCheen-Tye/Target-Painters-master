package sef.supermarketsupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Statement;

public class DatabaseOperations {

	static final String MYSQL_SERVER_ADDRESS = "ngocbeo1121.xyz";
	static final String DB_USERNAME = "sef2017";
	static final String DB_PASSWORD = "123456";
	
	static Connection currentConnection;
	
	static synchronized Connection makeConnection() throws SQLException {
		if (currentConnection == null || currentConnection.isClosed()) {
			String url = String.format("jdbc:mysql://%s:3306/%s", MYSQL_SERVER_ADDRESS, DB_USERNAME);
	        System.out.println("Connecting database...");
	        currentConnection = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
	        System.out.println("Database connected!");
		}
	    return currentConnection;
	}
	
	
	public static ArrayList<Product> getAllProducts() throws SQLException {
		Statement stmt = null;
		String query = "SELECT * FROM Product";
		
		try {
			Connection connection = makeConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<Product> products = new ArrayList<>();
			while (rs.next()) {
			    Product product = new Product();
			    product.setProductID(rs.getString("productID"));
			    product.setName(rs.getString("pName"));
			    product.setDescription(rs.getString("pDescription"));
			    product.setLine("pLine");
			    product.setPrice(rs.getFloat("pPrice"));
			    product.setQuantity(rs.getInt("pQuantity"));
			    product.setBrand(rs.getString("pBrand"));
			    products.add(product);
            }

            return products;
		}
		finally {
	        if (stmt != null) {
	        	stmt.close();
	        }
	    }
	}
	
	public static Account authenticate(String account, String password) throws SQLException  {
		Statement stmt = null;
		String query = "SELECT * FROM Account WHERE UserAccount = ? AND UserPassword = ?";		
		
		try {
			Connection connection = makeConnection();
			PreparedStatement preparedStm = connection.prepareStatement(query);
			preparedStm.setString(1, account);
			preparedStm.setString(2, password);
			ResultSet rs = preparedStm.executeQuery();
			
			if (rs.next()) {
			    Account acc = new Account();
			    acc.setAccountID(rs.getInt("accountID"));
			    acc.setUserAccount(rs.getString("UserAccount"));
			    acc.setRole(rs.getString("role"));
			    acc.setLevel(rs.getInt("level"));
			    
			    return acc;
            }
			
			//fail login
            return null;
		}
		finally {
	        if (stmt != null) {
	        	stmt.close();
	        }
	    }
		
	}
	
	public static ArrayList<CustomerSelection> selectProducts(String productID) throws SQLException {
		Statement stmt = null;
		String query = 
				"SELECT productID, pName,pDescription,pPrice FROM Product "
				+ "WHERE productID = \'" + productID + "\' " ;
		
		try {
			Connection connection = makeConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<CustomerSelection> customerSelections = new ArrayList<>();
			while (rs.next()) {
			    CustomerSelection customerSelection = new CustomerSelection();
			    customerSelection.setProductID(rs.getString("productID"));
			    customerSelection.setName(rs.getString("pName"));
			    customerSelection.setPrice(rs.getFloat("pPrice"));
			    customerSelection.setBrand(rs.getString("pBrand"));
			    customerSelections.add(customerSelection);
            }

            return customerSelections;
		}
		finally {
	        if (stmt != null) {
	        	stmt.close();
	        }
	    }
	}
	
	
}
