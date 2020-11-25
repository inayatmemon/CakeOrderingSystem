package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Confirm_Delievery extends JFrame {

	private JPanel contentPane;
	private JTextField tf_orderid;
	private JTextField tf_showid;
	private JTextField tf_orderon;
	private JTextField tf_name;
	private JTextField tf_mob;
	private JTextField tf_caketype;
	private JTextField tf_cakeflavour;
	private JTextField tf_shape;
	private JTextField tf_weight;
	private JTextField tf_rate;
	private JTextField tf_advance;
	private JTextField tf_pending;
	private JTextField tf_rdate;
	private JTextField tf_rtime;
	private JTextField tf_sn;
	
	String orderid,rec_name,rec_no;
	private JTextField tf_recname;
	private JTextField tf_recno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm_Delievery frame = new Confirm_Delievery();
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
	public Confirm_Delievery() {
		setTitle("Cake Ordering System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1346, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		javax.swing.UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 20));
		javax.swing.UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 15));
		
		
		JLabel lb_title = new JLabel("CONFIRM DELIEVERY");
		lb_title.setForeground(new Color(138, 43, 226));
		lb_title.setFont(new Font("Verdana", Font.BOLD, 30));
		lb_title.setBounds(565, 13, 370, 51);
		contentPane.add(lb_title);
		
		JLabel lbl_OrderID = new JLabel("Order ID :");
		lbl_OrderID.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		lbl_OrderID.setForeground(new Color(128, 128, 128));
		lbl_OrderID.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_OrderID.setBounds(73, 124, 178, 39);
		contentPane.add(lbl_OrderID);
		
		tf_orderid = new JTextField();
		tf_orderid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					rec_name = tf_recname.getText();
					rec_no = tf_recno.getText();
					orderid = tf_orderid.getText().toString();
					details(orderid,rec_name,rec_no);				}
			}
		});
		tf_orderid.setHorizontalAlignment(SwingConstants.CENTER);
		tf_orderid.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_orderid.setForeground(new Color(0, 0, 255));
		tf_orderid.setBackground(new Color(238, 232, 170));
		tf_orderid.setBounds(22, 162, 286, 39);
		contentPane.add(tf_orderid);
		tf_orderid.setColumns(10);
		
		JButton btn_showdetails = new JButton("Show Details");
		btn_showdetails.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
				rec_name = tf_recname.getText();
				rec_no = tf_recno.getText();
				orderid = tf_orderid.getText().toString();
				details(orderid,rec_name,rec_no);
				}
			}
		});
		btn_showdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec_name = tf_recname.getText();
				rec_no = tf_recno.getText();
				orderid = tf_orderid.getText().toString();
				details(orderid,rec_name,rec_no);
			}
		});
		btn_showdetails.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btn_showdetails.setBackground(new Color(255, 255, 255));
		btn_showdetails.setBounds(63, 430, 188, 39);
		contentPane.add(btn_showdetails);
		
		JLabel lbl_OrderID2 = new JLabel("Order ID :");
		lbl_OrderID2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_OrderID2.setForeground(Color.GRAY);
		lbl_OrderID2.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_OrderID2.setBounds(324, 126, 147, 39);
		contentPane.add(lbl_OrderID2);
		
		tf_showid = new JTextField();
		tf_showid.setEditable(false);
		tf_showid.setHorizontalAlignment(SwingConstants.CENTER);
		tf_showid.setForeground(Color.BLUE);
		tf_showid.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_showid.setColumns(10);
		tf_showid.setBackground(new Color(238, 232, 170));
		tf_showid.setBounds(495, 125, 303, 39);
		contentPane.add(tf_showid);
		
		JLabel lbl_OrderOn = new JLabel("Order On :");
		lbl_OrderOn.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_OrderOn.setForeground(Color.GRAY);
		lbl_OrderOn.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_OrderOn.setBounds(324, 202, 147, 39);
		contentPane.add(lbl_OrderOn);
		
		JLabel lbl_name = new JLabel("Customer Name :");
		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_name.setForeground(Color.GRAY);
		lbl_name.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lbl_name.setBounds(324, 278, 147, 39);
		contentPane.add(lbl_name);
		
		JLabel lbl_mob = new JLabel("Customer Mob :");
		lbl_mob.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mob.setForeground(Color.GRAY);
		lbl_mob.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lbl_mob.setBounds(324, 353, 147, 39);
		contentPane.add(lbl_mob);
		
		JLabel lbl_caketype = new JLabel("Cake Type :");
		lbl_caketype.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caketype.setForeground(Color.GRAY);
		lbl_caketype.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_caketype.setBounds(324, 430, 147, 39);
		contentPane.add(lbl_caketype);
		
		JLabel lbl_cakeflavour = new JLabel("Cake Flavour :");
		lbl_cakeflavour.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cakeflavour.setForeground(Color.GRAY);
		lbl_cakeflavour.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_cakeflavour.setBounds(324, 502, 147, 39);
		contentPane.add(lbl_cakeflavour);
		
		JLabel lbl_shape = new JLabel("Shape :");
		lbl_shape.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_shape.setForeground(Color.GRAY);
		lbl_shape.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_shape.setBounds(324, 575, 147, 39);
		contentPane.add(lbl_shape);
		
		tf_orderon = new JTextField();
		tf_orderon.setHorizontalAlignment(SwingConstants.CENTER);
		tf_orderon.setForeground(Color.BLUE);
		tf_orderon.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_orderon.setEditable(false);
		tf_orderon.setColumns(10);
		tf_orderon.setBackground(new Color(238, 232, 170));
		tf_orderon.setBounds(495, 200, 303, 39);
		contentPane.add(tf_orderon);
		
		tf_name = new JTextField();
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setForeground(Color.BLUE);
		tf_name.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_name.setEditable(false);
		tf_name.setColumns(10);
		tf_name.setBackground(new Color(238, 232, 170));
		tf_name.setBounds(495, 275, 303, 39);
		contentPane.add(tf_name);
		
		tf_mob = new JTextField();
		tf_mob.setHorizontalAlignment(SwingConstants.CENTER);
		tf_mob.setForeground(Color.BLUE);
		tf_mob.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_mob.setEditable(false);
		tf_mob.setColumns(10);
		tf_mob.setBackground(new Color(238, 232, 170));
		tf_mob.setBounds(495, 350, 303, 39);
		contentPane.add(tf_mob);
		
		tf_caketype = new JTextField();
		tf_caketype.setHorizontalAlignment(SwingConstants.CENTER);
		tf_caketype.setForeground(Color.BLUE);
		tf_caketype.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_caketype.setEditable(false);
		tf_caketype.setColumns(10);
		tf_caketype.setBackground(new Color(238, 232, 170));
		tf_caketype.setBounds(495, 425, 303, 39);
		contentPane.add(tf_caketype);
		
		tf_cakeflavour = new JTextField();
		tf_cakeflavour.setHorizontalAlignment(SwingConstants.CENTER);
		tf_cakeflavour.setForeground(Color.BLUE);
		tf_cakeflavour.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_cakeflavour.setEditable(false);
		tf_cakeflavour.setColumns(10);
		tf_cakeflavour.setBackground(new Color(238, 232, 170));
		tf_cakeflavour.setBounds(495, 500, 303, 39);
		contentPane.add(tf_cakeflavour);
		
		tf_shape = new JTextField();
		tf_shape.setHorizontalAlignment(SwingConstants.CENTER);
		tf_shape.setForeground(Color.BLUE);
		tf_shape.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_shape.setEditable(false);
		tf_shape.setColumns(10);
		tf_shape.setBackground(new Color(238, 232, 170));
		tf_shape.setBounds(495, 575, 303, 39);
		contentPane.add(tf_shape);
		
		JLabel lbl_weight = new JLabel("Weight :");
		lbl_weight.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_weight.setForeground(Color.GRAY);
		lbl_weight.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_weight.setBounds(810, 126, 147, 39);
		contentPane.add(lbl_weight);
		
		JLabel lbl_rate = new JLabel("Rate :");
		lbl_rate.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_rate.setForeground(Color.GRAY);
		lbl_rate.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_rate.setBounds(810, 198, 147, 39);
		contentPane.add(lbl_rate);
		
		JLabel lbl_advance = new JLabel("Advance :");
		lbl_advance.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_advance.setForeground(Color.GRAY);
		lbl_advance.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_advance.setBounds(810, 277, 147, 39);
		contentPane.add(lbl_advance);
		
		JLabel lbl_pending = new JLabel("Pending :");
		lbl_pending.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_pending.setForeground(Color.GRAY);
		lbl_pending.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_pending.setBounds(810, 353, 147, 39);
		contentPane.add(lbl_pending);
		
		JLabel lbl_rdate = new JLabel("Rec. Date :");
		lbl_rdate.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_rdate.setForeground(Color.GRAY);
		lbl_rdate.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_rdate.setBounds(810, 425, 147, 39);
		contentPane.add(lbl_rdate);
		
		JLabel lbl_rtime = new JLabel("Rec. Time :");
		lbl_rtime.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_rtime.setForeground(Color.GRAY);
		lbl_rtime.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_rtime.setBounds(810, 502, 147, 39);
		contentPane.add(lbl_rtime);
		
		JLabel lbl_sn = new JLabel("Special Note :");
		lbl_sn.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sn.setForeground(Color.GRAY);
		lbl_sn.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lbl_sn.setBounds(810, 575, 147, 39);
		contentPane.add(lbl_sn);
		
		tf_weight = new JTextField();
		tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
		tf_weight.setForeground(Color.BLUE);
		tf_weight.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_weight.setEditable(false);
		tf_weight.setColumns(10);
		tf_weight.setBackground(new Color(238, 232, 170));
		tf_weight.setBounds(969, 126, 303, 39);
		contentPane.add(tf_weight);
		
		tf_rate = new JTextField();
		tf_rate.setHorizontalAlignment(SwingConstants.CENTER);
		tf_rate.setForeground(Color.BLUE);
		tf_rate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_rate.setEditable(false);
		tf_rate.setColumns(10);
		tf_rate.setBackground(new Color(238, 232, 170));
		tf_rate.setBounds(969, 198, 303, 39);
		contentPane.add(tf_rate);
		
		tf_advance = new JTextField();
		tf_advance.setHorizontalAlignment(SwingConstants.CENTER);
		tf_advance.setForeground(Color.BLUE);
		tf_advance.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_advance.setEditable(false);
		tf_advance.setColumns(10);
		tf_advance.setBackground(new Color(238, 232, 170));
		tf_advance.setBounds(969, 278, 303, 39);
		contentPane.add(tf_advance);
		
		tf_pending = new JTextField();
		tf_pending.setHorizontalAlignment(SwingConstants.CENTER);
		tf_pending.setForeground(Color.BLUE);
		tf_pending.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_pending.setEditable(false);
		tf_pending.setColumns(10);
		tf_pending.setBackground(new Color(238, 232, 170));
		tf_pending.setBounds(969, 353, 303, 39);
		contentPane.add(tf_pending);
		
		tf_rdate = new JTextField();
		tf_rdate.setHorizontalAlignment(SwingConstants.CENTER);
		tf_rdate.setForeground(Color.BLUE);
		tf_rdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_rdate.setEditable(false);
		tf_rdate.setColumns(10);
		tf_rdate.setBackground(new Color(238, 232, 170));
		tf_rdate.setBounds(969, 425, 303, 39);
		contentPane.add(tf_rdate);
		
		tf_rtime = new JTextField();
		tf_rtime.setHorizontalAlignment(SwingConstants.CENTER);
		tf_rtime.setForeground(Color.BLUE);
		tf_rtime.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_rtime.setEditable(false);
		tf_rtime.setColumns(10);
		tf_rtime.setBackground(new Color(238, 232, 170));
		tf_rtime.setBounds(969, 502, 303, 39);
		contentPane.add(tf_rtime);
		
		tf_sn = new JTextField();
		tf_sn.setHorizontalAlignment(SwingConstants.CENTER);
		tf_sn.setForeground(Color.BLUE);
		tf_sn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_sn.setEditable(false);
		tf_sn.setColumns(10);
		tf_sn.setBackground(new Color(238, 232, 170));
		tf_sn.setBounds(969, 575, 303, 39);
		contentPane.add(tf_sn);
		
		JButton btn_deliever = new JButton("Confirm Delievery");
		btn_deliever.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					rec_name = tf_recname.getText();
					rec_no = tf_recno.getText();
					
					String a = tf_showid.getText();
					long num = Long.parseLong(a);
					confirmdel(num,rec_name,rec_no);
				}
			}
		});
		btn_deliever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tf_showid.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Firstly Enter The OrderID On The Left Side OrderID Fileld \n"
							+ "And Press Show Details Button, After All The Details Will Be Fetched \n"
							+ "Then You Can Confirm The Details And Then You Can Press This Button.");
				}
				else{
					rec_name = tf_recname.getText();
					rec_no = tf_recno.getText();
					
					String a = tf_showid.getText();
					long num = Long.parseLong(a);
					confirmdel(num,rec_name,rec_no);
					
					
					
				}
				
			}
		});
		btn_deliever.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		btn_deliever.setBackground(Color.WHITE);
		btn_deliever.setBounds(696, 660, 370, 56);
		contentPane.add(btn_deliever);
		
		JButton btn_back = new JButton("Back");
		btn_back.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					back();
				}
			}
		});
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_back.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(63, 502, 188, 39);
		contentPane.add(btn_back);
		
		JButton btn_home = new JButton("Home");
		btn_home.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					home();
				}
			}
		});
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});
		btn_home.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btn_home.setBackground(Color.WHITE);
		btn_home.setBounds(63, 575, 188, 39);
		contentPane.add(btn_home);
		
		JLabel lbl_recname = new JLabel("Receiver's Name :");
		lbl_recname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_recname.setForeground(Color.GRAY);
		lbl_recname.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		lbl_recname.setBounds(32, 214, 276, 39);
		contentPane.add(lbl_recname);
		
		JLabel lbl_recno = new JLabel("Receiver's Number :");
		lbl_recno.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_recno.setForeground(Color.GRAY);
		lbl_recno.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		lbl_recno.setBounds(22, 308, 276, 39);
		contentPane.add(lbl_recno);
		
		tf_recname = new JTextField();
		tf_recname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					rec_name = tf_recname.getText();
					rec_no = tf_recno.getText();
					orderid = tf_orderid.getText().toString();
					details(orderid,rec_name,rec_no);				}
			}
		});
		tf_recname.setHorizontalAlignment(SwingConstants.CENTER);
		tf_recname.setForeground(Color.BLUE);
		tf_recname.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_recname.setColumns(10);
		tf_recname.setBackground(new Color(238, 232, 170));
		tf_recname.setBounds(22, 256, 286, 39);
		contentPane.add(tf_recname);
		
		tf_recno = new JTextField();
		tf_recno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					rec_name = tf_recname.getText();
					rec_no = tf_recno.getText();
					orderid = tf_orderid.getText().toString();
					details(orderid,rec_name,rec_no);				}
			}
		});
		tf_recno.setHorizontalAlignment(SwingConstants.CENTER);
		tf_recno.setForeground(Color.BLUE);
		tf_recno.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		tf_recno.setColumns(10);
		tf_recno.setBackground(new Color(238, 232, 170));
		tf_recno.setBounds(22, 350, 286, 39);
		contentPane.add(tf_recno);
	}
	
	public void details(String ID,String rec_name,String rec_no){
	
			long id = 0;
			String date = null,name = null,mobile_2 = null,cake_type = null,cake_flavour = null,shape = null,weight = null,rate = null,advance = null,pending = null,pickup_date = null,pickup_time = null,specialnote = null;
			
			if(ID.equals("")){
				JOptionPane.showMessageDialog(null, "Order ID Field Cannot Be Empty");
				
			}
			else if(rec_name.equals("")){
				JOptionPane.showMessageDialog(null, "Rec. Name Field Cannot Be Empty");
				
			}
			else if(rec_no.equals("")){
				JOptionPane.showMessageDialog(null, "Rec. Number Field Cannot Be Empty");
				
			}else{
				
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
			PreparedStatement ps = con.prepareStatement("Select * from cake_order where Order_ID = '"+ID+"'");
			
			ResultSet rs = ps.executeQuery();
			int i=0;
			while(rs.next())
			{	
				id = rs.getLong(1);
				date = rs.getTimestamp("Order_On").toString();
				name = rs.getString("Name");
				mobile_2 = rs.getString("Mobile");
				cake_type = rs.getString("Cake_Type");
				cake_flavour = rs.getString("Cake_Flavour");
				shape = rs.getString("Shape");
				weight = rs.getString("Weight");
				rate = rs.getString("Rate");
				advance = rs.getString("Advance");
				pending = rs.getString("Pending");
				pickup_date = rs.getString("Rec_Date");
				pickup_time = rs.getString("Rec_Time");
				specialnote = rs.getString("Special_Note");
				
				i++;
			}
			if(i==0)
			{
			JOptionPane.showMessageDialog(null, "No Record Found");
			
			}
			else
			{
				JOptionPane.showMessageDialog(null,i+" Record Found");
				String oid = Long.toString(id);
				tf_showid.setText(oid);
				tf_orderon.setText(date);
				tf_name.setText(name);
				tf_mob.setText(mobile_2);
				tf_caketype.setText(cake_type);
				tf_cakeflavour.setText(cake_flavour);
				tf_shape.setText(shape);
				tf_weight.setText(weight);
				tf_rate.setText(rate);
				tf_advance.setText(advance);
				tf_pending.setText(pending);
				tf_rdate.setText(pickup_date);
				tf_rtime.setText(pickup_time);
				tf_sn.setText(specialnote);
			}
			
			con.close();
			}
			catch(Exception ex)
			{
			JOptionPane.showMessageDialog(null,"Error");
			}
		
		}	
		}
	
	public void back(){
		this.setVisible(false);
		Deliever_Order pl = new Deliever_Order();
		pl.setVisible(true);
	}
	
	public void home(){
		this.setVisible(false);
		Cake_ordering_system_Home pl = new 	Cake_ordering_system_Home();
		pl.setVisible(true);
		
	}
	
	public void confirmdel(Long num,String rec_name,String rec_no){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
			PreparedStatement ps = con.prepareStatement("insert into deliever_order(ORDER_ID,ORDER_ON,NAME,MOBILE,CAKE_TYPE,CAKE_FLAVOUR,SHAPE,WEIGHT,RATE,ADVANCE,PENDING,REC_DATE,REC_TIME,REC_NAME,REC_NO,SPECIAL_NOTE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps1 = con.prepareStatement("Delete from cake_order where Order_ID = '"+num+"'");
			
		//	String random = Long.toHexString(num);
			String random = tf_showid.getText();
			String date =tf_orderon.getText();
			String fname = tf_name.getText();
			String mob = tf_mob.getText();
			String caketype = tf_caketype.getText();
			String cakeflavour = tf_cakeflavour.getText();
			String shape = tf_shape.getText();
			String wei = tf_weight.getText();
			String rat = tf_rate.getText();
			String adva = tf_advance.getText();
			String p = tf_pending.getText();
			String da = tf_rdate.getText();
			String picktime = tf_rtime.getText();
			String sp =tf_sn.getText();
			
			
			
			ps.setString(1,random);
			ps.setString(2, date);
			ps.setString(3,fname);
			ps.setString(4,mob);
			ps.setString(5,caketype);
			ps.setString(6,cakeflavour);
			ps.setString(7,shape);
			ps.setString(8,wei);
			ps.setString(9,rat);
			ps.setString(10,adva);
			ps.setString(11,p);
			ps.setString(12,da);
			ps.setString(13,picktime);
			ps.setString(14,rec_name);
			ps.setString(15,rec_no);
			ps.setString(16, sp);
			
			
			
			ps.executeUpdate();
			
			
			
			JOptionPane.showMessageDialog(null,"Delievered Table Updated");
			
			
			ps1.executeUpdate("Delete from cake_order where Order_ID = '"+num+"'");
			
			JOptionPane.showMessageDialog(null,"Order Delievered Successfully");
			
			
			
			
			
			
			try {
				// Construct data
				String apiKey =  URLEncoder.encode("YOUR API KEY", "UTF-8");
				String message =   URLEncoder.encode(" Dear "+fname+" your order of "+wei+" "+cakeflavour+" with order id : "+random+" has been picked up by "+rec_name+" ( "+rec_no+" ). Your Order delievered from our side successfully. Thankyou verymuch for shopping with XYZ Bakery. Visit Again.", "UTF-8");										

				String sender =  URLEncoder.encode("FSTSMS", "UTF-8");
				String numbers =  URLEncoder.encode(mob, "UTF-8");
				
				// Send data
				String data = "https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sender+"&message="+message+"&language=english&route=p&numbers="+numbers;
				URL url = new URL(data);
				URLConnection conn = url.openConnection();
				conn.setDoOutput(true);
				
				// Get the response
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				String sResult="Message Sent";
				while ((line = rd.readLine()) != null) {
				// Process line...
					sResult=sResult+line+" ";
				}
				rd.close();
				
				System.out.println(sResult);
				JOptionPane.showMessageDialog(null,sResult+" to "+numbers);
			} catch (Exception e2) {
				System.out.println("Error SMS "+e2);
				System.out.println("Message Not Sent : "+e2);
				JOptionPane.showMessageDialog(null,"Message Not Sent..."+e2);
			}
	
			
			
			
			
			
			
			
			tf_showid.setText("");
			tf_orderon.setText("");
			tf_name.setText("");
			tf_mob.setText("");
			tf_caketype.setText("");
			tf_cakeflavour.setText("");
			tf_shape.setText("");
			tf_weight.setText("");
			tf_rate.setText("");
			tf_advance.setText("");
			tf_pending.setText("");
			tf_rdate.setText("");
			tf_rtime.setText("");
			tf_sn.setText("");
			tf_recname.setText("");
			tf_recno.setText("");
			
			
			
			
			
			
			
			
			
			
			con.close();
			}
			catch(Exception ex)
			{
			JOptionPane.showMessageDialog(null,"Error : "+ex);
			}
	}
}
