package sms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Student extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Student frame = new Student();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student(String reg_number, String st_class) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	    JPanel controlPanel = new JPanel();
		contentPane.add(controlPanel, BorderLayout.NORTH);
		
	    JPanel dataPanel = new JPanel();
	    dataPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(dataPanel);
		dataPanel.setLayout(new GridLayout(0, 1, 0, 0));

		viewMarks marks = new viewMarks(reg_number);
		dataPanel.add(marks);


		JButton btnNewButton_2 = new JButton("View marks");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				viewMarks marks = new viewMarks(reg_number);
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(marks);
			}
		});
		
		controlPanel.add(btnNewButton_2);
		
		
		JButton btnNewButton_1 = new JButton("View timetable");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				viewLessons lessons = new viewLessons(st_class);
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(lessons);
			}
		});
		
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
        		setVisible(false);
        		login.setExtendedState(JFrame.MAXIMIZED_BOTH);
        		login.setVisible(true);
			}
		});
		controlPanel.add(btnNewButton_3);

		controlPanel.add(btnNewButton_1);				

	}

}
