package com.company;

import com.company.entity.Lexeme;
import com.company.entity.Rule;
import com.company.gui.GUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Algorithm {
	private final int LIE = 0;
	private final int TRUTH = 1;
	private final int UNDEFINED = -1;

	private final DefaultListModel listModel;
	private final GUI gui;

	private List<Rule> activeRules;
	private List<Rule> discardedRules;
	private List<Rule> acceptedRules;

	private String resultConclusion;

	public Algorithm(GUI thisFrame, DefaultListModel listModel, List<Rule> rules) {
		this.gui = thisFrame;
		this.listModel = listModel;
		this.activeRules = rules;
		this.discardedRules = new ArrayList<>();
		this.acceptedRules = new ArrayList<>();
	}

	public void run(String firstSelection) {
		Stack<String> goals = new Stack<>();
		Stack<Boolean> desicions = new Stack<>();
		Stack<Lexeme> context = new Stack<>();

		desicions.push(true);
		goals.push(firstSelection);

		boolean logicalSign = false;
		int curRuleNumber = Integer.MIN_VALUE;
		int conclusion = UNDEFINED;
		while (!logicalSign) {
			boolean isFound = false;
			if (curRuleNumber == Integer.MIN_VALUE) {
				for (Rule rule : activeRules) {
					if (!discardedRules.contains(rule) && !acceptedRules.contains(rule) && rule.getConclusion().getName().equals(goals.lastElement())) {
						isFound = true;
						conclusion = UNDEFINED;
						curRuleNumber = activeRules.indexOf(rule);
						break;
					}
				}
			}
			if (curRuleNumber != Integer.MIN_VALUE) {
				int size = 0;
				for (Lexeme activeCond : activeRules.get(curRuleNumber).getConditions()) {
					for (Lexeme contLex : context) {
						if (contLex.getName().equals(activeCond.getName())) {
							if (contLex.getValue().equals(activeCond.getValue())) {
								size++;
							} else {
								conclusion = LIE;
							}
						}
					}
				}

				if (conclusion != LIE) {
					if (size == activeRules.get(curRuleNumber).getConditions().size()) {
						conclusion = TRUTH;
					} else {
						conclusion = UNDEFINED;
					}
				}

				switch (conclusion) {
					case TRUTH:
						Lexeme tempConcl = activeRules.get(curRuleNumber).getConclusion();
						acceptedRules.add(activeRules.get(curRuleNumber));
						context.add(tempConcl);
						listModel.addElement("Accepted rule : " + curRuleNumber + " " + tempConcl.toString());
						listModel.addElement(" then " + tempConcl.getName() + " = " + tempConcl.getValue());
						for (String str : goals) {
							if (str.equals(tempConcl.getName())) {
								int indexToRemove = goals.indexOf(str);
								goals.remove(indexToRemove);
								desicions.remove(indexToRemove);
								break;
							}
						}
						logicalSign = goals.isEmpty();

						curRuleNumber = Integer.MIN_VALUE;
						break;
					case LIE:
						discardedRules.add(activeRules.get(curRuleNumber));
						listModel.addElement("Discarded rule: " + curRuleNumber);
						curRuleNumber = Integer.MIN_VALUE;
						break;
					case UNDEFINED:
						String nextGoal = null;
						for (Lexeme curCondition : activeRules.get(curRuleNumber).getConditions()) {
							boolean isNext = true;
							for (Lexeme contLex : context) {
								if (curCondition.getName().equals(contLex.getName())) {
									isNext = false;
									break;
								}
							}
							if (isNext) {
								nextGoal = curCondition.getName();
								break;
							}
						}
						goals.add(nextGoal);
						desicions.add(true);
						listModel.addElement("Added to goal: " + nextGoal);

						curRuleNumber = Integer.MIN_VALUE;
						break;
				}
			} else if (goals.size() > 1) {
				String tempStr = goals.pop();
				boolean b = desicions.pop();
				if (!b) {
					logicalSign = true;
				} else {
					JComboBox<Object> decisionPanel = new JComboBox<>(Utils.getTypesEqualToStr(activeRules, tempStr));
					decisionPanel.setEditable(true);
					JOptionPane.showMessageDialog(gui, decisionPanel,
					                              "Choose : " + tempStr, JOptionPane.QUESTION_MESSAGE);
					resultConclusion = (String) decisionPanel.getSelectedItem();

					listModel.addElement("Added to context: " + tempStr + " " + resultConclusion);
					context.add(new Lexeme(tempStr, resultConclusion));
					listModel.addElement(tempStr + " : " + resultConclusion);

					curRuleNumber = desicions.lastElement() ? 1 : Integer.MIN_VALUE;
					if (!isFound) {
						desicions.pop();
						desicions.push(false);
					}
				}
			} else if (goals.size() == 1 && !isFound) {
				logicalSign = true;
			}
		}

		if (!context.empty()) {
			Lexeme resultLex = context.pop();
			resultConclusion = resultLex.getName() + " : " + resultLex.getValue();
		} else {
			resultConclusion = "We can't find anything :(";
		}
		JOptionPane.showConfirmDialog(gui, resultConclusion, "Result",
		                              JOptionPane.OK_CANCEL_OPTION);

	}
}