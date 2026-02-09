package UsefulFiles;

public class BinNode<T> {
    BinNode<T> left;
    BinNode<T> right;
    T value;

    public BinNode(T x) {
        this.value = x;
        this.left = null;
        this.right = null;
    }

    public BinNode(T x, BinNode left, BinNode right) {
        this.value = x;
        this.left = left;
        this.right = right;
    }

    public BinNode<T> getLeft() {
        return left;
    }

    public BinNode<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public void setLeft(BinNode<T> left) {
        this.left = left;
    }

    public void setRight(BinNode<T> right) {
        this.right = right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public boolean isLeaf() {
        return !(hasLeft() || hasRight());
    }

    @Override
    public String toString() {
        return "value: " + value + " left: [" + left + "] right: [" + right + "]";
    }
}