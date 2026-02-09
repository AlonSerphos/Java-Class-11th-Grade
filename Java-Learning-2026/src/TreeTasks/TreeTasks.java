import javax.swing.*;

public class TreeTasks {
    public static void main(String[] args) {
        BinNode<Integer> root = new BinNode<>(10);

        BinNode<Integer> n5 = new BinNode<>(5);
        BinNode<Integer> n15 = new BinNode<>(15);
        BinNode<Integer> n2 = new BinNode<>(2);
        BinNode<Integer> n7 = new BinNode<>(7);
        BinNode<Integer> n20 = new BinNode<>(20);

        root.setLeft(n5);
        root.setRight(n15);

        n5.setLeft(n2);
        n5.setRight(n7);

        n15.setRight(n20);

        TreeTasks t = new TreeTasks();

        System.out.println("Is root leaf: " + t.isLeaf(root));
        System.out.println("Count nodes: " + t.countNodes(root));
        System.out.println("Sum nodes: " + t.sumNodes(root));
        System.out.println("Single sons: " + t.singleSons(root));
        System.out.println("Count left children: " + t.countLeft(root));
        System.out.println("Tree height: " + t.treeHeight(root));

        System.out.println("Exists 7: " + t.exists(root, 7));
        System.out.println("Exists 99: " + t.exists(root, 99));

        System.out.println("Parent greater than children: " + t.greaterPerent(root));

        System.out.print("In-order print: ");
        t.inOrderString(root);
        System.out.println();

        System.out.println("Values less than 10:");
        t.printLess(root, 10);
    }

    public boolean isLeaf(BinNode<Integer> head) {
        return head.isLeaf();
    }

    public int countNodes(BinNode<Integer> head) {
        return countNodesLoop(head);
    }

    private int countNodesLoop(BinNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        if (head.isLeaf()) {
            return 1;
        }
        return 1 + countNodesLoop(head.getLeft()) + countNodesLoop(head.getRight());
    }

    public int sumNodes(BinNode<Integer> head) {
        return sumNodesLoop(head);
    }

    private int sumNodesLoop(BinNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        if (head.isLeaf()) {
            return head.getValue();
        }
        return sumNodesLoop(head.getLeft()) + sumNodesLoop(head.getRight()) + head.getValue();
    }

    public int singleSons(BinNode<Integer> head) {
        return singleSonsLoop(head);
    }

    private int singleSonsLoop(BinNode<Integer> head) {
        if (!head.hasLeft() && head.hasRight()) {
            return 1 + singleSonsLoop(head.getRight());
        }
        if (head.hasLeft() && !head.hasRight()) {
            return 1 + singleSonsLoop(head.getLeft());
        }
        if (head.isLeaf()) {
            return 0;
        }
        return singleSonsLoop(head.getLeft()) + singleSonsLoop(head.getRight());
    }

    public int countLeft(BinNode<Integer> head) {
        return countLeftLoop(head);
    }

    private int countLeftLoop(BinNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        if (head.hasLeft()) {
            return 1 + countLeft(head.getLeft()) + countLeft(head.getRight());
        }
        return countLeft(head.getRight());
    }

    public int treeHeight(BinNode<Integer> head) {
        return treeHeightLoop(head);
    }

    private int treeHeightLoop(BinNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        if (head.isLeaf()) {
            return 1;
        }
        return 1 + Math.max(treeHeightLoop(head.getRight()), treeHeightLoop(head.getLeft()));
    }

    public boolean exists(BinNode<Integer> head, int num) {
        return existsLoop(head, num);
    }

    private boolean existsLoop(BinNode<Integer> head, int num) {
        if (head == null) {
            return false;
        }
        if (head.getValue() == num) {
            return true;
        }
        return existsLoop(head.getLeft(), num) || existsLoop(head.getRight(), num);
    }

    public boolean greaterPerent(BinNode<Integer> head) {
        return greaterPerentLoop(head);
    }

    private boolean greaterPerentLoop(BinNode<Integer> head) {
        if (head == null) {
            return true;
        }
        boolean out = true;
        if (head.hasLeft()) {
            if (head.getValue() < head.getLeft().getValue()) {
                out = false;
            }
            out = out && greaterPerentLoop(head.getLeft());
        }

        if (head.hasRight()) {
            if (head.getValue() < head.getRight().getValue()) {
                out = false;
            }
            out = out && greaterPerentLoop(head.getRight());
        }
        return out;
    }

    public void inOrderString(BinNode<Integer> head) {
        String out = inOrderStringLoop(head);
        System.out.print(out.substring(0, out.length()-2));
    }

    private String inOrderStringLoop(BinNode<Integer> head) {
        if (head == null) {
            return "";
        }
        return inOrderStringLoop(head.getLeft()) + head.getValue() + ", " + inOrderStringLoop(head.getRight());
    }

    public void printLess(BinNode<Integer> head, int max) {
        printLessLoop(head, max);
    }

    private void printLessLoop(BinNode<Integer> head, int max) {
        if (head == null) {
            return;
        }
        if (head.getValue() < max) {
            System.out.println(head.getValue());;
        }
        printLessLoop(head.getLeft(), max);
        printLessLoop(head.getRight(), max);
    }
}