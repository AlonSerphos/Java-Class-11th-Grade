package BinTreeTasks;
//Alon Serphos
public class BinaryTree<T> {
    protected BinNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T x) {
        this.root = new BinNode<T>(x);
    }

    public BinaryTree(T[] list) {
        if (list == null || list.length == 0) {
            this.root = null;
        } else {
            this.root = buildTree(list, 0);
        }
    }

    private BinNode<T> buildTree(T[] list, int index) {
        if (index >= list.length || list[index] == null) {
            return null;
        }
        BinNode<T> left = buildTree(list, 2 * index + 1);
        BinNode<T> right = buildTree(list, 2 * index + 2);
        return new BinNode<T>(left, list[index], right);
    }

    public T root() {
        if (this.root == null) return null;
        return this.root.getValue();
    }

    public int getHeight() {
        return calcHeight(this.root);
    }

    private int calcHeight(BinNode<T> node) {
        if (node == null) return -1;
        int left = calcHeight(node.getLeft());
        int right = calcHeight(node.getRight());
        if (left > right) {
            return left + 1;
        }
        return right + 1;
    }

    public int getSize() {
        return calcSize(this.root);
    }

    private int calcSize(BinNode<T> node) {
        if (node == null) return 0;
        return 1 + calcSize(node.getLeft()) + calcSize(node.getRight());
    }

    public String inOrderString() {
        StringBuilder out = new StringBuilder();
        inOrder(this.root, out);
        if (out.length() > 1) {
            out.setLength(out.length() - 2);
        }
        return out.toString();
    }

    private void inOrder(BinNode<T> node, StringBuilder out) {
        if (node == null) return;
        inOrder(node.getLeft(), out);
        out.append(node.getValue()).append(", ");
        inOrder(node.getRight(), out);
    }

    public String postOrderString() {
        StringBuilder out = new StringBuilder();
        postOrder(this.root, out);
        if (out.length() > 1) {
            out.setLength(out.length() - 2);
        }
        return out.toString();
    }

    private void postOrder(BinNode<T> node, StringBuilder out) {
        if (node == null) return;
        postOrder(node.getLeft(), out);
        postOrder(node.getRight(), out);
        out.append(node.getValue()).append(", ");
    }

    public String preOrderString() {
        StringBuilder out = new StringBuilder();
        preOrder(this.root, out);
        if (out.length() > 1) {
            out.setLength(out.length() - 2);
        }
        return out.toString();
    }

    private void preOrder(BinNode<T> node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.getValue()).append(", ");
        preOrder(node.getLeft(), sb);
        preOrder(node.getRight(), sb);
    }
}