import java.util.Arrays;
import java.util.Objects;

public class MyQueue<T> {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyQueue() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object value) {
        if (elements.length == size) {
            Object[] bufferArray = new Object[elements.length + 10];
            System.arraycopy(elements, 0, bufferArray, 0, elements.length);
            elements = bufferArray;
        }
        elements[size] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, elements.length - index - 1);
        size--;
        return removedElement;
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        Objects.checkIndex(0, size);
        return (T) elements[0];
    }

    public T poll() {
        Objects.checkIndex(0, size);
        T polledElement = peek();
        remove(0);
        return polledElement;
    }

    public static void main(String[] args) {
        MyQueue<String> test = new MyQueue<>();
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
        System.out.println(Arrays.toString(test.elements));
        System.out.println(test.remove(3));
        System.out.println(Arrays.toString(test.elements));
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.poll());
        System.out.println(test.poll());
        System.out.println(Arrays.toString(test.elements));

        test.clear();
        System.out.println(Arrays.toString(test.elements));
    }
}

/*

add(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в очереди (FIFO)
poll() возвращает первый элемент в очереди и удаляет его из коллекции

 */