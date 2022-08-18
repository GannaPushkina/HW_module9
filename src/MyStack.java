import java.util.Arrays;
import java.util.Objects;

public class MyStack<T> {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(Object value) {
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
        return (T) elements[size - 1];
    }

    public T pop() {
        T poppedElement = peek();
        remove(size - 1);
        return poppedElement;
    }

    public static void main(String[] args) {
        MyStack<String> test = new MyStack<>();
        test.push("Zero");
        test.push("One");
        test.push("Two");
        test.push("Three");
        test.push("Four");
        test.push("Five");
        test.push("Six");
        test.push("Seven");
        test.push("Eight");
        test.push("Nine");
        test.push("Ten");
        test.push("Eleven");
        test.push("Twelve");
        test.push("Thirteen");
        test.push("Fourteen");


        System.out.println(test.size);
        System.out.println(Arrays.toString(test.elements));
        System.out.println(test.remove(3));
        System.out.println(Arrays.toString(test.elements));
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(Arrays.toString(test.elements));

        test.clear();
        System.out.println(Arrays.toString(test.elements));
    }
}

/*

push(Object value) добавляет элемент в конец
remove(int index) удаляет элемент под индексом
clear() очищает коллекцию
size() возвращает размер коллекции
peek() возвращает первый элемент в стеке (LIFO)
pop() возвращает первый элемент в стеке и удаляет его из коллекции

 */