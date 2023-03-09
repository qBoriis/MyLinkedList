package angerbauer.mylist;

/**
 * @author Boris Angerbauer
 */

public class MyList<E> {
    private Node<E> start;
    private Node<E> last;
    private int size = 0;

    public MyList() {
    }

    public Node search(int index) {
        Node<E> s = start;
        for (int i = 0; i < index; i++) {
            s = s.next;
        }
        return s;
    }

    public boolean add(E s) {
        if (size == 0) {
            Node<E> n = new Node(s, null, null);
            start = n;
            last = n;
        } else {
            Node<E> node = new Node(s, null, last);
            node.prev.next = node;
            last = node;
        }
        size++;
        return true;
    }

    public void add(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();

        } else if (index == 0) {
            Node<E> node = new Node<>(e, null, null);
            if (size == 0) {
                last = node;
            } else {
                node.next = start;
            }
            start = node;
        } else if (index == size && size == 1) {
            Node<E> add = new Node<>(e, start, null);
            Node<E> node = start;
            node.next = add;
            last = add;
        } else if (index == size) {
            Node<E> node = new Node<>(e, last, null);
            last.next = node;
            last = node;
        } else {
            Node<E> node = start;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node<E> add = new Node<>(e, node, node.next);
            node.next = add;
            node.next.prev = add;
        }
        size++;
    }

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) search(index).data;
    }

    public boolean remove(E s) {
        if (s == null) {
            return false;
        }

        Node<E> node = start;

        if (s.equals(start.data)) {
            if (size == 1) {
                start = null;
                last = null;
                size = 0;
                return true;
            }

            start = node.next;
            node.next.prev = start;
            size--;
            return true;
        }

        if (s.equals(last.data)) {
            last = node.prev;
            node.prev.next = last;
            size--;
            return true;
        }

        for (int i = 0; i < size; i++) {
            if (s.equals(node.data)) {
                node.prev.next = node.next;
                node.prev = node.next;
                size--;
                return true;
            }
            node = node.next;
        }


        return false;
    }

    public E remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0 && size == 1){
            Node<E> node = start;
            start = null;
            last = null;
            size--;
            return node.data;
        }

        if(index == 0){
            Node<E> node = start;
            node.next.prev = null;
            start = node.next;
            node.next = null;
            size--;
            return node.data;
        }

        if(index == size-1){
            Node<E> node = last;
            last = node.prev;
            node.prev.next = null;
            node.prev = null;
            size--;
            return node.data;
        }

        Node<E> n = search(index);
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
        size--;
        return n.data;
    }

    public E set(int index, E s) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E previously = (E) search(index).data;
        search(index).data = s;
        return previously;
    }

    public boolean contains(E s) {
        return indexOf(s) >= 0;
    }

    public int indexOf(E s) {
        Node<E> n = start;

        if (s == null) {
            for (int i = 0; i < size; i++) {
                if (n.data == null) {
                    return i;
                }
                n = n.next;
            }
        }

        Node<E> n2 = start;
        for (int i = 0; i < size; i++) {
            if (n2.data.equals(s)) {
                return i;
            }
            n2 = n2.next;
        }

        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }


    private static class Node<E> {
        E data;
        Node next;
        Node prev;

        public Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
