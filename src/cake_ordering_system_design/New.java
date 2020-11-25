package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;



import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class New extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JTextField tf_name,tf_mobile,tf_weight,tf_rate,tf_advance,tf_pending,tf_specialnote;
//	String caketype,cakeflavour,mobile_number;
	JButton btn_Submit;
	JDateChooser pickupdate;
	String za,zb,pen;
	int ad,total,pend;
	String fname,mob,wei,adva,rat,pendi,da,sp,caketype,cakeflavour,shape,a,b,picktime,mobile_number,p;
	String fname1,mob1,wei1,adva1,rat1,pendi1,da1,sp1,caketype1,cakeflavour1,shape1,a1,b1,picktime1,mobile_number1,p1;
	long random;
	
//	String shape,a,b,p,picktime;
	
	JComboBox cb_caketype,cb_cakeflavour,cb_shape,cb_hour,cb_time;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New frame = new New();
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
	
	public New() {
		setTitle("Cake Ordering System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPlaceOrder = new JLabel("PLACE ORDER");
		lblPlaceOrder.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblPlaceOrder.setBounds(168, 13, 272, 52);
		contentPane.add(lblPlaceOrder);
		
		JLabel lb_name = new JLabel("Full Name :");
		lb_name.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_name.setBounds(30, 80, 109, 34);
		contentPane.add(lb_name);
		
		JLabel lb_mobile = new JLabel("Mobile :");
		lb_mobile.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_mobile.setBounds(30, 125, 109, 34);
		contentPane.add(lb_mobile);
		
		JLabel lb_caketype = new JLabel("Cake Type :");
		lb_caketype.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_caketype.setBounds(30, 170, 109, 34);
		contentPane.add(lb_caketype);
		
		JLabel lb_cakeflavour = new JLabel("Cake Flavour :");
		lb_cakeflavour.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lb_cakeflavour.setBounds(30, 215, 109, 34);
		contentPane.add(lb_cakeflavour);
		
		JLabel lb_shape = new JLabel("Shape :");
		lb_shape.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_shape.setBounds(30, 260, 109, 34);
		contentPane.add(lb_shape);
		
		JLabel lb_weight = new JLabel("Weight :");
		lb_weight.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_weight.setBounds(30, 305, 109, 34);
		contentPane.add(lb_weight);
		
		JLabel lb_rate = new JLabel("Rate :");
		lb_rate.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_rate.setBounds(30, 350, 109, 34);
		contentPane.add(lb_rate);
		
		JLabel lb_advance = new JLabel("Advance :");
		lb_advance.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_advance.setBounds(30, 395, 109, 34);
		contentPane.add(lb_advance);
		
		JLabel lb_pending = new JLabel("Pending :");
		lb_pending.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_pending.setBounds(30, 440, 109, 34);
		contentPane.add(lb_pending);
		
		JLabel lb_pickupdate = new JLabel("Rec. Date :");
		lb_pickupdate.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_pickupdate.setBounds(30, 485, 109, 34);
		contentPane.add(lb_pickupdate);
		
		JLabel lb_pickuptime = new JLabel("Rec. Time :");
		lb_pickuptime.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lb_pickuptime.setBounds(30, 530, 109, 34);
		contentPane.add(lb_pickuptime);
		
		JLabel lb_specialnote = new JLabel("Special Note :");
		lb_specialnote.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lb_specialnote.setBounds(30, 575, 109, 34);
		contentPane.add(lb_specialnote);
		
		tf_name = new JTextField();
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setForeground(new Color(106, 90, 205));
		tf_name.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		tf_name.setBackground(new Color(255, 248, 220));
		tf_name.setBounds(178, 78, 349, 30);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		tf_mobile = new JTextField();
		tf_mobile.setHorizontalAlignment(SwingConstants.CENTER);
		tf_mobile.setForeground(new Color(106, 90, 205));
		tf_mobile.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		tf_mobile.setBackground(new Color(255, 248, 220));
		tf_mobile.setBounds(178, 123, 349, 30);
		contentPane.add(tf_mobile);
		tf_mobile.setColumns(10);
		
		tf_weight = new JTextField();
		tf_weight.setHorizontalAlignment(SwingConstants.CENTER);
		tf_weight.setForeground(new Color(106, 90, 205));
		tf_weight.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		tf_weight.setBackground(new Color(255, 248, 220));
		tf_weight.setBounds(178, 303, 349, 30);
		contentPane.add(tf_weight);
		tf_weight.setColumns(10);
		
		tf_rate = new JTextField();
		tf_rate.setHorizontalAlignment(SwingConstants.CENTER);
		tf_rate.setForeground(new Color(106, 90, 205));
		tf_rate.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		tf_rate.setBackground(new Color(255, 248, 220));
		tf_rate.setBounds(178, 348, 349, 30);
		contentPane.add(tf_rate);
		tf_rate.setColumns(10);
		
		tf_advance = new JTextField();
		tf_advance.setHorizontalAlignment(SwingConstants.CENTER);
		tf_advance.setForeground(new Color(106, 90, 205));
		tf_advance.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		tf_advance.setBackground(new Color(255, 248, 220));
		tf_advance.setBounds(178, 393, 349, 30);
		contentPane.add(tf_advance);
		tf_advance.setColumns(10);
		
		// String ad = tf_advance.getText();
		// String tot = tf_rate.getText();
		
		
		
		
		tf_pending = new JTextField();
		tf_pending.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			try{
				za = tf_advance.getText();
				zb = tf_rate.getText();
				ad = Integer.parseInt(za);
				total = Integer.parseInt(zb);
				int pend = total - ad;
				pen = Integer.toString(pend);
				tf_pending.setText(pen);
			//	pen = new Integer(pend).toString();
				
			}
			catch(Exception e6){
				System.out.println(e6);
			}
			}
		});
		tf_pending.setHorizontalAlignment(SwingConstants.CENTER);
		tf_pending.setForeground(new Color(106, 90, 205));
		tf_pending.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		tf_pending.setBackground(new Color(255, 248, 220));
		tf_pending.setBounds(178, 438, 349, 30);
		contentPane.add(tf_pending);
	
		tf_pending.setColumns(10);
		
		
		tf_specialnote = new JTextField();
		tf_specialnote.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					home();
				}
			}
		});
		
		tf_specialnote.setHorizontalAlignment(SwingConstants.CENTER);
		tf_specialnote.setForeground(new Color(106, 90, 205));
		tf_specialnote.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		tf_specialnote.setBackground(new Color(255, 248, 220));
		tf_specialnote.setBounds(178, 573, 349, 30);
		contentPane.add(tf_specialnote);
		tf_specialnote.setColumns(10);
		
		JComboBox cb_caketype = new JComboBox();
		cb_caketype.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		cb_caketype.setBounds(178, 168, 349, 30);
		cb_caketype.addItem("Select Cake Type");
		cb_caketype.addItem("Regular");
		cb_caketype.addItem("Fresh Cream");
		cb_caketype.addItem("Cheese Cream");
		cb_caketype.addItem("Photocake");
		cb_caketype.addItem("Special");
		contentPane.add(cb_caketype);
		
		JComboBox cb_cakeflavour = new JComboBox();
		cb_cakeflavour.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		cb_cakeflavour.setBounds(178, 213, 349, 30);
		cb_cakeflavour.addItem("Select Flavour");
		contentPane.add(cb_cakeflavour);
		
		JComboBox cb_shape = new JComboBox();
		cb_shape.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		cb_shape.setBounds(178, 258, 349, 30);
		cb_shape.addItem("Select Shape");
    	cb_shape.addItem("Any");
    	cb_shape.addItem("Heart");
    	cb_shape.addItem("Round");
    	cb_shape.addItem("Square");
		contentPane.add(cb_shape);
		
		JDateChooser pickupdate = new JDateChooser();
	//	pickupdate.setHorizontalAlignment(SwingConstants.CENTER);
		pickupdate.setForeground(new Color(106, 90, 205));
		pickupdate.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		pickupdate.setBackground(new Color(255, 248, 220));
		pickupdate.setDateFormatString("dd MMM, yyyy");
		pickupdate.setBounds(178, 483, 349, 30);
		contentPane.add(pickupdate);
		
		JComboBox cb_hour = new JComboBox();
		cb_hour.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		cb_hour.setBounds(178, 528, 169, 30);
		cb_hour.addItem("Select Hour");
		cb_hour.addItem("01");
		cb_hour.addItem("02");
		cb_hour.addItem("03");
		cb_hour.addItem("04");
		cb_hour.addItem("05");
		cb_hour.addItem("06");
		cb_hour.addItem("07");
		cb_hour.addItem("08");
		cb_hour.addItem("09");
		cb_hour.addItem("10");
		cb_hour.addItem("11");
		cb_hour.addItem("12");
		contentPane.add(cb_hour);
		
		JComboBox cb_time = new JComboBox();
		cb_time.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		cb_time.setBounds(359, 528, 168, 30);
		cb_time.addItem("Select Time");
		cb_time.addItem("PM");
		cb_time.addItem("AM");
		contentPane.add(cb_time);
		
		JButton btn_Submit = new JButton("Submit");
		btn_Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long smallest = 0000_0000_0000_0000L;
				long largest = 9999_9999_9999_9999L;
				
				
				 random = ThreadLocalRandom.current().nextLong(smallest,largest);
				 fname = tf_name.getText();
				 mob = tf_mobile.getText();
				 wei = tf_weight.getText();
				 adva = tf_advance.getText();
				 rat = tf_rate.getText();
				 pendi = tf_pending.getText();
				 da = ((JTextField)pickupdate.getDateEditor().getUiComponent()).getText();
				 sp = tf_specialnote.getText();
				 caketype = cb_caketype.getSelectedItem().toString();
				 cakeflavour = cb_cakeflavour.getSelectedItem().toString();
				 shape = cb_shape.getSelectedItem().toString();
				 a = cb_hour.getSelectedItem().toString();
				 b = cb_time.getSelectedItem().toString();
				 picktime =(a+" "+b);
				 mobile_number = tf_mobile.getText();
				 p = tf_pending.getText();
				submitt(random,fname,mob,wei,adva,rat,pendi,da,sp,caketype,cakeflavour,shape,a,b,picktime,mobile_number,p,a,b);
				
			}
		});
		btn_Submit.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_Submit.setBackground(new Color(152, 251, 152));
		btn_Submit.setBounds(178, 635, 151, 52);
		contentPane.add(btn_Submit);
		
		
		JButton btn_Home = new JButton("Home");
		btn_Home.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_Home.setBackground(new Color(255, 239, 213));
		btn_Home.setBounds(376, 635, 151, 52);
		contentPane.add(btn_Home);
		btn_Home.addActionListener(this);
		btn_Home.setActionCommand("Home");
		
		cb_caketype.addItemListener(new ItemListener() {
	            // Listening if a new items of the combo box has been selected.
	            public void itemStateChanged(ItemEvent event) {
	            	
	            	String item = event.getItem().toString();
		            switch (item){
		            
		            case "Select Cake Type":
		            	cb_cakeflavour.removeAllItems();
		            	cb_cakeflavour.addItem("Select Flavour");
		            	break;
		            	
		            case "Regular":
		            	cb_cakeflavour.removeAllItems();
		            	cb_cakeflavour.addItem("Select Flavour");
		            	cb_cakeflavour.addItem("Orange");
		            	cb_cakeflavour.addItem("Mango");
		            	cb_cakeflavour.addItem("Vannila");
		            	cb_cakeflavour.addItem("Chocolate");
		            	cb_cakeflavour.addItem("Pineapple");
		            	cb_cakeflavour.addItem("Pista");
		            	cb_cakeflavour.addItem("Day Night");
		            	cb_cakeflavour.addItem("Strawberry");
		            	cb_cakeflavour.addItem("Butter Scotch");
		            	break;
		            	
		            case "Fresh Cream":
		            	cb_cakeflavour.removeAllItems();
		            	cb_cakeflavour.addItem("Select Flavour");
		            	cb_cakeflavour.addItem("Black Forest");
		            	cb_cakeflavour.addItem("White Forest");
		            	break;
		            	
		            case "Cheese Cream":
		            	cb_cakeflavour.removeAllItems();
		            	cb_cakeflavour.addItem("Select Flavour");
		            	cb_cakeflavour.addItem("Blueberry");
		            	cb_cakeflavour.addItem("Raspberry");
		            	cb_cakeflavour.addItem("Guava");
		            	break;
		            	
		            case "Photocake":
		            	cb_cakeflavour.removeAllItems();
		            	cb_cakeflavour.addItem("Select Flavour");
		            	cb_cakeflavour.addItem("Regular Orange");
		            	cb_cakeflavour.addItem("Regular Mango");
		            	cb_cakeflavour.addItem("Regular Vannila");
		            	cb_cakeflavour.addItem("Regular Chocolate");
		            	cb_cakeflavour.addItem("Regular Pineapple");
		            	cb_cakeflavour.addItem("Regular Pista");
		            	cb_cakeflavour.addItem("Regular Day Night");
		            	cb_cakeflavour.addItem("Regular Strawberry");
		            	cb_cakeflavour.addItem("Regular Butter Scotch");
		            	cb_cakeflavour.addItem("F/C Black Forest");
		            	cb_cakeflavour.addItem("F/C White Forest");
		            	cb_cakeflavour.addItem("C/C Blueberry");
		            	cb_cakeflavour.addItem("C/C Raspberry");
		            	cb_cakeflavour.addItem("C/C Guava");
		            	break;
		            	
		            case "Special":
		            	cb_cakeflavour.removeAllItems();
		            	cb_cakeflavour.addItem("Select Flavour");
		            	cb_cakeflavour.addItem("Regular Orange");
		            	cb_cakeflavour.addItem("Regular Mango");
		            	cb_cakeflavour.addItem("Regular Vannila");
		            	cb_cakeflavour.addItem("Regular Chocolate");
		            	cb_cakeflavour.addItem("Regular Pineapple");
		            	cb_cakeflavour.addItem("Regular Pista");
		            	cb_cakeflavour.addItem("Regular Day Night");
		            	cb_cakeflavour.addItem("Regular Strawberry");
		            	cb_cakeflavour.addItem("Regular Butter Scotch");
		            	cb_cakeflavour.addItem("F/C Black Forest");
		            	cb_cakeflavour.addItem("F/C White Forest");
		            	cb_cakeflavour.addItem("C/C Blueberry");
		            	cb_cakeflavour.addItem("C/C Raspberry");
		            	cb_cakeflavour.addItem("C/C Guava");
		            	break;

		            }
	            	
	            }
		 }
		 );
		
		
		
		
	            }
	
	
	//public void submitt(long random,String fname1,String mob1,String wei1,String adva1,String rat1,String pendi1,String da1,String sp1,String caketype1, String cakeflavour1, String shape1, String a1, String b1,String picktime1, String mobile_number1, String p1){
	public void submitt(long random,String fname,String mob,String wei,String adva,String rat,String pendi,String da,String sp,String caketype, String cakeflavour, String shape, String a, String b,String picktime, String mobile_number, String p, String ab, String bc){
		
		
			
	/*		
		 fname1 = fname;
		 mob1 = mob;
		 wei1 = wei;
		 adva1 = adva;
		 rat1 = rat;
		 pendi1 = pendi;
		 da1 = da;
		 sp1 = sp;
		 caketype1 = caketype;
		 cakeflavour1 = cakeflavour;
		 shape1 = shape;
		 a1 = a;
		 b1 = b;
		 picktime1 =picktime;
		 mobile_number1 = mobile_number;
		 p1 = p;
		*/
			
			
			
			
			//		String unique_id = UUID.randomUUID().toString();
				
					
			//		System.out.println(random);
					
					
			if(fname.equals("")){
				JOptionPane.showMessageDialog(null,"Full Name Field Cannot Be Empty");
			}
			else if(mob.equals("")){
				JOptionPane.showMessageDialog(null,"Mobile Number Field Cannot Be Empty");
			}
			else if(caketype.equals("Select Cake Type")){
				JOptionPane.showMessageDialog(null,"Cake Type Should Be Properly Selected");
			}
			else if(cakeflavour.equals("Select Flavour")){
				JOptionPane.showMessageDialog(null,"Cake Flavour Should Be Properly Selected");
			}
			else if(shape.equals("Select Shape")){
				JOptionPane.showMessageDialog(null,"Shape Should Be Properly Selected, If Customer Has No Choice Then You Can Select Any From Dropdown");
			}
			else if(wei.equals("")){
				JOptionPane.showMessageDialog(null,"Weight Field Cannot Be Empty");
			}
			else if(rat.equals("")){
				JOptionPane.showMessageDialog(null,"Rate Field Cannot Be Empty");
			}
			else if(adva.equals("")){
				JOptionPane.showMessageDialog(null,"Advance Field Cannot Be Empty, If Customer Does Not Paid Anything Then You Can Write 0 In Advance Field");
			}
			else if(pendi.equals("")){
				JOptionPane.showMessageDialog(null,"Pending Field Cannot Be Empty, You Just Fill Rate And Advance Both Fields And Only Click In Pending Filed It Will Autometically Get Filled");
			}
			else if(da.equals("")){
				JOptionPane.showMessageDialog(null,"Receiving Date Field Cannot Be Empty");
			}
			else if(ab.equals("Select Hour")){
				JOptionPane.showMessageDialog(null,"Hour And Time Should Be Properly Selected");
			}
			else if(bc.equals("Select Time")){
				JOptionPane.showMessageDialog(null,"Hour And Time Should Be Properly Selected");
			}
			else{
				
			
					
					
					
					
					
					
					
					
					
				try{
					
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","root","");
					PreparedStatement ps = con.prepareStatement("insert into cake_order(ORDER_ID,NAME,MOBILE,CAKE_TYPE,CAKE_FLAVOUR,SHAPE,WEIGHT,RATE,ADVANCE,PENDING,REC_DATE,REC_TIME,SPECIAL_NOTE) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps.setLong(1,random);
					ps.setString(2,fname);
					ps.setString(3,mob);
					ps.setString(4,caketype);
					ps.setString(5,cakeflavour);
					ps.setString(6,shape);
					ps.setString(7,wei);
					ps.setString(8,rat);
					ps.setString(9,adva);
					ps.setString(10,p);
					ps.setString(11,da);
					ps.setString(12,picktime);
					ps.setString(13,sp);
					
					
					ps.executeUpdate();
				//	System.out.println(unique_id);
					JOptionPane.showMessageDialog(btn_Submit,"Order Confirmed");
					
					
				/*	
					try {
						// Construct data
						String apiKey =  URLEncoder.encode("5QoB48iljqfsKDp2cvL3kJmNCRbrhZEeVwT9tG1YxFgP60XHSu5rpkWuxFCEmXZc2IGifHKwdaoYROe7", "UTF-8");
						String message =   URLEncoder.encode(" Dear "+fname+" Thankyou for shopping with National Baker's , Your order for "+caketype+" "+cakeflavour+" "+wei+" "+shape+" shape is confirmed. Rate is : "+rat+" and "+adva+" advance is paid and "+pendi+" is pending. Please come on "+da+" at "+picktime+" to pickup your order. Your Order ID is : "+random+". Visit Again", "UTF-8");										
						String sender =  URLEncoder.encode("FSTSMS", "UTF-8");
						String numbers =  URLEncoder.encode(mobile_number, "UTF-8");
						
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
					
					
					
					*/
					
					
					
					
					
					
					
					
					
					
					con.close();
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
								
					
				//	String pick_date = ((JTextField)pickupdate.getDateEditor().getUiComponent()).getText();
					
					
					
					
					
			
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Error While Placing Order");
				}
		
		
			}
		
		
		
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
		if(cmd.equals("Home"))

		{
			
			home();
		/*	
			this.dispose();
			Cake_ordering_system_Home pl = new Cake_ordering_system_Home();
			pl.setVisible(true);
		*/
		}
		
	}
}

