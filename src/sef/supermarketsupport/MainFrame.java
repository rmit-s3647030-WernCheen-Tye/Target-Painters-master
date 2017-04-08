package sef.supermarketsupport;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.*;

public class MainFrame {

	JFrame frame;
//	private JTextField usernameTextField;
//	private JPasswordField passwordTextField;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}
	
//	void tryConnectDatabase() {
//		try {
//            ArrayList<Product> products = DatabaseOperations.getAllProducts();
//            for (Product product : products) {
//                System.out.println(Toolbox.getDefaultGson().toJson(product));
//            }
//		    
//		} catch (SQLException e) {
//		    throw new IllegalStateException("Cannot connect the database!", e);
//		}
//	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("SupermarketSupport");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JButton loginBtn = new JButton("Click to login");
		 
        loginBtn.addActionListener(e -> {
            LoginDialog loginDlg = new LoginDialog(frame);
            loginDlg.setVisible(true);
            // if login successfully
            if (loginDlg.isSucceeded()){
                loginBtn.setText("Hi " + loginDlg.getAccount() + "!");
            }
        });
        
        JButton btnNewButton = new JButton("Show Products");
        btnNewButton.addActionListener(e -> {
        	ArrayList<CustomerSelection> customerSelections;
        	ArrayList<Product> products;
			try {
				products = DatabaseOperations.getAllProducts();
				for (Product product : products) {
	        		System.out.println(Toolbox.getDefaultGson().toJson(product));
	        	}
				//User selecting product
				System.out.print("Select a product by keying the productID:");
				Scanner sc = new Scanner(System.in);
				String userInput = sc.nextLine();
				//not sure how do I link to customerSelections Class and Database here
				userInput = customerSelections;
				while (userInput == CustomerSelection.getProductID()){
					
				}
				customerSelections = DatabaseOperations.customerSelections();
				for (Product customerselection : customerSelections) {
	        		System.out.println(CustomerSelection.getDefaultGson().toJson(customerSelection));
				
				
				
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        });
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnNewButton)
        				.addComponent(loginBtn))
        			.addContainerGap(315, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(loginBtn)
        			.addGap(5)
        			.addComponent(btnNewButton)
        			.addContainerGap(209, Short.MAX_VALUE))
        );
        frame.getContentPane().setLayout(groupLayout);
		
//		
//		JLabel lblNewLabel = new JLabel("Username");
//		
//		usernameTextField = new JTextField();
//		usernameTextField.setColumns(10);
//		
//		JLabel lblPassword = new JLabel("Password");
//		
//		passwordTextField = new JPasswordField();
//		
//		JButton loginButton = new JButton("Login");
//		
//		JButton printProductListButton = new JButton("Print product list");
//		printProductListButton.addActionListener(e -> {
//			tryConnectDatabase();
//		});
//		
//		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
//							.addComponent(lblNewLabel)
//							.addComponent(usernameTextField)
//							.addComponent(lblPassword)
//							.addComponent(passwordTextField))
//						.addComponent(loginButton)
//						.addComponent(printProductListButton))
//					.addContainerGap(314, Short.MAX_VALUE))
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addContainerGap()
//					.addComponent(lblNewLabel)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(lblPassword)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(loginButton)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(printProductListButton)
//					.addContainerGap(100, Short.MAX_VALUE))
//		);
//		frame.getContentPane().setLayout(groupLayout);
	}
}
