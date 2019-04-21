package cn.rain.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.rain.Exceptions.UserNotFoundException;
import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;
import cn.rain.domain.User;

import javax.swing.JComboBox;

/**
 * 教师使用界面查询面板
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class Teac_FindPanel extends JPanel implements ActionListener, DocumentListener {

	private static final long serialVersionUID = 2167572405318362876L;

	UserDao dao = new UsersDaoImpl();
	JTextField snoField;
	JTextField nameField;
	JTextField scoreField;
	JTable table;
	JScrollPane scrollPane;
	Border border = new BevelBorder(1);
	int rowHeight = 25;

	JRadioButton snoRadio;
	JRadioButton nameRadio;
	JRadioButton higherRadio;
	JRadioButton lowerRadio;

	JRadioButton termRadio;
	JRadioButton yearRadio;

	ButtonGroup findMethodRadio = new ButtonGroup();
	ButtonGroup group = new ButtonGroup();
	ButtonGroup sortGroup = new ButtonGroup();

	JButton findButton;
	JButton sortButton;
	JComboBox<String> comboBox;
	JTextField subjectField;

	boolean sortMethod = false;

	JRadioButton downRadio;
	JRadioButton upRadio;

	public Teac_FindPanel() {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(0, 100, 700, 400);
		setLayout(null);
		setVisible(false);

		JLabel label = new JLabel("学号");
		label.setBounds(46, 29, 54, 15);
		add(label);

		snoField = new JTextField();
		snoField.setOpaque(false);
		snoField.setColumns(10);
		snoField.setBounds(98, 26, 84, 21);
		add(snoField);
		snoField.getDocument().addDocumentListener(this);

		JLabel label_1 = new JLabel("姓名");
		label_1.setBounds(222, 29, 48, 15);
		add(label_1);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setOpaque(false);
		nameField.setBounds(280, 26, 66, 21);
		nameField.getDocument().addDocumentListener(this);
		add(nameField);

		JLabel label_2 = new JLabel("指定分数");
		label_2.setBounds(519, 29, 54, 15);
		add(label_2);

		scoreField = new JTextField("0");
		scoreField.setOpaque(false);
		scoreField.setBounds(585, 26, 28, 21);
		add(scoreField);
		scoreField.setColumns(10);

		snoRadio = new JRadioButton("按学号查询");
		snoRadio.setOpaque(false);
		snoRadio.setBounds(98, 74, 99, 23);
		add(snoRadio);

		nameRadio = new JRadioButton("按姓名查询");
		nameRadio.setOpaque(false);
		nameRadio.setBounds(222, 74, 99, 23);
		add(nameRadio);

		higherRadio = new JRadioButton("高于(包含)指定分数");
		higherRadio.setOpaque(false);
		higherRadio.setBounds(334, 74, 160, 23);
		add(higherRadio);

		lowerRadio = new JRadioButton("低于指定分数");
		lowerRadio.setOpaque(false);
		lowerRadio.setBounds(519, 74, 99, 23);
		add(lowerRadio);

		findMethodRadio.add(snoRadio);
		findMethodRadio.add(nameRadio);
		findMethodRadio.add(higherRadio);
		findMethodRadio.add(lowerRadio);

		findButton = new JButton();
		findButton.setBounds(534, 122, 79, 23);
		findButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find_Button.png")));
		findButton.addActionListener(this);
		add(findButton);

		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(46, 179, 490, 180);
		add(scrollPane);

		termRadio = new JRadioButton("查询指定学期成绩");
		termRadio.setBounds(98, 122, 121, 23);
		termRadio.setOpaque(false);
		termRadio.setSelected(true);
		add(termRadio);

		yearRadio = new JRadioButton("查询指定学年成绩");
		yearRadio.setOpaque(false);
		yearRadio.setBounds(222, 122, 121, 23);
		add(yearRadio);

		termRadio.addActionListener(this);
		yearRadio.addActionListener(this);

		group.add(termRadio);
		group.add(yearRadio);

		JLabel label_3 = new JLabel("选择学期/学年");
		label_3.setBounds(360, 126, 83, 15);
		add(label_3);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(458, 123, 42, 21);
		for (int i = 1; i < 5; i++) {
			comboBox.addItem(i + "");
		}
		add(comboBox);

		JLabel label_4 = new JLabel("指定课程");
		label_4.setBounds(364, 29, 54, 15);
		add(label_4);

		subjectField = new JTextField();
		subjectField.setColumns(10);
		subjectField.setOpaque(false);
		subjectField.setBounds(434, 26, 66, 21);
		subjectField.getDocument().addDocumentListener(this);
		add(subjectField);

		sortButton = new JButton();
		sortButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sort_Button.png")));
		sortButton.setBounds(541, 290, 73, 23);
		sortButton.addActionListener(this);
		add(sortButton);

		downRadio = new JRadioButton("从高到低");
		downRadio.setOpaque(false);
		downRadio.setBounds(539, 212, 121, 23);
		downRadio.setSelected(true);
		downRadio.addActionListener(this);
		add(downRadio);

		upRadio = new JRadioButton("从低到高");
		upRadio.setOpaque(false);
		upRadio.setBounds(539, 250, 121, 23);
		upRadio.addActionListener(this);
		add(upRadio);

		sortGroup.add(downRadio);
		sortGroup.add(upRadio);

		ImageIcon labIma = new javax.swing.ImageIcon(getClass().getResource("/images/teacher_panel.png"));
		JLabel jlabel = new JLabel(labIma);
		add(jlabel, new Integer(Integer.MIN_VALUE));
		jlabel.setBounds(0, 0, labIma.getIconWidth(), labIma.getIconHeight());
		setOpaque(false);

	}

	private void showTable2Columns(Iterator<Entry<String, Integer>> iterator) {

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
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == sortButton) {
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
			if (columns == 2) {
				showTable2Columns(iterator);
			} else if (columns == 3) {
				showTable3Columns(iterator);
			}
		}

		if (e.getSource() == termRadio) {
			if (termRadio.isSelected()) {
				comboBox.removeAllItems();
				for (int i = 1; i < 9; i++) {
					comboBox.addItem(i + "");
				}
			}
		}

		if (e.getSource() == yearRadio) {
			if (yearRadio.isSelected()) {
				comboBox.removeAllItems();
				for (int i = 1; i < 5; i++) {
					comboBox.addItem(i + "");
				}
			}
		}

		if (e.getSource() == downRadio) {
			sortMethod = false;
		}
		if (e.getSource() == upRadio) {
			sortMethod = true;
		}

		if (e.getSource() == findButton) {

			String method = null;
			String timeMethod = null;
			Map<String, Integer> scores;

			Enumeration<AbstractButton> en = findMethodRadio.getElements();
			while (en.hasMoreElements()) {

				AbstractButton abstractButton = (AbstractButton) en.nextElement();
				if (abstractButton.isSelected()) {

					if (abstractButton.getText().equals("按学号查询")) {
						method = "sno";
					} else if (abstractButton.getText().equals("按姓名查询")) {
						method = "name";
					} else if (abstractButton.getText().equals("高于(包含)指定分数")) {
						method = "high";
					} else if (abstractButton.getText().equals("低于指定分数")) {
						method = "low";
					}
				}
			}

			Enumeration<AbstractButton> enumeration = group.getElements();
			while (enumeration.hasMoreElements()) {

				AbstractButton abstractButton = (AbstractButton) enumeration.nextElement();
				if (abstractButton.isSelected()) {
					if (abstractButton.getText().equals("查询指定学期成绩")) {
						timeMethod = "term";
					} else if (abstractButton.getText().equals("查询指定学年成绩")) {
						timeMethod = "year";
					}
				}
			}

			int num = comboBox.getSelectedIndex() + 1;

			if (method == null) {

				JOptionPane.showMessageDialog(null,
						new JLabel("<html><h2><font color='red'>请选择正确的查询方式！</font></h2></html>"), "警告",
						JOptionPane.ERROR_MESSAGE);

			} else {
				if (method.equals("sno")) {
					try {
						scores = dao.findScores(snoField.getText().trim(), timeMethod, num);
						Iterator<Entry<String, Integer>> iterator = scores.entrySet().iterator();
						showTable2Columns(iterator);

					} catch (UserNotFoundException e1) {
						JOptionPane.showMessageDialog(null,
								new JLabel("<html><h2><font color='red'>学号输入有误<br/>，请重新输入</font></h2></html>"), "警告",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (method.equals("name")) {
					User stu = dao.findStudentByName(nameField.getText().trim());
					if (stu != null) {

						try {
							scores = dao.findScores(stu.getSno(), timeMethod, num);
							Iterator<Entry<String, Integer>> iterator = scores.entrySet().iterator();
							showTable2Columns(iterator);

						} catch (UserNotFoundException e1) {
							JOptionPane.showMessageDialog(null,
									new JLabel("<html><h2><font color='red'>查询失败！</font></h2></html>"), "警告",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								new JLabel("<html><h2><font color='red'>未找到此学生<br/>，请重新输入</font></h2></html>"), "警告",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (method.equals("high") || method.equals("low")) {
					try {
						boolean isHigh = true;
						if (method.equals("low")) {
							isHigh = false;
						}
						Map<String, Integer> subscores = dao.findSubscoresBynum(subjectField.getText().trim(),
								Integer.parseInt(scoreField.getText().trim()), isHigh);

						Iterator<Entry<String, Integer>> iterator = subscores.entrySet().iterator();
						showTable3Columns(iterator);

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,
								new JLabel("<html><h2><font color='red'>查询失败！</font></h2></html>"), "警告",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}

	public void showTable3Columns(Iterator<Entry<String, Integer>> iterator) {
		Vector<Object> head = new Vector<Object>();
		head.addElement("学号");
		head.addElement("姓名");
		head.addElement("成绩");
		Vector<Object> data;
		Vector<Object> row = new Vector<Object>();

		int rowsCount = 0;
		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			data = new Vector<Object>();
			data.addElement(entry.getKey());
			data.addElement(dao.findStudentBySno(entry.getKey()).getName());
			data.addElement(entry.getValue());
			row.addElement(data);
			rowsCount++;
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
		table.setPreferredSize(new Dimension(472, rowHeight * rowsCount));
		table.repaint();
		table.updateUI();
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (e.getDocument() == subjectField.getDocument()) {
			higherRadio.setSelected(true);
			snoField.setText("");
			nameField.setText("");
		}
		if (e.getDocument() == snoField.getDocument()) {
			snoRadio.setSelected(true);
			subjectField.setText("");
			nameField.setText("");
		}
		if (e.getDocument() == nameField.getDocument()) {
			nameRadio.setSelected(true);
			snoField.setText("");
			subjectField.setText("");
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		if (e.getDocument() == subjectField.getDocument()) {
			higherRadio.setSelected(true);
			snoField.setText("");
			nameField.setText("");
		}
		if (e.getDocument() == snoField.getDocument()) {
			snoRadio.setSelected(true);
			nameField.setText("");
			subjectField.setText("");
		}
		if (e.getDocument() == nameField.getDocument()) {
			nameRadio.setSelected(true);
			snoField.setText("");
			subjectField.setText("");
		}
	}
}
