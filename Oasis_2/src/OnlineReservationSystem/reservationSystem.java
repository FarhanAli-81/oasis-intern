package OnlineReservationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.net.ssl.ExtendedSSLSession;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class reservationSystem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reservationSystem frame = new reservationSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	Connection con;
	PreparedStatement pstmt;
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
	public reservationSystem() throws ClassNotFoundException {
		
		connect();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logged In Successfully !!");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(40, 82, 224, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reservation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reservation res=new Reservation();
				res.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 31));
		btnNewButton.setBounds(191, 153, 299, 78);
		contentPane.add(btnNewButton);
		
		JButton btnCancelTicket = new JButton("Cancel Ticket");
		btnCancelTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 try {
				
				 String query="select * from reservationDetails";
					PreparedStatement pstmt=con.prepareStatement(query);
					ResultSet set=pstmt.executeQuery();
				
					Login l=new Login();
					String username=l.getUsername();
					String password=l.getPassword();
					System.out.println(username);
					while(set.next()) {
						
						String log=set.getString(1);
						String pas=set.getString(2);
						int num=set.getInt(3);
						
						if(log.equals(username) && pas.equals(password)) {
							System.out.println(log);
							System.out.println(username);
							if(num==0) {
							
								JOptionPane.showMessageDialog(null, "nothing to delete");
								
								break;
							}
							
						}
					
					}
					JOptionPane.showMessageDialog(null, "deleted");
		
					
			 }
			 catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
				
			}
		});
		btnCancelTicket.setForeground(Color.WHITE);
		btnCancelTicket.setFont(new Font("Tahoma", Font.BOLD, 31));
		btnCancelTicket.setBackground(new Color(255, 0, 0));
		btnCancelTicket.setBounds(191, 309, 299, 78);
		contentPane.add(btnCancelTicket);
	}

}
