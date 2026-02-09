package BinTreeTasks;
//Alon Serphos
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(T x) {
        super(x);
    }

    public BinarySearchTree(T[] list) {
        super();
        if (list != null) {
            for (T item : list) {
                insert(item);
            }
        }
    }

    public T root() {
        if (this.root == null) {
            return null;
        }
        return this.root.getValue();
    }

    public void insert(T val) {
        if (this.root == null) {
            this.root = new BinNode<>(val);
        } else {
            insertRec(this.root, val);
        }
    }

    private void insertRec(BinNode<T> current, T val) {
        if (val.compareTo(current.getValue()) < 0) {
            if (!current.hasLeft()) {
                current.setLeft(new BinNode<>(val));
            } else {
                insertRec(current.getLeft(), val);
            }
        } else {
            if (!current.hasRight()) {
                current.setRight(new BinNode<>(val));
            } else {
                insertRec(current.getRight(), val);
            }
        }
    }

    public boolean inTree(T val) {
        return searchRec(this.root, val);
    }

    private boolean searchRec(BinNode<T> current, T val) {
        if (current == null) {
            return false;
        }
        int comparison = val.compareTo(current.getValue());
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return searchRec(current.getLeft(), val);
        } else {
            return searchRec(current.getRight(), val);
        }
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
        inOrderRec(this.root, out);
        if (out.length() > 0) {
            out.setLength(out.length() - 2);
        }
        return out.toString();
    }

    private void inOrderRec(BinNode<T> node, StringBuilder out) {
        if (node == null) return;
        inOrderRec(node.getLeft(), out);
        out.append(node.getValue()).append(", ");
        inOrderRec(node.getRight(), out);
    }

    public String postOrderString() {
        StringBuilder out = new StringBuilder();
        postOrderRec(this.root, out);
        if (out.length() > 0) {
            out.setLength(out.length() - 2);
        }
        return out.toString();
    }

    private void postOrderRec(BinNode<T> node, StringBuilder out) {
        if (node == null) return;
        postOrderRec(node.getLeft(), out);
        postOrderRec(node.getRight(), out);
        out.append(node.getValue()).append(", ");
    }

    public String preOrderString() {
        StringBuilder out = new StringBuilder();
        preOrderRec(this.root, out);
        if (out.length() > 0) {
            out.setLength(out.length() - 2);
        }
        return out.toString();
    }

    private void preOrderRec(BinNode<T> node, StringBuilder out) {
        if (node == null) return;
        out.append(node.getValue()).append(", ");
        preOrderRec(node.getLeft(), out);
        preOrderRec(node.getRight(), out);
    }

    @Override
    public String toString() {
        if (this.root == null) return "";
        StringBuilder out = new StringBuilder();
        int height = getHeight();
        for (int i = 0; i <= height; i++) {
            printLevel(this.root, i, out);
        }
        if (out.length() > 0) {
            out.setLength(out.length() - 2);
        }
        return out.toString();
    }

    private void printLevel(BinNode<T> node, int level, StringBuilder out) {
        if (node == null) return;
        if (level == 0) {
            out.append(node.getValue()).append(", ");
        } else {
            printLevel(node.getLeft(), level - 1, out);
            printLevel(node.getRight(), level - 1, out);
        }
    }
}
