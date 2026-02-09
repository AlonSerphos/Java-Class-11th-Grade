package SortingAndDataStructures;

import UsefulFiles.Node;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Node<Integer> head = new Node<Integer>(9, new Node<Integer>(9, new Node<Integer>(32, new Node<Integer>(37, new Node<Integer>(2, new Node<Integer>(-6, new Node<Integer>(1089, new Node<Integer>(9, new Node<Integer>(-1, new Node<Integer>(5))))))))));
        System.out.println(merge(head).toStringList());
    }


    public static Node<Integer> merge(Node<Integer> head) {
        if (head.getLength() == 1) {
            return head;
        }
        Node<Integer> list1pos = head;
        for (int i = 0 ; i < head.getLength()%2 - 1 ; i++) {
            list1pos = list1pos.getNext();
        }
        Node<Integer> list1 = head;
        Node<Integer> list2 = list1pos.getNext();
        list1pos.setNext(null);
        list1 = merge(list1);
        list2 = merge(list2);
        Node<Integer> out = new Node<Integer>(null);
        Node<Integer> outpos = out;
        while (list2 != null && list1 != null) {
            if (list1.getValue() > list2.getValue()) {
                outpos.setNext(new Node<Integer>(list2.getValue()));
                list2 = list2.getNext();
                outpos = outpos.getNext();
            } else {
                outpos.setNext(new Node<Integer>(list1.getValue()));
                list1 = list1.getNext();
                outpos = outpos.getNext();
            }
        }
        if (list1 != null) {
            outpos.setNext(list1);
        } else {
            outpos.setNext(list2);
        }
        return out.getNext();
    }

}