package com.ncepu.javahomework13;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShoppingQuestionnaireFrame implements ActionListener {

	private JFrame frame = null;

	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints cons = null;

	private JPanel panel = new JPanel(layout);

	public ShoppingQuestionnaireFrame(String title) {
		frame = new JFrame(title);
		frame.setSize(450, 900);
		frame.setLocationRelativeTo(null);

		panel.setBackground(new Color(47, 47, 47));

		addMainTitle();

		addBlank();
		addTitle("一、基本信息");
		addLabel("  1. 姓名");
		addTextField();
		addLabel("  2. 性别");
		addComBox(new String[] { "男", "女" });
//        addRadioButtonGroup(new String[]{"男", "女"}, false);
		addLabel("  3. 年龄");
		addSpinner();
		addLabel("  4. 年级");
		addComBox(new String[] { "大一", "大二", "大三", "大四", "研一", "研二", "研三" });
		addBlank();
		addBlank();

		addTitle("二、问卷内容");
		addLabel("  1. 本次“双十一”是否会购物");
		addBlank();
		addRadioButtonGroup(new String[] { "是", "否" }, false);
		addLabel("  2. 感兴趣的商品种类有哪些");
		addBlank();
		addCheckBox(new String[] { "食品", "服装", "鞋帽", "日用品", "家具", "电器", "五金" }, true);
		addBlank();
		addLabel("  3. 预算范围");
		addBlank();
		addRadioButtonGroup(
				new String[] { "0 ~ 100", "100 ~ 500", "500 ~ 1000", "1000 ~ 2000", "2000 ~ 3000", "3000, 5000" },
				true);
		addLabel("  4.购物的目的");
		addBlank();
		addCheckBox(new String[] { "优惠力度大", "大家买我也买", "一年只有一次" }, true);
		addBlankTab();
		JTextArea purposeText = new JTextArea(3, 3);
		cons = new GridBagConstraints();
		cons.gridwidth = GridBagConstraints.CENTER;
		cons.fill = GridBagConstraints.BOTH;
		layout.addLayoutComponent(purposeText, cons);
		panel.add(purposeText);
		addBlank();

		addBlank();
		addBlankTab();
		JButton submitButton = new JButton("Submit");
		submitButton.setOpaque(false);
		submitButton.setFocusPainted(false);
		submitButton.setContentAreaFilled(false);
		submitButton.setForeground(Color.WHITE);
		cons = new GridBagConstraints();
		cons.gridwidth = GridBagConstraints.CENTER;
		cons.fill = GridBagConstraints.BOTH;
		layout.addLayoutComponent(submitButton, cons);

		submitButton.addActionListener(e -> {
			System.out.println("submit button clicked!");
			checkAllInfo();
		});

		panel.add(submitButton);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void checkAllInfo() {
		JTextArea confirmInfoText = new JTextArea();
		confirmInfoText.setEditable(false);
		confirmInfoText.append("请确认您的信息：\n");

		boolean flag = false;
		int count = panel.getComponentCount();
		int checkBoxCount = 0;

		int Combox = 1;
		int radioIndex = 1;

		ArrayList arrayList1 = new ArrayList<>();
		ArrayList arrayList2 = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			Object obj = panel.getComponent(i);
			if (obj instanceof JTextField tf) {
				if (tf.getText().equals("")) {
					System.out.println(tf);
					tf.setForeground(Color.RED);
					tf.setText("请补充！！！");

					flag = true;

				} else
					confirmInfoText.append("姓名: " + tf.getText() + "\n");
			}
			if (obj instanceof JTextArea ta) {
				if (ta.getText().equals("")) {
					System.out.println(ta);
					ta.setForeground(Color.RED);
					ta.setText("请补充！！！");

					flag = true;
				}
			}

//            System.out.println(obj);
			if (obj instanceof JCheckBox cb) {
				if (checkBoxCount < 8) {
					if (checkBoxCount == 0)
						confirmInfoText.append("感兴趣的商品种类: ");
					if (cb.isSelected()) {
						arrayList1.add(cb.getText());
						confirmInfoText.append(cb.getText() + " ");
					}
					if (checkBoxCount == 7)
						confirmInfoText.append("\n");
				} else {
					if (checkBoxCount == 8)
						confirmInfoText.append("购物目的: ");
					if (cb.isSelected()) {
						confirmInfoText.append(cb.getText());
						arrayList2.add(cb.getText());
					}
					if (checkBoxCount == 11)
						confirmInfoText.append("\n");
				}
				checkBoxCount++;
			}

			if (obj instanceof JSpinner s) {
				confirmInfoText.append("年龄: " + s.getValue() + "\n");
			}

			if (obj instanceof JComboBox cb) {
				if (Combox == 1) {
					confirmInfoText.append("性别: " + cb.getSelectedItem().toString() + "\n");
					Combox++;
				} else {
					confirmInfoText.append("年级: " + cb.getSelectedItem().toString() + "\n");
				}
			}

			if (obj instanceof JRadioButton rb) {
				if (rb.isSelected()) {
					if (radioIndex == 1) {
						confirmInfoText.append("双十一是否购物: " + rb.getText().toString() + "\n");
						radioIndex++;
					} else {
						confirmInfoText.append("预算范围: " + rb.getText().toString() + "\n");
					}
				}
			}

			if (obj instanceof JTextArea textArea) {
				confirmInfoText.append(textArea.getText());
			}
		}

		String str1 = "";
		if (arrayList1.isEmpty()) {
			System.out.println("补充购物信息");
			flag = true;
			str1 = "购物信息";
		}

		String str2 = "";
		if (arrayList2.isEmpty()) {
			System.out.println("补充购物目的");
			flag = true;
			str2 = "购物目的";
		}

		if (flag) {
			JOptionPane.showMessageDialog(frame, "请返回根据提示添加信息" + "(" + str1 + " " + str2 + ")", "补充信息",
					JOptionPane.INFORMATION_MESSAGE);
		}

		if (!flag) {
			int res = JOptionPane.showConfirmDialog(frame, "请确认信息", "确认问卷信息", JOptionPane.YES_NO_OPTION);
			if (res == 0) {
				System.out.println("confirm");
				JOptionPane.showMessageDialog(frame, confirmInfoText, "用户填报信息", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		System.out.println(checkBoxCount);
		System.out.println(arrayList1);
		System.out.println(arrayList2);
	}

	public boolean ifButtonSelected(ButtonGroup buttonGroup) {
		int count = 0;
		Enumeration<AbstractButton> radioButtons = buttonGroup.getElements();
		while (radioButtons.hasMoreElements()) {
			AbstractButton abstractButton = radioButtons.nextElement();
			if (abstractButton.isSelected()) {
				System.out.println(abstractButton.getText());

			}
		}

		if (count == 0)
			return false;
		else
			return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void addSpinner() {
		cons = new GridBagConstraints();
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.fill = GridBagConstraints.BOTH;
		JSpinner spinner = new JSpinner();
		spinner.setOpaque(false);
		spinner.setForeground(Color.WHITE);
		spinner.setValue(18);
		layout.addLayoutComponent(spinner, cons);
		panel.add(spinner);
	}

	public void addComBox(String[] str) {
		cons = new GridBagConstraints();
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.fill = GridBagConstraints.BOTH;
		JComboBox comboBox = new JComboBox(str);
		comboBox.setEditable(false);
		comboBox.setOpaque(false);
		comboBox.setBorder(null);
		layout.addLayoutComponent(comboBox, cons);
		panel.add(comboBox);
	}

	public void addCheckBox(String[] str, boolean other) {
//        JPanel panel_checkBox = new JPanel();
//        panel_checkBox.setOpaque(false);
		int i = 0;
		addBlankTab();
		for (String s : str) {
			cons = new GridBagConstraints();
			cons.gridwidth = 1;
			cons.fill = GridBagConstraints.BOTH;
			JCheckBox checkBox = new JCheckBox(s);
			checkBox.setOpaque(false);
			checkBox.setForeground(Color.WHITE);
//            panel_checkBox.add(checkBox);
			layout.addLayoutComponent(checkBox, cons);
			panel.add(checkBox);
			i++;
			if (i % 2 == 0) {
				cons = new GridBagConstraints();
				cons.gridwidth = GridBagConstraints.REMAINDER;
				cons.fill = GridBagConstraints.BOTH;
				JPanel blankPanel = new JPanel();
				blankPanel.setOpaque(false);
				layout.addLayoutComponent(blankPanel, cons);
				panel.add(blankPanel);
				addBlankTab();
			}
		}
		if (other) {
			cons = new GridBagConstraints();
			cons.gridwidth = 1;
			cons.fill = GridBagConstraints.BOTH;
			JCheckBox checkBox = new JCheckBox("其他");
			checkBox.setOpaque(false);
			checkBox.setForeground(Color.WHITE);
			layout.addLayoutComponent(checkBox, cons);
//            panel_checkBox.add(checkBox);
			panel.add(checkBox);
		}
		addBlank();
	}

	public void addRadioButtonGroup(String[] str, boolean other) {
		ButtonGroup group = new ButtonGroup();
		int i = 0;
		addBlankTab();
		for (String s : str) {
			cons = new GridBagConstraints();
			cons.gridwidth = 1;
			cons.fill = GridBagConstraints.BOTH;
			JRadioButton radioButton = new JRadioButton(s, true);
			radioButton.setOpaque(false);
			radioButton.setForeground(Color.WHITE);
			group.add(radioButton);
			layout.addLayoutComponent(radioButton, cons);
			panel.add(radioButton);
			i++;
			if (i % 2 == 0) {
				addBlank();
				addBlankTab();
			}
		}
		if (other) {
			cons = new GridBagConstraints();
			cons.gridwidth = 1;
			cons.fill = GridBagConstraints.BOTH;
			JRadioButton radioButton = new JRadioButton("其他");
			radioButton.setOpaque(false);
			radioButton.setForeground(Color.WHITE);
			group.add(radioButton);
			layout.addLayoutComponent(radioButton, cons);
			panel.add(radioButton);
		}
		addBlank();
	}

	public void addMainTitle() {
		cons = new GridBagConstraints();
		cons.gridwidth = GridBagConstraints.CENTER;
		cons.fill = GridBagConstraints.BOTH;
		JLabel titleLabel = new JLabel("双十一购物问卷调查", JLabel.CENTER);
		titleLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		titleLabel.setOpaque(false);
		titleLabel.setForeground(Color.WHITE);
		layout.addLayoutComponent(titleLabel, cons);
		panel.add(titleLabel);
		addBlank();
	}

	public void addTitle(String title) {
		cons = new GridBagConstraints();
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.fill = GridBagConstraints.BOTH;
		JLabel label1 = new JLabel(title);
		label1.setFont(new Font("楷体", Font.PLAIN, 16));
		label1.setOpaque(false);
		label1.setForeground(Color.WHITE);
		layout.addLayoutComponent(label1, cons);
		panel.add(label1);
	}

	public void addLabel(String str) {
		cons = new GridBagConstraints();
		cons.gridwidth = 2;
		cons.fill = GridBagConstraints.BOTH;
		JLabel label = new JLabel(str);
		label.setOpaque(false);
		label.setForeground(Color.WHITE);
		layout.addLayoutComponent(label, cons);
		panel.add(label);
	}

	public void addTextField() {
		cons = new GridBagConstraints();
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.fill = GridBagConstraints.BOTH;
		JTextField textField = new JTextField(1);
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		layout.addLayoutComponent(textField, cons);
		panel.add(textField);
	}

	public void addBlank() {
		cons = new GridBagConstraints();
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.fill = GridBagConstraints.BOTH;
		JPanel blankPanel = new JPanel();
		blankPanel.setOpaque(false);
		layout.addLayoutComponent(blankPanel, cons);
		panel.add(blankPanel);
	}

	public void addBlankTab() {
		cons = new GridBagConstraints();
		cons.gridwidth = 1;
		cons.fill = GridBagConstraints.BOTH;
		JPanel blankPanel = new JPanel();
		blankPanel.setOpaque(false);
		layout.addLayoutComponent(blankPanel, cons);
		panel.add(blankPanel);
	}
}
