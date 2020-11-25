package cake_ordering_system_design;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Add_Flavours extends JFrame {

	private JPanel contentPane;
	private JTextField tf_newtype;
	private JTextField tf_flavour;
	private Button btn_newtype,btn_newtypecancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Flavours frame = new Add_Flavours();
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
	public Add_Flavours() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Add New Flavours");
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lbl_caketype = new JLabel("Select Existing Cake Type");
		lbl_caketype.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caketype.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_caketype.setBounds(12, 24, 274, 31);
		contentPane.add(lbl_caketype);
		
		JComboBox cb_caketype = new JComboBox();
		cb_caketype.setForeground(Color.DARK_GRAY);
		cb_caketype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb_caketype.setBackground(Color.LIGHT_GRAY);
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
			
			
			PreparedStatement ps = con.prepareStatement("Select * from caketype order by type asc");
			
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next())
			{	
				cb_caketype.addItem(rs.getString(2));
			//	a = rs.getInt(1);
			//	a = rs.getInt(1);
			}
			 
			con.close();
		
		}catch(Exception e){
			System.out.println(e);
		}
	
		cb_caketype.setBounds(33, 71, 239, 37);
		contentPane.add(cb_caketype);
		
		tf_newtype = new JTextField();
		tf_newtype.setFont(new Font("Tahoma", Font.BOLD, 18));
		tf_newtype.setHorizontalAlignment(SwingConstants.CENTER);
		tf_newtype.setBounds(33, 131, 239, 37);
		contentPane.add(tf_newtype);
		tf_newtype.setColumns(10);
		tf_newtype.setVisible(false);
		
		JButton btn_newtypecancel = new JButton("Cancel");
		JButton btn_newtype = new JButton("Add Cake Type");
		btn_newtype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_newtype.setBackground(new Color(0, 191, 255));
		btn_newtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_newtype.setVisible(true);
				btn_newtypecancel.setVisible(true);
				btn_newtype.setVisible(false);
				
			}
		});
		btn_newtype.setBounds(77, 132, 136, 37);
		contentPane.add(btn_newtype);
		
		
		btn_newtypecancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_newtypecancel.setBackground(new Color(0, 191, 255));
		btn_newtypecancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_newtype.setVisible(false);
				btn_newtypecancel.setVisible(false);
				btn_newtype.setVisible(true);
				
			}
		});
		btn_newtypecancel.setBounds(284, 131, 136, 37);
		contentPane.add(btn_newtypecancel);
		btn_newtypecancel.setVisible(false);
		
		tf_flavour = new JTextField();
		tf_flavour.setFont(new Font("Tahoma", Font.BOLD, 18));
		tf_flavour.setHorizontalAlignment(SwingConstants.CENTER);
		tf_flavour.setColumns(10);
		tf_flavour.setBounds(33, 256, 239, 37);
		contentPane.add(tf_flavour);
		
		JButton btn_confirm = new JButton("Confirm");
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!tf_newtype.isVisible()){
					//JOptionPane.showMessageDialog(null,"Not Visible");
					String type = cb_caketype.getSelectedItem().toString();
					String newflavour = tf_flavour.getText().toString();
					if(newflavour.equals("")){
						JOptionPane.showMessageDialog(null,"Flavour Name Cannot Be Empty");
					}
					else{
						
					
					try{
						int type_id = 0;
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","","");
						
						
						PreparedStatement ps = con.prepareStatement("Select ID from caketype where type = '"+type+"'");
						PreparedStatement ps1 = con.prepareStatement("insert into cakeflavour(type_ID,flavour) values (?,?)");
						ResultSet rs = ps.executeQuery();
						
						
						
						if(rs.next())
						{	
							type_id = rs.getInt(1);
						}
						 ps1.setInt(1, type_id);
						 ps1.setString(2, newflavour);
						 ps1.executeUpdate();
						 
						 con.close();
						 
						JOptionPane.showMessageDialog(null,"New Flavour Added Successfully In "+type);
					
					}catch(Exception e1){
						System.out.println(e1);
						JOptionPane.showMessageDialog(null,"Error In Adding Flavour");
					}
					}

				}
				else{
					int type_id = 0;
					String newcaketype = tf_newtype.getText().toString();
					String newflavour = tf_flavour.getText().toString();
					if(newcaketype.equals("") || newflavour.equals("")){
						JOptionPane.showMessageDialog(null,"New Cake Type Name or New Flavour Name Cannot Be Empty");
					}
					else{
						
					
					try{
						
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_ordering_system","root","");
						
						
						PreparedStatement ps = con.prepareStatement("Select ID from caketype where type = '"+newcaketype+"'");
						PreparedStatement ps1 = con.prepareStatement("insert into cakeflavour(type_ID,flavour) values (?,?)");
						PreparedStatement ps2 = con.prepareStatement("insert into caketype (type) values(?)");
						
						ps2.setString(1, newcaketype);
						
						ps2.executeUpdate();

						ResultSet rs = ps.executeQuery();
						
						
						
						if(rs.next())
						{	
							type_id = rs.getInt(1);
						}
						 ps1.setInt(1, type_id);
						 ps1.setString(2, newflavour);
						 ps1.executeUpdate();
						 
						 con.close();
						JOptionPane.showMessageDialog(null,"New Cake Type : " +newcaketype+ "And New Flavour : " +newflavour + " Added Successfully");
					
					}catch(Exception e1){
						System.out.println(e1);
						JOptionPane.showMessageDialog(null,"Error in Adding Flavours");
					}
					}	
					//JOptionPane.showMessageDialog(null,"It Is Visible");
				}
				
				
				
			}
		});
		btn_confirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_confirm.setBackground(new Color(0, 191, 255));
		btn_confirm.setBounds(77, 319, 136, 37);
		contentPane.add(btn_confirm);
		
		JLabel lbl_flavour = new JLabel("New Flavour Name");
		lbl_flavour.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flavour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_flavour.setBounds(12, 212, 274, 31);
		contentPane.add(lbl_flavour);
		
		JButton btn_home = new JButton("Home");
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				home();
			}

			
		});
		btn_home.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_home.setBackground(new Color(0, 191, 255));
		btn_home.setBounds(77, 369, 136, 37);
		contentPane.add(btn_home);
	}
	
	private void home() {
		// TODO Auto-generated method stub
		this.dispose();
		Cake_ordering_system_Home pl = new Cake_ordering_system_Home();
		pl.setVisible(true);
	}
}
