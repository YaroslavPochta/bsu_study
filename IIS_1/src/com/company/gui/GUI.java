
package com.company.gui;

import com.company.Algorithm;
import com.company.Utils;
import com.company.entity.Rule;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GUI extends JFrame {
	private List<Rule> rules;
	private DefaultListModel listModel;
	private JList jList;
	private GUI jFrame;

	public static void main(String[] args) throws IOException {
		new GUI();
	}

	public GUI() throws IOException {
		super("Lab 1");
		jFrame = this;
		rules = Utils.readFile("resources\\rules.txt");
		constructFrame();

		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = constructGridBagConstraints();

		JPanel jPanel = new JPanel();
		JComboBox editComboBox = new JComboBox(Utils.getTypes(rules));
		editComboBox.setEditable(true);
		jPanel.add(editComboBox, BorderLayout.NORTH);

		JButton jOK = new JButton("Start");
		jPanel.add(jOK, BorderLayout.PAGE_END);

		gridBagLayout.setConstraints(jPanel, gridBagConstraints);
		this.add(jPanel);

		jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jList.setPreferredSize(new Dimension(360, 680));
		this.add(jList);

		this.revalidate();

		jOK.addActionListener(e -> {
			listModel.removeAllElements();
			new Algorithm(jFrame, listModel, rules)
					.run((String) editComboBox.getSelectedItem());
		});
	}

	public void constructFrame() {
		setSize(new Dimension(420, 780));
		setLocation(new Point(700, 150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		listModel = new DefaultListModel();
		jList = new JList(listModel);
	}

	public GridBagConstraints constructGridBagConstraints() {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
		gridBagConstraints.gridx = GridBagConstraints.RELATIVE;
		gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
		return gridBagConstraints;
	}
}