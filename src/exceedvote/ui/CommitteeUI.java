package exceedvote.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;

import exceedvote.controller.CommitteeController;

public class CommitteeUI extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JTextField addQuesUnstruText;
	private JTextField editQuesUnstruText;
	private JTextField addTeamNameText;
	private JTextField editTeamNameText;
	private JTextField usernameText;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	private CommitteeController controller;
	private JComboBox editQuesChoiceCombo;
	private JComboBox addQuesTypeCombo;
	private JComboBox editQuesTypeCombo;
	private JComboBox deleteQuesChoiceCombo;
	private JComboBox editTeamCombo;
	private JComboBox addUserCombo;
	private JComboBox deleteTeamCombo;
	private JTextPane addTeamDescripText;
	private JTextPane editTeamDescripText;
	private JPanel panel;
	private JComboBox deleteUserCombo;

	/**
	 * Create the application.
	 */
	public CommitteeUI(CommitteeController controller) {
		setResizable(false);
		this.controller = controller;
		initialize();
		this.pack();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setTitle("eXceed vote");
		setBounds(100, 100, 550, 565);
		setPreferredSize(new Dimension(550, 595));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// List of question
		List<String> questionList = controller.getQuestionInstructor();

		// Team list
		List<String> teamList = controller.getTeamName();
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(435, 523, 89, 23);
		getContentPane().add(logoutButton);
		logoutButton.addActionListener(this);
		logoutButton.setName("Logout");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 534, 512);
		getContentPane().add(panel_5);
				panel_5.setLayout(null);
		
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(0, 0, 534, 512);
				panel_5.add(tabbedPane);
				tabbedPane.setBorder(new LineBorder(Color.GRAY));
				tabbedPane.setToolTipText("");
				
						JPanel questionPanel = new JPanel();
						tabbedPane.addTab("Questions", null, questionPanel,
								"add/edit/delete question");
						questionPanel.setLayout(null);
						
								JLabel questionLabel = new JLabel("Question");
								questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
								questionLabel.setBounds(10, 11, 84, 25);
								questionPanel.add(questionLabel);
								
										JPanel quesAddPanel = new JPanel();
										quesAddPanel.setBorder(new LineBorder(Color.GRAY));
										quesAddPanel.setBounds(20, 47, 487, 72);
										questionPanel.add(quesAddPanel);
										quesAddPanel.setLayout(null);
										
												JLabel instructQuesLable = new JLabel("Instruction :");
												instructQuesLable.setFont(new Font("Tahoma", Font.PLAIN, 11));
												instructQuesLable.setBounds(10, 11, 65, 14);
												quesAddPanel.add(instructQuesLable);
												
														addQuesUnstruText = new JTextField();
														addQuesUnstruText.setBounds(95, 8, 382, 20);
														quesAddPanel.add(addQuesUnstruText);
														addQuesUnstruText.setColumns(10);
														
																JLabel lblQuestionType = new JLabel("Question Type :");
																lblQuestionType.setFont(new Font("Tahoma", Font.PLAIN, 11));
																lblQuestionType.setBounds(10, 43, 77, 14);
																quesAddPanel.add(lblQuestionType);
																
																		addQuesTypeCombo = new JComboBox();
																		addQuesTypeCombo.setModel(new DefaultComboBoxModel(new String[] {
																				"Score type", "Ballot type" }));
																		addQuesTypeCombo.setSelectedIndex(0);
																		addQuesTypeCombo.setBounds(95, 40, 102, 20);
																		quesAddPanel.add(addQuesTypeCombo);
																		
																				JButton addQuesButton = new JButton("Add Question");
																				addQuesButton.setName("addQuesButton");
																				addQuesButton.addActionListener(this);
																				addQuesButton.setBounds(367, 39, 110, 23);
																				quesAddPanel.add(addQuesButton);
																				
																						JPanel quesEditPanel = new JPanel();
																						quesEditPanel.setBorder(new LineBorder(Color.GRAY));
																						quesEditPanel.setBounds(20, 130, 487, 110);
																						questionPanel.add(quesEditPanel);
																						quesEditPanel.setLayout(null);
																						
																								editQuesChoiceCombo = new JComboBox();
																								editQuesChoiceCombo.setBounds(10, 11, 379, 20);
																								editQuesChoiceCombo.setModel(new DefaultComboBoxModel(questionList
																										.toArray()));
																								quesEditPanel.add(editQuesChoiceCombo);
																								
																										JButton quesSelectButton = new JButton("Select");
																										quesSelectButton.setName("quesSelectButton");
																										quesSelectButton.addActionListener(this);
																										quesSelectButton.setBounds(401, 10, 76, 23);
																										quesEditPanel.add(quesSelectButton);
																										
																												JLabel label = new JLabel("Instruction :");
																												label.setFont(new Font("Tahoma", Font.PLAIN, 11));
																												label.setBounds(10, 45, 65, 14);
																												quesEditPanel.add(label);
																												
																														editQuesUnstruText = new JTextField();
																														editQuesUnstruText.setColumns(10);
																														editQuesUnstruText.setBounds(95, 42, 382, 20);
																														quesEditPanel.add(editQuesUnstruText);
																														
																																editQuesTypeCombo = new JComboBox();
																																editQuesTypeCombo.setModel(new DefaultComboBoxModel(new String[] {
																																		"Score type", "Ballot type" }));
																																editQuesTypeCombo.setSelectedIndex(0);
																																editQuesTypeCombo.setBounds(95, 74, 102, 20);
																																quesEditPanel.add(editQuesTypeCombo);
																																
																																		JLabel label_1 = new JLabel("Question Type :");
																																		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																		label_1.setBounds(10, 77, 77, 14);
																																		quesEditPanel.add(label_1);
																																		
																																				JButton editQuesButton = new JButton("Edit Question");
																																				editQuesButton.setName("editQuesButton");
																																				editQuesButton.addActionListener(this);
																																				editQuesButton.setBounds(367, 73, 110, 23);
																																				quesEditPanel.add(editQuesButton);
																																				
																																						JPanel deleteQuesPanel = new JPanel();
																																						deleteQuesPanel.setBorder(new LineBorder(Color.GRAY));
																																						deleteQuesPanel.setBounds(20, 251, 487, 48);
																																						questionPanel.add(deleteQuesPanel);
																																						deleteQuesPanel.setLayout(null);
																																						
																																								deleteQuesChoiceCombo = new JComboBox();
																																								deleteQuesChoiceCombo.setModel(new DefaultComboBoxModel(questionList
																																										.toArray()));
																																								deleteQuesChoiceCombo.setBounds(10, 12, 379, 20);
																																								
																																										deleteQuesPanel.add(deleteQuesChoiceCombo);
																																										
																																												JButton deleteQuesButton = new JButton("Delete");
																																												deleteQuesButton.setName("deleteQuesButton");
																																												deleteQuesButton.addActionListener(this);
																																												deleteQuesButton.setBounds(401, 11, 76, 23);
																																												deleteQuesPanel.add(deleteQuesButton);
																																												
																																														JPanel teamPanel = new JPanel();
																																														tabbedPane.addTab("Teams", null, teamPanel, "add/edit/delete team");
																																														teamPanel.setLayout(null);
																																														
																																																JLabel teamLabel = new JLabel("Team");
																																																teamLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
																																																teamLabel.setBounds(10, 11, 84, 25);
																																																teamPanel.add(teamLabel);
																																																
																																																		JPanel addTeamPanel = new JPanel();
																																																		addTeamPanel.setLayout(null);
																																																		addTeamPanel.setBorder(new LineBorder(Color.GRAY));
																																																		addTeamPanel.setBounds(20, 47, 487, 159);
																																																		teamPanel.add(addTeamPanel);
																																																		
																																																				JLabel teamNamelabel = new JLabel("Team name :");
																																																				teamNamelabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																				teamNamelabel.setBounds(10, 11, 65, 14);
																																																				addTeamPanel.add(teamNamelabel);
																																																				
																																																						addTeamNameText = new JTextField();
																																																						addTeamNameText.setColumns(10);
																																																						addTeamNameText.setBounds(95, 8, 382, 20);
																																																						addTeamPanel.add(addTeamNameText);
																																																						
																																																								JButton addTeamButton = new JButton("Add Team");
																																																								addTeamButton.setName("addTeamButton");
																																																								addTeamButton.addActionListener(this);
																																																								addTeamButton.setBounds(367, 125, 110, 23);
																																																								addTeamPanel.add(addTeamButton);
																																																								
																																																										JLabel lblTeamDescription = new JLabel("Team description :");
																																																										lblTeamDescription.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																										lblTeamDescription.setBounds(10, 39, 99, 14);
																																																										addTeamPanel.add(lblTeamDescription);
																																																										
																																																												addTeamDescripText = new JTextPane();
																																																												addTeamDescripText.setBounds(20, 64, 457, 51);
																																																												addTeamPanel.add(addTeamDescripText);
																																																												
																																																														JPanel editTeamPanel = new JPanel();
																																																														editTeamPanel.setLayout(null);
																																																														editTeamPanel.setBorder(new LineBorder(Color.GRAY));
																																																														editTeamPanel.setBounds(20, 217, 487, 186);
																																																														teamPanel.add(editTeamPanel);
																																																														
																																																																JLabel label_2 = new JLabel("Team name :");
																																																																label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																																label_2.setBounds(10, 45, 65, 14);
																																																																editTeamPanel.add(label_2);
																																																																
																																																																		editTeamNameText = new JTextField();
																																																																		editTeamNameText.setColumns(10);
																																																																		editTeamNameText.setBounds(95, 42, 382, 20);
																																																																		editTeamPanel.add(editTeamNameText);
																																																																		
																																																																				JButton editTeamButton = new JButton("Edit Team");
																																																																				editTeamButton.setName("editTeamButton");
																																																																				editTeamButton.addActionListener(this);
																																																																				editTeamButton.setBounds(367, 159, 110, 23);
																																																																				editTeamPanel.add(editTeamButton);
																																																																				
																																																																						JLabel label_3 = new JLabel("Team description :");
																																																																						label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																																						label_3.setBounds(10, 73, 99, 14);
																																																																						editTeamPanel.add(label_3);
																																																																						
																																																																								editTeamDescripText = new JTextPane();
																																																																								editTeamDescripText.setBounds(20, 98, 457, 51);
																																																																								editTeamPanel.add(editTeamDescripText);
																																																																								
																																																																										editTeamCombo = new JComboBox();
																																																																										editTeamCombo.setBounds(10, 11, 368, 20);
																																																																										editTeamCombo.setModel(new DefaultComboBoxModel(teamList.toArray()));
																																																																										editTeamPanel.add(editTeamCombo);
																																																																										
																																																																												JButton selectTeamButton = new JButton("Select");
																																																																												selectTeamButton.setName("selectTeamButton");
																																																																												selectTeamButton.addActionListener(this);
																																																																												selectTeamButton.setBounds(388, 10, 89, 23);
																																																																												editTeamPanel.add(selectTeamButton);
																																																																												
																																																																														JPanel deleteTeamPanel = new JPanel();
																																																																														deleteTeamPanel.setBorder(new LineBorder(Color.GRAY));
																																																																														deleteTeamPanel.setBounds(20, 414, 487, 49);
																																																																														teamPanel.add(deleteTeamPanel);
																																																																														deleteTeamPanel.setLayout(null);
																																																																														
																																																																																deleteTeamCombo = new JComboBox();
																																																																																deleteTeamCombo.setBounds(10, 12, 368, 20);
																																																																																deleteTeamCombo.setModel(new DefaultComboBoxModel(teamList.toArray()));
																																																																																deleteTeamPanel.add(deleteTeamCombo);
																																																																																
																																																																																		JButton deleteTeamButton = new JButton("Delete");
																																																																																		deleteTeamButton.addActionListener(this);
																																																																																		deleteTeamButton.setName("deleteTeamButton");
																																																																																		deleteTeamButton.setBounds(388, 11, 89, 23);
																																																																																		deleteTeamPanel.add(deleteTeamButton);
																																																																																		
																																																																																				JPanel userPanel = new JPanel();
																																																																																				tabbedPane.addTab("Users", null, userPanel, "add/delete user");
																																																																																				userPanel.setLayout(null);
																																																																																				
																																																																																						JLabel userLabel = new JLabel("User");
																																																																																						userLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
																																																																																						userLabel.setBounds(10, 11, 84, 25);
																																																																																						userPanel.add(userLabel);
																																																																																						
																																																																																								panel = new JPanel();
																																																																																								panel.setLayout(null);
																																																																																								panel.setBorder(new LineBorder(Color.GRAY));
																																																																																								panel.setBounds(20, 47, 487, 123);
																																																																																								userPanel.add(panel);
																																																																																								
																																																																																										JLabel lblUsername = new JLabel("Username :");
																																																																																										lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																																																										lblUsername.setBounds(10, 11, 65, 14);
																																																																																										panel.add(lblUsername);
																																																																																										
																																																																																												usernameText = new JTextField();
																																																																																												usernameText.setColumns(10);
																																																																																												usernameText.setBounds(95, 8, 382, 20);
																																																																																												panel.add(usernameText);
																																																																																												
																																																																																														JLabel lblUserType = new JLabel("User Type :");
																																																																																														lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																																																														lblUserType.setBounds(10, 94, 77, 14);
																																																																																														panel.add(lblUserType);
																																																																																														
																																																																																																addUserCombo = new JComboBox();
																																																																																																addUserCombo.setModel(new DefaultComboBoxModel(new String[] { "Voter",
																																																																																																		"Commitee" }));
																																																																																																addUserCombo.setSelectedIndex(0);
																																																																																																addUserCombo.setBounds(95, 91, 82, 20);
																																																																																																panel.add(addUserCombo);
																																																																																																
																																																																																																		JButton addUserButton = new JButton("Add User");
																																																																																																		addUserButton.setName("addUserButton");
																																																																																																		addUserButton.addActionListener(this);
																																																																																																		addUserButton.setBounds(367, 90, 110, 23);
																																																																																																		panel.add(addUserButton);
																																																																																																		
																																																																																																				JLabel lblPassword = new JLabel("Password :");
																																																																																																				lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																																																																				lblPassword.setBounds(10, 39, 65, 14);
																																																																																																				panel.add(lblPassword);
																																																																																																				
																																																																																																						JLabel lblRepassword = new JLabel("Re-password :");
																																																																																																						lblRepassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																																																																						lblRepassword.setBounds(10, 66, 77, 14);
																																																																																																						panel.add(lblRepassword);
																																																																																																						
																																																																																																								passwordField = new JPasswordField();
																																																																																																								passwordField.setBounds(95, 36, 382, 20);
																																																																																																								panel.add(passwordField);
																																																																																																								
																																																																																																										passwordField2 = new JPasswordField();
																																																																																																										passwordField2.setBounds(95, 63, 382, 20);
																																																																																																										panel.add(passwordField2);
																																																																																																										
																																																																																																												JPanel panel_1 = new JPanel();
																																																																																																												panel_1.setLayout(null);
																																																																																																												panel_1.setBorder(new LineBorder(Color.GRAY));
																																																																																																												panel_1.setBounds(20, 181, 487, 48);
																																																																																																												userPanel.add(panel_1);
																																																																																																												
																																																																																																														JButton deleteUserButton = new JButton("Delete");
																																																																																																														deleteUserButton.setName("deleteUserButton");
																																																																																																														deleteUserButton.addActionListener(this);
																																																																																																														deleteUserButton.setBounds(401, 11, 76, 23);
																																																																																																														panel_1.add(deleteUserButton);
																																																																																																														
																																																																																																																JLabel label_4 = new JLabel("Username :");
																																																																																																																label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
																																																																																																																label_4.setBounds(10, 14, 76, 14);
																																																																																																																panel_1.add(label_4);
																																																																																																																
																																																																																																																deleteUserCombo = new JComboBox();
																																																																																																																deleteUserCombo.setBounds(96, 12, 295, 20);
																																																																																																																panel_1.add(deleteUserCombo);
																																																																																																																deleteUserCombo.setModel(new DefaultComboBoxModel(controller.getUsersName()));
																																																																																																																deleteUserCombo.setSelectedIndex(0);
																																																																																																																
																																																																																																																		JPanel panel_2 = new JPanel();
																																																																																																																		tabbedPane.addTab("Open Vote", null, panel_2, "start/close vote");
																																																																																																																		panel_2.setLayout(null);
																																																																																																																		
																																																																																																																				JPanel panel_3 = new JPanel();
																																																																																																																				panel_3.setLayout(null);
																																																																																																																				panel_3.setBorder(new LineBorder(Color.GRAY));
																																																																																																																				panel_3.setBounds(20, 47, 487, 66);
																																																																																																																				panel_2.add(panel_3);
																																																																																																																				
																																																																																																																						JButton startVoteButton = new JButton("Start vote");
																																																																																																																						startVoteButton.setName("startVoteButton");
																																																																																																																						startVoteButton.addActionListener(this);
																																																																																																																						startVoteButton.setBounds(47, 11, 144, 38);
																																																																																																																						panel_3.add(startVoteButton);
																																																																																																																						
																																																																																																																								JButton closeVoteButton = new JButton("Close vote");
																																																																																																																								closeVoteButton.setName("closeVoteButton");
																																																																																																																								closeVoteButton.addActionListener(this);
																																																																																																																								closeVoteButton.setBounds(275, 11, 144, 38);
																																																																																																																								panel_3.add(closeVoteButton);
																																																																																																																								
																																																																																																																										JLabel lblVoteStatus = new JLabel("Vote Status");
																																																																																																																										lblVoteStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
																																																																																																																										lblVoteStatus.setBounds(10, 11, 98, 25);
																																																																																																																										panel_2.add(lblVoteStatus);
																																																																																																																										
																																																																																																																										JPanel panel_4 = new JPanel();
																																																																																																																										tabbedPane.addTab("Ranking", null, panel_4, null);
																																																																																																																										panel_4.setLayout(null);
																																																																																																																										
																																																																																																																										JLabel rankingLabel = new JLabel("Ranking");
																																																																																																																										rankingLabel.setBounds(10, 11, 70, 22);
																																																																																																																										rankingLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
																																																																																																																										panel_4.add(rankingLabel);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = ((JButton) arg0.getSource()).getName();
		if (name.equals("addQuesButton")) {

			String type;
			if (addQuesTypeCombo.getSelectedIndex() == 0)
				type = "ScoreType";
			else
				type = "BallotType";
			controller.addQuestion(addQuesUnstruText.getText(), type);
			addQuesUnstruText.setText("");
			JOptionPane.showMessageDialog(null, "Added!");

		} else if (name.equals("quesSelectButton")) {

			List<String> questionList = controller.getQuestionInstructor();
			int index = editQuesChoiceCombo.getSelectedIndex();
			editQuesUnstruText.setText(questionList.get(index));
			List<String> questiontype = controller.getQuestionType();
			if (questiontype.get(index).equals("ScoreType"))
				editQuesTypeCombo.setSelectedIndex(0);
			else
				editQuesTypeCombo.setSelectedIndex(1);

		} else if (name.equals("editQuesButton")) {

			int index = editQuesChoiceCombo.getSelectedIndex();
			String type;
			if (editQuesTypeCombo.getSelectedIndex() == 0)
				type = "ScoreType";
			else
				type = "BallotType";
			controller.editQuestion(index, editQuesUnstruText.getText(), type);
			editQuesUnstruText.setText("");
			JOptionPane.showMessageDialog(null, "Edited!");

		} else if (name.equals("deleteQuesButton")) {

			controller.deleteQuestion(deleteQuesChoiceCombo.getSelectedIndex());
			JOptionPane.showMessageDialog(null, "Deleted!");

		} else if (name.equals("addTeamButton")) {

			controller.addTeam(addTeamNameText.getText(),
					addTeamDescripText.getText());
			addTeamNameText.setText("");
			JOptionPane.showMessageDialog(null, "Added!");

		} else if (name.equals("selectTeamButton")) {

			List<String> teamName = controller.getTeamName();
			editTeamNameText.setText(teamName.get(editTeamCombo
					.getSelectedIndex()));
			List<String> teamDis = controller.getTeamDescription();
			editTeamDescripText.setText(teamDis.get(editTeamCombo
					.getSelectedIndex()));

		} else if (name.equals("editTeamButton")) {

			controller.editTeam(editTeamCombo.getSelectedIndex(),
					editTeamNameText.getText(), editTeamDescripText.getText());
			JOptionPane.showMessageDialog(null, "Edited!");
			editTeamNameText.setText("");
			editTeamDescripText.setText("");
			
		} else if (name.equals("deleteTeamButton")) {

			controller.deleteTeam(deleteTeamCombo.getSelectedIndex());
			JOptionPane.showMessageDialog(null, "Deleted!");

		} else if (name.equals("addUserButton")) {

			String type;
			if (addUserCombo.getSelectedIndex() == 0)
				type = "student";
			else
				type = "committee";
			String pass1 = String.valueOf(passwordField.getPassword());
			String pass2 = String.valueOf(passwordField2.getPassword());
			if (pass1.equals(pass2)) {
				controller.addUser(usernameText.getText(), pass1.toString(),
						type);
				usernameText.setText("");
				JOptionPane.showMessageDialog(null, "Added!");
			} else
				JOptionPane.showMessageDialog(null, "Password not match!");
			passwordField.setText("");
			passwordField2.setText("");
			deleteUserCombo.setModel(new DefaultComboBoxModel(controller.getUsersName()));
			deleteUserCombo.setSelectedIndex(0);
			
		} else if (name.equals("deleteUserButton")) {

			int index = deleteUserCombo.getSelectedIndex();
			controller.deleteUser( controller.getUsers().get(index).getUserId() );
			JOptionPane.showMessageDialog(null, "Deleted!");
			deleteUserCombo.setModel(new DefaultComboBoxModel(controller.getUsersName()));
			deleteUserCombo.setSelectedIndex(0);

		} else if (name.equals("startVoteButton")) {

			controller.addScoreTable();
			JOptionPane.showMessageDialog(null, "Vote Started!");

		} else if (name.equals("closeVoteButton")) {

			// controller.addScoreTable();
			JOptionPane.showMessageDialog(null, "Vote closed!");

		}
		else if (name.equals("Logout")) {
			
			JOptionPane.showMessageDialog(null, "Logged out!");
			this.dispose();
			LoginUI frame = new LoginUI();
			frame.setVisible(true);

		}
		if (!name.equals("selectTeamButton")
				&& !name.equals("quesSelectButton")) {
			List<String> questionList = controller.getQuestionInstructor();
			editQuesChoiceCombo.setModel(new DefaultComboBoxModel(questionList
					.toArray()));
			deleteQuesChoiceCombo.setModel(new DefaultComboBoxModel(
					questionList.toArray()));

			List<String> teamList = controller.getTeamName();
			editTeamCombo
					.setModel(new DefaultComboBoxModel(teamList.toArray()));
			deleteTeamCombo.setModel(new DefaultComboBoxModel(teamList
					.toArray()));
		}

	}
}
