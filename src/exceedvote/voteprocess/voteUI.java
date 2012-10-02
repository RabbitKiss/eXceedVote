package exceedvote.voteprocess;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import java.awt.EventQueue;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;

public class voteUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane mainScrollPane;
	private JPanel choicePanel;
	private JPanel panel;
	private JButton btnSubmit;
	private List<List<JRadioButton>> ballotList = new ArrayList<List<JRadioButton>>();
	private List<List<JComboBox>> scoreList = new ArrayList<List<JComboBox>>();

	private Controller controller;

	/**
	 * Create the frame.
	 */
	public voteUI(Controller controller) {
		setResizable(false);
		this.controller = controller;
		initComponent();
		this.pack();

	}

	private void initComponent() {

		setTitle("eXceedVote");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		mainScrollPane = new JScrollPane();

		panel = new JPanel();

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		panel.add(btnSubmit);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(mainScrollPane);
		contentPane.add(panel, BorderLayout.EAST);

		choicePanel = new JPanel();
		contentPane.add(choicePanel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		choicePanel.setLayout(gbl_panel);

		// for test only
		List<String> question = controller.getInstruction();
		List<String> team = controller.getTeam();

		for (int i = 1; i <= team.size(); i++) {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridy = 0;
			gbc.gridx = i;
			choicePanel.add(new JLabel(team.get(i - 1)), gbc);
		}
		for (int i = 1; i <= question.size(); i++) {
			// System.out.println(question.get(i));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridy = i + 1;
			gbc.gridx = 0;
			choicePanel.add(new JLabel(i + ") " + question.get(i - 1) + " "),
					gbc);
		}

		for (int i = 0; i < question.size(); i++) {
			if ((controller.getQuestionType(i)).equals("exceedvote.voteprocess.BallotType")) {
				ButtonGroup group = new ButtonGroup();
				List<JRadioButton> list = new ArrayList<JRadioButton>();
				for (int j = 0; j < team.size(); j++) {
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridy = i + 2;
					gbc.gridx = j + 1;
					JRadioButton jrb = new JRadioButton();
					group.add(jrb);
					list.add(jrb);
					choicePanel.add(jrb, gbc);
				}
				ballotList.add(list);
			} else if ((controller.getQuestionType(i)).equals("exceedvote.voteprocess.ScoreType")) {
				List<JComboBox> list = new ArrayList<JComboBox>();
				for (int j = 0; j < team.size(); j++) {
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridy = i + 2;
					gbc.gridx = j + 1;
					String[] c = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
							"10" };
					JComboBox ans = new JComboBox(c);
					ans.setPreferredSize(new Dimension(45, 25));
					list.add(ans);
					choicePanel.add(ans, gbc);
				}
				scoreList.add(list);
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<String> question = controller.getInstruction();
		List<String> team = controller.getTeam();
		int a=0,b=0;
		for (int i = 0; i < question.size(); i++) {
			if ((controller.getQuestionType(i))
					.equals("exceedvote.voteprocess.BallotType")) {
				List<Integer> list = new ArrayList<Integer>();
				List<JRadioButton> tmp = ballotList.get(b);
				for (int j = 0; j<team.size(); j++) {
					if(tmp.get(j).isSelected()) list.add(1);
					else list.add(0);
//					System.out.print(list.get(j));
				}
//				System.out.println();
				controller.vote(i, list);
				b++;
			} else if ((controller.getQuestionType(i))
					.equals("exceedvote.voteprocess.ScoreType")) {
				List<Integer> list = new ArrayList<Integer>();
				List<JComboBox> tmp = scoreList.get(a);
				for (int j = 0; j<team.size(); j++) {
					 list.add(tmp.get(j).getSelectedIndex()+1);
//					 System.out.print(list.get(j));
				}
//				System.out.println();
				controller.vote(i, list);
				a++;
			}
		}

		JOptionPane.showMessageDialog(null, "Record Complete!");

	}

}

class HintTextField extends JTextField implements FocusListener {

	private final String hint;

	public HintTextField(final String hint) {
		super(hint);
		this.hint = hint;
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(hint);
		}
	}

	@Override
	public String getText() {
		String typed = super.getText();
		return typed.equals(hint) ? "" : typed;
	}
}