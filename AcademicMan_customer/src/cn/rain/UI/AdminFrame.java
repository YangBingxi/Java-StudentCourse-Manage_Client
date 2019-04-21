package cn.rain.UI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

/** 
* 管理员界面框架
* @author  rain 
* @version 2014-09-10
* @since   JDK1.6
*/

public class AdminFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6021475535550094475L;

	private JPanel contentPane;

	Admin_AddStuPanel addStuPanel = new Admin_AddStuPanel();
	Admin_AddteacPanel addteacPanel = new Admin_AddteacPanel();
	Admin_DelUserPanel delUserPanel = new Admin_DelUserPanel();

	private JButton addStuButton;

	private JButton addTeacButton;

	private JButton delUserButton;

	public AdminFrame() {
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				AdminFrame.this.dispose();
				new LoginFrame().setVisible(true);
			}
		});

		setResizable(false);
		setTitle("管理员");
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 630) / 2, (height - 390) / 2, 630, 390);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addStuPanel.setVisible(true);
		getContentPane().add(addStuPanel);
		getContentPane().add(addteacPanel);
		getContentPane().add(delUserPanel);

		addStuButton = new JButton("添加学生");
		addStuButton.setBounds(104, 10, 93, 23);
		addStuButton.addActionListener(this);
		contentPane.add(addStuButton);

		addTeacButton = new JButton("添加教师");
		addTeacButton.setBounds(253, 10, 93, 23);
		addTeacButton.addActionListener(this);
		contentPane.add(addTeacButton);

		delUserButton = new JButton("删除用户");
		delUserButton.setBounds(415, 10, 93, 23);
		delUserButton.addActionListener(this);
		contentPane.add(delUserButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addStuButton) {
			addStuPanel.setVisible(true);
			addteacPanel.setVisible(false);
			delUserPanel.setVisible(false);

		}
		if (e.getSource() == addTeacButton) {
			addStuPanel.setVisible(false);
			addteacPanel.setVisible(true);
			delUserPanel.setVisible(false);
		}
		if (e.getSource() == delUserButton) {
			addStuPanel.setVisible(false);
			addteacPanel.setVisible(false);
			delUserPanel.setVisible(true);
			delUserPanel.showUsernames();
		}
	}
}
