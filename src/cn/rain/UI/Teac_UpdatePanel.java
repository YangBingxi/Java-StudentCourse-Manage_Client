package cn.rain.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;

/**
 * 教师使用界面修改成绩面板
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class Teac_UpdatePanel extends JPanel implements ActionListener, DocumentListener {

	private static final long serialVersionUID = 4004410198324316342L;
	private JTextField snoField;
	private JTextField scoreField;
	JComboBox<String> subjectBox;
	JButton updateButton;
	UserDao dao = new UsersDaoImpl();

	public Teac_UpdatePanel() {

		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(0, 100, 700, 400);
		setLayout(null);
		setVisible(false);

		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setBounds(186, 73, 42, 15);
		add(lblNewLabel);

		snoField = new JTextField();
		snoField.setBounds(238, 70, 98, 21);
		add(snoField);
		snoField.setOpaque(false);
		snoField.getDocument().addDocumentListener(this);
		snoField.setColumns(10);

		JLabel label = new JLabel("课程名称");
		label.setBounds(362, 73, 60, 15);
		add(label);

		subjectBox = new JComboBox<String>();
		subjectBox.setEnabled(false);
		subjectBox.setBounds(426, 70, 100, 21);
		add(subjectBox);

		scoreField = new JTextField();
		scoreField.setBounds(238, 126, 99, 21);
		scoreField.setOpaque(false);
		add(scoreField);
		scoreField.setColumns(10);

		JLabel label_1 = new JLabel("成绩");
		label_1.setBounds(186, 129, 42, 15);
		add(label_1);

		updateButton = new JButton();
		updateButton.setBounds(400, 125, 100, 23);
		updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update_Button.png")));
		updateButton.addActionListener(this);
		add(updateButton);

		ImageIcon labIma = new javax.swing.ImageIcon(getClass().getResource("/images/teacher_panel.png"));
		JLabel jlabel = new JLabel(labIma);
		add(jlabel, new Integer(Integer.MIN_VALUE));
		jlabel.setBounds(0, 0, labIma.getIconWidth(), labIma.getIconHeight());
		setOpaque(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateButton) {

			String sno = snoField.getText().trim();
			String score = scoreField.getText().trim();
			String subject = "";
			Object object = subjectBox.getSelectedItem();
			if (object != null) {
				subject = object.toString();
			}
			boolean isSucceed = false;
			if (!score.equals("") && !subject.equals("") && !sno.equals("")) {

				boolean isNum = score.matches("[0-9]+");
				if (isNum) {
					int scor = Integer.parseInt(score);
					if (scor >= 0 && scor <= 100) {
						isSucceed = dao.updateScore(snoField.getText().trim(), subjectBox.getSelectedItem().toString(),
								scor);
					}
				}
			}

			if (!isSucceed) {
				JOptionPane.showMessageDialog(null, new JLabel("<html><h2><font color='red'>修改失败！</font></h2></html>"),
						"警告", JOptionPane.ERROR_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(null,
						new JLabel("<html><h2><font color='green'>修改成功！</font></h2></html>"), "提示",
						JOptionPane.INFORMATION_MESSAGE);

			}
			snoField.setText("");
			scoreField.setText("");
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		String sno = snoField.getText().trim();
		if (!sno.equals("")) {
			subjectBox.setEnabled(true);
			List<String> subjects = dao.getSubjects(sno);
			subjectBox.removeAllItems();
			for (int i = 0; i < subjects.size(); i++) {
				subjectBox.addItem(subjects.get(i));
			}
		} else {
			subjectBox.removeAllItems();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		String sno = snoField.getText().trim();
		if (!sno.equals("")) {
			subjectBox.setEnabled(true);
			List<String> subjects = dao.getSubjects(sno);
			subjectBox.removeAllItems();
			for (int i = 0; i < subjects.size(); i++) {
				subjectBox.addItem(subjects.get(i));
			}
		} else {
			subjectBox.removeAllItems();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		String sno = snoField.getText().trim();
		if (!sno.equals("")) {
			subjectBox.setEnabled(true);
			List<String> subjects = dao.getSubjects(sno);
			subjectBox.removeAllItems();
			for (int i = 0; i < subjects.size(); i++) {
				subjectBox.addItem(subjects.get(i));
			}
		} else {
			subjectBox.removeAllItems();
		}
	}
}
