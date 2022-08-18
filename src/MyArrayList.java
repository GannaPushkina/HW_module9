import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {

    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public MyArrayList() {
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
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<>();
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
        System.out.println(test.get(12));
        System.out.println(test.elements.length);
        System.out.println(Arrays.toString(test.elements));
        System.out.println(test.remove(3));
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
get(int index) возвращает элемент под индексом

 */