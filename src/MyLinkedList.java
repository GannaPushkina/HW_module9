import java.util.Objects;

public class MyLinkedList<T> {

    static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = first.element;
            first = first.next;
            first.next.prev = null;

            if (first == null) {
                last = null;
            }

        } else {
            Node<T> previous = getNodeByIndex(index - 1);
            removedElement = previous.element;
            previous.next = previous.next.next;
            previous.next.next.prev = previous;
            if (index == size - 1) {
                last = previous;
            }
        }
        size--;
        return removedElement;
    }

    public static void main(String[] args) {
        MyLinkedList<String> test = new MyLinkedList<>();

        System.out.println(test.size);

        test.add("Zero");
        test.add("One");
        test.add("Two");
        test.add("Three");
        test.add("Four");
        test.add("Five");
        test.add("Six");
        test.add("Seven");
        test.add("Eight");
        test.add("Nine");
        test.add("Ten");
        test.add("Eleven");
        test.add("Twelve");
        test.add("Thirteen");
        test.add("Fourteen");

        System.out.println(test.size);

        System.out.println(test.get(5));
        test.remove(5);
        System.out.println(test.size);
        System.out.println(test.get(5));
        test.clear();
        System.out.println(test.size);
        test.add("New Zero");
        test.add("New One");
        test.add("New Two");
        test.add("New Three");
        test.add("New Four");
        test.add("New Five");
        System.out.println(test.size);
        test.remove(2);
        System.out.println(test.size);
        System.out.println(test.get(2));
        System.out.println(test.get(0));
        test.remove(0);
        System.out.println(test.get(0));
        System.out.println(test.size);
        System.out.println(test.get(3));
    }
}

/*

//add(Object value) добавляет элемент в конец
//remove(int index) удаляет элемент под индексом
//clear() очищает коллекцию
//size() возвращает размер коллекции
//get(int index) возвращает элемент под индексом

 */