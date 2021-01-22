package sample.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

public class TextUtils {

	public static String format(BigDecimal bigDecimal) {
		return new DecimalFormat("#,###.######")
				.format(bigDecimal.stripTrailingZeros()).replaceAll(",", " ");
	}

	public static String parseBigDecimal(String text) throws ParseException {
		if (Pattern.matches("^-?(((\\d{1,3})( \\d{3})*)|(\\d*))(((\\.)|(,))\\d*)?$", text)) {
			text = text.replaceAll(",", ".");
			text = text.replaceAll("\\s+", "");

			if (text.contains(",")) {
				String[] arr = text.split(",");
				text = arr[0] + "." + arr[1];
			}
			return text;
		} else {
			throw new ParseException("Invalid input", 0);
		}
	}
}
