package cn.rain.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import cn.rain.Exceptions.UserExistedException;
import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;

/** 
* ����Ա������ӽ�ʦ��� 
* @author  rain 
* @version 2014-09-10
* @since   JDK1.6
*/ 

public class Admin_AddteacPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8383397966179559339L;

	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField nameField;
	private JButton addTeacButton;

	public Admin_AddteacPanel() {

		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setVisible(false);
		setBounds(0, 100, 616, 330);
		setLayout(null);

		JLabel label = new JLabel("�û���");
		label.setFont(UIManager.getFont("Label.font"));
		label.setBounds(74, 28, 36, 15);
		add(label);

		usernameField = new JTextField();
		usernameField.setBounds(133, 25, 66, 21);
		add(usernameField);
		usernameField.setColumns(10);

		JLabel label_1 = new JLabel("����");
		label_1.setBounds(271, 28, 24, 15);
		add(label_1);

		passwordField = new JTextField();
		passwordField.setBounds(305, 25, 66, 21);
		add(passwordField);
		passwordField.setColumns(10);

		JLabel label_3 = new JLabel("����");
		label_3.setBounds(437, 28, 24, 15);
		add(label_3);

		nameField = new JTextField();
		nameField.setBounds(471, 25, 66, 21);
		add(nameField);
		nameField.setColumns(10);

		addTeacButton = new JButton("��ӽ�ʦ");
		addTeacButton.addActionListener(this);
		addTeacButton.setBounds(264, 96, 93, 23);
		add(addTeacButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addTeacButton) {

			String username = usernameField.getText().trim();
			String password = passwordField.getText().trim();
			String name = nameField.getText().trim();

			Map<String, Object> teacher = new LinkedHashMap<String, Object>();
			teacher.put("username", username);
			teacher.put("password", password);
			teacher.put("name", name);
			teacher.put("permission", "��ʦ");


			UserDao dao = new UsersDaoImpl();
			try {
				if (username.equals("") || password.equals("")|| name.equals("")) {
					JOptionPane
					.showMessageDialog(
							null,
							new JLabel(
									"<html><h2><font color='red'>����д�����û���Ϣ��</font></h2></html>"),
							"����", JOptionPane.ERROR_MESSAGE);

				}else{
					dao.addUser(teacher);
					
					JOptionPane.showMessageDialog(null, new JLabel(
							"<html><h2><font color='green'>��ӳɹ���</font></h2></html>"),
							"����", JOptionPane.INFORMATION_MESSAGE);
					usernameField.setText("");
					passwordField.setText("");
					nameField.setText("");
				}
			} catch (UserExistedException e1) {
				JOptionPane
						.showMessageDialog(
								null,
								new JLabel(
										"<html><h2><font color='red'>�û��Ѵ��ڣ�</font></h2></html>"),
								"����", JOptionPane.ERROR_MESSAGE);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
	}
}
