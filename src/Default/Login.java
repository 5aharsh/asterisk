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
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.io.File;
import java.io.IOException;



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
	String filePath, originalPath, loginPassword;
	private JPasswordField passfield;
	private JPasswordField confirmpass;
	private JTextField savePathField;
	private JTextField save_dest;
	private String new_file_add;
	private File created_File;
	
	private void initialize() {
		formAsterisk = new JFrame();
		formAsterisk.setResizable(false);
		formAsterisk.setType(Type.POPUP);
		formAsterisk.setFont(new Font("Rockwell", Font.PLAIN, 12));
		formAsterisk.setTitle("Asterisk* - Password Manager");
		formAsterisk.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\College\\Mini-I\\Asterisk\\Logo\\logo.png"));
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\College\\Mini-I\\asterisk\\Logo\\login.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 68, 1027, 229);
		login.add(label);
		
		JButton lgn_bk_bnt = new JButton("");
		lgn_bk_bnt.setIcon(new ImageIcon("D:\\College\\Mini-I\\Asterisk\\Logo\\Picture2.png"));
		lgn_bk_bnt.setSelectedIcon(null);
		lgn_bk_bnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				welcome.setVisible(true);
				login.setVisible(false);
			}
		});
		lgn_bk_bnt.setForeground(Color.WHITE);
		lgn_bk_bnt.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lgn_bk_bnt.setBackground(new Color(245, 102, 23));
		lgn_bk_bnt.setBounds(10, 11, 37, 37);
		login.add(lgn_bk_bnt);
		
		lng_passwd_fld = new JPasswordField();
		lng_passwd_fld.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lng_passwd_fld.setBounds(317, 438, 394, 50);
		login.add(lng_passwd_fld);
		
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "SQLite Database", "sqlite");
		fc.setFileFilter(filter);
		final JButton db_choose_btn = new JButton("Choose");
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
		db_choose_btn.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		db_choose_btn.setBackground(new Color(245, 102, 23));
		db_choose_btn.setBounds(557, 332, 154, 50);
		login.add(db_choose_btn);
		
		pathField = new JTextField();
		pathField.setEditable(false);
		pathField.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
		pathField.setBounds(317, 332, 238, 50);
		login.add(pathField);
		JButton lgn_btn = new JButton("Login");
		lgn_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(originalPath==null){
					JOptionPane.showMessageDialog(null, "No database chosen!");
				}
				else{
					connection = sqliteConnection.dbConnector(filePath);
					loginPassword = lng_passwd_fld.getText();
					
					
					try{
						String scrambled = Encrypt.scramble(loginPassword, "Rhapsody");
						String query = "select content from whitestar where content = ?";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1,scrambled);
						ResultSet rs = pst.executeQuery();
						int count = 0;
						while(rs.next()){
							count++;
						}
						if(count == 1){
							//Access Granted!
							JOptionPane.showMessageDialog(null, "Authentication Successfull");
						}
						else{
							JOptionPane.showMessageDialog(formAsterisk, "Invalid password!", "Access Denied!", JOptionPane.WARNING_MESSAGE);
						}
						rs.close();
						pst.close();
					
					}catch(Exception e1){
						JOptionPane.showMessageDialog(formAsterisk, "Invalid credentials!", "Access Denied!", JOptionPane.WARNING_MESSAGE);
						JOptionPane.showMessageDialog(null, e1);
						pathField.setText(null);
						lng_passwd_fld.setText(null);
					}
				}
			}
		});
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
		lblChooseFile.setBounds(317, 299, 198, 34);
		login.add(lblChooseFile);
		
		
		JPanel signup = new JPanel();
		signup.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(signup, "name_1031052097970885");
		signup.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\College\\Mini-I\\Asterisk\\Logo\\signup.png"));
		lblNewLabel_1.setBounds(0, 46, 1027, 220);
		signup.add(lblNewLabel_1);
		
		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon("D:\\College\\Mini-I\\asterisk\\Logo\\Picture2.png"));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				welcome.setVisible(true);
				signup.setVisible(false);
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		backBtn.setBackground(new Color(8, 204, 120));
		backBtn.setBounds(10, 11, 37, 37);
		signup.add(backBtn);
		
		JLabel databasename = new JLabel("Database Save Location:");
		databasename.setForeground(Color.WHITE);
		databasename.setFont(new Font("Century Gothic", Font.BOLD, 16));
		databasename.setBounds(338, 249, 198, 34);
		signup.add(databasename);
		
		JLabel password = new JLabel("Password:");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Century Gothic", Font.BOLD, 16));
		password.setBounds(338, 333, 198, 34);
		signup.add(password);
		
		JLabel confirmpassword = new JLabel("Confirm Password:");
		confirmpassword.setForeground(Color.WHITE);
		confirmpassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
		confirmpassword.setBounds(338, 415, 198, 34);
		signup.add(confirmpassword);
		
		passfield = new JPasswordField();
		passfield.setFont(new Font("Century Gothic", Font.BOLD, 18));
		passfield.setHorizontalAlignment(SwingConstants.LEFT);
		passfield.setBounds(338, 364, 344, 49);
		signup.add(passfield);
		
		confirmpass = new JPasswordField();
		confirmpass.setFont(new Font("Century Gothic", Font.BOLD, 18));
		confirmpass.setHorizontalAlignment(SwingConstants.LEFT);
		confirmpass.setBounds(338, 447, 344, 49);
		signup.add(confirmpass);

		final JFileChooser filesave = new JFileChooser();
		filesave.setDialogTitle("Specify a file to save"); 
		FileNameExtensionFilter savefilter = new FileNameExtensionFilter("SQLite Database", "sqlite");
		filesave.setFileFilter(savefilter);
		JButton btn_save_db = new JButton("Choose");
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
		btn_save_db.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		btn_save_db.setBackground(new Color(245, 102, 23));
		btn_save_db.setBounds(552, 283, 130, 50);
		signup.add(btn_save_db);
		
		save_dest = new JTextField();
		save_dest.setEditable(false);
		save_dest.setFont(new Font("Century Gothic", Font.BOLD, 18));
		save_dest.setBounds(338, 284, 213, 49);
		signup.add(save_dest);
		save_dest.setColumns(10);
		
		JButton signupBtn = new JButton("Done");
		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passwordField = passfield.getText();
				String confirmPassword = confirmpass.getText();
				
				if(!passwordField.contains(" ")&&!confirmPassword.equals("")&&!passwordField.equals("")&&passwordField.equals(confirmPassword)&&passwordField.length()>=8){
					try {
						created_File.createNewFile();
						JOptionPane.showMessageDialog(null, "Database ready at location: "+filePath);
						/*
						String UD = "userdata";
						String query = "CREATE TABLE IF NOT EXISTS " + UD + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, website text, username VARCHAR, password VARCHAR)";
						Statement st = connection.createStatement();
						st.execute(query);
						
						String WS = "whitestar";
						String query1 = "CREATE TABLE IF NOT EXISTS " + WS + "(hash INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content VARCHAR)";
						Statement st1 = connection.createStatement();
						st1.execute(query1);
						String scrambledText = Encrypt.scramble(passwordField, "Rhapsody");
						String query2 = "insert into " + WS + "('content') values ('" + scrambledText + "')";
						PreparedStatement pst2 = connection.prepareStatement(query2);
						pst2.execute();
						*/
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
		signupBtn.setBounds(387, 524, 238, 60);
		signup.add(signupBtn);
		
		JLabel lbldontForgetTo = new JLabel("*Don't forget to move your database to a secured location");
		lbldontForgetTo.setFont(new Font("Source Sans Pro", Font.PLAIN, 15));
		lbldontForgetTo.setForeground(Color.WHITE);
		lbldontForgetTo.setHorizontalAlignment(SwingConstants.CENTER);
		lbldontForgetTo.setBounds(314, 605, 380, 21);
		signup.add(lbldontForgetTo);

		JPanel display = new JPanel();
		display.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(display, "name_1031052111462232");
		display.setLayout(null);
		
		JPanel update = new JPanel();
		update.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(update, "name_1031052123407705");
		update.setLayout(null);
		
		JPanel setting = new JPanel();
		setting.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(setting, "name_1031052135985275");
		setting.setLayout(null);
		
		JPanel delete = new JPanel();
		delete.setBackground(new Color(0, 191, 255));
		formAsterisk.getContentPane().add(delete, "name_1031052149777264");
		delete.setLayout(null);
		formAsterisk.setBounds(0, 64, 1033, 666);
		formAsterisk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 64, 1027, 229);
		lblNewLabel.setIcon(new ImageIcon("D:\\College\\Mini-I\\asterisk\\Logo\\logo2.png"));
		welcome.add(lblNewLabel);
		
		JButton loginBtn = new JButton("Login");
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
		
		JButton createBtn = new JButton("Create");
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
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setIcon(null);
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
