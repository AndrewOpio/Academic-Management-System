package sms;

import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class addResults extends JPanel {
	private JComboBox textField;
	private JTextField textField_3;
	private JComboBox period_Field;
	private JComboBox term_Field;
	private JComboBox subject_field;
	private String[] period = { "Beginning Of Term", "Mid Term", "End Of Term" };
	private String[] terms = { "1", "2", "3" };
	private String[] subjects = {"Science" ,"Mathematics" ,"English" ,"Social Studies" ,"Writing" ,"Music" ,"Physical Education" ,"French" ,"Swahili"};


	//adding results to the database
	public void addResults(String reg_number, Integer term, int subject_id, int marks, String period) {
		databaseConnection conn = null;
		try {
			conn = new databaseConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "insert into mark(reg_number, term, subject_id, mark, period) values"
				+ "('" + reg_number + "','" + term + "','" + subject_id + "','" + marks + "','" + period + "')";
		assert conn != null;
		conn.insertData(query);
		
		revalidate();
		repaint();

		JOptionPane.showMessageDialog(null, "Results added successfully.");
	}
	
	
	/**
	 * Create the panel.
	 */
	public addResults() {
		setBackground(SystemColor.controlHighlight);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Record Students' Results");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(30, 120, 5, 5);
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registration Number : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(10, 120, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		databaseConnection conn = null;
		try {
			conn = new databaseConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] reg_numbers = {};
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(reg_numbers));
		String query = "select reg_number from student";
		ResultSet res = conn.getData(query);

		try {

			// data of the table
			while (res.next()) {
				arrayList.add(res.getString("reg_number"));
			}
			reg_numbers = arrayList.toArray(reg_numbers);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textField = new JComboBox(reg_numbers);
		textField.setSelectedIndex(0);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(10, 0, 5, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		
		JLabel lblNewLabel_2 = new JLabel("Term :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 7;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		term_Field = new JComboBox(terms);
		term_Field.setSelectedIndex(0);
		term_Field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(10, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 8;
		gbc_textField_1.gridy = 3;
		add(term_Field, gbc_textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Subject : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		subject_field = new JComboBox(subjects);
		subject_field.setSelectedIndex(0);
		subject_field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(10, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 4;
		add(subject_field, gbc_textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Marks :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 7;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(10, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 8;
		gbc_textField_3.gridy = 4;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Period :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		period_Field = new JComboBox(period);
		period_Field.setSelectedIndex(0);
		period_Field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(10, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 5;
		add(period_Field, gbc_textField_4);
//		period_Field.setColumns(10);


		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setPreferredSize(new Dimension(200,30));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(30, 0, 0, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 7;

		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String reg_number = String.valueOf(textField.getSelectedItem());
				int term = Integer.valueOf(String.valueOf(term_Field.getSelectedItem()));
				int subject_id = Integer.valueOf(String.valueOf(subject_field.getSelectedIndex())) + 1;
				int marks = Integer.valueOf(textField_3.getText());
				String period = String.valueOf(period_Field.getSelectedItem());

			    addResults(reg_number, term, subject_id, marks, period);
			}
		});

		add(btnNewButton, gbc_btnNewButton);
	}
}
