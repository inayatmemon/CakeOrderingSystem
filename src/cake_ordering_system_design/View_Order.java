package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View_Order extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Order frame = new View_Order();
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
	public View_Order() {
		setTitle("Cake Ordering System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lb_title = new JLabel("VIEW ORDERS");
		lb_title.setForeground(new Color(138, 43, 226));
		lb_title.setFont(new Font("Verdana", Font.BOLD, 35));
		lb_title.setBounds(85, 13, 291, 51);
		contentPane.add(lb_title);
		
		JButton btn_ViewByOrderID = new JButton("View By Order ID");
		btn_ViewByOrderID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btn_ViewByOrderID.setBackground(new Color(255,255,255));
				btn_ViewByOrderID.setForeground(new Color(0, 0, 0));
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				btn_ViewByOrderID.setForeground(new Color(139, 0, 0));
				
				btn_ViewByOrderID.setBackground(new Color(222, 184, 135));
			}
		});
		btn_ViewByOrderID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					viewid();
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_ViewByOrderID.setForeground(new Color(139, 0, 0));
		btn_ViewByOrderID.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btn_ViewByOrderID.setBackground(new Color(222, 184, 135));
		
		
		btn_ViewByOrderID.setBounds(135, 75, 200, 51);
		contentPane.add(btn_ViewByOrderID);
		btn_ViewByOrderID.addActionListener(this);
		btn_ViewByOrderID.setActionCommand("ViewById");
		
		JButton btn_ViewByDate = new JButton("View By Rec. Date");
		btn_ViewByDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btn_ViewByDate.setBackground(new Color(255,255,255));
				btn_ViewByDate.setForeground(new Color(0, 0, 0));
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				btn_ViewByDate.setForeground(new Color(139, 0, 0));
				
				btn_ViewByDate.setBackground(new Color(222, 184, 135));
			}
		});
		btn_ViewByDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					viewdate();
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_ViewByDate.setForeground(new Color(139, 0, 0));
		btn_ViewByDate.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btn_ViewByDate.setBackground(new Color(222, 184, 135));
		btn_ViewByDate.setBounds(135, 150, 200, 51);
		contentPane.add(btn_ViewByDate);
		btn_ViewByDate.addActionListener(this);
		btn_ViewByDate.setActionCommand("ViewByDate");
		
		JButton btn_ViewByMobile = new JButton("View By Mobile");
		btn_ViewByMobile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btn_ViewByMobile.setBackground(new Color(255,255,255));
				btn_ViewByMobile.setForeground(new Color(0, 0, 0));
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				btn_ViewByMobile.setForeground(new Color(139, 0, 0));
				
				btn_ViewByMobile.setBackground(new Color(222, 184, 135));
			}
		});
		btn_ViewByMobile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					viewmobile();
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_ViewByMobile.setForeground(new Color(139, 0, 0));
		btn_ViewByMobile.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btn_ViewByMobile.setBackground(new Color(222, 184, 135));
		btn_ViewByMobile.setBounds(135, 225, 200, 51);
		contentPane.add(btn_ViewByMobile);
		btn_ViewByMobile.addActionListener(this);
		btn_ViewByMobile.setActionCommand("ViewByMobile");
		
		JButton btn_ViewAll = new JButton("View All Orders");
		btn_ViewAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btn_ViewAll.setBackground(new Color(255,255,255));
				btn_ViewAll.setForeground(new Color(0, 0, 0));
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				btn_ViewAll.setForeground(new Color(139, 0, 0));
				
				btn_ViewAll.setBackground(new Color(222, 184, 135));
			}
		});
		btn_ViewAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					viewall();
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_ViewAll.setForeground(new Color(139, 0, 0));
		btn_ViewAll.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		btn_ViewAll.setBackground(new Color(222, 184, 135));
		btn_ViewAll.setBounds(135, 300, 200, 51);
		contentPane.add(btn_ViewAll);
		btn_ViewAll.addActionListener(this);
		btn_ViewAll.setActionCommand("ViewAll");
		
		JButton btn_home = new JButton("Home");
		btn_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btn_home.setBackground(Color.BLACK);
				btn_home.setForeground(Color.WHITE);
				
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				btn_home.setForeground(new Color(139, 0, 0));
				
				btn_home.setBackground(new Color(222, 184, 135));
			}
		});
		btn_home.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					
					
					
					
				
					
					home();
					
					
					
					
					
					
					
					
				}
			}
		});
		btn_home.setForeground(new Color(139, 0, 0));
		btn_home.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		btn_home.setBackground(new Color(143, 188, 143));
		btn_home.setBounds(135, 375, 200, 51);
		contentPane.add(btn_home);
		btn_home.addActionListener(this);
		btn_home.setActionCommand("Home");
	}
	
	public void viewall(){
		this.dispose();
		View_All pl4 = new View_All();
		pl4.setVisible(true);
		
	}
	
	public void viewid(){
		this.dispose();
		View_By_ID pl1 = new View_By_ID();
		pl1.setVisible(true);
		
	}
	
	public void viewmobile(){
		this.dispose();
		View_By_Mobile pl3 = new View_By_Mobile();
		pl3.setVisible(true);
		
	}
	
	public void viewdate(){
		this.dispose();
		View_By_Date pl2 = new View_By_Date();
		pl2.setVisible(true);
		
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
		else if(cmd.equals("ViewById")){
			
			viewid();
			
		
		}
		else if(cmd.equals("ViewByDate")){
			
			viewdate();
			
		
		}
		else if(cmd.equals("ViewByMobile")){
			
			viewmobile();
		
			*/
		}
		if(cmd.equals("ViewAll")){
			viewall();
		
		}
		
	}

}
