package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class View_By_Date extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTable table;
	JFrame frame1; 
	String[] columnNames = {"Order_ID","Name", "Mobile No", "Cake Type", "Cake Flavour",  "Shape", "Weight",
			"Rate", "Advance", "Pending", "Rec. Date", "Rec. Time","Special Note"};
	String check;
	JDateChooser pickupdate;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_By_Date frame = new View_By_Date();
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
	public View_By_Date() {
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
		JLabel lb_title = new JLabel("VIEW BY RECEIVING DATE");
		lb_title.setForeground(new Color(70, 130, 180));
		lb_title.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lb_title.setBounds(25, 23, 414, 45);
		contentPane.add(lb_title);
		
		JLabel lb_date = new JLabel("RECEIVING DATE :");
		lb_date.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lb_date.setBounds(107, 81, 240, 45);
		contentPane.add(lb_date);
		
		JDateChooser pickupdate = new JDateChooser();
		pickupdate.setForeground(new Color(106, 90, 205));
		pickupdate.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		pickupdate.setBackground(new Color(255, 248, 220));
		pickupdate.setDateFormatString("dd MMM, yyyy");
		pickupdate.setBounds(107, 127, 265, 38);
		contentPane.add(pickupdate);
		
		((JTextField)pickupdate.getDateEditor().getUiComponent()).addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
					check = ((JTextField)pickupdate.getDateEditor().getUiComponent()).getText();
					view(check);
					
					
					
					
					
					
					
					
					
					
				}
			}
		});
		
		JButton btn_Submit = new JButton("Submit");
		btn_Submit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					check = ((JTextField)pickupdate.getDateEditor().getUiComponent()).getText();
					view(check);
					
				
					
					
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				check = ((JTextField)pickupdate.getDateEditor().getUiComponent()).getText();
				view(check);
				
				
				
	}
		});
			
		btn_Submit.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_Submit.setBackground(new Color(152, 251, 152));
		btn_Submit.setBounds(162, 180, 139, 45);
		contentPane.add(btn_Submit);
		btn_Submit.addActionListener(this);
		btn_Submit.setActionCommand("Sub");
		
		JButton btn_Home = new JButton("Home");
		btn_Home.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_Home.setBackground(new Color(72, 209, 204));
		btn_Home.setBounds(162, 300, 139, 45);
		contentPane.add(btn_Home);
		btn_Home.addActionListener(this);
		btn_Home.setActionCommand("Home");
		
		JButton btn_back = new JButton("Back");
		btn_back.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_back.setBackground(new Color(72, 209, 204));
		btn_back.setActionCommand("Home");
		btn_back.setBounds(162, 240, 139, 45);
		contentPane.add(btn_back);
		btn_back.addActionListener(this);
		btn_back.setActionCommand("Back");

		btn_back.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					back();
					
					
					
					
					
					
					
					
				}
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

		
		
		
	}
	
	
	public void view(String check){
		
		
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
			
	//		String date = ((JTextField)pickupdate.getDateEditor().getUiComponent()).getText();
		//	String date1 = date.toString();
			
		//	textField.setText(date);
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
			PreparedStatement ps = con.prepareStatement("Select * from cake_order where Rec_Date = '"+check+"'");
			
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
		
		
			
				
			
		

	

	}
}



