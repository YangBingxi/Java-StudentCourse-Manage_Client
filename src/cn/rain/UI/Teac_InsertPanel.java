package cn.rain.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import cn.rain.Exceptions.UserNotFoundException;
import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;

/**
 * 教师使用界面插入用户面板
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class Teac_InsertPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4943724672525922943L;

	JTextField snoField;
	JTextField subjectField;
	JTextField scoreField;
	JButton insertButton;
	JComboBox<Integer> termComboBox;

	public Teac_InsertPanel() {

		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(0, 100, 700, 400);
		setLayout(null);
		setVisible(false);

		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setBounds(135, 66, 54, 15);
		add(lblNewLabel);

		snoField = new JTextField();
		snoField.setBounds(199, 63, 98, 21);
		add(snoField);
		snoField.setOpaque(false);
		snoField.setColumns(10);

		JLabel label = new JLabel("课程名称");
		label.setBounds(135, 122, 54, 15);
		add(label);

		scoreField = new JTextField();
		scoreField.setBounds(458, 119, 32, 21);
		add(scoreField);
		scoreField.setOpaque(false);
		scoreField.setColumns(10);

		JLabel label_1 = new JLabel("成绩");
		label_1.setBounds(390, 122, 42, 15);
		add(label_1);

		insertButton = new JButton();
		insertButton.setBounds(304, 172, 70, 38);
		insertButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insert_Button.png")));
		insertButton.addActionListener(this);
		add(insertButton);

		subjectField = new JTextField();
		subjectField.setBounds(199, 119, 98, 21);
		add(subjectField);
		subjectField.setOpaque(false);
		subjectField.setColumns(10);

		JLabel label_2 = new JLabel("学期");
		label_2.setBounds(390, 66, 42, 15);
		add(label_2);

		termComboBox = new JComboBox<Integer>();
		termComboBox.setBounds(458, 63, 32, 21);
		for (int i = 1; i < 9; i++) {
			termComboBox.addItem(i);
		}
		add(termComboBox);

		ImageIcon labIma = new javax.swing.ImageIcon(getClass().getResource("/images/teacher_panel.png"));
		JLabel jlabel = new JLabel(labIma);
		add(jlabel, new Integer(Integer.MIN_VALUE));
		jlabel.setBounds(0, 0, labIma.getIconWidth(), labIma.getIconHeight());
		setOpaque(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertButton) {
			UserDao dao = new UsersDaoImpl();
			Map<String, Integer> scores = new HashMap<String, Integer>();
			String subject = subjectField.getText().trim();
			String score = scoreField.getText().trim();
			if (!score.equals("") && !subject.equals("")) {
				boolean isNum = score.matches("[0-9]+");
				if (isNum) {
					int scor = Integer.parseInt(score);
					if (scor >= 0 && scor <= 100) {
						scores.put(subject, scor);
					}
				}
			}
			int term = 1;
			term = termComboBox.getSelectedIndex() + 1;
			try {
				boolean issucceed = false;
				if (scores.size() > 0) {
					issucceed = dao.addScores(snoField.getText(), scores, term);
				}
				if (!issucceed) {
					JOptionPane.showMessageDialog(null,
							new JLabel("<html><h2><font color='red'>录入失败！</font></h2></html>"), "警告",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							new JLabel("<html><h2><font color='green'>录入成功！</font></h2></html>"), "提示",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (UserNotFoundException e1) {
				JOptionPane.showMessageDialog(null,
						new JLabel("<html><h2><font color='red'>此学号不存在！<br/>请重新输入！</font></h2></html>"), "警告",
						JOptionPane.ERROR_MESSAGE);
			}
			snoField.setText("");
			scoreField.setText("");
		}

	}
}
