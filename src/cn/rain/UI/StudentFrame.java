package cn.rain.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.UIManager;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

import cn.rain.Exceptions.UserNotFoundException;
import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;
import cn.rain.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;
import java.awt.Font;

/**
 * 学生用户界面
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class StudentFrame extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = 1L;

	JPanel contentPane;
	JTextField subjectName;
	ButtonGroup findRadio;
	JButton findButton = new JButton("查询");;
	JButton sortButton = new JButton("排序");;
	JRadioButton yearButton;
	JRadioButton subject;
	JRadioButton termButton;
	User student = null;
	JComboBox<Integer> yearBox;
	JComboBox<Integer> termBox;
	ButtonGroup sortRadio;
	Object[][] info = null;
	JTable table;
	JScrollPane scrollPane;
	String[] names = { "课程名称", "成绩" };

	Border border = new BevelBorder(1);
	int rowHeight = 25;

	JRadioButton downRadio;

	JRadioButton upRadio;

	boolean sortMethod = false;

	public StudentFrame(User student) throws RemoteException {

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				StudentFrame.this.dispose();
				new LoginFrame().setVisible(true);
			}
		});

		this.student = student;
		setTitle("欢迎使用成绩管理系统");
		setResizable(false);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - 700) / 2, (height - 500) / 2, 675, 500);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setSize(700, 500);
		contentPane.setOpaque(false);

		ImageIcon labIma = new javax.swing.ImageIcon(getClass().getResource("/images/stuback.png"));
		JLabel jlabel = new JLabel(labIma);
		getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
		jlabel.setBounds(0, 0, labIma.getIconWidth(), labIma.getIconHeight());

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		yearBox = new JComboBox<Integer>();
		yearBox.setForeground(new Color(0, 0, 0));
		yearBox.setBounds(164, 40, 33, 21);
		yearBox.addFocusListener(this);
		contentPane.add(yearBox);

		JLabel label = new JLabel("选择学年");
		label.setOpaque(false);
		label.setBounds(90, 42, 60, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("选择学期");
		label_1.setOpaque(false);
		label_1.setBounds(240, 42, 60, 15);
		contentPane.add(label_1);

		termBox = new JComboBox<Integer>();
		termBox.setForeground(new Color(0, 0, 0));
		termBox.setBounds(309, 40, 33, 21);
		termBox.addFocusListener(this);
		contentPane.add(termBox);

		for (int i = 1; i < 5; i++) {
			yearBox.addItem(i);
		}
		for (int i = 1; i < 9; i++) {
			termBox.addItem(i);
		}

		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 222, 472, 240);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("课程名称");
		lblNewLabel.setBounds(404, 42, 60, 15);
		lblNewLabel.setOpaque(false);
		contentPane.add(lblNewLabel);

		subjectName = new JTextField();
		subjectName.setBounds(482, 40, 90, 21);
		contentPane.add(subjectName);
		subjectName.setColumns(10);
		subjectName.setOpaque(false);
		subjectName.addFocusListener(this);

		yearButton = new JRadioButton("按学年查询");
		yearButton.setBounds(100, 86, 103, 23);
		yearButton.setOpaque(false);
		yearButton.setSelected(true);
		contentPane.add(yearButton);

		termButton = new JRadioButton("按学期查询");
		termButton.setBounds(220, 86, 103, 23);
		termButton.setOpaque(false);
		contentPane.add(termButton);

		subject = new JRadioButton("按指定课程查询");
		subject.setBounds(323, 86, 123, 23);
		subject.setOpaque(false);
		contentPane.add(subject);

		findRadio = new ButtonGroup();
		findRadio.add(yearButton);
		findRadio.add(termButton);
		findRadio.add(subject);
		findButton.setForeground(new Color(153, 255, 204));
		findButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));

		findButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png")));
		findButton.setBounds(482, 86, 82, 23);
		findButton.setBackground(new Color(0, 102, 204));
		contentPane.add(findButton);
		findButton.addActionListener(this);

		upRadio = new JRadioButton("从低到高");
		upRadio.setBounds(528, 302, 121, 23);
		upRadio.setSelected(true);
		upRadio.setOpaque(false);
		upRadio.addActionListener(this);
		contentPane.add(upRadio);

		downRadio = new JRadioButton("从高到低");
		downRadio.setBounds(528, 263, 121, 23);
		downRadio.setOpaque(false);
		downRadio.addActionListener(this);
		contentPane.add(downRadio);

		sortRadio = new ButtonGroup();
		sortRadio.add(upRadio);
		sortRadio.add(downRadio);
		sortButton.setForeground(new Color(153, 255, 204));
		sortButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		sortButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/up.png")));
		sortButton.setBounds(532, 346, 82, 23);
		sortButton.addActionListener(this);
		sortButton.setBackground(new Color(0, 102, 204));
		contentPane.add(sortButton);

		JLabel label_2 = new JLabel("<html>欢迎您，<font color='#930093'>" + student.getName() + "</font> 同学！</html>");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setBounds(22, 10, 430, 15);
		contentPane.add(label_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == downRadio) {
			sortMethod = false;
		}
		if (e.getSource() == upRadio) {
			sortMethod = true;
		}

		UserDao dao = new UsersDaoImpl();
		Map<String, Integer> scores = null;
		String method = "year";
		int num = 1;
		num = yearBox.getSelectedIndex() + 1;
		Enumeration<AbstractButton> en = findRadio.getElements();
		while (en.hasMoreElements()) {
			AbstractButton abstractButton = (AbstractButton) en.nextElement();
			if (abstractButton.isSelected()) {
				if (abstractButton.getText().equals("按学期查询")) {
					method = "term";
					num = termBox.getSelectedIndex() + 1;
				} else if (abstractButton.getText().equals("按指定课程查询")) {
					method = "subject";
				}
			}
		}

		try {
			if (method.equals("subject")) {
				Map<String, Integer> map = dao.findScore(student.getSno(), subjectName.getText().trim());
				scores = map != null ? map : null;
			} else {
				scores = dao.findScores(student.getSno(), method, num);
			}
		} catch (UserNotFoundException e1) {
			JOptionPane.showMessageDialog(null, new JLabel("<html><h2><font color='red'>查询失败，请重试！</font></h2></html>"),
					"警告", JOptionPane.ERROR_MESSAGE);
		}

		if (e.getSource() == findButton && scores != null) {

			subjectName.setText("");

			Iterator<Entry<String, Integer>> iterator = scores.entrySet().iterator();

			showTable(iterator);

		} else if (e.getSource() == sortButton) {
			TableModel model = table.getModel();
			int rows = model.getRowCount();
			int columns = model.getColumnCount();
			String name;
			int value;
			Map<String, Integer> map = new LinkedHashMap<String, Integer>();
			for (int i = 0; i < rows; i++) {
				name = (String) model.getValueAt(i, 0);
				value = (Integer) model.getValueAt(i, columns - 1);
				map.put(name, value);
			}
			Map<String, Integer> tables = dao.sortTable(map, sortMethod);
			Iterator<Entry<String, Integer>> iterator = tables.entrySet().iterator();
			showTable(iterator);
		}
	}

	private void showTable(Iterator<Entry<String, Integer>> iterator) {

		Vector<Object> head = new Vector<Object>();
		head.addElement("课程");
		head.addElement("成绩");
		Vector<Object> data;
		Vector<Object> row = new Vector<Object>();

		int rows = 0;
		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			data = new Vector<Object>();
			data.addElement(entry.getKey());
			data.addElement(entry.getValue());
			row.addElement(data);
			rows++;
		}

		DefaultTableModel model = new DefaultTableModel(row, head);
		table.setModel(model);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setBorder(border);
		table.setDefaultRenderer(Object.class, r);
		table.setRowHeight(rowHeight);
		table.getTableHeader().setDefaultRenderer(r);
		table.setPreferredSize(new Dimension(472, rowHeight * rows));
		table.repaint();
		table.updateUI();
	}

	@Override
	public void focusGained(FocusEvent e) {
		boolean isSub = true;
		if (subjectName.getText().trim().length() != 0) {
			isSub = false;
		}
		if (e.getSource() == subjectName) {
			subject.setSelected(true);
		} else if (e.getSource() == yearBox && isSub) {
			yearButton.setSelected(true);
		} else if (e.getSource() == termBox && isSub) {
			termButton.setSelected(true);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == subject) {
			if (subjectName.getText().trim().length() == 0) {
				yearButton.setSelected(true);
			}
		}
	}
}
