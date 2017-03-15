import java.awt.EventQueue;
import java.security.*;
import java.math.BigInteger;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Login {

	private JFrame frmOnecryptPasswordManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmOnecryptPasswordManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JPasswordField passwordField;
	private JTable table;
	private JTextField urlField;
	private JTextField siteField;
	private JTextField userField;
	private JTextField signupUser;
	private JPasswordField signupPassword;
	private JTextField siteInput;
	private JTextField urlInput;
	private JPasswordField passwordInput;
	private JTextField sitePid;
	private JTextField updatePid;
	private JPasswordField updatePass;
	/**
	 * Create the application.
	 */
	
	static final String AB = "0123456789ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijklmonpqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
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
		connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOnecryptPasswordManager = new JFrame();
		frmOnecryptPasswordManager.setResizable(false);
		frmOnecryptPasswordManager.setType(Type.POPUP);
		frmOnecryptPasswordManager.setFont(new Font("Rockwell", Font.PLAIN, 12));
		frmOnecryptPasswordManager.setTitle("OneCrypt Password Manager");
		frmOnecryptPasswordManager.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\eclipse\\OneCrypt\\OneCrypt\\SQLiteDB\\lock.png"));
		frmOnecryptPasswordManager.getContentPane().setLocation(0, 162);
		frmOnecryptPasswordManager.getContentPane().setBackground(Color.WHITE);
		frmOnecryptPasswordManager.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel Login = new JPanel();
		Login.setBackground(new Color(135, 206, 250));
		frmOnecryptPasswordManager.getContentPane().add(Login, "name_173643190514586");
		Login.setVisible(true);
		
		JPanel Data = new JPanel();
		Data.setBackground(new Color(135, 206, 250));
		frmOnecryptPasswordManager.getContentPane().add(Data, "name_173643203550017");
		Data.setLayout(null);
		Data.setVisible(false);
		
		JPanel Signup = new JPanel();
		Signup.setBackground(new Color(135, 206, 250));
		frmOnecryptPasswordManager.getContentPane().add(Signup, "name_173643214925007");
		Signup.setVisible(false);
		Login.setLayout(null);
		
		JPanel AddInfo = new JPanel();
		AddInfo.setBackground(new Color(135, 206, 250));
		frmOnecryptPasswordManager.getContentPane().add(AddInfo, "name_173643225529233");
		AddInfo.setLayout(null);
		AddInfo.setVisible(false);
		
		JPanel DeleteData = new JPanel();
		DeleteData.setBackground(new Color(135, 206, 250));
		frmOnecryptPasswordManager.getContentPane().add(DeleteData, "name_173643236312817");
		DeleteData.setLayout(null);
		DeleteData.setVisible(false);
		
		JPanel UpdateData = new JPanel();
		UpdateData.setBackground(new Color(135, 206, 250));
		frmOnecryptPasswordManager.getContentPane().add(UpdateData, "name_173650643572852");
		UpdateData.setVisible(false);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Master Password");
		passwordField.setBounds(299, 372, 415, 51);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		passwordField.setBackground(Color.WHITE);
		Login.add(passwordField);
		
		
		
		
		JButton button = new JButton("Access");
		button.setBounds(445, 496, 124, 57);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String user = userField.getText();
					String query = "select * from " + user + " where crypted = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					String masterPass = passwordField.getText();
					pst.setString(1, masterPass);
					ResultSet rs = pst.executeQuery();
					int count = 0;
	
					while(rs.next())
					{
						count++;
					}
					
					if(count == 1){
						
						Data.setVisible(true);
						Login.setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(frmOnecryptPasswordManager, "Password Mismatch", "Access Denied!", JOptionPane.ERROR_MESSAGE);
						passwordField.setText(null);
					}
					rs.close();
					pst.close();
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, "Enter Valid User Name!", "Access Denied!", JOptionPane.WARNING_MESSAGE);
					userField.setText(null);
					passwordField.setText(null);
				}
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Rockwell", Font.PLAIN, 25));
		button.setBackground(new Color(0, 191, 255));
		Login.add(button);
		
		JButton button_1 = new JButton("Exit");
		button_1.setBounds(619, 496, 124, 57);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Rockwell", Font.PLAIN, 25));
		button_1.setBackground(new Color(255, 99, 71));
		Login.add(button_1);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.setBounds(268, 496, 124, 57);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.setVisible(false);
				Signup.setVisible(true);
			}
		});
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnSignup.setBackground(new Color(0, 102, 255));
		Login.add(btnSignup);
		
		userField = new JTextField();
		userField.setToolTipText("Username");
		userField.setHorizontalAlignment(SwingConstants.CENTER);
		userField.setFont(new Font("Rockwell", Font.PLAIN, 25));
		userField.setBounds(299, 289, 415, 51);
		Login.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("F:\\College\\Sem 4\\Mini-I\\OneCrypt\\Asterisk\\logo\\Logo2.png"));
		lblNewLabel_1.setBounds(278, 0, 457, 300);
		Login.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 155, 884, 360);
		Data.add(scrollPane);
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		urlField = new JTextField();
		urlField.setFont(new Font("Rockwell", Font.PLAIN, 23));
		urlField.setColumns(10);
		urlField.setBounds(293, 72, 295, 56);
		Data.add(urlField);
		
		JButton button_2 = new JButton("Site");
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setFont(new Font("Rockwell", Font.PLAIN, 23));
		button_2.setBackground(new Color(100, 149, 237));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String user = userField.getText();
					String site = siteField.getText();
					String query = "select * from " + user + " where site = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, site);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					siteField.setText(null);
					urlField.setText(null);
				}
				catch(Exception e3)
				{
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, e3, null, JOptionPane.WARNING_MESSAGE, null);
				}
				
			}
		});
		button_2.setBounds(587, 16, 156, 57);
		Data.add(button_2);
		
		siteField = new JTextField();
		siteField.setFont(new Font("Rockwell", Font.PLAIN, 23));
		siteField.setColumns(10);
		siteField.setBounds(293, 17, 295, 56);
		Data.add(siteField);
		
		JButton button_3 = new JButton("Username");
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setFont(new Font("Rockwell", Font.PLAIN, 23));
		button_3.setBackground(new Color(100, 149, 237));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String user = userField.getText();
					String username = urlField.getText();
					String query = "select * from " + user + " where username = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, username);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					siteField.setText(null);
					urlField.setText(null);						
				}
				catch(Exception e3)
				{
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, e3, null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_3.setBounds(587, 71, 156, 56);
		Data.add(button_3);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setFont(new Font("Rockwell", Font.PLAIN, 23));
		btnRefresh.setBackground(new Color(0, 255, 127));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String user = userField.getText();
					String query = "select * from " + user + " where pid is not 1";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.show(true);
					
					rs.close();
					pst.close();
				}catch(Exception e2){
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, e2);
				}
			}
		});
		btnRefresh.setBounds(36, 16, 129, 112);
		Data.add(btnRefresh);
		
		JButton btnBack_1 = new JButton("Log Out");
		btnBack_1.setForeground(new Color(255, 255, 255));
		btnBack_1.setFont(new Font("Rockwell", Font.PLAIN, 23));
		btnBack_1.setBackground(new Color(255, 99, 71));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				Login.setVisible(true);
				Data.setVisible(false);
				userField.setText(null);
				passwordField.setText(null);
				table.show(false);
			}
		});
		btnBack_1.setBounds(854, 17, 129, 111);
		Data.add(btnBack_1);
		
		JButton btnAddInfo = new JButton("Add Password");
		btnAddInfo.setForeground(new Color(255, 255, 255));
		btnAddInfo.setFont(new Font("Rockwell", Font.PLAIN, 23));
		btnAddInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data.setVisible(false);
				AddInfo.setVisible(true);
			}
		});
		btnAddInfo.setBackground(new Color(218, 165, 32));
		btnAddInfo.setBounds(65, 551, 197, 59);
		Data.add(btnAddInfo);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Rockwell", Font.PLAIN, 23));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Data.setVisible(false);
				DeleteData.setVisible(true);
				
			}
		});
		btnDelete.setBackground(new Color(255, 99, 71));
		btnDelete.setBounds(806, 551, 143, 59);
		Data.add(btnDelete);
		
		JButton btnUpdateDatabase = new JButton("Update Password");
		btnUpdateDatabase.setForeground(new Color(255, 255, 255));
		btnUpdateDatabase.setFont(new Font("Rockwell", Font.PLAIN, 23));
		btnUpdateDatabase.setBackground(new Color(173, 255, 47));
		btnUpdateDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateData.setVisible(true);
				Data.setVisible(false);
			}
		});
		btnUpdateDatabase.setBounds(402, 551, 244, 59);
		Data.add(btnUpdateDatabase);
		Signup.setLayout(null);
		
		
		signupUser = new JTextField();
		signupUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		signupUser.setBounds(295, 300, 415, 51);
		signupUser.setToolTipText("Username");
		signupUser.setHorizontalAlignment(SwingConstants.CENTER);
		signupUser.setFont(new Font("Rockwell", Font.PLAIN, 25));
		signupUser.setColumns(10);
		Signup.add(signupUser);
		
		signupPassword = new JPasswordField();
		signupPassword.setBounds(295, 379, 415, 51);
		signupPassword.setToolTipText("New Master Password");
		signupPassword.setHorizontalAlignment(SwingConstants.CENTER);
		signupPassword.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		signupPassword.setBackground(Color.WHITE);
		Signup.add(signupPassword);
		
		JButton btnSignup_1 = new JButton("Done");
		btnSignup_1.setBounds(356, 494, 124, 57);
		btnSignup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String user = signupUser.getText();
					String pass = signupPassword.getText();
					String query1 = "CREATE TABLE IF NOT EXISTS "+user+"(pid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, site TEXT, username VARCHAR, crypted VARCHAR)";
					Statement st = connection.createStatement();
					st.execute(query1);
					String query2 = "insert into " + user + "('site', 'username', 'crypted') values ('localhost', 'localhost', '" + pass + "' )";
					PreparedStatement pst2 = connection.prepareStatement(query2);
					pst2.execute();
					
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, "Go Back And Login", "User Successfully Created", JOptionPane.PLAIN_MESSAGE, null);
					
					st.close();
					pst2.close();
					signupUser.setText(null);
					signupPassword.setText(null);
					
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, "Enter Valid Username","User Not Created", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSignup_1.setForeground(Color.WHITE);
		btnSignup_1.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnSignup_1.setBackground(new Color(0, 255, 0));
		Signup.add(btnSignup_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(521, 494, 124, 57);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.setVisible(true);
				Signup.setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnBack.setBackground(new Color(255, 99, 71));
		Signup.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setBounds(298, 25, 412, 247);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("F:\\College\\Sem 4\\Mini-I\\OneCrypt\\Asterisk\\Logo\\signup.png"));
		Signup.add(label);
		
		
		
		JLabel lblNewLabel = new JLabel("Add Site Info To The Database");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 72, 1027, 57);
		AddInfo.add(lblNewLabel);
		
		siteInput = new JTextField();
		
		siteInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		siteInput.setHorizontalAlignment(SwingConstants.CENTER);
		siteInput.setFont(new Font("Rockwell", Font.PLAIN, 23));
		siteInput.setBounds(305, 181, 416, 54);
		AddInfo.add(siteInput);
		siteInput.setColumns(10);
		
		urlInput = new JTextField();
		urlInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		urlInput.setText("username");
		urlInput.setHorizontalAlignment(SwingConstants.CENTER);
		urlInput.setFont(new Font("Rockwell", Font.PLAIN, 23));
		urlInput.setColumns(10);
		urlInput.setBounds(305, 281, 416, 57);
		AddInfo.add(urlInput);
		
		passwordInput = new JPasswordField();
		passwordInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		passwordInput.setFont(new Font("Tahoma", Font.PLAIN, 23));
		passwordInput.setHorizontalAlignment(SwingConstants.CENTER);
		passwordInput.setToolTipText("Username");
		passwordInput.setBounds(305, 386, 416, 57);
		
		AddInfo.add(passwordInput);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String user = userField.getText();
					String query = "insert into " + user + "(site, username, crypted) values (?, ?, ?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, siteInput.getText());
					pst.setString(2, urlInput.getText());
					pst.setString(3, passwordInput.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, "Successfully Added", "Success", JOptionPane.PLAIN_MESSAGE, null);
					
					siteInput.setText(null);
					urlInput.setText(null);
					passwordInput.setText(null);
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, e1, null, JOptionPane.WARNING_MESSAGE, null);
				}
				
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setBounds(305, 486, 124, 57);
		AddInfo.add(btnAdd);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data.setVisible(true);
				AddInfo.setVisible(false);
			}
		});
		btnBack_2.setForeground(Color.WHITE);
		btnBack_2.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnBack_2.setBackground(new Color(255, 99, 71));
		btnBack_2.setBounds(597, 486, 124, 57);
		AddInfo.add(btnBack_2);
		
		JButton btnAutoPass = new JButton("Auto Pass");
		btnAutoPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass = randomString(10);
				passwordInput.setText(pass);
			}
		});
		btnAutoPass.setForeground(Color.WHITE);
		btnAutoPass.setFont(new Font("Rockwell", Font.PLAIN, 19));
		btnAutoPass.setBackground(Color.GREEN);
		btnAutoPass.setBounds(736, 386, 117, 57);
		AddInfo.add(btnAutoPass);
		
		
		
		JLabel lblDeleteSiteInfo = new JLabel("Delete Site Info From The Database");
		lblDeleteSiteInfo.setForeground(new Color(255, 255, 255));
		lblDeleteSiteInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteSiteInfo.setFont(new Font("Rockwell", Font.PLAIN, 30));
		lblDeleteSiteInfo.setBounds(0, 114, 1027, 36);
		DeleteData.add(lblDeleteSiteInfo);
		
		JLabel lblEnterPidOf = new JLabel("Enter PID of the Site");
		lblEnterPidOf.setForeground(new Color(255, 255, 255));
		lblEnterPidOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterPidOf.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblEnterPidOf.setBounds(400, 274, 223, 36);
		DeleteData.add(lblEnterPidOf);
		
		sitePid = new JTextField();
		sitePid.setHorizontalAlignment(SwingConstants.CENTER);
		sitePid.setFont(new Font("Rockwell", Font.PLAIN, 23));
		sitePid.setBounds(300, 341, 426, 57);
		DeleteData.add(sitePid);
		sitePid.setColumns(10);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String user = userField.getText();
					int pid = Integer.parseInt(sitePid.getText());
					String query = "delete from " + user + " where pid = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setInt(1, pid);
					pst.execute();
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, "Successfully Data Deleted From " + pid, "Operation Successful", JOptionPane.PLAIN_MESSAGE, null);
					pst.close();
					sitePid.setText(null);
				} catch (Exception e6) {
					
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, e6, null, JOptionPane.WARNING_MESSAGE, null);
				}
				
				
				
			}
		});
		btnDelete_1.setForeground(Color.WHITE);
		btnDelete_1.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnDelete_1.setBackground(Color.GREEN);
		btnDelete_1.setBounds(356, 510, 124, 57);
		DeleteData.add(btnDelete_1);
		
		JButton button_6 = new JButton("Back");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Data.setVisible(true);
				DeleteData.setVisible(false);
				sitePid.setText(null);
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Rockwell", Font.PLAIN, 25));
		button_6.setBackground(new Color(255, 99, 71));
		button_6.setBounds(528, 510, 124, 57);
		DeleteData.add(button_6);
		UpdateData.setLayout(null);
		
		updatePass = new JPasswordField();
		updatePass.setFont(new Font("Roboto", Font.PLAIN, 23));
		updatePass.setHorizontalAlignment(SwingConstants.CENTER);
		updatePass.setBounds(331, 390, 373, 48);
		UpdateData.add(updatePass);
		frmOnecryptPasswordManager.setBounds(0, -27, 1033, 666);
		frmOnecryptPasswordManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUpdatePassword = new JLabel("Update Password");
		lblUpdatePassword.setForeground(new Color(255, 255, 255));
		lblUpdatePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatePassword.setBounds(0, 52, 1027, 57);
		lblUpdatePassword.setFont(new Font("Rockwell", Font.PLAIN, 30));
		UpdateData.add(lblUpdatePassword);
		
		JLabel lblPid = new JLabel("PID");
		lblPid.setForeground(new Color(255, 255, 255));
		lblPid.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblPid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPid.setBounds(440, 213, 156, 20);
		UpdateData.add(lblPid);
		
		updatePid = new JTextField();
		updatePid.setFont(new Font("Rockwell", Font.PLAIN, 23));
		updatePid.setHorizontalAlignment(SwingConstants.CENTER);
		updatePid.setBounds(331, 249, 373, 48);
		updatePid.setColumns(10);
		UpdateData.add(updatePid);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setForeground(new Color(255, 255, 255));
		lblNewPassword.setFont(new Font("Rockwell", Font.PLAIN, 23));
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setBounds(440, 350, 156, 28);
		UpdateData.add(lblNewPassword);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(365, 493, 124, 57);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String user = userField.getText();
					int pid = Integer.parseInt(updatePid.getText());
					String pass = updatePass.getText();
					String query = "update " + user + " set crypted = ? where pid = ?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, pass);
					pst.setInt(2, pid);
					pst.execute();
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, "Password Updated Successfully", "Operation Successful", JOptionPane.PLAIN_MESSAGE, null);
					pst.close();
					
					updatePass.setText(null);
					updatePid.setText(null);
				} catch (Exception e7) {
					JOptionPane.showMessageDialog(frmOnecryptPasswordManager, e7, null, JOptionPane.WARNING_MESSAGE, null);
				}
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnUpdate.setBackground(Color.GREEN);
		UpdateData.add(btnUpdate);
		
		JButton button_7 = new JButton("Back");
		button_7.setBounds(536, 493, 124, 57);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateData.setVisible(false);
				Data.setVisible(true);
				
				updatePass.setText(null);
				updatePid.setText(null);
			}
		});
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Rockwell", Font.PLAIN, 25));
		button_7.setBackground(Color.RED);
		UpdateData.add(button_7);
		
		
	}
}
