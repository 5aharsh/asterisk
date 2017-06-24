/*
 * Saharsh: Line 100: Login(): commented "connection = sqliteConnection.dbConnector();". Added "connection = sqliteConnection.dbConnector();" in Line 183 in lgn_button action
 * Saharsh: Line 189: clickAction() for Login. Added connection and login authentication system.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */



package Default;

import java.awt.EventQueue;
import java.security.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.io.File;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.SystemColor;



public class Login {

	private JFrame formAsterisk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.formAsterisk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	
	/**
	 * Create the application.
	 */
	
	String filePath, originalPath, loginPassword;
	

	
	static final private String rhapsody = "e3jwA8Mfrs8CqcFNj7RfH7RV";
	static private String masterpass;
	static private String prevMaster;
	static final String AB = "0123456789ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijklmonpqrstuvwxyz@$#";
	static SecureRandom rnd = new SecureRandom();
	private JPasswordField lng_passwd_fld;
	private JTextField pathField;
	
	String randomString(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0 ; i < len ; i++)
		{
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}
	
	
	
	public Login() {
		initialize();
		//connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private DefaultTableModel model;
	private DefaultTableModel logmodel;
	private ArrayList<Users> users;
	private ArrayList<Log> log;
	private JPasswordField passfield;
	private JPasswordField confirmpass;
	private JTextField save_dest;
	private String new_file_add;
	private File created_File;
	private JTextField pass_input;
	private JTextField user_input;
	private JTextField web_input;
	private JTextField search_site;
	private JTextField search_user;
	private JTable table;
	private JTextField update_pass;
	private JTextField update_user;
	private JTextField update_web;
	private JTextField delete_site;
	private JTextField delete_user;
	private JPasswordField prevPass;
	private JPasswordField nuPass;
	private JPasswordField conNuPass;
	private JTable logtable;
	
	
	private void initialize() {
		formAsterisk =  new JFrame();
		formAsterisk.setResizable(false);
		formAsterisk.setType(Type.POPUP);
		formAsterisk.setFont(new Font("Rockwell", Font.PLAIN, 12));
		formAsterisk.setTitle("Asterisk* - Password Manager");
		formAsterisk.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\College\\Mini-I\\Asterisk\\Logo\\logo.png"));
		formAsterisk.getContentPane().setLocation(0, 162);
		formAsterisk.getContentPane().setBackground(Color.WHITE);
		formAsterisk.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel welcome = new JPanel();
		welcome.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(welcome, "name_1031052069408735");
		welcome.setLayout(null);
		
		JPanel login = new JPanel();
		login.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(login, "name_1031052084328624");
		login.setLayout(null);
		
		JPanel display = new JPanel();
		display.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(display, "name_1031052111462232");
		display.setLayout(null);
		
		JPanel delete = new JPanel();
		delete.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(delete, "name_1031052149777264");
		delete.setLayout(null);
		
		JPanel help = new JPanel();
		help.setBackground(new Color(0, 191, 255));		
		formAsterisk.getContentPane().add(help, "name_1478948930350");
		help.setLayout(null);
		
		JPanel changeMP = new JPanel();
		formAsterisk.getContentPane().add(changeMP, "name_4670521238724");
		changeMP.setBackground(new Color(0, 191, 255));	
		changeMP.setLayout(null);
		
		JPanel menu = new JPanel();
		formAsterisk.getContentPane().add(menu, "name_5297513390425");
		menu.setBackground(new Color(0, 191, 255));
		menu.setLayout(null);
		
		JPanel about = new JPanel();
		formAsterisk.getContentPane().add(about, "name_232117629067749");
		about.setBackground(new Color(0, 191, 255));
		about.setLayout(null);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Capture.PNG"));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(0, 13, 1027, 82);
		about.add(label_10);
		
		JLabel lblDevelopedBy = new JLabel("Developers");
		lblDevelopedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevelopedBy.setForeground(Color.WHITE);
		lblDevelopedBy.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDevelopedBy.setBounds(354, 401, 317, 38);
		about.add(lblDevelopedBy);
		
		JLabel lblSaharshAnand = new JLabel("Saharsh Anand");
		lblSaharshAnand.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaharshAnand.setForeground(new Color(255, 255, 102));
		lblSaharshAnand.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSaharshAnand.setBounds(183, 454, 225, 29);
		about.add(lblSaharshAnand);
		
		JLabel lblKrushnalDhandhukia = new JLabel("Krushnal Dhandhukia");
		lblKrushnalDhandhukia.setHorizontalAlignment(SwingConstants.CENTER);
		lblKrushnalDhandhukia.setForeground(new Color(255, 255, 102));
		lblKrushnalDhandhukia.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblKrushnalDhandhukia.setBounds(594, 454, 225, 29);
		about.add(lblKrushnalDhandhukia);
		
		JLabel lblbitnirmauniacin = new JLabel("@guywhogeek");
		lblbitnirmauniacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblbitnirmauniacin.setForeground(Color.WHITE);
		lblbitnirmauniacin.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		lblbitnirmauniacin.setBounds(183, 484, 225, 29);
		about.add(lblbitnirmauniacin);
		
		JLabel lblbitnirmauniacin_1 = new JLabel("@krushnald9");
		lblbitnirmauniacin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblbitnirmauniacin_1.setForeground(Color.WHITE);
		lblbitnirmauniacin_1.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		lblbitnirmauniacin_1.setBounds(594, 484, 225, 29);
		about.add(lblbitnirmauniacin_1);
		
		JLabel lblDevelopedAsA = new JLabel("Asterisk* is a minimalistic password manager with complete transparency where user is the");
		lblDevelopedAsA.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevelopedAsA.setForeground(SystemColor.textInactiveText);
		lblDevelopedAsA.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblDevelopedAsA.setBounds(0, 133, 1027, 29);
		about.add(lblDevelopedAsA);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about.setVisible(false);
				menu.setVisible(true);
			}
		});
		button_2.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\anotherback2.png"));
		button_2.setOpaque(false);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBackground(new Color(8, 204, 120));
		button_2.setBounds(15, 16, 49, 46);
		about.add(button_2);
		
		JLabel lblApplicationMakesUser = new JLabel("ultimate owner of all their passwords with the security of AES based encryption on your data.");
		lblApplicationMakesUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplicationMakesUser.setForeground(SystemColor.textInactiveText);
		lblApplicationMakesUser.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblApplicationMakesUser.setBounds(0, 166, 1027, 29);
		about.add(lblApplicationMakesUser);
		
		JLabel lblConsideringAllYour = new JLabel("Keeping data online is the best way to make it vulnerable. Thus, it's important to have your");
		lblConsideringAllYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsideringAllYour.setForeground(SystemColor.textInactiveText);
		lblConsideringAllYour.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblConsideringAllYour.setBounds(0, 199, 1027, 27);
		about.add(lblConsideringAllYour);
		
		JLabel lblSolutionIs = new JLabel("sensetive information, like passwords, to be kept within your personal system. This is where");
		lblSolutionIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolutionIs.setForeground(SystemColor.textInactiveText);
		lblSolutionIs.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSolutionIs.setBounds(0, 230, 1027, 29);
		about.add(lblSolutionIs);
		
		JLabel lblAsteriskHelpsYou = new JLabel("Asterisk* helps you to manage passwords offline with added security and also make it mobile");
		lblAsteriskHelpsYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsteriskHelpsYou.setForeground(SystemColor.textInactiveText);
		lblAsteriskHelpsYou.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAsteriskHelpsYou.setBounds(0, 263, 1027, 29);
		about.add(lblAsteriskHelpsYou);
		
		JLabel lblByProvidingYou = new JLabel("by providing you a movable database, which can be moved and used on any system with");
		lblByProvidingYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblByProvidingYou.setForeground(SystemColor.textInactiveText);
		lblByProvidingYou.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblByProvidingYou.setBounds(0, 296, 1027, 29);
		about.add(lblByProvidingYou);
		
		JLabel lblAsterisk = new JLabel("Asterisk*.");
		lblAsterisk.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsterisk.setForeground(SystemColor.textInactiveText);
		lblAsterisk.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblAsterisk.setBounds(0, 329, 1027, 29);
		about.add(lblAsterisk);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(354, 439, 317, 2);
		about.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(354, 564, 317, 2);
		about.add(separator_1);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblCredits.setBounds(354, 528, 317, 38);
		about.add(lblCredits);
		
		JLabel lblEclipse = new JLabel("Eclipse IDE       Stackoverflow       Flaticons       YouTube       Spotify");
		lblEclipse.setBackground(Color.DARK_GRAY);
		lblEclipse.setHorizontalAlignment(SwingConstants.CENTER);
		lblEclipse.setForeground(Color.DARK_GRAY);
		lblEclipse.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblEclipse.setBounds(0, 580, 1027, 29);
		about.add(lblEclipse);
		
		
		lng_passwd_fld = new JPasswordField();
		lng_passwd_fld.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lng_passwd_fld.setBounds(317, 438, 394, 50);
		login.add(lng_passwd_fld);
		
		
		
		JButton btnChangeMasterPassword = new JButton("Change Master Password");
		btnChangeMasterPassword.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\password2.png"));
		btnChangeMasterPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMP.setVisible(true);
				menu.setVisible(false);
				
			}
		});
		btnChangeMasterPassword.setForeground(Color.WHITE);
		btnChangeMasterPassword.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnChangeMasterPassword.setBackground(new Color(30, 144, 255));
		btnChangeMasterPassword.setBounds(352, 146, 321, 55);
		menu.add(btnChangeMasterPassword);
		
		JButton button_3 = new JButton("");
		button_3.setOpaque(false);
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					users = new ArrayList<Users>();
				       
				       try {
				           
				    	   String q = "SELECT * FROM Data";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rs1 = pst1.executeQuery();
				           int k = 1;
				           while(rs1.next()){
				               
				               Users u = new Users(
				                       k,
				                       rs1.getString("website"),
				                       rs1.getString("username"),
				                       rs1.getString("password")
				               );
				               
				               users.add(u);
				               k++;
				           }
				           
				           model = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[4];
				           
				           columnsName[0] = "#";
				           columnsName[1] = "Website";
				           columnsName[2] = "Username";
				           columnsName[3] = "Password";
				           
				           model.setColumnIdentifiers(columnsName);
				           
				           Object[] rowData = new Object[4];
				           
				           for(int i = 0; i < users.size(); i++){
				               rowData[0] = users.get(i).getId();
				               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
				               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
				               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
				               model.addRow(rowData);
				           }
				           rs1.close();
				           pst1.close();
				            
				       } catch (SQLException ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					table.setModel(model);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(formAsterisk, e2);
				}
				search_site.setText(null);
				search_user.setText(null);
			
				
				menu.setVisible(true);
				changeMP.setVisible(false);
			}
		});
		
		
		
		
		
		
		
		button_3.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\anotherback2.png"));
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button_3.setBackground(new Color(8, 204, 120));
		button_3.setBounds(15, 16, 49, 46);
		changeMP.add(button_3);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\logo2.png"));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(0, 0, 1027, 244);
		changeMP.add(label_9);
		
		JLabel lblPreviousPassword = new JLabel("Previous Password:");
		lblPreviousPassword.setForeground(Color.WHITE);
		lblPreviousPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPreviousPassword.setBounds(344, 261, 198, 34);
		changeMP.add(lblPreviousPassword);
		
		prevPass = new JPasswordField();
		prevPass.setHorizontalAlignment(SwingConstants.LEFT);
		prevPass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		prevPass.setBounds(344, 292, 344, 49);
		changeMP.add(prevPass);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewPassword.setBounds(344, 348, 198, 34);
		changeMP.add(lblNewPassword);
		
		nuPass = new JPasswordField();
		nuPass.setHorizontalAlignment(SwingConstants.LEFT);
		nuPass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		nuPass.setBounds(344, 380, 344, 49);
		changeMP.add(nuPass);
		
		
		
		
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblConfirmPassword.setBounds(344, 440, 198, 34);
		changeMP.add(lblConfirmPassword);
		
		conNuPass = new JPasswordField();
		conNuPass.setHorizontalAlignment(SwingConstants.LEFT);
		conNuPass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		conNuPass.setBounds(344, 472, 344, 49);
		changeMP.add(conNuPass);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					users = new ArrayList<Users>();
				       
				       try {
				           
				    	   String q = "SELECT * FROM Data";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rs1 = pst1.executeQuery();
				           int k = 1;
				           while(rs1.next()){
				               
				               Users u = new Users(
				                       k,
				                       rs1.getString("website"),
				                       rs1.getString("username"),
				                       rs1.getString("password")
				               );
				               
				               users.add(u);
				               k++;
				           }
				           
				           model = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[4];
				           
				           columnsName[0] = "#";
				           columnsName[1] = "Website";
				           columnsName[2] = "Username";
				           columnsName[3] = "Password";
				           
				           model.setColumnIdentifiers(columnsName);
				           
				           Object[] rowData = new Object[4];
				           
				           for(int i = 0; i < users.size(); i++){
				               rowData[0] = users.get(i).getId();
				               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
				               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
				               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
				               model.addRow(rowData);
				           }
				           rs1.close();
				           pst1.close();
				            
				       } catch (SQLException ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					table.setModel(model);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(formAsterisk, e2);
				}
				search_site.setText(null);
				search_user.setText(null);
			
				
			display.setVisible(true);
			help.setVisible(false);
			}
		});
		btnDone.setIcon(null);
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnDone.setBackground(new Color(255, 255, 51));
		btnDone.setBounds(453, 583, 121, 48);
		help.add(btnDone);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\steps.png"));
		lblNewLabel_4.setBounds(0, 11, 1027, 561);
		help.add(lblNewLabel_4);
		
		JButton lgn_bk_bnt = new JButton("");
		lgn_bk_bnt.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\anotherback2.png"));
		lgn_bk_bnt.setSelectedIcon(null);
		lgn_bk_bnt.setOpaque(false);
		lgn_bk_bnt.setFocusPainted(false);
		lgn_bk_bnt.setBorderPainted(false);
		lgn_bk_bnt.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				pathField.setText(null);
				lng_passwd_fld.setText(null);
				welcome.setVisible(true);
				login.setVisible(false);
				masterpass = lng_passwd_fld.getText();
			}
		});
		
		lgn_bk_bnt.setForeground(Color.WHITE);
		lgn_bk_bnt.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lgn_bk_bnt.setBackground(new Color(245, 102, 23));
		lgn_bk_bnt.setBounds(15, 16, 49, 46);
		login.add(lgn_bk_bnt);
		
		
		
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "SQLite Database", "sqlite");
		fc.setFileFilter(filter);
		final JButton db_choose_btn = new JButton(" Pick");
		db_choose_btn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\choose2.png"));
		db_choose_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				int returnVal = fc.showDialog(db_choose_btn, "Choose");
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					String returnAdd = file.getAbsolutePath();
					String fixAdd = returnAdd.replace("\\", "\\\\");
					pathField.setText(returnAdd);
					filePath = fixAdd;
					originalPath = returnAdd;
					 
				}
			}
		});
		db_choose_btn.setForeground(Color.WHITE);
		db_choose_btn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		db_choose_btn.setBackground(new Color(245, 102, 23));
		db_choose_btn.setBounds(551, 353, 160, 50);
		login.add(db_choose_btn);
		

		
		
		
		pathField = new JTextField();
		pathField.setEditable(false);
		pathField.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
		pathField.setBounds(317, 353, 235, 50);
		login.add(pathField);
		JButton lgn_btn = new JButton(" Login");
		lgn_btn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\done2.png"));
		lgn_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(originalPath==null){
					JOptionPane.showMessageDialog(null, "No database chosen!");
				}
				else{
					connection = sqliteConnection.dbConnector(filePath);
					
					loginPassword = lng_passwd_fld.getText();
					masterpass = loginPassword;
					
					try{
						String scrambled = Encrypt.scramble(Encrypt.rhapsody(loginPassword), loginPassword);
						String query = "select * from whitestar where content = ?";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1,scrambled);
						ResultSet rs = pst.executeQuery();
						int hlp_int = 9;
						int count = 0;
						while(rs.next()){
							hlp_int = rs.getInt("hash");
							count++;
						}
						if(count == 1){
							JOptionPane.showMessageDialog(null, "Authentication Successfull");
							pathField.setText(null);
							lng_passwd_fld.setText(null);
							if(hlp_int == 1)
							{
								help.setVisible(true);
								String query1 = "update whitestar set hash = 0";
								PreparedStatement pst1 = connection.prepareStatement(query1);
								int rs1 = pst1.executeUpdate();
								
							}
							else
							{
									try{
										users = new ArrayList<Users>();
									       
									       try {
									           
									    	   String q = "SELECT * FROM Data";
									           PreparedStatement pst1 = connection.prepareStatement(q);
									           ResultSet rs1 = pst1.executeQuery();
									           int k = 1;
									           while(rs1.next()){
									               
									               Users u = new Users(
									                       k,
									                       rs1.getString("website"),
									                       rs1.getString("username"),
									                       rs1.getString("password")
									               );
									               
									               users.add(u);
									               k++;
									           }
									           
									           model = new DefaultTableModel();
									           
									           Object[] columnsName = new Object[4];
									           
									           columnsName[0] = "#";
									           columnsName[1] = "Website";
									           columnsName[2] = "Username";
									           columnsName[3] = "Password";
									           
									           model.setColumnIdentifiers(columnsName);
									           
									           Object[] rowData = new Object[4];
									           
									           for(int i = 0; i < users.size(); i++){
									               rowData[0] = users.get(i).getId();
									               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
									               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
									               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
									               model.addRow(rowData);
									           }
									           rs1.close();
									           pst1.close();
									            
									       } catch (SQLException ex) {
									           JOptionPane.showMessageDialog(null, ex);
									       }
										 
										table.setModel(model);
										//table.setModel(DbUtils.resultSetToTableModel(rs));
										table.show(true);
										
										
										
									}catch(Exception e2){
										JOptionPane.showMessageDialog(formAsterisk, e2);
									}
									search_site.setText(null);
									search_user.setText(null);
								
								
								display.setVisible(true);
							}
							
							login.setVisible(false);
							Date date = new Date();
							String originalTime =  new SimpleDateFormat("HH:mm dd.MM.yyyy").format(date);
							String time = Encrypt.scramble(masterpass, originalTime);
							String activity = Encrypt.scramble(masterpass, "Logged in.");
							
							String addlog = "insert into userlog (time, activity) values (?, ?)";
							PreparedStatement pstmt = connection.prepareStatement(addlog);
							pstmt.setString(1, time);
							pstmt.setString(2, activity);
							pstmt.execute();
							pstmt.close();
							
						}
						else{
							JOptionPane.showMessageDialog(formAsterisk, "Invalid password!", "Access Denied!", JOptionPane.WARNING_MESSAGE);
						}
						rs.close();
						pst.close();
					
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
						
					}
					
					lng_passwd_fld.setText(null);
				}
			}
		});
		
		
		
		
		

		JButton button_4 = new JButton("");
		button_4.setOpaque(false);
		button_4.setFocusPainted(false);
		button_4.setBorderPainted(false);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					users = new ArrayList<Users>();
				       
				       try {
				           
				    	   String q = "SELECT * FROM Data";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rs1 = pst1.executeQuery();
				           int k = 1;
				           while(rs1.next()){
				               
				               Users u = new Users(
				                       k,
				                       rs1.getString("website"),
				                       rs1.getString("username"),
				                       rs1.getString("password")
				               );
				               
				               users.add(u);
				               k++;
				           }
				           
				           model = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[4];
				           
				           columnsName[0] = "#";
				           columnsName[1] = "Website";
				           columnsName[2] = "Username";
				           columnsName[3] = "Password";
				           
				           model.setColumnIdentifiers(columnsName);
				           
				           Object[] rowData = new Object[4];
				           
				           for(int i = 0; i < users.size(); i++){
				               rowData[0] = users.get(i).getId();
				               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
				               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
				               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
				               model.addRow(rowData);
				           }
				           rs1.close();
				           pst1.close();
				            
				       } catch (SQLException ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					table.setModel(model);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(formAsterisk, e2);
				}
				search_site.setText(null);
				search_user.setText(null);
			
				
				menu.setVisible(false);
				display.setVisible(true);
			}
		});
		button_4.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\anotherback2.png"));
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button_4.setBackground(new Color(8, 204, 120));
		button_4.setBounds(15, 16, 49, 46);
		menu.add(button_4);
		
		JButton btnHelp = new JButton("About");
		btnHelp.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\help2.png"));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about.setVisible(true);
				menu.setVisible(false);
				
			}
		});
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnHelp.setBackground(new Color(30, 144, 255));
		btnHelp.setBounds(352, 63, 321, 55);
		menu.add(btnHelp);
		
		JScrollPane logscroll = new JScrollPane();
		logscroll.setBounds(37, 300, 947, 300);
		menu.add(logscroll);
		
		logtable = new JTable();
		logscroll.setViewportView(logtable);
		
		JButton showlog = new JButton("Reload Log");
		showlog.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\history2.png"));
		showlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					log = new ArrayList<Log>();										
					try{
				    	   String q = "SELECT * FROM userlog";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rset= pst1.executeQuery();
				           int k = 1;
				           while(rset.next()){
				               Log line = new Log(
				                       k,
				                       rset.getString("time"),
				                       rset.getString("activity")
				               );
				               log.add(line);
				               k++;
				           }

				           logmodel = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[3];
				           
				           columnsName[0] = "#";
				           columnsName[1] = "Time";
				           columnsName[2] = "Activity";

				           logmodel.setColumnIdentifiers(columnsName);
				           Object[] rowData = new Object[4];
				           for(int i = 0; i < log.size(); i++){
				               rowData[0] = log.get(i).getId();
				               rowData[1] = Encrypt.unscramble(masterpass, log.get(i).getTime().toString());
				               rowData[2] = Encrypt.unscramble(masterpass, log.get(i).getActivity().toString());
				               logmodel.addRow(rowData);
				           }
				           rset.close();
				           pst1.close();

				       } catch (Exception ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					logtable.setModel(logmodel);
					logtable.show(true);
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		showlog.setForeground(Color.WHITE);
		showlog.setFont(new Font("Century Gothic", Font.BOLD, 20));
		showlog.setBackground(new Color(30, 144, 255));
		showlog.setBounds(352, 223, 321, 55);
		menu.add(showlog);
		
		
		lgn_btn.setForeground(Color.WHITE);
		lgn_btn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lgn_btn.setBackground(new Color(8, 204, 120));
		lgn_btn.setBounds(435, 547, 154, 50);
		login.add(lgn_btn);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(317, 403, 198, 34);
		login.add(lblNewLabel_2);
		
		JLabel lblChooseFile = new JLabel("Choose File:");
		lblChooseFile.setForeground(Color.WHITE);
		lblChooseFile.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblChooseFile.setBounds(317, 320, 198, 34);
		login.add(lblChooseFile);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\login.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 1027, 242);
		login.add(label);
		
		
		
		JPanel signup = new JPanel();
		signup.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(signup, "name_1031052097970885");
		signup.setLayout(null);
		
		JPanel add = new JPanel();
		add.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(add, "name_175497036809876");
		add.setLayout(null);
		
		pass_input = new JTextField();
		pass_input.setHorizontalAlignment(SwingConstants.LEFT);
		pass_input.setFont(new Font("Century Gothic", Font.BOLD, 18));
		pass_input.setBounds(339, 453, 344, 49);
		add.add(pass_input);
		
		JButton btnRegister = new JButton(" Add");
		btnRegister.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\done2.png"));
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try{
					String webo = web_input.getText();
					String usero = user_input.getText();
					String passo = pass_input.getText();
					String web = Encrypt.scramble(masterpass, webo.toLowerCase());
					String user = Encrypt.scramble(masterpass, usero.toLowerCase());
					String pass = Encrypt.scramble(masterpass, passo);
					
					String query = "select * from Data where website = ? and username = ?";
					
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.setString(1, web);
					pst1.setString(2, user);
					ResultSet rs = pst1.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count++;
					}
					
					if((count == 0)&&!(webo.equals(""))&&!(usero.equals(""))&&!(passo.equals(""))&&!(passo.contains(" "))){
						String query1 = "insert into Data (website, username, password) values (?, ?, ?)";
						PreparedStatement pst = connection.prepareStatement(query1);
						pst.setString(1, web);
						pst.setString(2, user);
						pst.setString(3, pass);
						pst.execute();
						pst.close();
						Date date = new Date();
						String originalTime =  new SimpleDateFormat("HH:mm dd.MM.yyyy").format(date);
						String time = Encrypt.scramble(masterpass, originalTime);
						String activity = Encrypt.scramble(masterpass, "Added new password for site: "+web_input.getText()+" and username: "+user_input.getText());
						String addlog = "insert into userlog (time, activity) values (?, ?)";
						PreparedStatement pstmt = connection.prepareStatement(addlog);
						pstmt.setString(1, time);
						pstmt.setString(2, activity);
						pstmt.execute();
						pstmt.close();
						
						JOptionPane.showMessageDialog(formAsterisk, "Successfully Added", "Success", JOptionPane.PLAIN_MESSAGE, null);
						web_input.setText(null);
						user_input.setText(null);
						pass_input.setText(null);
					}
					else
					{
						if(count!=0)
							JOptionPane.showMessageDialog(formAsterisk, "Username Password Combo already exist", "Failure", JOptionPane.PLAIN_MESSAGE, null);
						else if(passo.contains(" "))
							JOptionPane.showMessageDialog(formAsterisk, "Password can't contain spaces", "Failure", JOptionPane.PLAIN_MESSAGE, null);
						else
							JOptionPane.showMessageDialog(formAsterisk, "Uh oh! Did you filled up all fields?", "Failure", JOptionPane.PLAIN_MESSAGE, null);
					}
					pst1.close();
					rs.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(formAsterisk, e1, null, JOptionPane.WARNING_MESSAGE, null);
				}
				
			}
		});
		
		
		JButton btnDone_1 = new JButton(" Done");
		btnDone_1.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\done2.png"));
		btnDone_1.setForeground(Color.WHITE);
		btnDone_1.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnDone_1.setBackground(new Color(8, 204, 120));
		btnDone_1.setBounds(399, 532, 238, 60);
		changeMP.add(btnDone_1);
		
		JLabel lblPleaseWaitThis = new JLabel("Please wait... this may take a while");
		lblPleaseWaitThis.setForeground(Color.WHITE);
		lblPleaseWaitThis.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPleaseWaitThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWaitThis.setBounds(366, 601, 304, 25);
		changeMP.add(lblPleaseWaitThis);
		btnDone_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(masterpass.equals(prevPass.getText()) && nuPass.getText().equals(conNuPass.getText())){
					try {
						
						prevMaster = masterpass;
						masterpass = nuPass.getText();
						String fetch = "select * from Data";
						PreparedStatement pst1 = connection.prepareStatement(fetch);
						ResultSet rs1 = pst1.executeQuery();
						String dataup;
						PreparedStatement pst2;
						int k = 1;
						while(rs1.next()){
							dataup = "update Data set website = ?, username = ?, password = ? where id = ?";
							pst2 = connection.prepareStatement(dataup);
							pst2.setString(1, Encrypt.scramble(masterpass, Encrypt.unscramble(prevMaster, rs1.getString("website"))));
							pst2.setString(2, Encrypt.scramble(masterpass, Encrypt.unscramble(prevMaster, rs1.getString("username"))));
							pst2.setString(3, Encrypt.scramble(masterpass, Encrypt.unscramble(prevMaster, rs1.getString("password"))));
							pst2.setInt(4, k);
							pst2.executeUpdate();
							pst2.close();
							k++;
						}
						
						String up = "update whitestar set content = ? ";
						PreparedStatement pst = connection.prepareStatement(up);
						pst.setString(1, Encrypt.scramble(Encrypt.rhapsody(nuPass.getText()), nuPass.getText()));
						pst.executeUpdate();
						pst.close();
						pst1.close();
						rs1.close();
						
						String logfetch = "select * from userlog";
						PreparedStatement pstmt1 = connection.prepareStatement(logfetch);
						ResultSet rset = pstmt1.executeQuery();
						String logdataup;
						PreparedStatement pstmt2;
						k = 1;
						while(rset.next()){
							logdataup = "update userlog set time = ?, activity = ? where id = ?";
							pstmt2 = connection.prepareStatement(logdataup);
							pstmt2.setString(1, Encrypt.scramble(masterpass, Encrypt.unscramble(prevMaster, rset.getString("time"))));
							pstmt2.setString(2, Encrypt.scramble(masterpass, Encrypt.unscramble(prevMaster, rset.getString("activity"))));
							pstmt2.setInt(3, k);
							pstmt2.executeUpdate();
							pstmt2.close();
							k++;
						}
						pstmt1.close();
						rset.close();
						
						/* *
						 * 
						 * Adding to log with nuPass
						 * 
						 * */
						Date date = new Date();
						String originalTime =  new SimpleDateFormat("HH:mm dd.MM.yyyy").format(date);
						String time = Encrypt.scramble(masterpass, originalTime);
						String activity = Encrypt.scramble(masterpass, "Master Password have been changed");
						String addlog = "insert into userlog (time, activity) values (?, ?)";
						PreparedStatement pstmt = connection.prepareStatement(addlog);
						pstmt.setString(1, time);
						pstmt.setString(2, activity);
						pstmt.execute();
						pstmt.close();
						JOptionPane.showMessageDialog(null, "Successfully changed");
						prevPass.setText(null);
						nuPass.setText(null);
						conNuPass.setText(null);
						changeMP.setVisible(false);
						menu.setVisible(true);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else{
					if(!masterpass.equals(prevPass.getText())){
						JOptionPane.showMessageDialog(null, "Seems previous password is incorrect. Try again!", "Failure", JOptionPane.PLAIN_MESSAGE, null);
						prevPass.setText(null);
					}
					else if(!nuPass.getText().equals(conNuPass.getText())){
						JOptionPane.showMessageDialog(null, "New password doesn't match!",  "Failure", JOptionPane.PLAIN_MESSAGE, null);
						nuPass.setText(null);
						conNuPass.setText(null);
					}
				}
				
			}
		});
		
		
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnRegister.setBackground(new Color(8, 204, 120));
		btnRegister.setBounds(388, 547, 238, 60);
		add.add(btnRegister);
		
		JLabel lblWebsite = new JLabel("Website:");
		lblWebsite.setForeground(Color.WHITE);
		lblWebsite.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblWebsite.setBounds(339, 255, 198, 34);
		add.add(lblWebsite);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblUsername.setBounds(339, 334, 198, 34);
		add.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPassword.setBounds(339, 418, 198, 34);
		add.add(lblPassword);
		
		user_input = new JTextField();
		user_input.setFont(new Font("Century Gothic", Font.BOLD, 18));
		user_input.setBounds(339, 370, 344, 47);
		add.add(user_input);
		user_input.setColumns(10);
		
		web_input = new JTextField();
		web_input.setFont(new Font("Century Gothic", Font.BOLD, 18));
		web_input.setColumns(10);
		web_input.setBounds(339, 285, 344, 47);
		add.add(web_input);
		
		JButton back_input = new JButton("");
		back_input.setOpaque(false);
		back_input.setFocusPainted(false);
		back_input.setBorderPainted(false);
		back_input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				web_input.setText(null);
				user_input.setText(null);
				pass_input.setText(null);
				
				try{
					users = new ArrayList<Users>();
				       
				       try {
				           
				    	   String q = "SELECT * FROM Data";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rs1 = pst1.executeQuery();
				           int k = 1;
				           while(rs1.next()){
				               
				               Users u = new Users(
				                       k,
				                       rs1.getString("website"),
				                       rs1.getString("username"),
				                       rs1.getString("password")
				               );
				               
				               users.add(u);
				               k++;
				           }
				           
				           model = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[4];
				           
				           columnsName[0] = "#";
				           columnsName[1] = "Website";
				           columnsName[2] = "Username";
				           columnsName[3] = "Password";
				           
				           model.setColumnIdentifiers(columnsName);
				           
				           Object[] rowData = new Object[4];
				           
				           for(int i = 0; i < users.size(); i++){
				               rowData[0] = users.get(i).getId();
				               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
				               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
				               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
				               model.addRow(rowData);
				           }
				           rs1.close();
				           pst1.close();
				            
				       } catch (SQLException ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					table.setModel(model);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(formAsterisk, e2);
				}
				search_site.setText(null);
				search_user.setText(null);
			
				
				display.setVisible(true);
				add.setVisible(false);
			}
		});
		back_input.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\anotherback2.png"));
		back_input.setForeground(Color.WHITE);
		back_input.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		back_input.setBackground(new Color(8, 204, 120));
		back_input.setBounds(15, 16, 49, 46);
		add.add(back_input);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\addpass2.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 0, 1027, 230);
		add.add(label_1);
		
		JButton btnRandomize = new JButton("Generate");
		btnRandomize.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\generate2.png"));
		btnRandomize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass_input.setText(randomString(10));
				StringSelection stringSelection = new StringSelection(pass_input.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				JOptionPane.showMessageDialog(null, "Password copied!");
			}
		});
		btnRandomize.setForeground(Color.WHITE);
		btnRandomize.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnRandomize.setBackground(Color.LIGHT_GRAY);
		btnRandomize.setBounds(695, 453, 184, 49);
		add.add(btnRandomize);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\College\\Mini-I\\Asterisk\\Logo\\signup.png"));
		lblNewLabel_1.setBounds(0, 0, 1027, 242);
		signup.add(lblNewLabel_1);
		
		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\anotherback2.png"));
		backBtn.setOpaque(false);
		backBtn.setFocusPainted(false);
		backBtn.setBorderPainted(false);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passfield.setText(null);
				save_dest.setText(null);
				confirmpass.setText(null);
				welcome.setVisible(true);
				signup.setVisible(false);
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		backBtn.setBackground(new Color(8, 204, 120));
		backBtn.setBounds(15, 16, 49, 46);
		signup.add(backBtn);
		
		JLabel databasename = new JLabel("Select Database Location & Name:");
		databasename.setForeground(Color.WHITE);
		databasename.setFont(new Font("Century Gothic", Font.BOLD, 16));
		databasename.setBounds(315, 261, 297, 34);
		signup.add(databasename);
		
		JLabel password = new JLabel("Password:");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Century Gothic", Font.BOLD, 16));
		password.setBounds(315, 344, 198, 34);
		signup.add(password);
		
		JLabel confirmpassword = new JLabel("Confirm Password:");
		confirmpassword.setForeground(Color.WHITE);
		confirmpassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		confirmpassword.setBounds(315, 427, 198, 34);
		signup.add(confirmpassword);
		
		passfield = new JPasswordField();
		passfield.setFont(new Font("Century Gothic", Font.BOLD, 18));
		passfield.setHorizontalAlignment(SwingConstants.LEFT);
		passfield.setBounds(315, 377, 382, 49);
		signup.add(passfield);
		
		confirmpass = new JPasswordField();
		confirmpass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		confirmpass.setHorizontalAlignment(SwingConstants.LEFT);
		confirmpass.setBounds(315, 462, 382, 49);
		signup.add(confirmpass);

		final JFileChooser filesave = new JFileChooser();
		filesave.setDialogTitle("Specify a file to save"); 
		FileNameExtensionFilter savefilter = new FileNameExtensionFilter("SQLite Database", "sqlite");
		filesave.setFileFilter(savefilter);
		JButton btn_save_db = new JButton(" Select");
		btn_save_db.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\choose2.png"));
		btn_save_db.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = filesave.showSaveDialog(btn_save_db);
				
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File file = filesave.getSelectedFile();
					new_file_add = file.getAbsolutePath();
					String dblocation = new_file_add+".sqlite";
					save_dest.setText(dblocation);
					filePath=dblocation;
					created_File = new File(new_file_add + ".sqlite");
				}
			}
		});
		btn_save_db.setForeground(Color.WHITE);
		btn_save_db.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btn_save_db.setBackground(new Color(245, 102, 23));
		btn_save_db.setBounds(542, 294, 155, 50);
		signup.add(btn_save_db);
		
		save_dest = new JTextField();
		save_dest.setEditable(false);
		save_dest.setFont(new Font("Century Gothic", Font.BOLD, 18));
		save_dest.setBounds(315, 295, 227, 49);
		signup.add(save_dest);
		save_dest.setColumns(10);
		
		JButton signupBtn = new JButton(" Done");
		signupBtn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\done2.png"));
		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passwordField = passfield.getText();
				String confirmPassword = confirmpass.getText();
				
				if(!passwordField.contains(" ")&&!confirmPassword.equals(null)&&!passwordField.equals(null)&&passwordField.equals(confirmPassword)&&passwordField.length()>=8){
					try {
						created_File.createNewFile();
						JOptionPane.showMessageDialog(null, "Database successfully created!");
						connection = sqliteConnection.dbConnector(filePath); 
						String UD = "Data";
						String query = "CREATE TABLE IF NOT EXISTS " + UD + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, website string, username string, password string)";
						Statement st = connection.createStatement();
						st.execute(query);
						
						String WR = "warning";
						String warn = "CREATE TABLE IF NOT EXISTS " + WR + "(Message string)";
						Statement st3 = connection.createStatement();
						st3.execute(warn);
						
						String inst = "insert into warning('Message') values ('You Are Looking At A Wrong Place Buddy, Please Use Our App To Go Through The Database!!')";
						Statement st4 = connection.createStatement();
						st4.execute(inst);
						
						
						String WS = "whitestar";
						String query1 = "CREATE TABLE IF NOT EXISTS " + WS + "(hash INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content VARCHAR)";
						Statement st1 = connection.createStatement();
						st1.execute(query1);
						
						String UL = "userlog";
						String query2 = "CREATE TABLE IF NOT EXISTS " + UL + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Time VARCHAR NOT NULL, Activity VARCHAR)";
						Statement st2 = connection.createStatement();
						st2.execute(query2);
						Date date = new Date();
						String originalTime =  new SimpleDateFormat("HH:mm dd.MM.yyyy").format(date);
						String time = Encrypt.scramble(passwordField, originalTime);
						String activity = Encrypt.scramble(passwordField, "Database created!");
						
						String addlog = "insert into userlog (time, activity) values (?, ?)";
						PreparedStatement pst = connection.prepareStatement(addlog);
						pst.setString(1, time);
						pst.setString(2, activity);
						pst.execute();
						pst.close();
						
						
						
						String scrambledText = Encrypt.scramble(Encrypt.rhapsody(passwordField), passwordField);
						String query3 = "insert into " + WS + "('content') values ('" + scrambledText + "')";
						PreparedStatement pst3 = connection.prepareStatement(query3);
						pst3.execute();
						passfield.setText(null);
						save_dest.setText(null);
						confirmpass.setText(null);
						
						
					
						
						
						welcome.setVisible(true);
						signup.setVisible(false);
						st.close();
						st1.close();
						st2.close();
						pst3.close();
						st3.close();
						st4.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					if(passwordField.equals("")||confirmPassword.equals(""))
						JOptionPane.showMessageDialog(null, "Password field can't be empty");
					else if(passwordField.length()<8)
						JOptionPane.showMessageDialog(null, "Password length should be more than 8");
					else if(passwordField.contains(" "))
						JOptionPane.showMessageDialog(null, "No spaces are allowed in password");
				}
			}
		});
		signupBtn.setForeground(Color.WHITE);
		signupBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		signupBtn.setBackground(new Color(8, 204, 120));
		signupBtn.setBounds(386, 539, 238, 60);
		signup.add(signupBtn);

		
		
		JButton disp_bk_btn = new JButton("Logout");
		disp_bk_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				masterpass = null;
				connection = null;
				display.setVisible(false);
				welcome.setVisible(true);
			}
		});
		disp_bk_btn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\logout2.png"));
		disp_bk_btn.setForeground(Color.WHITE);
		disp_bk_btn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		disp_bk_btn.setBackground(new Color(8, 204, 120));
		disp_bk_btn.setBounds(15, 16, 127, 45);
		display.add(disp_bk_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 261, 949, 300);
		display.add(scrollPane);
		
        
       
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//JScrollPane pane = new JScrollPane(table);
		
		
		
		JButton addInfo = new JButton("Add");
		addInfo.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\add2.png"));
		addInfo.setBackground(new Color(102, 204, 102));
		addInfo.setForeground(new Color(255, 255, 255));
		addInfo.setFont(new Font("Century Gothic", Font.BOLD, 20));
		addInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_site.setText(null);
				search_user.setText(null);
				add.setVisible(true);
				display.setVisible(false);
			}
		});
		addInfo.setBounds(22, 581, 120, 45);
		display.add(addInfo);
		
		search_site = new JTextField();
		search_site.setBackground(new Color(255, 255, 255));
		search_site.setFont(new Font("Century Gothic", Font.BOLD, 20));
		search_site.setBounds(354, 142, 203, 43);
		display.add(search_site);
		search_site.setColumns(10);
		
		search_user = new JTextField();
		search_user.setBackground(new Color(255, 255, 255));
		search_user.setFont(new Font("Century Gothic", Font.BOLD, 20));
		search_user.setColumns(10);
		search_user.setBounds(354, 191, 203, 43);
		display.add(search_user);
		
		JButton site_search = new JButton("Site");
		site_search.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\site2.png"));
		site_search.setBackground(new Color(106, 90, 205));
		site_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(search_site.getText() != ""){
				model.setRowCount(0);
				users = new ArrayList<Users>();
			       
			       try {
			           
			    	   String q = "SELECT * FROM Data where website = ?";
			           PreparedStatement pst1 = connection.prepareStatement(q);
			           pst1.setString(1, Encrypt.scramble(masterpass, search_site.getText().toLowerCase()));
			           ResultSet rs1 = pst1.executeQuery();
			           int k = 1;
			           while(rs1.next()){
			               
			               Users u = new Users(
			                       k,
			                       rs1.getString("website"),
			                       rs1.getString("username"),
			                       rs1.getString("password")
			               );
			               
			               users.add(u);
			               k++;
			           }
			           
			         
			           
			           Object[] columnsName = new Object[4];
			           
			           columnsName[0] = "#";
			           columnsName[1] = "Website";
			           columnsName[2] = "UserName";
			           columnsName[3] = "Password";
			           
			           model.setColumnIdentifiers(columnsName);
			           
			           Object[] rowData = new Object[4];
			           
			           for(int i = 0; i < users.size(); i++){
			               
			               rowData[0] = users.get(i).getId();
			                rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
			                 rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
			                  rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
			                  
			                  model.addRow(rowData);
			           }
			           pst1.close();
			            
			       } catch (SQLException ex) {
			           JOptionPane.showMessageDialog(null, ex);
			       }
			       search_user.setText(null);
		}
				
				else{
					try{
						users = new ArrayList<Users>();
					       
					       try {
					           
					    	   String q = "SELECT * FROM Data";
					           PreparedStatement pst1 = connection.prepareStatement(q);
					           ResultSet rs1 = pst1.executeQuery();
					           int k = 1;
					           while(rs1.next()){
					               
					               Users u = new Users(
					                       k,
					                       rs1.getString("website"),
					                       rs1.getString("username"),
					                       rs1.getString("password")
					               );
					               
					               users.add(u);
					               k++;
					           }
					           
					           model = new DefaultTableModel();
					           
					           Object[] columnsName = new Object[4];
					           
					           columnsName[0] = "#";
					           columnsName[1] = "Website";
					           columnsName[2] = "Username";
					           columnsName[3] = "Password";
					           
					           model.setColumnIdentifiers(columnsName);
					           
					           Object[] rowData = new Object[4];
					           
					           for(int i = 0; i < users.size(); i++){
					               rowData[0] = users.get(i).getId();
					               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
					               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
					               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
					               model.addRow(rowData);
					           }
					           rs1.close();
					           pst1.close();
					            
					       } catch (SQLException ex) {
					           JOptionPane.showMessageDialog(null, ex);
					       }
						 
						table.setModel(model);
						//table.setModel(DbUtils.resultSetToTableModel(rs));
						table.show(true);
						
						
						
					}catch(Exception e2){
						JOptionPane.showMessageDialog(formAsterisk, e2);
					}
					search_site.setText(null);
					search_user.setText(null);
				
					
					
				}
				
		}});
		site_search.setForeground(new Color(255, 255, 255));
		site_search.setFont(new Font("Century Gothic", Font.BOLD, 20));
		site_search.setBounds(562, 141, 112, 44);
		display.add(site_search);
		
		JButton user_search = new JButton("User");
		user_search.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\user2.png"));
		user_search.setBackground(new Color(106, 90, 205));
		user_search.setForeground(new Color(255, 255, 255));
		user_search.setFont(new Font("Century Gothic", Font.BOLD, 20));
		user_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				users = new ArrayList<Users>();
			       
			       try {
			           
			    	   String q = "SELECT * FROM Data where username = ?";
			           PreparedStatement pst1 = connection.prepareStatement(q);
			           pst1.setString(1, Encrypt.scramble(masterpass, search_user.getText().toLowerCase()));
			           ResultSet rs1 = pst1.executeQuery();
			           int k = 1;
			           while(rs1.next()){
			               
			               Users u = new Users(
			                       k,
			                       rs1.getString("website"),
			                       rs1.getString("username"),
			                       rs1.getString("password")
			               );
			               
			               users.add(u);
			               k++;
			           }
			           
			         
			           
			           Object[] columnsName = new Object[4];
			           
			           columnsName[0] = "#";
			           columnsName[1] = "Website";
			           columnsName[2] = "UserName";
			           columnsName[3] = "Password";
			           
			           model.setColumnIdentifiers(columnsName);
			           
			           Object[] rowData = new Object[4];
			           
			           for(int i = 0; i < users.size(); i++){
			               
			               rowData[0] = users.get(i).getId();
			                rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
			                 rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
			                  rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
			                  
			                  model.addRow(rowData);
			           }
			            
			       } catch (SQLException ex) {
			           JOptionPane.showMessageDialog(null, ex);
			}
			       search_site.setText(null);
		}});
		user_search.setBounds(562, 191, 112, 43);
		display.add(user_search);
		
		JButton btnDeleteData = new JButton("Delete");
		btnDeleteData.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\delete2.png"));
		btnDeleteData.setBackground(new Color(255, 69, 0));
		btnDeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_site.setText(null);
				search_user.setText(null);
				display.setVisible(false);
				delete.setVisible(true);
			}
		});
		btnDeleteData.setForeground(new Color(255, 255, 255));
		btnDeleteData.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnDeleteData.setBounds(888, 581, 127, 45);
		display.add(btnDeleteData);
		
		JLabel lblSearchDataBy = new JLabel("Search");
		lblSearchDataBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchDataBy.setForeground(Color.WHITE);
		lblSearchDataBy.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblSearchDataBy.setBounds(354, 104, 320, 34);
		display.add(lblSearchDataBy);
		
		JPanel update = new JPanel();
		update.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(update, "name_1031052123407705");
		update.setLayout(null);
		
		update_pass = new JTextField();
		update_pass.setHorizontalAlignment(SwingConstants.LEFT);
		update_pass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		update_pass.setBounds(344, 433, 344, 49);
		update.add(update_pass);
		
		
		JButton btnUpdate = new JButton(" Update");
		btnUpdate.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\done2.png"));
		btnUpdate.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try{
					String site = Encrypt.scramble(masterpass, update_web.getText().toLowerCase());
					String user = Encrypt.scramble(masterpass, update_user.getText().toLowerCase());
					String pass = Encrypt.scramble(masterpass, update_pass.getText());
				
					String query = "select * from Data WHERE website= ? and username= ?";
					PreparedStatement pst1 = connection.prepareStatement(query);
					pst1.setString(1, site);
					pst1.setString(2, user);
					ResultSet rs = pst1.executeQuery();
					
					int count = 0;
					
					while(rs.next())
					{
						count++;
					}
					
					if(count == 1){
					
					
						try{
							
						String q = "UPDATE Data SET password= ? WHERE website= ? and username= ?";
						PreparedStatement pst = connection.prepareStatement(q);
						pst.setString(1, pass);
						pst.setString(2, site);
						pst.setString(3, user);
						pst.execute();
						Date date = new Date();
						String originalTime =  new SimpleDateFormat("HH:mm dd.MM.yyyy").format(date);
						String time = Encrypt.scramble(masterpass, originalTime);
						String activity = Encrypt.scramble(masterpass, "Updated password for site: "+update_web.getText().toString()+" and username"+update_user.getText().toString());
						String addlog = "insert into userlog (time, activity) values (?, ?)";
						PreparedStatement pstmt = connection.prepareStatement(addlog);
						pstmt.setString(1, time);
						pstmt.setString(2, activity);
						pstmt.execute();
						pstmt.close();
					
						JOptionPane.showMessageDialog(formAsterisk, "Update Successfull");
						update_web.setText(null);
						update_user.setText(null);
						update_pass.setText(null);
						
						pst.close();
						}
						catch(Exception e2)
						{
							JOptionPane.showMessageDialog(formAsterisk, e2);
						}
						
	
					
					}
					else
					{
						JOptionPane.showMessageDialog(formAsterisk, "Website or Password Does not Exist!!");
					}
					
					pst1.close();
					rs.close();
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnUpdate.setBackground(new Color(8, 204, 120));
		btnUpdate.setBounds(399, 522, 238, 60);
		update.add(btnUpdate);
		
		JLabel label_2 = new JLabel("Website:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_2.setBounds(344, 238, 198, 34);
		update.add(label_2);
		
		JLabel label_3 = new JLabel("Username:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_3.setBounds(344, 318, 198, 34);
		update.add(label_3);
		
		JLabel label_4 = new JLabel("Password:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_4.setBounds(344, 399, 198, 34);
		update.add(label_4);
		
		update_user = new JTextField();
		update_user.setFont(new Font("Century Gothic", Font.BOLD, 18));
		update_user.setColumns(10);
		update_user.setBounds(344, 351, 344, 47);
		update.add(update_user);
		
		update_web = new JTextField();
		update_web.setFont(new Font("Century Gothic", Font.BOLD, 18));
		update_web.setColumns(10);
		update_web.setBounds(344, 272, 344, 47);
		update.add(update_web);
		
		JButton button_1 = new JButton("");
		button_1.setOpaque(false);
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_web.setText(null);
				update_user.setText(null);
				update_pass.setText(null);
				
				try{
					users = new ArrayList<Users>();
				       
				       try {
				           
				    	   String q = "SELECT * FROM Data";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rs1 = pst1.executeQuery();
				           int k = 1;
				           while(rs1.next()){
				               
				               Users u = new Users(
				                       k,
				                       rs1.getString("website"),
				                       rs1.getString("username"),
				                       rs1.getString("password")
				               );
				               
				               users.add(u);
				               k++;
				           }
				           
				           model = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[4];
				           
				           columnsName[0] = "#";
				           columnsName[1] = "Website";
				           columnsName[2] = "Username";
				           columnsName[3] = "Password";
				           
				           model.setColumnIdentifiers(columnsName);
				           
				           Object[] rowData = new Object[4];
				           
				           for(int i = 0; i < users.size(); i++){
				               rowData[0] = users.get(i).getId();
				               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
				               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
				               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
				               model.addRow(rowData);
				           }
				           rs1.close();
				           pst1.close();
				            
				       } catch (SQLException ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					table.setModel(model);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(formAsterisk, e2);
				}
				search_site.setText(null);
				search_user.setText(null);
			
				
				update.setVisible(false);
				display.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\anotherback2.png"));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button_1.setBackground(new Color(8, 204, 120));
		button_1.setBounds(15, 16, 49, 46);
		update.add(button_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\addpass2.png"));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 0, 1027, 230);
		update.add(label_5);
		
		JButton btnUpdateData = new JButton("Modify");
		btnUpdateData.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\edit2.png"));
		btnUpdateData.setBackground(new Color(255, 215, 0));
		btnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search_site.setText(null);
				search_user.setText(null);
				update.setVisible(true);
				display.setVisible(false);
			}
		});
		btnUpdateData.setForeground(new Color(255, 255, 255));
		btnUpdateData.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnUpdateData.setBounds(445, 581, 135, 45);
		display.add(btnUpdateData);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\Capture.PNG"));
		lblNewLabel_3.setBounds(0, 0, 1027, 82);
		display.add(lblNewLabel_3);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\menu2.png"));
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setVisible(false);
				menu.setVisible(true);
			}
			
		});
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnMenu.setBackground(new Color(255, 165, 0));
		btnMenu.setBounds(877, 16, 138, 45);
		display.add(btnMenu);
		
		JButton btnClear = new JButton("Reload");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					users = new ArrayList<Users>();
				       
				       try {
				           
				    	   String q = "SELECT * FROM Data";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rs1 = pst1.executeQuery();
				           int k = 1;
				           while(rs1.next()){
				               
				               Users u = new Users(
				                       k,
				                       rs1.getString("website"),
				                       rs1.getString("username"),
				                       rs1.getString("password")
				               );
				               
				               users.add(u);
				               k++;
				           }
				           
				           model = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[4];
				           
				           columnsName[0] = "#";
				           columnsName[1] = "Website";
				           columnsName[2] = "Username";
				           columnsName[3] = "Password";
				           
				           model.setColumnIdentifiers(columnsName);
				           
				           Object[] rowData = new Object[4];
				           
				           for(int i = 0; i < users.size(); i++){
				               rowData[0] = users.get(i).getId();
				               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
				               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
				               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
				               model.addRow(rowData);
				           }
				           rs1.close();
				           pst1.close();
				            
				       } catch (SQLException ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					table.setModel(model);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(formAsterisk, e2);
				}
				search_site.setText(null);
				search_user.setText(null);

			}
		});
		btnClear.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\reload2.png"));
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnClear.setBackground(new Color(32, 178, 170));
		btnClear.setBounds(877, 68, 138, 45);
		display.add(btnClear);
		
		
		
		
		
		JLabel label_6 = new JLabel("Website:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_6.setBounds(345, 317, 198, 34);
		delete.add(label_6);
		
		delete_site = new JTextField();
		delete_site.setFont(new Font("Century Gothic", Font.BOLD, 18));
		delete_site.setColumns(10);
		delete_site.setBounds(345, 347, 344, 47);
		delete.add(delete_site);
		
		JLabel label_7 = new JLabel("Username:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_7.setBounds(345, 396, 198, 34);
		delete.add(label_7);
		
		delete_user = new JTextField();
		delete_user.setFont(new Font("Century Gothic", Font.BOLD, 18));
		delete_user.setColumns(10);
		delete_user.setBounds(345, 432, 344, 47);
		delete.add(delete_user);
		
		JButton button = new JButton("");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete_site.setText(null);
				delete_user.setText(null);
				
				try{
					users = new ArrayList<Users>();
				       
				       try {
				           
				    	   String q = "SELECT * FROM Data";
				           PreparedStatement pst1 = connection.prepareStatement(q);
				           ResultSet rs1 = pst1.executeQuery();
				           int k = 1;
				           while(rs1.next()){
				               
				               Users u = new Users(
				                       k,
				                       rs1.getString("website"),
				                       rs1.getString("username"),
				                       rs1.getString("password")
				               );
				               
				               users.add(u);
				               k++;
				           }
				           
				           model = new DefaultTableModel();
				           
				           Object[] columnsName = new Object[4];
				           
				           columnsName[0] = "#";
				           columnsName[1] = "Website";
				           columnsName[2] = "Username";
				           columnsName[3] = "Password";
				           
				           model.setColumnIdentifiers(columnsName);
				           
				           Object[] rowData = new Object[4];
				           
				           for(int i = 0; i < users.size(); i++){
				               rowData[0] = users.get(i).getId();
				               rowData[1] = Encrypt.unscramble(masterpass, users.get(i).getWeb().toString());
				               rowData[2] = Encrypt.unscramble(masterpass, users.get(i).getUser().toString());
				               rowData[3] = Encrypt.unscramble(masterpass, users.get(i).getPass().toString());
				               model.addRow(rowData);
				           }
				           rs1.close();
				           pst1.close();
				            
				       } catch (SQLException ex) {
				           JOptionPane.showMessageDialog(null, ex);
				       }
					 
					table.setModel(model);
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(formAsterisk, e2);
				}
				search_site.setText(null);
				search_user.setText(null);
			
				
				
				display.setVisible(true);
				delete.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\anotherback2.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		button.setBackground(new Color(8, 204, 120));
		button.setBounds(15, 16, 49, 46);
		delete.add(button);
		
		JButton btnDelete = new JButton(" Delete");
		btnDelete.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\done2.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					String site = Encrypt.scramble(masterpass, delete_site.getText().toLowerCase());
					String user = Encrypt.scramble(masterpass, delete_user.getText().toLowerCase());
					
					
					
					String q = "select * FROM Data WHERE website = ? AND username = ?";
					PreparedStatement pst = connection.prepareStatement(q);
					pst.setString(1, site);
					pst.setString(2, user);
					ResultSet rs = pst.executeQuery();
					int  count = 0;
					while(rs.next()){
						count++;
					}
						if(count == 1)
						{
							String query = "delete FROM Data WHERE website = ? AND username = ?";
							PreparedStatement pst1 = connection.prepareStatement(query);
							pst1.setString(1, site);
							pst1.setString(2, user);
							pst1.execute();
							pst1.close();
							Date date = new Date();
							String originalTime =  new SimpleDateFormat("HH:mm dd.MM.yyyy").format(date);
							String time = Encrypt.scramble(masterpass, originalTime);
							String activity = Encrypt.scramble(masterpass, "Deleted password for site: "+delete_site.getText().toString()+" and username: "+delete_user.getText().toString());
							String addlog = "insert into userlog (time, activity) values (?, ?)";
							PreparedStatement pstmt = connection.prepareStatement(addlog);
							pstmt.setString(1, time);
							pstmt.setString(2, activity);
							pstmt.execute();
							pstmt.close();
							JOptionPane.showMessageDialog(formAsterisk, "Successfully Data Deleted From " + delete_site.getText() + " " + delete_user.getText(), "Operation Successful", JOptionPane.PLAIN_MESSAGE, null);
						}
						else
						{
							JOptionPane.showMessageDialog(formAsterisk, "Website or Username Does not exist" , "Failure", JOptionPane.PLAIN_MESSAGE, null);
						}
					
						pst.close();
						rs.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(formAsterisk, "Website or Username Does not exist" , "Failure", JOptionPane.PLAIN_MESSAGE, null);
				}
				delete_site.setText(null);
				delete_user.setText(null);
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Century Gothic", Font.BOLD, 25));
		btnDelete.setBackground(new Color(8, 204, 120));
		btnDelete.setBounds(396, 515, 238, 60);
		delete.add(btnDelete);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\addpass2.png"));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(10, 0, 1027, 229);
		delete.add(label_8);
		formAsterisk.setBounds(0, 64, 1033, 666);
		formAsterisk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1027, 242);
		lblNewLabel.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\logo2.png"));
		welcome.add(lblNewLabel);
		
		JButton loginBtn = new JButton(" Login");
		loginBtn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\login2.png"));
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setBackground(new Color(8, 204, 120));
		loginBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.setVisible(true);
				welcome.setVisible(false);
			}
		});
		loginBtn.setBounds(186, 337, 238, 60);
		welcome.add(loginBtn);
		
		JButton createBtn = new JButton(" Create");
		createBtn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\signup2.png"));
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signup.setVisible(true);
				welcome.setVisible(false);
			}
		});
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setBackground(new Color(255, 192, 0));
		createBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		createBtn.setBounds(603, 337, 238, 60);
		welcome.add(createBtn);
		
		JButton exitBtn = new JButton(" Exit");
		exitBtn.setIcon(new ImageIcon("C:\\College\\Mini-I\\asterisk\\Logo\\icons\\exit2.png"));
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBtn.setForeground(new Color(255, 255, 255));
		exitBtn.setBackground(new Color(245, 102, 23));
		exitBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		exitBtn.setBounds(394, 497, 238, 60);
		welcome.add(exitBtn);
		
	
		
		
		
		
		
				
	}
}
