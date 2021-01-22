package sample.gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
	public GUI() {
		setLayout(new BorderLayout());
		setTitle("Calculator");
		setResizable(false);
		setLocation(new Point(520, 250));
		setPreferredSize(new Dimension(850, 180));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setVisible(true);

		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(600, 50));
		JLabel developerInfo = new JLabel("Выполнил: Почта Ярослав, 4 группа, 4 курс, 2020 год");
		developerInfo.setFont(new Font("TimesRoman", Font.BOLD, 22));
		developerInfo.setEnabled(true);
		infoPanel.add(developerInfo, BorderLayout.NORTH);
		add(infoPanel, BorderLayout.NORTH);

		add(new InputPanel(), BorderLayout.CENTER);
		pack();
	}
}