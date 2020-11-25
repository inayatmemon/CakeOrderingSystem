package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Cake_ordering_system_Home extends JFrame implements ActionListener{

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cake_ordering_system_Home frame = new Cake_ordering_system_Home();
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
	public Cake_ordering_system_Home() {
		getContentPane().setForeground(new Color(102, 102, 153));
		getContentPane().setBackground(new Color(255, 255, 204));
		setBackground(new Color(112, 128, 144));
		setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
		setTitle("Cake Ordering System");
		setForeground(new Color(211, 211, 211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 623);
		getContentPane().setLayout(null);
		
		JLabel lb_title = new JLabel("CAKE ORDERING SYSTEM");
		lb_title.setForeground(new Color(102, 153, 204));
		lb_title.setFont(new Font("Sitka Heading", Font.BOLD, 35));
		lb_title.setBackground(new Color(255, 255, 255));
		lb_title.setBounds(88, 28, 417, 45);
		getContentPane().add(lb_title);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlaceOrder.setBackground(new Color(0,0,0));
				btnPlaceOrder.setForeground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlaceOrder.setForeground(new Color(255, 245, 238));
				
				btnPlaceOrder.setBackground(new Color(51, 204, 204));
				
			}
		});
		btnPlaceOrder.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					place();
				}
			}
		});
		btnPlaceOrder.setForeground(new Color(255, 245, 238));
		btnPlaceOrder.setFont(new Font("Yu Gothic Medium", Font.BOLD, 25));
		btnPlaceOrder.setBackground(new Color(51, 204, 204));
		btnPlaceOrder.setBounds(183, 96, 224, 45);
		getContentPane().add(btnPlaceOrder);
		btnPlaceOrder.addActionListener(this);
		btnPlaceOrder.setActionCommand("Place Order");
		
		JButton btnViewOrders = new JButton("View Orders");
		btnViewOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnViewOrders.setBackground(new Color(0,0,0));
				btnViewOrders.setForeground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnViewOrders.setForeground(new Color(255, 245, 238));
				
				btnViewOrders.setBackground(new Color(51, 204, 204));
				
			}
		});
		btnViewOrders.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					view();
				}
			}
		});
		btnViewOrders.setForeground(new Color(255, 245, 238));
		btnViewOrders.setFont(new Font("Yu Gothic Medium", Font.BOLD, 25));
		btnViewOrders.setBackground(new Color(51, 204, 204));
		btnViewOrders.setBounds(183, 174, 224, 45);
		getContentPane().add(btnViewOrders);
		btnViewOrders.addActionListener(this);
		btnViewOrders.setActionCommand("View Order");
		
		JButton btnCanceldeleteOrders = new JButton("Cancel/Delete Orders");
		btnCanceldeleteOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCanceldeleteOrders.setBackground(new Color(255,0,0));
				btnCanceldeleteOrders.setForeground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCanceldeleteOrders.setForeground(new Color(255, 245, 238));
				
				btnCanceldeleteOrders.setBackground(new Color(51, 204, 204));
				
			}
		});
		btnCanceldeleteOrders.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					cancel();
				}
			}
		});
		btnCanceldeleteOrders.setForeground(new Color(255, 245, 238));
		btnCanceldeleteOrders.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		btnCanceldeleteOrders.setBackground(new Color(51, 204, 204));
		btnCanceldeleteOrders.setBounds(183, 332, 224, 45);
		getContentPane().add(btnCanceldeleteOrders);
		btnCanceldeleteOrders.addActionListener(this);
		btnCanceldeleteOrders.setActionCommand("Cancel Order");
		
		
		JLabel lbl_developer = new JLabel("S/W Designed and Developed By :");
		lbl_developer.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lbl_developer.setForeground(new Color(95, 158, 160));
		lbl_developer.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_developer.setBounds(183, 508, 224, 25);
		getContentPane().add(lbl_developer);
		
		JLabel lbl_developerName = new JLabel("Inayat Memon");
		lbl_developerName.setForeground(new Color(75, 0, 130));
		lbl_developerName.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 20));
		lbl_developerName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_developerName.setBounds(183, 527, 224, 36);
		getContentPane().add(lbl_developerName);
		
		JButton btn_deliever = new JButton("Make Order Delievered");
		btn_deliever.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_deliever.setBackground(new Color(0,0,0));
				btn_deliever.setForeground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_deliever.setForeground(new Color(255, 245, 238));
				
				btn_deliever.setBackground(new Color(51, 204, 204));
				
			}
		});
		btn_deliever.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					deliever();
				}
			}
		});
		btn_deliever.setForeground(new Color(255, 245, 238));
		btn_deliever.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		btn_deliever.setBackground(new Color(51, 204, 204));
		btn_deliever.setActionCommand("Cancel Order");
		btn_deliever.setBounds(183, 253, 224, 45);
		getContentPane().add(btn_deliever);
		btn_deliever.addActionListener(this);
		btn_deliever.setActionCommand("Make Del");
		
		JButton btnaddflavours = new JButton("Add Flavours");
		btnaddflavours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addflavours();
			}
		});
		btnaddflavours.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnaddflavours.setBackground(new Color(0,0,0));
				btnaddflavours.setForeground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnaddflavours.setForeground(new Color(255, 245, 238));
				
				btnaddflavours.setBackground(new Color(51, 204, 204));
				
			}
		});
		btnaddflavours.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					addflavours();
				}
			}
		});
		btnaddflavours.setForeground(new Color(255, 245, 238));
		btnaddflavours.setFont(new Font("Yu Gothic Medium", Font.BOLD, 25));
		btnaddflavours.setBackground(new Color(51, 204, 204));
		btnaddflavours.setBounds(183, 412, 224, 45);
		getContentPane().add(btnaddflavours);
		
		
	
	}
	
	public void place(){
		this.dispose();
		Place_Order pl = new Place_Order();
		pl.setVisible(true);
	}
	
	public void view(){
		this.dispose();
		View_Order pl1 = new View_Order();
		pl1.setVisible(true);
	}
	
	public void cancel(){
		this.dispose();
		Cancel_Order pl2 = new Cancel_Order();
		pl2.setVisible(true);
	}
	
	public void deliever(){
		this.dispose();
		Deliever_Order pl3 = new Deliever_Order();
		pl3.setVisible(true);
	}
	
	public void addflavours(){
		this.dispose();
		Add_Flavours pl4 = new Add_Flavours();
		pl4.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("Place Order")){
			
			place();
		
		}
		else if(cmd.equals("View Order")){
			
			view();
		
		}
		else if(cmd.equals("Cancel Order")){
			
			cancel();
		
		}
		else if(cmd.equals("Make Del")){
			deliever();
		}
		
	}
}
