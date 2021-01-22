import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable {
    private final String INPUT_FILENAME = "discount.in";
    private final String OUTPUT_FILENAME = "discount.out";
    private final int MAX_NUMBER_OF_PRODUCTS = 5;
    private final int MAX_NUMBER_OF_PRODUCTS_PLUS_ONE = 6;
    private final int FIRST_PRODUCT_INDEX = 0;
    private final int SECOND_PRODUCT_INDEX = 1;
    private final int THIRD_PRODUCT_INDEX = 2;
    private final int FOURTHS_PRODUCT_INDEX = 3;
    private final int FIVES_PRODUCT_INDEX = 4;
    private int FIRST_PRODUCT_CODE;
    private int SECOND_PRODUCT_CODE;
    private int THIRD_PRODUCT_CODE;
    private int FOURTHS_PRODUCT_CODE;
    private int FIVES_PRODUCT_CODE;

    public class FoodBasket {
        private List<Pair<Product, Integer>> productList = new ArrayList<>();
    }

    public class Product {
        private int code;
        private int price;
    }

    public class Discount {
        // private List<Pair> //??????????????????
    }

    public static void main( String[] args ) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILENAME));
            PrintWriter printWriter = new PrintWriter(OUTPUT_FILENAME);
            String str;
            String[] paramStr;
            int productsQuantity = Integer.parseInt(bufferedReader.readLine());
            int[][] productArr = new int[MAX_NUMBER_OF_PRODUCTS_PLUS_ONE][3];
            try {
                for (int i = 0; i < productsQuantity; i++) {
                    str = bufferedReader.readLine();
                    paramStr = str.split(" ");
                    for (int j = 0; j < paramStr.length; j++) {
                        productArr[i][j] = Integer.parseInt(paramStr[j]);

                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

            FIRST_PRODUCT_CODE = productArr[FIRST_PRODUCT_INDEX][0];
            SECOND_PRODUCT_CODE = productArr[SECOND_PRODUCT_INDEX][0];
            THIRD_PRODUCT_CODE = productArr[THIRD_PRODUCT_INDEX][0];
            FOURTHS_PRODUCT_CODE = productArr[FOURTHS_PRODUCT_INDEX][0];
            FIVES_PRODUCT_CODE = productArr[FIVES_PRODUCT_INDEX][0];

            int discounts = Integer.parseInt(bufferedReader.readLine());
            int[][] discountsArr = new int[discounts + MAX_NUMBER_OF_PRODUCTS][MAX_NUMBER_OF_PRODUCTS * 2 + 3];
            int[] discountsCost = new int[discounts];
            try {
                for (int i = 0; i < discounts; i++) {
                    str = bufferedReader.readLine();
                    paramStr = str.split(" ");
                    for (int j = 1; j <= paramStr.length; j++) {
                        discountsArr[i][j - 1] = Integer.parseInt(paramStr[j - 1]);
                        discountsCost[i] = Integer.parseInt(paramStr[paramStr.length - 1]);

                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            int[][][][][] prices =
                    new int[MAX_NUMBER_OF_PRODUCTS_PLUS_ONE][MAX_NUMBER_OF_PRODUCTS_PLUS_ONE]
                            [MAX_NUMBER_OF_PRODUCTS_PLUS_ONE][MAX_NUMBER_OF_PRODUCTS_PLUS_ONE][MAX_NUMBER_OF_PRODUCTS_PLUS_ONE];

            int[][] addiditionalDiscountMatr = new int[discounts + productsQuantity][MAX_NUMBER_OF_PRODUCTS];

            for (int i = 0; i < discounts; i++) {
                for (int j = 0; j < MAX_NUMBER_OF_PRODUCTS; j++) {
                    int code = discountsArr[i][1 + 2 * j];
                    if (code != 0) {
                        if (code == FIRST_PRODUCT_CODE) {
                            addiditionalDiscountMatr[productsQuantity + i][FIRST_PRODUCT_INDEX] = discountsArr[i][2 + 2 * j];
                        }
                        if (code == SECOND_PRODUCT_CODE) {
                            addiditionalDiscountMatr[productsQuantity + i][SECOND_PRODUCT_INDEX] = discountsArr[i][2 + 2 * j];
                        }
                        if (code == THIRD_PRODUCT_CODE) {
                            addiditionalDiscountMatr[productsQuantity + i][THIRD_PRODUCT_INDEX] = discountsArr[i][2 + 2 * j];
                        }
                        if (code == FOURTHS_PRODUCT_CODE) {
                            addiditionalDiscountMatr[productsQuantity + i][FOURTHS_PRODUCT_INDEX] = discountsArr[i][2 + 2 * j];
                        }
                        if (code == FIVES_PRODUCT_CODE) {
                            addiditionalDiscountMatr[productsQuantity + i][FIVES_PRODUCT_INDEX] = discountsArr[i][2 + 2 * j];
                        }
                    }
                }
            }

            for (int i = 0; i < productsQuantity; i++) {
                addiditionalDiscountMatr[i][i] = 1;
            }


            for (int i = 0; i < MAX_NUMBER_OF_PRODUCTS_PLUS_ONE; i++) {
                for (int j = 0; j < MAX_NUMBER_OF_PRODUCTS_PLUS_ONE; j++) {
                    for (int k = 0; k < MAX_NUMBER_OF_PRODUCTS_PLUS_ONE; k++) {
                        for (int l = 0; l < MAX_NUMBER_OF_PRODUCTS_PLUS_ONE; l++) {
                            for (int m = 0; m < MAX_NUMBER_OF_PRODUCTS_PLUS_ONE; m++) {
                                prices[i][j][k][l][m] = 99999999;
                            }
                        }
                    }
                }
            }
            int[] productsAndDiscountsPrices = new int[productsQuantity + discounts];
            for (int i = 0; i < productsQuantity; i++) {
                productsAndDiscountsPrices[i] = productArr[i][2];
            }
            for (int i = 0; i < discounts; i++) {
                productsAndDiscountsPrices[i + productsQuantity] = discountsCost[i];
            }
            for (int i = 0; i < discounts + productsQuantity; i++) {
                prices[addiditionalDiscountMatr[i][FIRST_PRODUCT_INDEX]]
                        [addiditionalDiscountMatr[i][SECOND_PRODUCT_INDEX]]
                        [addiditionalDiscountMatr[i][THIRD_PRODUCT_INDEX]]
                        [addiditionalDiscountMatr[i][FOURTHS_PRODUCT_INDEX]]
                        [addiditionalDiscountMatr[i][FIVES_PRODUCT_INDEX]] =
                        productsAndDiscountsPrices[i];
                // add price of each product to pricesArr
            }
            prices[0][0][0][0][0] = 0;

            for (int index = 0; index < productsQuantity + discounts; index++) {
                // external cycle
                System.out.println("external cycle, iteration: " + index);
                for (int i = 0; i <= productArr[FIRST_PRODUCT_INDEX][1]; i++) {
                    for (int j = 0; j <= productArr[SECOND_PRODUCT_INDEX][1]; j++) {
                        for (int k = 0; k <= productArr[THIRD_PRODUCT_INDEX][1]; k++) {
                            for (int l = 0; l <= productArr[FOURTHS_PRODUCT_INDEX][1]; l++) {
                                for (int m = 0; m <= productArr[FIVES_PRODUCT_INDEX][1]; m++) {
                                    if (prices[i][j][k][l][m] != 99999999) {
                                        if (i + addiditionalDiscountMatr[index][FIRST_PRODUCT_INDEX] <
                                                MAX_NUMBER_OF_PRODUCTS_PLUS_ONE) {
                                            if (j + addiditionalDiscountMatr[index][SECOND_PRODUCT_INDEX] <
                                                    MAX_NUMBER_OF_PRODUCTS_PLUS_ONE) {
                                                if (k + addiditionalDiscountMatr[index][THIRD_PRODUCT_INDEX] <
                                                        MAX_NUMBER_OF_PRODUCTS_PLUS_ONE) {
                                                    if (l + addiditionalDiscountMatr[index][FOURTHS_PRODUCT_INDEX] <
                                                            MAX_NUMBER_OF_PRODUCTS_PLUS_ONE) {
                                                        if (m + addiditionalDiscountMatr[index][FIVES_PRODUCT_INDEX] <
                                                                MAX_NUMBER_OF_PRODUCTS_PLUS_ONE) {
                                                            try {
                                                                prices[i + addiditionalDiscountMatr[index][FIRST_PRODUCT_INDEX]]
                                                                        [j + addiditionalDiscountMatr[index][SECOND_PRODUCT_INDEX]]
                                                                        [k + addiditionalDiscountMatr[index][THIRD_PRODUCT_INDEX]]
                                                                        [l + addiditionalDiscountMatr[index][FOURTHS_PRODUCT_INDEX]]
                                                                        [m + addiditionalDiscountMatr[index][FIVES_PRODUCT_INDEX]] =
                                                                        Integer.min(prices[i][j][k][l][m] + productsAndDiscountsPrices[index],
                                                                                prices[i + addiditionalDiscountMatr[index][FIRST_PRODUCT_INDEX]]
                                                                                        [j + addiditionalDiscountMatr[index][SECOND_PRODUCT_INDEX]]
                                                                                        [k + addiditionalDiscountMatr[index][THIRD_PRODUCT_INDEX]]
                                                                                        [l + addiditionalDiscountMatr[index][FOURTHS_PRODUCT_INDEX]]
                                                                                        [m + addiditionalDiscountMatr[index][FIVES_PRODUCT_INDEX]]);
                                                            } catch (ArrayIndexOutOfBoundsException e) {
                                                                System.out.println(e.getMessage());
                                                                System.out.println(index + " " + i + " " + j + " " + k + " " + l + " " + m);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i <= productArr[FIRST_PRODUCT_INDEX][1]; i++) {
                for (int j = 0; j <= productArr[SECOND_PRODUCT_INDEX][1]; j++) {
                    for (int k = 0; k <= productArr[THIRD_PRODUCT_INDEX][1]; k++) {
                        for (int l = 0; l <= productArr[FOURTHS_PRODUCT_INDEX][1]; l++) {
                            for (int m = 0; m <= productArr[FIVES_PRODUCT_INDEX][1]; m++) {
                                System.out.println(prices[i][j][k][l][m] + " ");
                            }
                        }
                    }
                }
            }
            printWriter.print(
                    prices[productArr[FIRST_PRODUCT_INDEX][1]]
                            [productArr[SECOND_PRODUCT_INDEX][1]][productArr[THIRD_PRODUCT_INDEX][1]]
                            [productArr[FOURTHS_PRODUCT_INDEX][1]][productArr[FIVES_PRODUCT_INDEX][1]]
            );

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}