class lab1 {
    public static void main(String[] args) throws java.io.IOException {
        double x;
        double accuracy;
        System.out.println("Its working");
        try {
            if (args.length != 2) throw new IllegalArgumentException("Expected two elements");
            x = Double.parseDouble(args[0]);
            accuracy = Double.parseDouble(args[1]);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return;
        }
        double accumulate = 0;
        double elem = 1 / (2 * 3);
        for (int i = 2; elem < accuracy; i++) {
            elem *= x;
            elem /= (i + 1) * (i + 2);
            accumulate += elem;

        }
        System.out.println("Sum of the row (with an accuracy " + accuracy + " is " + accumulate);
    }
}
