package OnlineReservationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
      
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	Connection con;
	PreparedStatement pstmt;
	int train=0;
	public int getTrain() {
		return train;
	}
	public void connect() throws ClassNotFoundException {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String user="root";
			String pass="root";
			String url="jdbc:mysql://localhost:3306/oasis";
			con=DriverManager.getConnection(url, user, pass);
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	public Login() throws ClassNotFoundException {
		connect();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(230, 11, 262, 62);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		panel.setBounds(123, 103, 426, 270);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(32, 69, 127, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(32, 153, 127, 22);
		panel.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(169, 64, 213, 39);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(169, 142, 213, 39);
		panel.add(password);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from reservationDetails";
					PreparedStatement pstmt=con.prepareStatement(query);
					ResultSet set=pstmt.executeQuery();
					boolean correct=false;
					while(set.next()) {
						String log=set.getString(1);
						String pas=set.getString(2);
						if(log.equals(username.getText()) && pas.equals(password.getText())) {
							correct=true;
							
							reservationSystem r=new reservationSystem();
							r.setVisible(true);
							
						}
						
					}
					if(!correct) {
						JOptionPane.showMessageDialog(null, "invalid username or password");
						username.setText("");
						password.setText("");
						username.requestFocus();
					}
					
					
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(169, 216, 89, 23);
		panel.add(btnNewButton);
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		
		return username.getText();
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password.getText();
	}
}
