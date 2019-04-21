package cn.rain.UI;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JPanel;

import cn.rain.Exceptions.UserExistedException;
import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 管理员界面添加学生面板
 * 
 * @author rain
 * @version 2014-09-10
 * @since JDK1.6
 */

public class Admin_AddStuPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -2444827634455955112L;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField snoField;
	private JTextField nameField;
	private JTextField ClassField;
	JComboBox<String> yearBox;
	JComboBox<String> monthBox;
	JComboBox<String> dayBox;
	JRadioButton maleRadio;
	JRadioButton femaleRadio;

	String gender = "男";
	JButton addStuButton;

	public Admin_AddStuPanel() {

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setVisible(false);
		setBounds(0, 100, 616, 330);
		setLayout(null);

		JLabel label = new JLabel("用户名");
		label.setFont(UIManager.getFont("Label.font"));
		label.setBounds(10, 20, 60, 15);
		add(label);

		usernameField = new JTextField();
		usernameField.setBounds(66, 17, 80, 21);
		add(usernameField);
		usernameField.setColumns(10);

		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(184, 20, 54, 15);
		add(label_1);

		passwordField = new JTextField();
		passwordField.setBounds(248, 17, 66, 21);
		add(passwordField);
		passwordField.setColumns(10);

		JLabel label_2 = new JLabel("学号");
		label_2.setBounds(338, 20, 54, 15);
		add(label_2);

		snoField = new JTextField();
		snoField.setBounds(388, 17, 66, 21);
		add(snoField);
		snoField.setColumns(10);

		JLabel label_3 = new JLabel("姓名");
		label_3.setBounds(472, 20, 54, 15);
		add(label_3);

		nameField = new JTextField();
		nameField.setBounds(520, 17, 80, 21);
		add(nameField);
		nameField.setColumns(10);

		JLabel label_4 = new JLabel("性别");
		label_4.setBounds(10, 58, 54, 15);
		add(label_4);

		maleRadio = new JRadioButton("男");
		maleRadio.setSelected(true);
		maleRadio.setBounds(66, 54, 44, 23);
		add(maleRadio);

		femaleRadio = new JRadioButton("女");
		femaleRadio.setBounds(112, 54, 44, 23);
		add(femaleRadio);

		JLabel label_5 = new JLabel("班级");
		label_5.setBounds(184, 58, 54, 15);
		add(label_5);

		ClassField = new JTextField();
		ClassField.setBounds(248, 55, 66, 21);
		add(ClassField);
		ClassField.setColumns(10);

		yearBox = new JComboBox<String>();
		yearBox.setBounds(398, 55, 56, 21);
		yearBox.addActionListener(this);
		add(yearBox);

		monthBox = new JComboBox<String>();
		monthBox.setBounds(478, 55, 40, 21);
		monthBox.addActionListener(this);
		add(monthBox);

		dayBox = new JComboBox<String>();
		dayBox.setBounds(541, 55, 38, 21);
		dayBox.addActionListener(this);
		add(dayBox);

		for (int i = 1990; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
			yearBox.addItem(i + "");
		}

		for (int i = 1; i <= 12; i++) {
			monthBox.addItem(i + "");
		}

		for (int i = 1; i <= 31; i++) {
			dayBox.addItem(i + "");
		}

		JLabel label_6 = new JLabel("年");
		label_6.setBounds(463, 58, 18, 15);
		add(label_6);

		JLabel label_7 = new JLabel("月");
		label_7.setBounds(525, 58, 18, 15);
		add(label_7);

		JLabel label_8 = new JLabel("日");
		label_8.setBounds(590, 58, 18, 15);
		add(label_8);

		addStuButton = new JButton("添加学生");
		addStuButton.addActionListener(this);
		addStuButton.setBounds(238, 101, 93, 23);
		add(addStuButton);

		JLabel label_9 = new JLabel("出生日期");
		label_9.setBounds(338, 58, 54, 15);
		add(label_9);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int year, month0 = 1, day0 = 1;
		if (e.getSource() == yearBox || e.getSource() == monthBox) {
			year = yearBox.getSelectedIndex() + 1990;
			month0 = monthBox.getSelectedIndex() + 1;

			switch (month0) {
			case 1:
				addStandardMon();
				dayBox.addItem("31");
				break;
			case 2:
				addStandardMon();
				dayBox.removeItem("30");
				if (year % 400 != 0 && year % 4 != 0) {
					dayBox.removeItem("29");
				}
				break;
			case 3:
				addStandardMon();
				dayBox.addItem("31");
				break;
			case 4:
				addStandardMon();
				break;
			case 5:
				addStandardMon();
				dayBox.addItem("31");
				break;
			case 6:
				addStandardMon();
				break;
			case 7:
				addStandardMon();
				dayBox.addItem("31");
				break;
			case 8:
				addStandardMon();
				dayBox.addItem("31");
				break;
			case 9:
				addStandardMon();
				break;
			case 10:
				addStandardMon();
				dayBox.addItem("31");
				break;
			case 11:
				addStandardMon();
				break;
			case 12:
				addStandardMon();
				dayBox.addItem("31");
				break;
			default:
				break;
			}
		}

		if (e.getSource() == femaleRadio) {
			if (femaleRadio.isSelected()) {
				gender = "男";
			}
		}
		if (e.getSource() == maleRadio) {
			if (maleRadio.isSelected()) {
				gender = "女";
			}
		}

		if (e.getSource() == addStuButton) {
			month0 = monthBox.getSelectedIndex() + 1;
			day0 = dayBox.getSelectedIndex() + 1;
			String month = null, day = null;

			if (month0 < 10) {
				month = "0" + month0;
			} else {
				month = month0 + "";
			}
			if (day0 < 10) {
				day = "0" + day0;
			} else {
				day = day0 + "";
			}

			String username = usernameField.getText().trim();
			String password = passwordField.getText().trim();
			String sno = snoField.getText().trim();
			String name = nameField.getText().trim();
			String schoolClass = ClassField.getText().trim();
			String bir = yearBox.getSelectedItem() + "-" + month + "-" + day;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = null;

			try {
				birthday = df.parse(bir);
			} catch (ParseException e1) {
				JOptionPane
						.showMessageDialog(
								null,
								new JLabel(
										"<html><h2><font color='red'>输入日期有误！</font></h2></html>"),
								"警告", JOptionPane.ERROR_MESSAGE);
			}

			UserDao dao = new UsersDaoImpl();

			Map<String, Object> stu = new LinkedHashMap<String, Object>();
			stu.put("username", username);
			stu.put("password", password);
			stu.put("sno", sno);
			stu.put("name", name);
			stu.put("gender", gender);
			stu.put("birthday", birthday);
			stu.put("schoolClass", schoolClass);
			stu.put("permission", "学生");

			try {
				if (username.equals("") || password.equals("")
						|| sno.equals("") || name.equals("")
						|| schoolClass.equals("")) {
					JOptionPane
					.showMessageDialog(
							null,
							new JLabel(
									"<html><h2><font color='red'>请填写完整用户信息！</font></h2></html>"),
							"警告", JOptionPane.ERROR_MESSAGE);

				}else{
					dao.addUser(stu);
					
					JOptionPane.showMessageDialog(null, new JLabel(
							"<html><h2><font color='green'>添加成功！</font></h2></html>"),
							"提醒", JOptionPane.INFORMATION_MESSAGE);
					usernameField.setText("");
					passwordField.setText("");
					snoField.setText("");
					nameField.setText("");
				}
			} catch (UserExistedException e1) {
				JOptionPane
						.showMessageDialog(
								null,
								new JLabel(
										"<html><h2><font color='red'>用户已存在！</font></h2></html>"),
								"警告", JOptionPane.ERROR_MESSAGE);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void addStandardMon() {
		dayBox.removeAllItems();
		for (int i = 1; i <= 30; i++) {
			dayBox.addItem(i + "");
		}
	}
}
