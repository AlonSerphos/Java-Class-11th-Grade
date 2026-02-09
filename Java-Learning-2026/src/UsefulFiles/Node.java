public class Node<T>{
    private Node<T> next;
    private T x;

    public Node(T x) {
        this.x = x;
        this.next = null;
    }

    public Node(T x, Node<T> next) {
        this.x = x;
        this.next = next;
    }

    public T getValue() {
        return x;
    }

    public Node<T> getNext (){
        return next;
    }

    public void setValue(T x) {
        this.x = x;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return !(this.next == null);
    }

    public boolean isEmpty() {
        if (this.x == null) {
            return false;
        }
        return true;
    }

    public Node<T> copyOf() {
        return new Node<T>(this.x, this.next);
    }

    public int getLength() {
        Node<T> temp = this.copyOf();
        int count = 1;
        while (temp.hasNext()) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public int length() {
        Node<T> temp = this.copyOf();
        int out = 1;
        while (temp.hasNext()) {
            temp = temp.getNext();
            out++;
        }
        return out;
    }

    @Override
    public String toString() {
        return x.toString();
    }

    public String toStringList() {
        Node<T> pos = this.copyOf();
        String out = "[";
        while (pos.hasNext()) {
            out += pos.getValue() + ", ";
            pos = pos.getNext();
        }
        return out + pos.getValue() + "]";
    }
}