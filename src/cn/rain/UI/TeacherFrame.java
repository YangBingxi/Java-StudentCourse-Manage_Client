package cn.rain.UI;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import cn.rain.domain.User;

import javax.swing.JLabel;

/**
 * 教师使用界面框架
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class TeacherFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	Teac_FindPanel findPanel = new Teac_FindPanel();
	Teac_InsertPanel insertPanel = new Teac_InsertPanel();
	Teac_StatisticPanel statisticPanel = new Teac_StatisticPanel();
	Teac_UpdatePanel updatePanel = new Teac_UpdatePanel();
	JButton insertButton = new JButton("录入成绩"), updatebutton = new JButton("修改成绩"), statButton = new JButton("成绩统计"),
			findButton = new JButton("查询成绩");
	private JPanel contentPane;

	User teacher = null;

	public TeacherFrame(User teacher) {

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				TeacherFrame.this.dispose();
				new LoginFrame().setVisible(true);
			}
		});
		findPanel.setVisible(true);
		this.teacher = teacher;
		setTitle("欢迎使用成绩管理系统");

		ImageIcon labIma = new javax.swing.ImageIcon(getClass().getResource("/images/stuback.png"));
		JLabel jlabel = new JLabel(labIma);
		getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
		jlabel.setBounds(0, 0, labIma.getIconWidth(), labIma.getIconHeight());

		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 700) / 2, (height - 500) / 2, 700, 500);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(findPanel);
		contentPane.add(statisticPanel);
		contentPane.add(updatePanel);
		contentPane.add(insertPanel);

		Listener listener = new Listener();
		insertButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insert.png")));
		insertButton.addActionListener(listener);
		insertButton.setBounds(23, 48, 120, 29);
		contentPane.add(insertButton);

		findButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png")));
		findButton.addActionListener(listener);
		findButton.setBounds(355, 48, 120, 29);
		contentPane.add(findButton);

		statButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sta.png")));
		statButton.addActionListener(listener);
		statButton.setBounds(517, 48, 120, 29);
		contentPane.add(statButton);

		updatebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png")));
		updatebutton.addActionListener(listener);
		updatebutton.setBounds(187, 48, 120, 29);
		contentPane.add(updatebutton);

		JLabel label = new JLabel("<html>欢迎您，<font color='#930093'>" + teacher.getName() + "</font> 老师！</html>");
		label.setBounds(23, 10, 179, 21);
		contentPane.add(label);

	}

	public class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == insertButton) {
				insertPanel.setVisible(true);
				updatePanel.setVisible(false);
				findPanel.setVisible(false);
				statisticPanel.setVisible(false);
			}

			if (e.getSource() == updatebutton) {
				insertPanel.setVisible(false);
				updatePanel.setVisible(true);
				findPanel.setVisible(false);
				statisticPanel.setVisible(false);
			}

			if (e.getSource() == statButton) {
				insertPanel.setVisible(false);
				updatePanel.setVisible(false);
				findPanel.setVisible(false);
				statisticPanel.setVisible(true);
			}

			if (e.getSource() == findButton) {
				insertPanel.setVisible(false);
				updatePanel.setVisible(false);
				findPanel.setVisible(true);
				statisticPanel.setVisible(false);
			}
		}
	}
}
