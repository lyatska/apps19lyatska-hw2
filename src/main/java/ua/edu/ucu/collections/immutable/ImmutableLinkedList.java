package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private int size;

    private static class Node {
        private Object item;
        private Node next;

        private Node(Object item) {
            this.item = item;
            next = null;
        }

        private Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private void checkIndex(int index) {
        //Check if index exists. If not, throw Exception
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private ImmutableLinkedList makeNew() {
        if (size != 0) {
            ImmutableLinkedList list = new ImmutableLinkedList();
            list.size = size;
            list.head = new Node(head.item);
            Node currNode = head.next;
            Node currentAddingNode = list.head;
            while (currNode != null) {
                currentAddingNode.next = new Node(currNode.item);
                currentAddingNode = currentAddingNode.next;
                currNode = currNode.next;
            }
            return list;
        }
        return new ImmutableLinkedList();
    }

    public ImmutableLinkedList(Object[] items) {
        if (items.length == 0) {
            size = 0;
        }else{
            head = new Node(items[0]);
            Node currNode = head;
            for (int i = 1; i < items.length; i++) {
                currNode.next = new Node(items[i]);
                currNode = currNode.next;

            }
        }
        size = items.length;
    }

    public ImmutableLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(size, e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList newList = makeNew();
        if (index == 0) {
            newList.head = new Node(e, newList.head);

        } else {
            Node before = newList.getNode(index - 1);
            before.next = new Node(e, before.next);
        }
        newList.size = size + 1;
        return newList;
    }

    private Node getNode(int index) {
        checkIndex(index);

        int counter;
        Node currentNode = head;
        for (counter = 0; counter < index; counter++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        checkIndex(index);
        ImmutableLinkedList newList = makeNew();


        newList.head = new Node(null, newList.head);
        if (c.length > 0) {
            Node currentAdding = newList.getNode(index);
            for (Object o : c) {
                currentAdding.next = new Node(o, currentAdding.next);
                currentAdding = currentAdding.next;
            }
        }

        newList.head = newList.head.next;
        newList.size = size + c.length;
        return newList;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return getNode(index).item;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        ImmutableLinkedList newList = makeNew();

        if (index == 0) {
            newList.head = newList.head.next;
        } else {
            Node before = newList.getNode(index - 1);
            before.next = before.next.next;
        }
        newList.size--;
        return newList;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList newList = makeNew();
        newList.getNode(index).item = e;
        return newList;
    }

    @Override
    public int indexOf(Object e) {
        int counter = 0;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.item == e) {
                return counter;
            }
            counter++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int currPos = 0;
        Node currNode = head;
        while (currNode != null) {
            result[currPos] = currNode.item;
            currNode = currNode.next;
            currPos++;
        }
        return result;
    }



    @Override
    public String toString() {
        if (head == null) {
            return "";
        }

        StringBuilder result = new StringBuilder(head.item.toString());
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            result.append(", ").append(currentNode.item.toString());
        }
        return result.toString();
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return get(0);
    }

    public Object getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return get(size - 1);
    }

    public ImmutableLinkedList removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return remove(size - 1);
    }

}