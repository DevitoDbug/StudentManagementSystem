package studentManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import database.model;


public class studentDisplayPanel extends JPanel implements ActionListener{
	JButton deletstd;
	JButton refresh;
	
	JTable table = new JTable();
	JScrollPane pane = new JScrollPane(table);
	Object [] columns = {"Student Name", "Gender" , "Year" , "Age"};
	DefaultTableModel model = new DefaultTableModel();
	Object[] row = new Object[4];
	Object[] headers = new Object[4];

	//____Gerald's Changes____
	ArrayList<ArrayList<String>> data = new ArrayList<>();
	DefaultTableModel myTableModel = new DefaultTableModel();

	//____Gerald's Changes____

	public ArrayList<String> titles = new ArrayList<>();
	public ArrayList<model> data1 = new ArrayList<>();
	
	
	//adding the titles to the array list 
	
	public studentDisplayPanel(ArrayList<model> newdata) {
		super();
		this.data1.addAll(newdata);
		
		
	}

	
	public studentDisplayPanel() {

		//the pane 
				pane.setForeground(Color.RED);
				pane.setBackground(Color.black);
				pane.setPreferredSize(new Dimension (1200,550));
				
				
				
				//model
				model.setColumnIdentifiers(columns);

				//the table
					//____Gerald's Changes____
						table = new JTable(myTableModel);
					//____Gerald's Changes____
						table.setBounds(0, 0, 500, 550);
						table.setModel(model);
						table.setBackground(Color.WHITE);
						table.setForeground(Color.BLACK);
						table.setSelectionBackground(Color.CYAN);
						table.setGridColor(Color.RED);
						table.setSelectionForeground(Color.WHITE);
						table.setRowHeight(30);
						table.setAutoCreateRowSorter(true);
						
						
				//the delete button
				deletstd = new JButton("Delet Student");
				deletstd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					 //data.remove()
					}
				});
				//refreshing the view 
				refresh = new JButton("Refresh view");
				refresh.setBounds(505, 200, 90, 50);
				refresh.setFocusable(false);
				refresh.setForeground(Color.BLUE);
				refresh.setFont(new Font("Times New Roman",Font.PLAIN,15));
				refresh.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				refresh.addActionListener(this);	

				
				//adding the new info to the table
				titles.add("Student Name");
				titles.add("Gender");
				titles.add("Age");
				titles.add("Year");
				headers[0] = titles.get(0).toUpperCase();
				headers[1] = titles.get(1);
				headers[2] = titles.get(2);
				headers[3] = titles.get(3);
				model.addRow(headers);
//				model.addRow(updateInfo(data1));
				
				
				this.add(table);
				this.add(refresh);
				this.add(pane);
				
				this.setLayout(null);
				this.setVisible(true);
				this.setPreferredSize(new Dimension (1000,550));
				this.setBackground(Color.gray);
				this.setFocusable(true);
		
		
	}
	

	public Object[] updateInfo(ArrayList<model> info) {
		//ArrayList<model> data = new ArrayList<>();
		//System.out.print("\n     her her      "+ data.get(0)+"\n");				
		
			for (int i = 0 ; i < info.size(); i++)
			{

				row[0] = info.get(i).name.toString();
				row[1] = info.get(i).gender.toString();
				row[2] = info.get(i).age.toString();
				row[3] = info.get(i).year.toString();
				
			}
			return this.row;
	}

	//___Gerald's changes____
	public void setData1(database.model data1) {
		this.data1.add(data1);
		//System.out.println("here");
		//System.out.println(data1);
		updateInfo(data1);
	}

	private void updateInfo(model model) {
		ArrayList<String> row = new ArrayList<>();
		row.add(model.name);
		row.add(model.gender);
		row.add(model.age);
		row.add(model.year);
//		System.out.println(Arrays.toString(data.toArray()));
		DefaultTableModel tableUpdate = (DefaultTableModel) table.getModel();
		tableUpdate.addRow(row.toArray());
	}


	//___Gerald's changes____

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==  refresh)
		{
			///updateInfo();
		}
	}

}
