package lab6;

import java.util.*;

/**
 * Типізована колекція на основі класу Coffee, яка реалізує інтерфейс Set.
 */
public class CustomCollection implements Set<Coffee> {

    /**
     * Внутрішній клас, що описує вузол двозв’язного списку.
     */
    private static class Node {
        Coffee value;
        Node next;
        Node prev;

        Node(Coffee value) {
            this.value = value;
        }
    }

    private Node head; // Початок списку
    private Node tail; // Кінець списку
    private int size;  // Розмір колекції

    /**
     * Порожній конструктор.
     */
    public CustomCollection() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Конструктор, що приймає один об’єкт Coffee.
     *
     * @param coffee об’єкт Coffee для додавання
     */
    public CustomCollection(Coffee coffee) {
        this();
        add(coffee);
    }

    /**
     * Конструктор, що приймає колекцію об’єктів Coffee.
     *
     * @param coffees колекція об’єктів Coffee
     */
    public CustomCollection(Collection<Coffee> coffees) {
        this();
        for (Coffee coffee : coffees) {
            add(coffee);
        }
    }

    @Override
    public boolean add(Coffee coffee) {
        if (coffee == null || contains(coffee)) return false;

        Node newNode = new Node(coffee);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.value, o)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (Objects.equals(current.value, o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Coffee next() {
                if (!hasNext()) throw new NoSuchElementException();
                Coffee value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public <U> U[] toArray(U[] a) {
        if (a.length < size) {
            a = (U[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        Node current = head;
        int index = 0;
        while (current != null) {
            a[index++] = (U) current.value;
            current = current.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Coffee> c) {
        boolean modified = false;
        for (Coffee coffee : c) {
            if (add(coffee)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            if (!c.contains(current.value)) {
                Node toRemove = current;
                current = current.next;
                remove(toRemove.value);
                modified = true;
            } else {
                current = current.next;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object coffee : c) {
            if (remove(coffee)) {
                modified = true;
            }
        }
        return modified;
    }
}
