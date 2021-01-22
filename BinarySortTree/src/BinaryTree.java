public class BinaryTree<Type extends Comparable<? super Type>>
{
    private class Node
    {
        Type elem;
        Node leftElem;
        Node rightElem;

        Node(Type val)
        {
            this.elem = val;
            this.leftElem = this.rightElem = null;
        }
    }

    private Node root;

    public boolean find(Type value) {
        return findHelper(this.root, value);
    }

    private boolean findHelper(Node curElem, Type key) {
        if (curElem == null) return false;
        if (key.compareTo(curElem.elem) < 0) findHelper(curElem.leftElem, key);
        if (key.compareTo(curElem.elem) > 0) findHelper(curElem.rightElem, key);
        return true;
    }

    public void add(Type key){
        root = insert(root, key);
    }

    private Node insert(Node curElem, Type key) {
        if (curElem == null) return new Node(key);
        if (key.compareTo(curElem.elem) < 0) curElem.leftElem = insert(curElem.leftElem, key);
        if (key.compareTo(curElem.elem) > 0) curElem.rightElem = insert(curElem.rightElem, key);
        return curElem;
    }
    public void bypassLeftRootRight()
    {
        bypassLeftRootRightHelper(root);
    }

    private void bypassLeftRootRightHelper(Node localRoot)
    {
        if (localRoot != null){
            bypassLeftRootRightHelper(localRoot.leftElem);
            System.out.print(localRoot.elem + " ");
            bypassLeftRootRightHelper(localRoot.rightElem);
        }
    }

    public void bypassLeftRightRoot()
    {
        bypassLeftRightRootHelper(root);
    }

    private void bypassLeftRightRootHelper(Node localRoot)
    {
        if (localRoot != null){
            bypassLeftRightRootHelper(localRoot.leftElem);
            bypassLeftRightRootHelper(localRoot.rightElem);
            System.out.print(localRoot.elem + " ");
        }
    }
    public void bypassRootLeftRight()
    {
        bypassRootLeftRightHelper(root);
    }

    private void bypassRootLeftRightHelper(Node localRoot)
    {
        if (localRoot != null){
            System.out.print(localRoot.elem + " ");
            bypassRootLeftRightHelper(localRoot.leftElem);
            bypassRootLeftRightHelper(localRoot.rightElem);
        }
    }

}
