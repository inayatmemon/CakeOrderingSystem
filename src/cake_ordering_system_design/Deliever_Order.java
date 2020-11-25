package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Deliever_Order extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTable table;
	JFrame frame1; 
	String[] columnNames = {"Order_ID","Name", "Mobile No", "Cake Type", "Cake Flavour",  "Shape", "Weight",
			"Rate", "Advance", "Pending", "Rec. Date", "Rec. Time","Special Note"};
	
	String[] columnNames2 = {"Delievered On","Order_ID","Name", "Order On","Mobile No", "Cake Type", "Cake Flavour",  "Shape", "Weight",
			"Rate", "Advance", "Pending", "Rec. Date", "Rec. Time","Rec. By"};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deliever_Order frame = new Deliever_Order();
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
	public Deliever_Order() {
		
		setTitle("Cake Ordering System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		javax.swing.UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 20));
		javax.swing.UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 15));
		
		JLabel lb_title = new JLabel("DELIEVERED ORDERS");
		lb_title.setForeground(new Color(138, 43, 226));
		lb_title.setFont(new Font("Verdana", Font.BOLD, 30));
		lb_title.setBounds(59, 13, 370, 51);
		contentPane.add(lb_title);
		
		JButton btn_ViewAll = new JButton("View All Orders");
		btn_ViewAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_ViewAll.setForeground(new Color(75, 0, 130));
				btn_ViewAll.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_ViewAll.setForeground(new Color(75, 0, 130));
				btn_ViewAll.setBackground(new Color(211, 211, 211));
			}
		});
		btn_ViewAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					view();
				}
			}
		});
		btn_ViewAll.setForeground(new Color(75, 0, 130));
		btn_ViewAll.setBackground(new Color(211, 211, 211));
		btn_ViewAll.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		btn_ViewAll.setBounds(112, 80, 261, 40);
		contentPane.add(btn_ViewAll);
		btn_ViewAll.addActionListener(this);
		btn_ViewAll.setActionCommand("View All");
		
		
		
		JButton btn_makedeliever = new JButton("Confirm Delievery");
		btn_makedeliever.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_makedeliever.setForeground(new Color(75, 0, 130));
				btn_makedeliever.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_makedeliever.setForeground(new Color(75, 0, 130));
				btn_makedeliever.setBackground(new Color(211, 211, 211));
			}
		});
		btn_makedeliever.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					makedel();
				}
			}
		});
		btn_makedeliever.setForeground(new Color(75, 0, 130));
		btn_makedeliever.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		btn_makedeliever.setBackground(new Color(211, 211, 211));
		btn_makedeliever.setBounds(112, 150, 261, 40);
		contentPane.add(btn_makedeliever);
		btn_makedeliever.addActionListener(this);
		btn_makedeliever.setActionCommand("Make Del");
		
		
		
		JButton btn_ViewDeliever = new JButton("View Delievered Orders");
		btn_ViewDeliever.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_ViewDeliever.setForeground(new Color(75, 0, 130));
				btn_ViewDeliever.setBackground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_ViewDeliever.setForeground(new Color(75, 0, 130));
				btn_ViewDeliever.setBackground(new Color(211, 211, 211));
			}
		});
		btn_ViewDeliever.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					viewdel();
				}
			}
		});
		btn_ViewDeliever.setForeground(new Color(75, 0, 130));
		btn_ViewDeliever.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btn_ViewDeliever.setBackground(new Color(211, 211, 211));
		btn_ViewDeliever.setBounds(112, 220, 261, 40);
		contentPane.add(btn_ViewDeliever);
		btn_ViewDeliever.addActionListener(this);
		btn_ViewDeliever.setActionCommand("View Del");
		
		JButton btn_Home = new JButton("Home");
		btn_Home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Home.setForeground(Color.WHITE);
				btn_Home.setBackground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Home.setForeground(new Color(75, 0, 130));
				btn_Home.setBackground(new Color(211, 211, 211));
			}
		});
		btn_Home.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					home();
				}
			}
		});
		btn_Home.setForeground(new Color(75, 0, 130));
		btn_Home.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		btn_Home.setBackground(new Color(211, 211, 211));
		btn_Home.setBounds(112, 290, 261, 40);
		contentPane.add(btn_Home);
		btn_Home.addActionListener(this);
		btn_Home.setActionCommand("Home");
	}



