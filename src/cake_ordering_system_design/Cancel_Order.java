package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//	import java.sql.Connection;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cancel_Order extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tf_mobile;

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancel_Order frame = new Cancel_Order();
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
	public Cancel_Order() {
		setTitle("Cake Ordering System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 431);
		contentPane = new JPanel();

		javax.swing.UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 20));
		javax.swing.UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 15));
		
		
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lb_title = new JLabel("CANCEL/DELETE ORDER");
		lb_title.setForeground(new Color(70, 130, 180));
		lb_title.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lb_title.setBounds(31, 13, 417, 45);
		contentPane.add(lb_title);
		
		JLabel lb_mobile = new JLabel("Mobile Number/Order ID :");
		lb_mobile.setHorizontalAlignment(SwingConstants.CENTER);
		lb_mobile.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lb_mobile.setBounds(68, 106, 326, 45);
		contentPane.add(lb_mobile);
		
		tf_mobile = new JTextField();
		tf_mobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					String expression = "^[a-zA-Z][ ]*$";
					
					String mobile = tf_mobile.getText();

					if(mobile.matches(expression)){
						JOptionPane.showMessageDialog(null, "This Field Must Contains Numeric Values Only");
					}
					else{
						long number = Long.parseLong(mobile);
						del(mobile,number);
						}
				}
			}
		});
		tf_mobile.setHorizontalAlignment(SwingConstants.CENTER);
		tf_mobile.setForeground(new Color(106, 90, 205));
		tf_mobile.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		tf_mobile.setBackground(new Color(253, 245, 230));
		tf_mobile.setBounds(68, 164, 326, 45);
		contentPane.add(tf_mobile);
		tf_mobile.setColumns(10);
		
		JButton btn_Submit = new JButton("Submit");
		btn_Submit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					String expression = "^[a-zA-Z][ ]*$";
					
					String mobile = tf_mobile.getText();

					if(mobile.matches(expression)){
						JOptionPane.showMessageDialog(null, "This Field Must Contains Numeric Values Only");
					}
					else{
						long number = Long.parseLong(mobile);
						del(mobile,number);
						}
					
				}
			}
		});
		btn_Submit.setFont(new Font("Sylfaen", Font.BOLD, 25));
		btn_Submit.setBackground(new Color(152, 251, 152));
		btn_Submit.setBounds(162, 234, 139, 45);
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
		btn_Home.setBounds(162, 303, 139, 45);
		contentPane.add(btn_Home);
		btn_Home.addActionListener(this);
		btn_Home.setActionCommand("Home");
		
		
		
	}
public void del(String mobile,long number){
		
	try{
		

		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
		PreparedStatement ps = con.prepareStatement("Select * from cake_order where Mobile = '"+mobile+"'"+" OR Order_ID = '"+number+"'");
		PreparedStatement ps1 = con.prepareStatement("delete from cake_order where Mobile = '"+mobile+"'"+" OR Order_ID = '"+number+"'");
		ResultSet rs = ps.executeQuery();
		int i=0;
		while(rs.next())
		{	
		String mobile_2 = rs.getString("Mobile");
		i++;
		}
		if(i <1)
		{
		JOptionPane.showMessageDialog(null, "No Record Found With Mobile Number/Order ID = "+mobile);
		 
		
		}
		else
		{
		JOptionPane.showMessageDialog(null,i+" Record Found");
		//default icon, custom title
        int n = JOptionPane.showConfirmDialog(
            null,
            "Are you confirm to cancel or delete order?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION);

        if(n == JOptionPane.YES_OPTION){
    		
    		
        	ps1.executeUpdate();
    		JOptionPane.showMessageDialog(null,"The Order With Mobile Number/Order ID : "+mobile+" Has Been \n Deleted Successfully");
    		
        }
        else if(n == JOptionPane.NO_OPTION){
        	
        	JOptionPane.showMessageDialog(null,"The Order With Mobile Number/Order ID : "+mobile+" Is Not Deleted..");
        }
		}
		
	
		
		
		
		con.close();
	
		}catch(Exception ex)
	{
	JOptionPane.showMessageDialog(null,"Error");
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
		if(cmd.equals("Home")){
			
			home();
		}
		else if(cmd.equals("Sub")){
			String expression = "^[a-zA-Z][ ]*$";
			
			String mobile = tf_mobile.getText();

			if(mobile.matches(expression)){
				JOptionPane.showMessageDialog(null, "This Field Must Contains Numeric Values Only");
			}
			else{
				long number = Long.parseLong(mobile);
				del(mobile,number);
				}
				}
	}

}
