package sms;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class addTime extends JPanel {
	private JComboBox textField;
	private JComboBox textField_1;
	private JComboBox textField_2;
	private JComboBox textField_3;
	private JComboBox textField_4;
	private JComboBox textField_5;
	private JComboBox textField_6;
	private JComboBox textField_7;
	private JComboBox textField_8;
	private JComboBox textField_9;
	private JComboBox textField_10;
	private JComboBox textField_11;
	private JComboBox textField_12;

	
	//adding a teacher to the database
	public void addTime(String subject, String day, String time, String st_class) {
		databaseConnection conn = null;
		try {
			conn = new databaseConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "insert into timetable(subject, day, time, class) values"
				+ "('" + subject + "','" + day + "','" + time + "','"  + st_class + "')";
		conn.insertData(query);	
		
		revalidate();
		repaint();

		JOptionPane.showMessageDialog(null, "Time added successfully.");
	}
	
	

	/**
	 * Create the panel.
	 */
	public addTime() {
		setBackground(SystemColor.controlHighlight);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Add TimeTable Entry");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(30, 120, 5, 5);
		gbc_lblNewLabel.gridwidth = 11;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		databaseConnection conn = null;
		try {
			conn = new databaseConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] subjects = {};
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(subjects));
		String query1 = "select subject_name from subject";
		ResultSet res = conn.getData(query1);

		try {

			// data of the table
			while (res.next()) {
				arrayList.add(res.getString("subject_name"));
			}
			subjects = arrayList.toArray(subjects);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_1 = new JLabel("First Period :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(10, 120, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JComboBox(subjects);
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(10, 0, 5, 5);
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		
		JLabel lblNewLabel_2 = new JLabel("First Period Teacher:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 7;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JComboBox();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(10, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 9;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Second Period :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_2 = new JComboBox(subjects);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(10, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 4;
		add(textField_2, gbc_textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Second Period Teacher :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 7;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_3 = new JComboBox();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(10, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 9;
		gbc_textField_3.gridy = 4;
		add(textField_3, gbc_textField_3);

		JLabel lblNewLabel_5 = new JLabel("Third Period :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 4;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		textField_4 = new JComboBox(subjects);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(10, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 4;
		add(textField_4, gbc_textField_2);

		JLabel lblNewLabel_6 = new JLabel("Third Period Teacher :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 7;
		gbc_lblNewLabel_6.gridy = 4;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		textField_5 = new JComboBox();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(10, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 9;
		gbc_textField_7.gridy = 4;
		add(textField_5, gbc_textField_7);

		JLabel lblNewLabel_7 = new JLabel("Fourth Period :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 4;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		textField_6 = new JComboBox(subjects);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(10, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 5;
		gbc_textField_8.gridy = 4;
		add(textField_6, gbc_textField_8);

		JLabel lblNewLabel_8 = new JLabel("Fourth Period Teacher :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 7;
		gbc_lblNewLabel_8.gridy = 4;
		add(lblNewLabel_8, gbc_lblNewLabel_8);

		textField_7 = new JComboBox();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(10, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 9;
		gbc_textField_9.gridy = 4;
		add(textField_7, gbc_textField_9);

		JLabel lblNewLabel_9 = new JLabel("Fifth Period :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 3;
		gbc_lblNewLabel_9.gridy = 4;
		add(lblNewLabel_9, gbc_lblNewLabel_9);

		textField_8 = new JComboBox(subjects);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(10, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 5;
		gbc_textField_10.gridy = 4;
		add(textField_8, gbc_textField_10);

		JLabel lblNewLabel_10 = new JLabel("Fifth Period Teacher :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 7;
		gbc_lblNewLabel_10.gridy = 4;
		add(lblNewLabel_10, gbc_lblNewLabel_10);

		textField_9 = new JComboBox();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(10, 0, 5, 5);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 9;
		gbc_textField_11.gridy = 4;
		add(textField_9, gbc_textField_11);

		JLabel lblNewLabel_11 = new JLabel("Sixth Period :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 3;
		gbc_lblNewLabel_11.gridy = 4;
		add(lblNewLabel_11, gbc_lblNewLabel_11);

		textField_10 = new JComboBox(subjects);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(10, 0, 5, 5);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 5;
		gbc_textField_12.gridy = 4;
		add(textField_10, gbc_textField_12);

		JLabel lblNewLabel_12 = new JLabel("Sixth Period Teacher :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 7;
		gbc_lblNewLabel_12.gridy = 4;
		add(lblNewLabel_12, gbc_lblNewLabel_12);

		textField_11 = new JComboBox();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.insets = new Insets(10, 0, 5, 5);
		gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_13.gridx = 9;
		gbc_textField_13.gridy = 4;
		add(textField_11, gbc_textField_13);


		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setPreferredSize(new Dimension(200,30));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(30, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 6;
		
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		add(btnNewButton, gbc_btnNewButton);

	}

}
