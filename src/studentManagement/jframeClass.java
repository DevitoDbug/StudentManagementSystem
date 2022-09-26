package studentManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//My xql 

public class jframeClass extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	
	JCheckBox grade_a ;
	JCheckBox grade_b ;
	JCheckBox grade_c;
	JCheckBox grade_d;
	
	
	JButton stored_data = new JButton();
	JButton input_data = new JButton();
	
	boolean display_panel;
	boolean input_panel;
	
	studentDisplayPanel display ;
	studentInfoPanel input ;

	
	
	public jframeClass()
	
	{
		//this are the checkbox for the graded that we gotten in the KCSE
		grade_a = new JCheckBox();
		grade_b = new JCheckBox();
		grade_c = new JCheckBox();
		grade_d = new JCheckBox();

		

		
		//ArrayList<model> nothing = new ArrayList<>();
		 display = new studentDisplayPanel();
		display.setBounds(205, 0, 1900, 550);
		
		 input = new studentInfoPanel(display);
		input.setBounds(205, 0, 1900, 550);

		
		//buttons 
		stored_data = new JButton("Student Data Base");
		stored_data.setBounds(10, 140, 170, 50);
		stored_data.setFocusable(false);
		stored_data.setForeground(Color.BLUE);
		stored_data.setFont(new Font("Times New Roman",Font.PLAIN,20));
		stored_data.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		stored_data.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentManagement.jframeClass.this.display.setVisible(true);

				
			}
		});
		
		input_data = new JButton("Add Student");
		input_data.setBounds(10, 200, 170, 50);
		input_data.setFocusable(false);
		input_data.setForeground(Color.BLUE);
		input_data.setFont(new Font("Times New Roman",Font.PLAIN,20));
		input_data.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		input_data.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentManagement.jframeClass.this.display.setVisible(false);

			}
		});

		
		
		//the panel 
		panel = new JPanel ();
		panel.add(input_data);
		panel.add(stored_data);
		panel.setLayout(null);
		panel.setBackground(new Color(240,70,140));
		panel.setBounds(0, 0, 200, 550);

		
		
			
		this.add(panel);
		this.add(display);
		this.add(input);
		this.setLayout(null);
		this.setSize(900, 590);//remove this later 
		this.setTitle("Student Management System");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		//this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
	
	
}
