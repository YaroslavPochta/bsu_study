package sample.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {
	private static final int PLUS = 0;
	private static final int MINUS = 1;
	private static final int MULTIPLICATION = 2;
	private static final int DIVIDE = 3;

	public static BigDecimal calc(BigDecimal val1, BigDecimal val2, BigDecimal val3, BigDecimal val4, int[] operations)
			throws IllegalArgumentException {
		BigDecimal result;
		BigDecimal bracketValue = calcVal(val2, val3, operations[1]);
		if (operations[0] == DIVIDE || operations[0] == MULTIPLICATION) {
			result = calcVal(val1, bracketValue, operations[0]);
			result = calcVal(result, val4, operations[2]);
		} else {
			result = calcVal(bracketValue, val4, operations[2]);
			result = calcVal(val1, result, operations[0]);
		}
		return result;
	}

	private static BigDecimal calcVal(BigDecimal first, BigDecimal second, int operationIndex) throws IllegalArgumentException {
		BigDecimal result = new BigDecimal(0);

		switch (operationIndex) {
			case PLUS:
				result = first.add(second).setScale(10, RoundingMode.HALF_UP);
				break;
			case MINUS:
				result = first.subtract(second).setScale(10, RoundingMode.HALF_UP);
				break;
			case MULTIPLICATION:
				result = first.multiply(second).setScale(10, RoundingMode.HALF_UP);
				break;
			case DIVIDE:
				if (second.compareTo(BigDecimal.ZERO) == 0) {
					throw new IllegalArgumentException("Divide by zero is forbidden");
				}
				result = first.divide(second, 10, BigDecimal.ROUND_HALF_UP);
				break;
		}
		return result;
	}

	public static BigDecimal round(BigDecimal value, int selectedIndex, int scale) {
		BigDecimal result;
		if (selectedIndex == 0) {
			result = value.setScale(scale, RoundingMode.HALF_UP);
		} else {
			if (selectedIndex == 1) {
				result = value.setScale(scale, RoundingMode.HALF_EVEN);
			} else {
				result = value.setScale(scale, RoundingMode.DOWN);
			}
		}
		return result;
	}

	public static boolean isInBounds(BigDecimal val) {
		return val.compareTo(new BigDecimal("-1000000000000")) != -1 &&
		       val.compareTo(new BigDecimal("1000000000000")) != 1;
	}
}
