public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        int[] arr = {8, 10, 12, 15,18 };
        for (int x : arr)
        {
            tree.add(x);
        }
        System.out.println("Is find = " + tree.find(8));
        System.out.println("Обход Левый - Корень - Правый ");
        tree.bypassLeftRootRight();
        System.out.println("\nОбход Левый - Правый - Корень ");
        tree.bypassLeftRightRoot();
        System.out.println("\nОбход Корень - Левый - Правый ");
        tree.bypassRootLeftRight();
    }
}
