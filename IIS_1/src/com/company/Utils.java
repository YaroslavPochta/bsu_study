package com.company;

import com.company.entity.Lexeme;
import com.company.entity.Rule;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Utils {

	public static Object[] getTypes(List<Rule> rules) {
		Set<String> uniqueTypes = new TreeSet<>();
		for (Rule rule : rules) {
			uniqueTypes.add(rule.getConclusion().getName());
		}
		return uniqueTypes.toArray();
	}

	public static Object[] getTypesEqualToStr(List<Rule> activeRules, String str) {
		Set<String> answers = new HashSet<>();
		for (Rule rule : activeRules) {
			for (Lexeme condition : rule.getConditions()) {
				if (condition.getName().equals(str)) {
					answers.add(condition.getValue());
				}
			}
		}
		return answers.toArray();
	}

	public static List<Rule> readFile(String path) throws IOException {
		List<Rule> rules = new ArrayList<>();
		ArrayList<Lexeme> conditions;
		BufferedReader bufferedReader;
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
		bufferedReader = new BufferedReader(inputStreamReader);
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		while (stringTokenizer.hasMoreElements() && stringTokenizer.nextToken().equals("Если")) {
			conditions = new ArrayList<>();
			String[] parsedString = new String[4];
			parsedString[0] = stringTokenizer.nextToken();
			parsedString[1] = stringTokenizer.nextToken();
			parsedString[2] = stringTokenizer.nextToken();
			parsedString[3] = stringTokenizer.nextToken();
			Lexeme lexeme = new Lexeme(parsedString[0], parsedString[2]);
			conditions.add(lexeme);
			while (parsedString[3].equals("и")) {
				parsedString[0] = stringTokenizer.nextToken();
				parsedString[1] = stringTokenizer.nextToken();
				parsedString[2] = stringTokenizer.nextToken();
				parsedString[3] = stringTokenizer.nextToken();
				lexeme = new Lexeme(parsedString[0], parsedString[2]);
				conditions.add(lexeme);
			}
			if (parsedString[3].equals("тогда")) {
				parsedString[0] = stringTokenizer.nextToken();
				parsedString[1] = stringTokenizer.nextToken();
				parsedString[2] = stringTokenizer.nextToken();
				lexeme = new Lexeme(parsedString[0], parsedString[2]);
			}
			Rule rule = new Rule(conditions, lexeme);
			rules.add(rule);

			String tempStr = bufferedReader.readLine();
			if (tempStr != null) {
				stringTokenizer = new StringTokenizer(tempStr);
			} else {
				break;
			}
		}
		bufferedReader.close();
		System.out.println(rules);
		return rules;
	}
}
