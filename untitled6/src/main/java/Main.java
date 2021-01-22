public class Main {
	public static void main(String[] args) {
		System.out.println(bank_round(-5.4851));
	}

	public static double bank_round(double val)
	{
		int tmp = (int) (Math.abs(val) * 100);
		if (tmp % 2 != 0) {
			tmp += 1;
		}
		if (val < 0){
			tmp = -tmp;
		}
		return tmp / 100;
	}
}
