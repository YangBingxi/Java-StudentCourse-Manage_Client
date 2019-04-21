package cn.rain.UI;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import java.awt.Color;
import javax.swing.ImageIcon;

import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;
import cn.rain.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Map;

/**
 * 用户登陆界面
 * 
 * @author rain
 * @version 2014-09-10
 * @since JDK1.6
 */

public class LoginFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JPanel contentPane;
	JTextField textField;
	JPasswordField passwordField;
	JButton login = new JButton("登陆");
	ButtonGroup group = new ButtonGroup();
	JRadioButton adminRadio;

	public LoginFrame() {

		setResizable(false);
		setTitle("登陆");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 548) / 2, (height - 467) / 2, 548, 467);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setOpaque(false);

		ImageIcon labIma = new javax.swing.ImageIcon(getClass().getResource(
				"/images/back.png"));

		JLabel jlabel = new JLabel(labIma);
		getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
		jlabel.setBounds(0, 0, labIma.getIconWidth(), labIma.getIconHeight());
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("学生成绩管理系统");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 28));
		lblNewLabel.setBounds(194, 61, 250, 67);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		login.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/login.png")));
		login.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		login.setBackground(new Color(98, 183, 240));
		login.setBounds(348, 304, 83, 30);
		login.addActionListener(this);
		contentPane.add(login);

		JLabel usernamelab = new JLabel("用户名：");
		usernamelab.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/username.png")));
		usernamelab.setFont(new Font("楷体", Font.PLAIN, 15));
		usernamelab.setHorizontalAlignment(SwingConstants.LEFT);
		usernamelab.setBounds(128, 163, 92, 30);
		contentPane.add(usernamelab);

		JLabel passwordlab = new JLabel("密码：");
		passwordlab.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/password.png")));
		passwordlab.setFont(new Font("楷体", Font.PLAIN, 15));
		passwordlab.setHorizontalAlignment(SwingConstants.LEFT);
		passwordlab.setBounds(128, 241, 83, 30);
		contentPane.add(passwordlab);

		textField = new JTextField("rain");
		textField.setOpaque(false);
		textField.setBounds(230, 165, 199, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField("rain");
		passwordField.setOpaque(false);
		passwordField.setBounds(230, 243, 199, 27);
		contentPane.add(passwordField);

		JRadioButton stuRadio = new JRadioButton("学生");
		stuRadio.setName("student");
		stuRadio.setOpaque(false);
		stuRadio.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		stuRadio.setSelected(true);
		stuRadio.setBounds(149, 308, 49, 23);
		contentPane.add(stuRadio);

		JRadioButton teacherRadio = new JRadioButton("教师");
		teacherRadio.setName("teacher");
		teacherRadio.setOpaque(false);
		teacherRadio.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		teacherRadio.setBounds(205, 308, 49, 23);
		contentPane.add(teacherRadio);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/log.png")));
		label.setBounds(81, 61, 81, 67);
		contentPane.add(label);

		adminRadio = new JRadioButton("管理员");
		adminRadio.setName("admin");
		adminRadio.setOpaque(false);
		adminRadio.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		adminRadio.setBounds(261, 308, 72, 23);
		contentPane.add(adminRadio);

		group.add(stuRadio);
		group.add(teacherRadio);
		group.add(adminRadio);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login) {

			UserDao dao = new UsersDaoImpl();
			String username = textField.getText();
			String password = new String(passwordField.getPassword());
			String permission = "学生";

			Enumeration<AbstractButton> en = group.getElements();
			while (en.hasMoreElements()) {
				AbstractButton abstractButton = (AbstractButton) en
						.nextElement();
				if (abstractButton.isSelected()) {
					if (abstractButton.getName().equals("teacher")) {
						permission = "教师";
					} else if (abstractButton.getName().equals("admin")) {

						Map<String, String> admin = dao.getAdmin();

						String adminName = admin.get("username");
						String adminPassword = admin.get("password");
						if (username.equals(adminName)
								&& password.equals(adminPassword)) {
							this.dispose();
							new AdminFrame().setVisible(true);
						} else {
							JOptionPane
									.showMessageDialog(
											null,
											new JLabel(
													"<html><h2><font color='red'>用户名或密码错<br/>误，请重新输入</font></h2></html>"),
											"警告", JOptionPane.ERROR_MESSAGE);
							textField.setText("");
							passwordField.setText("");
						}
					}
				}
			}

			if (!adminRadio.isSelected()) {
				User user = dao.find(username, password, permission);
				if (user != null) {
					if (permission.equals("学生")) {
						this.dispose();
						try {
							new StudentFrame(user).setVisible(true);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						this.dispose();
						new TeacherFrame(user).setVisible(true);
					}
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									new JLabel(
											"<html><h2><font color='red'>用户名或密码错<br/>误，请重新输入</font></h2></html>"),
									"警告", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					passwordField.setText("");
				}
			}
		}
	}
}