public void view(){
	try{
		

		frame1 = new JFrame("Database Search Result");
		//frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(new BorderLayout());
		
		
		//TableModel tm = new TableModel();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		table = new JTable(model);
		
		
		
		table = new JTable();
		table.setModel(model); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		table.setRowHeight(30);
		table.getColumn("Order_ID").setPreferredWidth(200);
		table.getColumn("Name").setPreferredWidth(220);
		table.getColumn("Mobile No").setPreferredWidth(150);
		table.getColumn("Cake Type").setPreferredWidth(170);
		table.getColumn("Cake Flavour").setPreferredWidth(170);
		table.getColumn("Shape").setPreferredWidth(170);
		table.getColumn("Weight").setPreferredWidth(100);
		table.getColumn("Rate").setPreferredWidth(100);
		table.getColumn("Advance").setPreferredWidth(100);
		table.getColumn("Pending").setPreferredWidth(100);
		table.getColumn("Rec. Date").setPreferredWidth(180);
		table.getColumn("Rec. Time").setPreferredWidth(100);
		table.getColumn("Special Note").setPreferredWidth(400);
		
		
		
		
		
		
		
		
		
		
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		frame1.getContentPane().add(new JScrollPane(scroll));
		
	
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
		PreparedStatement ps = con.prepareStatement("Select * from cake_order");
		
		ResultSet rs = ps.executeQuery();
		int i=0;
		while(rs.next())
		{	
			long id = rs.getLong("Order_ID");
			String name = rs.getString("Name");
			String mobile_2 = rs.getString("Mobile");
			String cake_type = rs.getString("Cake_Type");
			String cake_flavour = rs.getString("Cake_Flavour");
			String shape = rs.getString("Shape");
			String weight = rs.getString("Weight");
			String rate = rs.getString("Rate");
			String advance = rs.getString("Advance");
			String pending = rs.getString("Pending");
			String pickup_date = rs.getString("Rec_Date");
			String pickup_time = rs.getString("Rec_Time");
			String specialnote = rs.getString("Special_Note");
			
			model.addRow(new Object[]{id,name, mobile_2, cake_type, cake_flavour, shape, weight, rate, advance, pending, pickup_date, pickup_time,specialnote});
			i++;
		}
		
		if(i <1)
		{
		JOptionPane.showMessageDialog(null, "No Record Found");
		}
		else if(i ==1)
		{
			JOptionPane.showMessageDialog(null,i+" Record Found");
		}
		else
		{
			JOptionPane.showMessageDialog(null,i+" Records Found");
		}
		con.close();
		}
		catch(Exception ex)
		{
		JOptionPane.showMessageDialog(null,"Error");
		}
	
	
	//Component scroll = null;
	
	frame1.setVisible(true);
	frame1.setSize(2000,1000);

}

public void makedel(){
	this.dispose();
	Confirm_Delievery pl = new Confirm_Delievery();
	pl.setVisible(true);
	
}

public void viewdel(){


		
		

		try{
			

			frame1 = new JFrame("Database Search Result");
			//frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.getContentPane().setLayout(new BorderLayout());
			
			
			//TableModel tm = new TableModel();
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames2);
			//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
			table = new JTable(model);
			
			
			
			table = new JTable();
			table.setModel(model); 
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setFillsViewportHeight(true);
			table.setFont(new Font("Sylfaen", Font.PLAIN, 20));
			table.setRowHeight(30);
			table.getColumn("Delievered On").setPreferredWidth(200);
			table.getColumn("Order_ID").setPreferredWidth(200);
			table.getColumn("Name").setPreferredWidth(220);
			table.getColumn("Order On").setPreferredWidth(200);
			table.getColumn("Mobile No").setPreferredWidth(150);
			table.getColumn("Cake Type").setPreferredWidth(170);
			table.getColumn("Cake Flavour").setPreferredWidth(170);
			table.getColumn("Shape").setPreferredWidth(100);
			table.getColumn("Weight").setPreferredWidth(100);
			table.getColumn("Rate").setPreferredWidth(100);
			table.getColumn("Advance").setPreferredWidth(100);
			table.getColumn("Pending").setPreferredWidth(100);
			table.getColumn("Rec. Date").setPreferredWidth(150);
			table.getColumn("Rec. Time").setPreferredWidth(100);
			table.getColumn("Rec. By").setPreferredWidth(200);
			
			JScrollPane scroll = new JScrollPane(table);
			//	JScrollPane scroll = new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
				//Component scroll = null;
				frame1.getContentPane().add(new JScrollPane(scroll));
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
			PreparedStatement ps = con.prepareStatement("Select * from deliever_order");
			
			ResultSet rs = ps.executeQuery();
			int i=0;
			while(rs.next())
			{	
				String date = rs.getTimestamp(2).toString();
				long id = rs.getLong("Order_ID");
				String name = rs.getString("Name");
				String oron = rs.getString(4);
				String mobile_2 = rs.getString("Mobile");
				String cake_type = rs.getString("Cake_Type");
				String cake_flavour = rs.getString("Cake_Flavour");
				String shape = rs.getString("Shape");
				String weight = rs.getString("Weight");
				String rate = rs.getString("Rate");
				String advance = rs.getString("Advance");
				String pending = rs.getString("Pending");
				String pickup_date = rs.getString("Rec_Date");
				String pickup_time = rs.getString("Rec_Time");
				String rec_by = rs.getString("REC_NAME");
				
				model.addRow(new Object[]{date,id,name,oron, mobile_2, cake_type, cake_flavour, shape, weight, rate, advance, pending, pickup_date, pickup_time,rec_by});
				i++;
			}
			
			if(i <1)
			{
			JOptionPane.showMessageDialog(null, "No Record Found");
			}
			else if(i ==1)
			{
				JOptionPane.showMessageDialog(null,i+" Record Found");
			}
			else
			{
				JOptionPane.showMessageDialog(null,i+" Records Found");
			}
			con.close();
			}
			catch(Exception ex)
			{
			JOptionPane.showMessageDialog(null,"Error :    "+ex);
			}
		
		
		frame1.setVisible(true);
		frame1.setSize(1800,800);
		
		
		
		
	}
	
	


public void home(){
	this.dispose();
	Cake_ordering_system_Home pl = new Cake_ordering_system_Home();
	pl.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String cmd = e.getActionCommand();
	if(cmd.equals("Home")){
		home();
}
	else if(cmd.equals("Make Del")){
	makedel();
}
	else if(cmd.equals("View Del")){
		viewdel();
}
	else if(cmd.equals("View All")){
		view();
}
	
}
}
