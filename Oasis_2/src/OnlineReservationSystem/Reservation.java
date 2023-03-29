package OnlineReservationSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JLabel grg;
	private JLabel lblNewLabel_2;
	private JLabel classType;
	private JLabel lblNewLabel_4;
	private JLabel dgd;
	private JTextField trainNo;
	private JTextField classt;
	private JTextField from;
	private JTextField date;
	private JTextField to;
	private JButton btnNewButton;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
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
	public Reservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 75, 595, 140);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 17));
		table.setBackground(new Color(255, 255, 0));
		table.setBorder(new LineBorder(new Color(0, 255, 0)));
		table.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "2345", "Chennai Express"},
				{"2", "0933", "Farhan Express"},
				{"3", "4652", "Jammu Express"},
				{"4", "7860", "VijayaWada Express"},
				{"5", "4545", "Maharaja Express"},
				{"6", "0362", "Duronto Express"},
				{"7", "1234", "Deccan Odyssey"},
			},
			new String[] {
				"s.no", "Train no.", "Train Name"
			}
		));
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Book details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(49, 237, 595, 197);
		contentPane.add(panel);
		panel.setLayout(null);
		
		grg = new JLabel("Train Number");
		grg.setForeground(Color.RED);
		grg.setFont(new Font("Tahoma", Font.BOLD, 15));
		grg.setBackground(Color.WHITE);
		grg.setBounds(10, 39, 184, 34);
		panel.add(grg);
		
		lblNewLabel_2 = new JLabel("Class type");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 69, 184, 34);
		panel.add(lblNewLabel_2);
		
		classType = new JLabel("From");
		classType.setForeground(Color.RED);
		classType.setFont(new Font("Tahoma", Font.BOLD, 15));
		classType.setBackground(Color.WHITE);
		classType.setBounds(10, 109, 184, 34);
		panel.add(classType);
		
		lblNewLabel_4 = new JLabel("To");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(284, 99, 184, 34);
		panel.add(lblNewLabel_4);
		
		dgd = new JLabel("Date");
		dgd.setForeground(Color.RED);
		dgd.setFont(new Font("Tahoma", Font.BOLD, 15));
		dgd.setBackground(Color.WHITE);
		dgd.setBounds(284, 39, 184, 34);
		panel.add(dgd);
		
		trainNo = new JTextField();
		trainNo.setBounds(128, 39, 126, 29);
		panel.add(trainNo);
		trainNo.setColumns(10);
		
		classt = new JTextField();
		classt.setColumns(10);
		classt.setBounds(128, 78, 126, 29);
		panel.add(classt);
		
		from = new JTextField();
		from.setColumns(10);
		from.setBounds(128, 114, 126, 29);
		panel.add(from);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(361, 44, 138, 29);
		panel.add(date);
		
		to = new JTextField();
		to.setColumns(10);
		to.setBounds(361, 99, 138, 29);
		panel.add(to);
		
		btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			String nametrain;
			String pnr;
			Connection con;
			public void actionPerformed(ActionEvent e) {
				
				boolean matched=true;
				
				switch(trainNo.getText()) {
				case "2345":
					nametrain="Chennai Express";
					pnr="123456789";
					
					break;
				case "0933":
					nametrain="Farhan Express";
					pnr="678912345";
					
					break;
				case "4652":
					 nametrain="Jammu Express";
					 pnr="912345678";
					break;
				case "7860":
					 nametrain="VijayaWada Express";
					 pnr="915678234";
					break;
				case "4545":
					 nametrain="Maharaja Express";
					 pnr="823915674";
					break;
				case "0362":
					 nametrain="Duronto Express";
					 pnr="398215674";
					break;
				case "1234":
					 nametrain="Deccan Odyssey";
					 pnr="156823974";
					break;
				default:
					matched=false;
					
					break;
				}
				
				
				
				
				if(matched) {
					JOptionPane.showMessageDialog(null, "TICKET BOOKED \n TraiNo. : "+trainNo.getText()+"\nPNR : "+pnr+"\nTrain : "+nametrain+"\n From : "+from.getText()+"\nTo : "+to.getText()+"\nClass : "+classt.getText()+"\nDate : "+date.getText()+"\n    HAPPY  JOURNEY ");
									}
				else {
					JOptionPane.showMessageDialog(null, "enter correct train number");
				}
				
				
			
			
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(222, 163, 89, 23);
		panel.add(btnNewButton);
		
		JSlider slider = new JSlider();
		slider.setBounds(20, 160, 200, 26);
		panel.add(slider);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Available Trains.....", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(36, 28, 625, 197);
		contentPane.add(panel_1);
	}
}
