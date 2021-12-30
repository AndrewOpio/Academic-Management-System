package sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class Main extends JFrame {

	private JPanel contentPane;

    public Main() {
        
    }

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(25, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	    JPanel controlPanel = new JPanel();
		contentPane.add(controlPanel, BorderLayout.NORTH);
		
	    JPanel dataPanel = new JPanel();
	    dataPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(dataPanel);
		dataPanel.setLayout(new GridLayout(0, 1, 0, 0));

		viewRecords records = new viewRecords();
		dataPanel.add(records);

		JButton btnNewButton_3 = new JButton("Add student's records");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addRecord addrec = new addRecord();
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(addrec);
			}
		});
		
		
		controlPanel.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Add time");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addTime addtime = new addTime();
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(addtime);
			}
		});
		controlPanel.add(btnNewButton_6);

		JButton btnNewButton_4 = new JButton("Add teacher's records");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addTeachers addteacher = new addTeachers();
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(addteacher);
			}
		});

		controlPanel.add(btnNewButton_4);

		JButton btnNewButton_2 = new JButton("Add student results");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addResults addres = new addResults();
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(addres);
			}
		});
		
		controlPanel.add(btnNewButton_2);
		
		
		JButton btnNewButton_7 = new JButton("View timetable");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				viewTimetable time = new viewTimetable();
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(time);
			}
		});
		controlPanel.add(btnNewButton_7);

		JButton btnNewButton_1 = new JButton("View students");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				viewRecords records = new viewRecords();
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(records);
			}
		});
		
		controlPanel.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("View teachers");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		controlPanel.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				viewTeachers viewteachers = new viewTeachers();
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(viewteachers);
			}
		});

		JButton btnNewButton = new JButton("View results");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				viewResults results = new viewResults();
				dataPanel.removeAll();
				dataPanel.revalidate();
				dataPanel.add(results);
			}
		});
		controlPanel.add(btnNewButton);
		
		
		if(username.equals("admin")) {
			btnNewButton_4.setVisible(true);
			btnNewButton_5.setVisible(true);
			
		} else {
			btnNewButton_4.setVisible(false);
			btnNewButton_5.setVisible(false);
		}
				
	}
}
