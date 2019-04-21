package cn.rain.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;

/**
 * 管理员界面删除用户面板
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class Admin_DelUserPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8743335316422534023L;
	private JComboBox<String> usernamesBox;
	private JButton delButton;

	UserDao dao = new UsersDaoImpl();

	public Admin_DelUserPanel() {

		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setVisible(false);
		setBounds(0, 100, 616, 330);
		setLayout(null);

		JLabel label = new JLabel("用户名");
		label.setBounds(155, 36, 54, 15);
		add(label);

		usernamesBox = new JComboBox<String>();
		usernamesBox.setBounds(219, 33, 75, 21);
		add(usernamesBox);

		delButton = new JButton("删除用户");
		delButton.setBounds(352, 32, 93, 23);
		delButton.addActionListener(this);
		add(delButton);

	}

	public void showUsernames() {

		usernamesBox.removeAllItems();

		List<String> subjects = dao.getUsernames();
		for (int i = 0; i < subjects.size(); i++) {
			usernamesBox.addItem(subjects.get(i));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == delButton) {
			String username = usernamesBox.getSelectedItem().toString();
			dao.deleteUser(username);
			showUsernames();
		}
	}
}
