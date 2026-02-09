package SortingAndDataStructures;

import UsefulFiles.Node;

public class SortingAndDataStructures {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------");
        int[] arr = {7, 42, 19, 88, 3, 56, 71, 24, 90, 11, 65, 2, 38, 77, 14, 59, 83, 6, 31, 95};
        expensiveSwap(arr);
        sortTasks(
                new Node<Task>(new Task(3, 7),
                        new Node<Task>(new Task(5, 2),
                                new Node<Task>(new Task(3, 9),
                                        new Node<Task>(new Task(1, 4),
                                                new Node<Task>(new Task(7, 10),
                                                        new Node<Task>(new Task(2, 1),
                                                                new Node<Task>(new Task(9, 6),
                                                                        new Node<Task>(new Task(4, 8),
                                                                                new Node<Task>(new Task(6, 3),
                                                                                        new Node<Task>(new Task(8, 5)
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
        int[] arr2 = smallestKSorted(arr, 6);
        System.out.print("[" + arr2[0]);
        for (int n = 1 ; n+1 <= 6 ; n++) {
            System.out.print(", " + arr2[n]);
        }
        System.out.println("]");
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int value1 = arr[pos1];
        int value2 = arr[pos2];
        arr[pos1] = value2;
        arr[pos2] = value1;
    }

    public static void swapNode(Node<Task> pos1, Node<Task> pos2) {
        Task pos1Task = pos1.getValue();
        pos1.setValue(pos2.getValue());
        pos2.setValue(pos1Task);
    }

    public static void expensiveSwap(int[] arr) {
        int comparison = 0;
        int swaps = 0;
        int length = arr.length;
        for (int i = 0 ; i <= length ; i++) {
            int posMax = i;
            for (int j = i+1 ; j+1 <= length ; j++) {
                comparison++;
                if (arr[posMax] < arr[j]) {
                    posMax = j;
                }
            }
            if (posMax != i) {
                swap(arr, posMax, i);
                swaps++;
            }
        }
        System.out.println("swaps - " + swaps);
        System.out.println("comparisons - " + comparison);
        System.out.print("[" + arr[0]);
        for (int n = 1 ; n+1 <= length ; n++) {
            System.out.print(", " + arr[n]);
        }
        System.out.println("]");
    }

    public static Node<Task> sortTasks(Node<Task> head) {
        Node<Task> temp = head;
            while (temp.hasNext()) {
                Node<Task> max = temp;
                Node<Task> temp2 = temp.getNext();
                while (temp2.hasNext()) {
                    if ((max.getValue().getPriority() == temp2.getValue().getPriority() && max.getValue().getTimestamp() < temp2.getValue().getTimestamp()) || max.getValue().getPriority() < temp2.getValue().getPriority()) {
                        max = temp2;
                    }
                    temp2 = temp2.getNext();
                }
                if ((max.getValue().getPriority() == temp2.getValue().getPriority() && max.getValue().getTimestamp() < temp2.getValue().getTimestamp()) || max.getValue().getPriority() < temp2.getValue().getPriority()) {
                    max = temp2;
                }
                swapNode(max, temp);
                temp = temp.getNext();
            }
        System.out.println(head.toStringList());
        return head;
    }

    public static boolean find(int[] arr, int num) {
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static int[] smallestKSorted(int[] arr, int k) {
        int[] output = new int[k];
        int length = arr.length;
        for (int i = 0 ; i < k ; i++) {
            int posMin = i;
            for (int j = i+1 ; j+1 <= length ; j++) {
                if (arr[posMin] > arr[j] && !find(output, arr[j])) {
                    posMin = j;
                }
            }
            if (posMin != i) {
                output[i] = arr[posMin];
            }
        }
        return output;
    }
}
