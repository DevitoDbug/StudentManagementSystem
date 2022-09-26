package studentManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import database.model;

public class studentInfoPanel extends JPanel implements ActionListener{

	//a list so store the records of students
	public ArrayList<model> stdInfo = new ArrayList<>();

	JButton add = new JButton ("ADD");
	
	JTextField stdName_textF;
	JTextField stdAgetextF;
		
	// ___Gerald's changes____
	//capture the instance of the studentDisplayPanel
	studentDisplayPanel createdPanel;
	// ___Gerald's changes____
	
	JLabel stGender_label;
	JLabel stYear_label;
	
	JComboBox year;
	//the values for the combobox
	String [] year_str = {"2018", "2019" , "2020" , "2021" , "2022"};
	
	JComboBox gender_CB;
	String [] gender_str = { "Complicated", "Male" , "Female" };
	
	//button to save the work
	JButton save;
	
	JButton next;
	Boolean done = true;
	
	
	
	public studentInfoPanel(studentDisplayPanel panel)
	{
		// ___Gerald's changes____
		createdPanel = panel;
		// ___Gerald's changes____


		//student name text field
		stdName_textF = new JTextField();
		stdName_textF.setBounds(20, 40 , 250 , 50);
		Border loweredbevel1= BorderFactory.createLoweredSoftBevelBorder();
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(loweredbevel1, "Student Name");
		title1.setTitleJustification(TitledBorder.LEFT);
		title1.setTitleFont(new Font("Times New Roman",Font.BOLD,15));
		title1.setTitleColor(Color.blue );
		stdName_textF.setBorder(title1);
		
		//age text field 
		stdAgetextF = new JTextField();
		stdAgetextF.setBounds(20, 100 , 250 , 50);
		Border loweredbevel2= BorderFactory.createLoweredBevelBorder();
		TitledBorder title2;
		title2 = BorderFactory.createTitledBorder(loweredbevel2, "Student Age");
		title2.setTitleJustification(TitledBorder.LEFT);
		title2.setTitleFont(new Font("Times New Roman",Font.BOLD,15));
		title2.setTitleColor(Color.blue); 
		stdAgetextF.setBorder(title2);
		
		//label for gender 
		stGender_label = new JLabel("Gender");
		stGender_label.setBounds(20, 160 , 75 , 30);
		stGender_label.setFont(new Font("Times New Roman",Font.BOLD,12));
		stGender_label.setOpaque(true);
		stGender_label.setForeground(Color.blue);
		stGender_label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		//label for the year of study
		stYear_label = new JLabel ("Year of study");
		stYear_label.setBounds(20, 200 ,75 , 30);
		stYear_label.setFont(new Font("Times New Roman",Font.BOLD,12));
		stYear_label.setOpaque(true);
		stYear_label.setForeground(Color.blue);
		stYear_label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		
		//combo boxes 
		gender_CB = new JComboBox(gender_str);
		gender_CB.setBounds(100, 160, 170, 30);
		
		year = new JComboBox(year_str);
		year.setBounds(100, 200 , 170 , 30);
		
		//Buttons
		save = new JButton("Save");
		save.setBounds(300, 250, 170, 50);
		save.setFocusable(false);
		save.setForeground(Color.BLUE);
		save.setFont(new Font("Times New Roman",Font.PLAIN,20));
		save.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		save.addActionListener(this);

		//button to add more records
		next = new JButton("Next Student");
		next.setBounds(300, 190, 170, 50);
		next.setFocusable(false);
		next.setForeground(Color.BLUE);
		next.setFont(new Font("Times New Roman",Font.PLAIN,20));
		next.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				store_info();
				stdName_textF.setText("");
				stdAgetextF.setText("");
				
			}
		});
		
		this.add(next);
		this.add(save);
		this.add(year);
		this.add(gender_CB);
		this.add(stGender_label);
		this.add(stdAgetextF);
		this.add(stdName_textF);
		this.add(stYear_label);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setPreferredSize(new Dimension (1000,550));
		this.setBackground(Color.cyan);
		this.setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == save)
		{
			store_info();
			stdName_textF.setText("");
			stdAgetextF.setText("");

					

		}
	}

	private void store_info() {
		
//		stdInfo.add(new model(stdName_textF.getText(),gender_CB.
//				getSelectedItem().toString(), year.getSelectedItem().toString(), stdAgetextF.getText() ));
		
//		studentDisplayPanel instance = new studentDisplayPanel(stdInfo);
		//instance.data1 = stdInfo;
		//instance.updateInfo(stdInfo);
		
		createdPanel.setData1(new model(stdName_textF.getText(),gender_CB.
				getSelectedItem().toString(), year.getSelectedItem().toString(), stdAgetextF.getText() ));
	}

}
