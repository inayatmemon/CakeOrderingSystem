package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View_By_Mobile extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tf_mobile;
	
	JTable table;
	JFrame frame1; 
	String[] columnNames = {"Order_ID","Name", "Mobile No", "Cake Type", "Cake Flavour",  "Shape", "Weight",
			"Rate", "Advance", "Pending", "Rec. Date", "Rec. Time","Special Note"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_By_Mobile frame = new View_By_Mobile();
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
	public View_By_Mobile() {
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
		
		JLabel lb_title = new JLabel("VIEW BY MOBILE");
		lb_title.setForeground(new Color(70, 130, 180));
		lb_title.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
		lb_title.setBounds(76, 13, 332, 45);
		contentPane.add(lb_title);
		
		JLabel lb_mobile = new JLabel("Mobile Number :");
		lb_mobile.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lb_mobile.setBounds(147, 58, 169, 45);
		contentPane.add(lb_mobile);
		
		tf_mobile = new JTextField();
		tf_mobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					view();
					
					
					
					
					
					
					
					
				}
			}
		});
		tf_mobile.setHorizontalAlignment(SwingConstants.CENTER);
		tf_mobile.setForeground(new Color(106, 90, 205));
		tf_mobile.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		tf_mobile.setBackground(new Color(253, 245, 230));
		tf_mobile.setBounds(65, 97, 326, 45);
		contentPane.add(tf_mobile);
		tf_mobile.setColumns(10);
		
		JButton btn_Submit = new JButton("Submit");
		btn_Submit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					view();
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_Submit.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_Submit.setBackground(new Color(152, 251, 152));
		btn_Submit.setBounds(162, 170, 139, 45);
		contentPane.add(btn_Submit);
		btn_Submit.addActionListener(this);
		btn_Submit.setActionCommand("Sub");
		
		JButton btn_Home = new JButton("Home");
		btn_Home.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					home();
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_Home.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_Home.setBackground(new Color(72, 209, 204));
		btn_Home.setBounds(162, 310, 139, 45);
		contentPane.add(btn_Home);
		btn_Home.addActionListener(this);
		btn_Home.setActionCommand("Home");
		
		JButton btn_back = new JButton("Back");
		btn_back.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					back();
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_back.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_back.setBackground(new Color(72, 209, 204));
		btn_back.setActionCommand("Home");
		btn_back.setBounds(162, 240, 139, 45);
		contentPane.add(btn_back);
		btn_back.addActionListener(this);
		btn_back.setActionCommand("Back");
		
		
		
		
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

			
			
			String mobile = tf_mobile.getText();
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
			PreparedStatement ps = con.prepareStatement("Select * from cake_order where Mobile = '"+mobile+"'");
			
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
	
	public void home(){
		
		this.dispose();
		Cake_ordering_system_Home pl = new Cake_ordering_system_Home();
		pl.setVisible(true);
		
	}

	public void back(){
		
		this.dispose();
		View_Order pl2 = new View_Order();
		pl2.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("Home")){
			
			home();
			
		
		}
		else if(cmd.equals("Back")){
			
			
			back();
		
		}
		else if(cmd.equals("Sub")){
			
			
			view();
			
			}
		
			
				
			
		

	

	}}

