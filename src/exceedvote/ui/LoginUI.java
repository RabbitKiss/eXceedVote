package exceedvote.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import exceedvote.controller.VoteController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passwordField;
	private JPanel loginPanel;
	private VoteController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		controller = new VoteController();
		setTitle("eXceedVote");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 275, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		loginPanel = new JPanel();
		loginPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(loginPanel, GroupLayout.PREFERRED_SIZE, 131, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		
		JLabel lblPasswrd = new JLabel("Password :");
		lblPasswrd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		//add
		passwordField.addActionListener(this);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPasswrd))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addComponent(usernameTextField, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(63)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPasswrd)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		loginPanel.setLayout(gl_loginPanel);
		contentPane.setLayout(gl_contentPane);
	}


	/**
	 * actionPerformed for login button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(controller.login( usernameTextField.getText(), passwordField.getText())){
			VoteUI frame = new VoteUI(controller);
			this.setVisible(false);
			dispose();
			frame.setVisible(true);
		}
		// add
		else{
			JOptionPane.showMessageDialog(contentPane,"login failed");
		}
		
	}
}
