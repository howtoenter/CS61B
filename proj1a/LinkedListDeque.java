public class LinkedListDeque<T> {
    public class Node<T> {
        Node first;
        Node next;
        T value;
        public Node(T a) {
            value = a;
            first = null;
            next = null;
        }
    }
    Node front;
    Node end;
    int size;

    public LinkedListDeque() {
        front = new Node(0);
        end = new Node(0);

        front.next = end;
        end.first = front;
        size = 0;

    }

    public void addFirst(T argument) {
        Node p = new Node(argument);
        Node temp = front.next;
        p.next = temp;
        p.first = front;
        temp.first = p;
        front.next = p;
        size++;
    }

    public void addLast(T argument) {
        Node p = new Node(argument);
        Node temp = end.first;
        p.next = end;
        p.first = temp;
        end.first = p;
        temp.next = p;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        } else {
            Node p = front;
            for (int i = 0; i < size; i++) {
                System.out.print(p.value + " ");
                p = p.next;
            }
        }

    }

    public T removeFirst() {
        if(size == 0 || front == null) {
            return null;
        } else {
            T p = (T) front.next.value;
            Node temp = front.next.next;
            front.next = temp;
            temp.first= front;
            size--;
            return p;
        }
    }

    public T removeLast() {
        if (size == 0 || end == null) {
            return null;
        } else {
            T p = (T) end.first.value;
            Node temp = end.first.first;
            end.first = temp;
            temp.next = end;
            size--;
            return p;
        }
    }

    public T get(int index) {
        if(size == 0) {
            return null;
        } else if (index < 0 || index >= size) {
            return null;
        } else {
            Node p  = front.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return (T) p.value;
        }
    }

    private T getRecursive1(int index, Node p) {
        if (index == 0) {
            return (T) p.value;
        } else {
            return (T) getRecursive1(index - 1, p.next);
        }

    }

    public T getRecursive(int index) {
        if (size == 0) {
            return null;
        } else if (index < 0 || index >= size) {
            return null;
        }
        return getRecursive1(index, front);
    }

}
