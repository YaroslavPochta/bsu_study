package com.company.entity;

import java.util.List;

public class Rule {
	private final List<Lexeme> conditions;
	private final Lexeme conclusion;

	public Rule(List<Lexeme> conditions, Lexeme conclusion) {
		this.conditions = conditions;
		this.conclusion = conclusion;
	}

	public Lexeme getConclusion() {
		return conclusion;
	}

	public List<Lexeme> getConditions() {
		return conditions;
	}

	@Override
	public String toString() {
		return "If = " + conditions + ", " +
		       "then = " + conclusion + "\n";
	}
}