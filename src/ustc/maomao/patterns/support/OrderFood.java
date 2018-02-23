package ustc.maomao.patterns.support;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ustc.maomao.patterns.decorator.SimpleFood;
import ustc.maomao.patterns.decorator.SpicyFood;
import ustc.maomao.patterns.decorator.SweetFood;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderFood extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private MealOrder order;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public OrderFood(Patron p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 16;
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCos = new JLabel("COS点餐系统");
		panel.add(lblCos);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 16;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label = new JLabel("普通菜");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 9;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("花生米");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_1.add(label_1, gbc_label_1);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 1;
		panel_1.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		
		
		JLabel label_3 = new JLabel("数量：");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 1;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(1);
		
		JLabel label_4 = new JLabel("单价：");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 6;
		gbc_label_4.gridy = 1;
		panel_1.add(label_4, gbc_label_4);
		
		JLabel label_7 = new JLabel("12");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 7;
		gbc_label_7.gridy = 1;
		panel_1.add(label_7, gbc_label_7);
		
		JLabel label_2 = new JLabel("皮蛋豆腐");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel_1.add(label_2, gbc_label_2);
		
		JCheckBox checkBox = new JCheckBox("");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox.gridx = 1;
		gbc_checkBox.gridy = 2;
		panel_1.add(checkBox, gbc_checkBox);
		
		JLabel label_5 = new JLabel("数量：");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 2;
		panel_1.add(label_5, gbc_label_5);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 3;
		gbc_panel_5.gridy = 2;
		panel_1.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0, 47, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(1);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 0, 5);
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 0;
		panel_5.add(textField_3, gbc_textField_3);
		
		JLabel label_6 = new JLabel("单价：");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 0, 5);
		gbc_label_6.gridx = 6;
		gbc_label_6.gridy = 2;
		panel_1.add(label_6, gbc_label_6);
		
		JLabel label_8 = new JLabel("20");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.gridx = 7;
		gbc_label_8.gridy = 2;
		panel_1.add(label_8, gbc_label_8);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 16;
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel label_9 = new JLabel("甜菜");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.gridwidth = 15;
		gbc_label_9.insets = new Insets(0, 0, 5, 0);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 0;
		panel_2.add(label_9, gbc_label_9);
		
		JLabel label_10 = new JLabel("拔丝香蕉");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.gridwidth = 2;
		gbc_label_10.insets = new Insets(0, 0, 0, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 1;
		panel_2.add(label_10, gbc_label_10);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_1.gridx = 2;
		gbc_checkBox_1.gridy = 1;
		panel_2.add(checkBox_1, gbc_checkBox_1);
		
		JLabel label_11 = new JLabel("数量：");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.insets = new Insets(0, 0, 0, 5);
		gbc_label_11.gridx = 3;
		gbc_label_11.gridy = 1;
		panel_2.add(label_11, gbc_label_11);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 2;
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 4;
		gbc_panel_6.gridy = 1;
		panel_2.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 47, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		textField_1 = new JTextField();
		textField_1.setColumns(1);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 0;
		panel_6.add(textField_1, gbc_textField_1);
		
		JLabel label_14 = new JLabel("甜度:");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 0, 5);
		gbc_label_14.gridx = 7;
		gbc_label_14.gridy = 1;
		panel_2.add(label_14, gbc_label_14);
		
		JLabel label_15 = new JLabel("很甜");
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 0, 5);
		gbc_label_15.gridx = 8;
		gbc_label_15.gridy = 1;
		panel_2.add(label_15, gbc_label_15);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_2.gridx = 9;
		gbc_checkBox_2.gridy = 1;
		panel_2.add(checkBox_2, gbc_checkBox_2);
		
		JLabel label_16 = new JLabel("一般甜");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.insets = new Insets(0, 0, 0, 5);
		gbc_label_16.gridx = 10;
		gbc_label_16.gridy = 1;
		panel_2.add(label_16, gbc_label_16);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
		gbc_checkBox_3.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_3.gridx = 11;
		gbc_checkBox_3.gridy = 1;
		panel_2.add(checkBox_3, gbc_checkBox_3);
		
		JLabel label_12 = new JLabel("单价：");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 0, 5);
		gbc_label_12.gridx = 13;
		gbc_label_12.gridy = 1;
		panel_2.add(label_12, gbc_label_12);
		
		JLabel label_13 = new JLabel("30");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.gridx = 14;
		gbc_label_13.gridy = 1;
		panel_2.add(label_13, gbc_label_13);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 2;
		gbc_panel_3.gridwidth = 16;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 5;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_17 = new JLabel("辣菜");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.gridwidth = 16;
		gbc_label_17.insets = new Insets(0, 0, 5, 0);
		gbc_label_17.gridx = 0;
		gbc_label_17.gridy = 0;
		panel_3.add(label_17, gbc_label_17);
		
		JLabel label_18 = new JLabel("麻辣豆腐");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.insets = new Insets(0, 0, 0, 5);
		gbc_label_18.gridx = 0;
		gbc_label_18.gridy = 1;
		panel_3.add(label_18, gbc_label_18);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_4 = new GridBagConstraints();
		gbc_checkBox_4.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_4.gridx = 1;
		gbc_checkBox_4.gridy = 1;
		panel_3.add(checkBox_4, gbc_checkBox_4);
		
		JLabel label_19 = new JLabel("数量：");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.insets = new Insets(0, 0, 0, 5);
		gbc_label_19.gridx = 2;
		gbc_label_19.gridy = 1;
		panel_3.add(label_19, gbc_label_19);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridwidth = 5;
		gbc_panel_7.insets = new Insets(0, 0, 0, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 3;
		gbc_panel_7.gridy = 1;
		panel_3.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 0;
		panel_7.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel label_20 = new JLabel("辣度：");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.insets = new Insets(0, 0, 0, 5);
		gbc_label_20.gridx = 8;
		gbc_label_20.gridy = 1;
		panel_3.add(label_20, gbc_label_20);
		
		JLabel label_21 = new JLabel("很辣");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.insets = new Insets(0, 0, 0, 5);
		gbc_label_21.gridx = 9;
		gbc_label_21.gridy = 1;
		panel_3.add(label_21, gbc_label_21);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_5 = new GridBagConstraints();
		gbc_checkBox_5.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_5.gridx = 10;
		gbc_checkBox_5.gridy = 1;
		panel_3.add(checkBox_5, gbc_checkBox_5);
		
		JLabel label_22 = new JLabel("一般辣");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.insets = new Insets(0, 0, 0, 5);
		gbc_label_22.gridx = 11;
		gbc_label_22.gridy = 1;
		panel_3.add(label_22, gbc_label_22);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_6 = new GridBagConstraints();
		gbc_checkBox_6.insets = new Insets(0, 0, 0, 5);
		gbc_checkBox_6.gridx = 12;
		gbc_checkBox_6.gridy = 1;
		panel_3.add(checkBox_6, gbc_checkBox_6);
		
		JLabel label_23 = new JLabel("单价：");
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.insets = new Insets(0, 0, 0, 5);
		gbc_label_23.gridx = 14;
		gbc_label_23.gridy = 1;
		panel_3.add(label_23, gbc_label_23);
		
		JLabel label_24 = new JLabel("35");
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.gridx = 15;
		gbc_label_24.gridy = 1;
		panel_3.add(label_24, gbc_label_24);
		
		JButton button = new JButton("确认");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				order=new MealOrder(p);
				Boolean huashengmi_state=chckbxNewCheckBox.isSelected();
				if(huashengmi_state)
				{
					//System.out.println("花生米");
					int huashengmi_mount=Integer.valueOf(textField.getText());
					float huashengmi_price=Integer.valueOf(label_7.getText());
					//System.out.println(huashengmi_state);
					//System.out.println(huashengmi_mount);
					//System.out.println(huashengmi_price);
					SimpleFood f1 = new SimpleFood();
					f1.setName("花生米");
					f1.order(huashengmi_mount);
					order.addFood(f1);
				}
				
				
				Boolean pidandoufu_state=checkBox.isSelected();
				if(pidandoufu_state)
				{
					//System.out.println("皮蛋豆腐");
					int pidandoufu_mount=Integer.valueOf(textField_3.getText());
					float pidandoufu_price=Integer.valueOf(label_8.getText());
					//System.out.println(pidandoufu_state);
					//System.out.println(pidandoufu_mount);
					//System.out.println(pidandoufu_price);
					SimpleFood f4 = new SimpleFood();
					f4.setName("皮蛋豆腐");
					f4.order(pidandoufu_mount);
					order.addFood(f4);
				}
				
				
				Boolean banana_state=checkBox_1.isSelected();
				if(banana_state)
				{
					//System.out.println("拔丝香蕉");
					int banana_mount=Integer.valueOf(textField_1.getText());
					float banana_price=Integer.valueOf(label_13.getText());
					SweetLevel banana_kouwei=SweetLevel.Light;
					Boolean very_sweet=checkBox_2.isSelected();
					Boolean normal_sweet=checkBox_3.isSelected();
					if (very_sweet)
						banana_kouwei=SweetLevel.Cloying;
					else if (normal_sweet)
						banana_kouwei=SweetLevel.Normal;
					
					//System.out.println(banana_state);
					//System.out.println(banana_mount);
					//System.out.println(banana_price);
					//System.out.println(banana_kouwei);
					SimpleFood f3 = new SimpleFood();
					f3.setName("拔丝香蕉");
					SweetFood sweetF3 = new SweetFood(f3);
					sweetF3.order(banana_mount,banana_kouwei);
					order.addFood(sweetF3);
				}
				
				
				
				Boolean maladoufu_state=checkBox_4.isSelected();
				if(maladoufu_state)
				{
					//System.out.println("麻辣豆腐");
					int maladoufu_mount=Integer.valueOf(textField_2.getText());
					float maladoufu_price=Integer.valueOf(label_24.getText());
					SpicyLevel doufu_kouwei=SpicyLevel.Low;
				
					Boolean very_spicy=checkBox_5.isSelected();
					Boolean normal_spicy=checkBox_6.isSelected();
					if (very_spicy)
						doufu_kouwei=SpicyLevel.Dead;
					else if (normal_spicy)
						doufu_kouwei=SpicyLevel.Middle;
					//System.out.println(maladoufu_state);
					//System.out.println(maladoufu_mount);
					//System.out.println(maladoufu_price);
					//System.out.println(doufu_kouwei);
					SimpleFood f2 = new SimpleFood();
					f2.setName("麻辣豆腐");
					SpicyFood spicyF2 = new SpicyFood(f2);
					spicyF2.order(maladoufu_mount);
					spicyF2.setSpicyLevel(doufu_kouwei);
					order.addFood(spicyF2);
					Dialog dialog=new Dialog("订餐成功！");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    				dialog.setVisible(true);

				}
				
				
				/*
				SimpleFood f1 = new SimpleFood();
				f1.setName("花生米");
				f1.order(5);
				order.addFood(f1);

				SimpleFood f2 = new SimpleFood();
				f2.setName("麻辣豆腐");
				SpicyFood spicyF2 = new SpicyFood(f2);
				spicyF2.order(2);
				spicyF2.setSpicyLevel(SpicyLevel.Dead);
				order.addFood(spicyF2);

				SimpleFood f3 = new SimpleFood();
				f3.setName("拔丝香蕉");
				SweetFood sweetF3 = new SweetFood(f3);
				sweetF3.order(5, SweetLevel.Cloying);
				order.addFood(sweetF3);

				SimpleFood f4 = new SimpleFood();
				f4.setName("皮蛋豆腐");
				f4.order(7);
				order.addFood(f4);
				*/
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 5;
		gbc_button.gridy = 7;
		contentPane.add(button, gbc_button);
		
		JButton button_1 = new JButton("取消");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("取消");
				System.exit(0);
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 8;
		gbc_button_1.gridy = 7;
		contentPane.add(button_1, gbc_button_1);
		
	}
	public MealOrder getMealOrder()
	{
		return order;
	}

}
