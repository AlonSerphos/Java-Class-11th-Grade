package BinTreeTasks;
//Alon Serphos
public class BinNode<T> {
    private BinNode<T> left;
    private BinNode<T> right;
    private T value;

    public BinNode(T x) {
        this.value = x;
        this.left = null;
        this.right = null;
    }

    public BinNode(BinNode<T> left, T x, BinNode<T> right) {
        this.left = left;
        this.value = x;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public BinNode<T> getLeft() {
        return left;
    }

    public BinNode<T> getRight() {
        return right;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public void setValue(T x) {
        this.value = x;
    }

    public void setLeft(BinNode<T> left) {
        this.left = left;
    }

    public void setRight(BinNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
