package cn.rain.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

import cn.rain.Exceptions.UserNotFoundException;
import cn.rain.dao.UserDao;
import cn.rain.dao.impl.UsersDaoImpl;

/**
 * ��ʦʹ�ý���ͳ�Ƴɼ����
 * 
 * @author SwYoung
 * @version V1.0
 * @since 2019-4-29
 */

public class Teac_StatisticPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -2965662075841487069L;

	UserDao dao = new UsersDaoImpl();
	JTable table;
	JScrollPane scrollPane;
	Border border = new BevelBorder(1);
	int rowHeight = 25;

	JComboBox<String> classBox;
	JComboBox<String> subjectBox = new JComboBox<String>();;
	JButton showButton;

	public Teac_StatisticPanel() {

		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(0, 100, 700, 400);
		setLayout(null);
		setVisible(false);

		JLabel label = new JLabel("�༶");
		label.setBounds(47, 24, 54, 15);
		add(label);

		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(141, 71, 417, 274);
		add(scrollPane);

		classBox = new JComboBox<String>();
		classBox.addActionListener(this);
		classBox.setBounds(111, 21, 120, 21);
		List<String> classes = dao.getAllClass();
		for (int i = 0; i < classes.size(); i++) {
			classBox.addItem(classes.get(i));
		}
		add(classBox);

		JLabel label_1 = new JLabel("��Ŀ");
		label_1.setBounds(262, 24, 54, 15);
		add(label_1);

		subjectBox.addActionListener(this);
		subjectBox.setBounds(326, 21, 103, 21);
		add(subjectBox);

		showButton = new JButton();
		showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/statistic.png")));
		showButton.addActionListener(this);
		showButton.setBounds(501, 21, 134, 23);
		add(showButton);

		ImageIcon labIma = new javax.swing.ImageIcon(getClass().getResource("/images/teacher_panel.png"));
		JLabel jlabel = new JLabel(labIma);
		add(jlabel, new Integer(Integer.MIN_VALUE));
		jlabel.setBounds(0, 0, labIma.getIconWidth(), labIma.getIconHeight());
		setOpaque(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == classBox) {
			subjectBox.removeAllItems();
			String schoolClass = (String) classBox.getSelectedItem();
			List<String> classSubject = dao.getAllsubjectsByClass(schoolClass);
			for (int i = 0; i < classSubject.size(); i++) {
				subjectBox.addItem(classSubject.get(i));
			}
		}

		if (e.getSource() == showButton) {
			try {
				String[][] result = dao.statistics(classBox.getSelectedItem().toString(),
						subjectBox.getSelectedItem().toString());
				showTable3Columns(result);

			} catch (UserNotFoundException e1) {
				JOptionPane.showMessageDialog(null, new JLabel("<html><h2><font color='red'>��ѯʧ�ܣ�</font></h2></html>"),
						"����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void showTable3Columns(String[][] result) {
		Vector<Object> head = new Vector<Object>();
		head.addElement("������");
		head.addElement("����");
		head.addElement("ռ�ٷֱ�");
		Vector<Object> data;
		Vector<Object> row = new Vector<Object>();

		int rowsCount = 0;

		String[] interval = { "60������", "60-70��", "70-80��", "80-90��", "90-100��" };

		for (int i = 0; i < interval.length; i++) {
			data = new Vector<Object>();
			data.addElement(interval[rowsCount]);
			data.addElement(result[i][0]);
			data.addElement(result[i][1]);
			row.addElement(data);
			rowsCount++;
		}

		DefaultTableModel model = new DefaultTableModel(row, head);
		table.setModel(model);
		table.setFont(new Font("΢���ź�", Font.PLAIN, 13));
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

}
