package sample.gui;

import sample.utils.TextUtils;
import sample.utils.MathUtils;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static sample.utils.TextUtils.parseBigDecimal;
import static sample.utils.MathUtils.isInBounds;

public class InputPanel extends JPanel {
	private static final int PLUS = 0;
	public List<String> operations = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
	public List<String> roundTypes = new ArrayList<>(Arrays.asList("математическое", "бухгалтерское (банковское)", "усечение"));

	public InputPanel() {
		setLayout(new GridLayout(2, 1));
		setPreferredSize(new Dimension(850, 100));

		JPanel expressionPanel = new JPanel();
		expressionPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		expressionPanel.setPreferredSize(new Dimension(850, 50));
		GridBagLayout gridBagLayout = new GridBagLayout();
		expressionPanel.setLayout(gridBagLayout);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.5;
		gridBagConstraints.weighty = 0.0;

		JTextField var1 = new JTextField(String.valueOf(PLUS), 15);
		var1.setPreferredSize(new Dimension(200, 40));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridwidth = 2;
		expressionPanel.add(var1);

		JComboBox<Object> oper1 = new JComboBox<>(operations.toArray());
		oper1.setPreferredSize(new Dimension(40, 40));
		oper1.setSelectedIndex(PLUS);
		gridBagConstraints.gridx = 2;
		expressionPanel.add(oper1);

		JLabel openBracket = new JLabel("(");
		openBracket.setPreferredSize(new Dimension(12, 40));
		openBracket.setFont(new Font("TimesRoman", Font.BOLD, 35));
		openBracket.setEnabled(false);
		gridBagConstraints.gridx = 3;
		expressionPanel.add(openBracket);

		JTextField var2 = new JTextField(String.valueOf(PLUS), 15);
		var2.setPreferredSize(new Dimension(200, 40));
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridwidth = 2;
		expressionPanel.add(var2);

		JComboBox<Object> oper2 = new JComboBox<>(operations.toArray());
		oper2.setPreferredSize(new Dimension(40, 40));
		oper2.setSelectedIndex(PLUS);
		gridBagConstraints.gridx = 5;
		expressionPanel.add(oper2);

		JTextField var3 = new JTextField(String.valueOf(PLUS), 15);
		var3.setPreferredSize(new Dimension(200, 40));
		gridBagConstraints.gridx = 6;
		gridBagConstraints.gridwidth = 2;
		expressionPanel.add(var3);

		JLabel closeBracket = new JLabel(")");
		closeBracket.setPreferredSize(new Dimension(12, 40));
		closeBracket.setFont(new Font("TimesRoman", Font.BOLD, 35));
		closeBracket.setEnabled(false);
		gridBagConstraints.gridx = 8;
		expressionPanel.add(closeBracket);

		JComboBox<Object> oper3 = new JComboBox<>(operations.toArray());
		oper3.setPreferredSize(new Dimension(40, 40));
		oper3.setSelectedIndex(PLUS);
		gridBagConstraints.gridx = 8;
		expressionPanel.add(oper3);

		JTextField var4 = new JTextField(String.valueOf(PLUS), 15);
		var4.setPreferredSize(new Dimension(200, 40));
		gridBagConstraints.gridx = 9;
		gridBagConstraints.gridwidth = 10;
		expressionPanel.add(var4);

		add(expressionPanel);

		JPanel calculatePanel = new JPanel();
		calculatePanel.setLayout(new GridLayout(1, 2, 5, 5));
		calculatePanel.setPreferredSize(new Dimension(600, 50));

		JComboBox roundType = new JComboBox(roundTypes.toArray());
		roundType.setPreferredSize(new Dimension(300, 50));

		JButton calculate = new JButton("Calculate");
		calculate.setPreferredSize(new Dimension(300, 50));
		calculate.addActionListener(
				e -> {
					try {
						fun(new BigDecimal(parseBigDecimal(var1.getText())),
						    new BigDecimal(parseBigDecimal(var2.getText())),
						    new BigDecimal(parseBigDecimal(var3.getText())),
						    new BigDecimal(parseBigDecimal(var4.getText())),
						    roundType.getSelectedIndex(),
						    getOperationIndexes(oper1, oper2, oper3));
					} catch (ParseException exception) {
						JOptionPane.showMessageDialog(this, exception.getMessage(),
						                              "Something wen't wrong", 0);
					}
				});
		calculate.setVisible(true);
		calculate.setEnabled(true);
		calculatePanel.add(roundType, BorderLayout.SOUTH);
		calculatePanel.add(calculate, BorderLayout.WEST);
		add(calculatePanel);
	}

	private void fun(BigDecimal val1, BigDecimal val2, BigDecimal val3, BigDecimal val4, int roundIndex, int[] operations) {
		try {
			BigDecimal result = MathUtils.calc(val1, val2, val3, val4, operations);
			if (isInBounds(result)) {
				JOptionPane.showConfirmDialog(this,
				                              "Result: " + TextUtils.format(MathUtils.round(result, roundIndex, 6)) + "\n" +
				                              "Integer round: " + TextUtils.format(MathUtils.round(result, roundIndex, 0)),
				                              "Result", 2);
			} else {
				throw new IllegalArgumentException("Result out of bounds");
			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Something wen't wrong", 0);
		}
	}

	private int[] getOperationIndexes(JComboBox<Object> op1, JComboBox<Object> op2, JComboBox<Object> op3) {
		int[] operations = new int[3];
		operations[0] = op1.getSelectedIndex();
		operations[1] = op2.getSelectedIndex();
		operations[2] = op3.getSelectedIndex();
		return operations;
	}
}
