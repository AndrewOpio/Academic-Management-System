package sms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
    private static Login frame;
    
    
    //Authenticating users
    public void userAuth(String name, String pass) throws SQLException {
		btnNewButton.setText("Logging in...");

    	if(name.equals("") || pass.equals("")) {
    		JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
			btnNewButton.setText("Login");

    	} else {
    		databaseConnection conn = null;
			try {
				conn = new databaseConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    		String query = "select * from teachers where username='" + name + "'and password='" + pass + "'";
    		ResultSet res = conn.getData(query);

    		if(!res.isBeforeFirst()) {
        		String query_1 = "select * from students where reg_number='" + name + "'and password='" + pass + "'";
        		ResultSet res_1 = conn.getData(query_1);

        		if(!res_1.isBeforeFirst()) {
            		JOptionPane.showMessageDialog(null, "Invalid username or password.");
        			btnNewButton.setText("Login");

        		} else {
        			String st_class = null;
        			if(res_1.next()) {
        			   st_class = res_1.getString("class");
        			}
            		Student studentFrame = new Student(name, st_class);
            		frame.setVisible(false);
            		studentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            		studentFrame.setVisible(true);
        		}
    			
    		} else {
        		Main mainFrame = new Main(name);
        		frame.setVisible(false);
        		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        		mainFrame.setVisible(true);
    		}

    	}
    }
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame = new Login();
				    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Student Management Sytstem");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(200, 0, 20, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 6;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 8;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 10;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		textField.setToolTipText("enter your username");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setPreferredSize(new Dimension(50, 30));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 10;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(1);
		lblNewLabel_2.setLabelFor(textField);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 11;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("enter your password");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setPreferredSize(new Dimension(50, 30));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(10, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 11;
		contentPane.add(passwordField, gbc_passwordField);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setPreferredSize(new Dimension(200,30));;
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 5;
		gbc_btnNewButton.insets = new Insets(20, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 12;
		
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				try {
					frame.userAuth(username, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});

		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
