import java.util.Arrays;

public class MyHashMap<K, V> {

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> first;
    private Node<K, V> last;
    private int size;

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (first == null) {
            first = last = newNode;
            size++;
        } else {
            if (isKeyUnique(key)) {
                last.next = newNode;
                last = newNode;
                size++;
            } else {
                System.out.println("Key is already applied, use another");
            }
        }
    }

    public void remove(K key) {
        if (!isKeyUnique(key)) { // тут чомусь не спрацьовує перевірка на унікальність ключа. Якщо прибрати цю перевірку,
            Node<K, V> current = first; // то видалення працює, але, якщо передати недійсний ключ, отримуємо Exception
            for (int i = 0; i < size; i++) {
                if (current.next.key.equals(key)) {
                    current.next = current.next.next;
                    size--;
                } else {
                    current = current.next;
                }
            }
        } else {
            System.out.println("No such key in current HashMap");
        }
    }

    public void clear() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node<K, V> current = first;
        for (int i = 0; i < size; i++) {
            if (current.key.equals(key)) {
                return current.value;
            } else {
                current = current.next;
            }
        }
        return null; // ????
    }

    @SuppressWarnings("unchecked")
    private K[] getAllKeys() {
        K[] keys = (K[]) new Object[size];
        Node<K, V> current = first;
        for (int i = 0; i < size; i++) {
            keys[i] = current.key;
            current = current.next;
        }
        return keys;
    }

    private boolean isKeyUnique(K key) { // перевіряє, чи є переданий ключ унікальним для поточного набору ключів
        boolean res = false;
        K[] keysArray = getAllKeys();
        for (K k : keysArray) {
            if (k.equals(key)) {
                res = false;
            } else res = true;
        }
        System.out.println(res); // це для контролю результату роботи метода
        return res;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> test = new MyHashMap<>();

        System.out.println(test.size);

        test.put(0, "Zero");
        test.put(1, "One");
        test.put(2, "Two");
        test.put(3, "Three");
        test.put(4, "Four");
        test.put(5, "Five");
        test.put(5, "Fake Five");
        test.put(6, "Six");
        test.put(7, "Seven");
        test.put(8, "Eight");
        test.put(9, "Nine");
        test.put(10, "Ten");
        test.put(11, "Eleven");
        test.put(12, "Twelve");
        test.put(13, "Thirteen");
        test.put(14, "Fourteen");

        System.out.println(test.size);

        System.out.println(test.get(5));
        test.remove(5);
        System.out.println(test.size);

        System.out.println(Arrays.toString(test.getAllKeys()));

        System.out.println(test.get(5));

        test.clear();
        System.out.println(test.size);

        test.put(10, "New Zero");
        test.put(11, "New One");
        test.put(12, "New Two");
        test.put(13, "New Three");
        test.put(14, "New Four");
        test.put(15, "New Five");
        System.out.println(test.size);

        System.out.println(Arrays.toString(test.getAllKeys()));

        test.remove(16);
        test.remove(12);

        System.out.println(test.size);
        System.out.println(test.get(13));
    }
}

/*

put(Object key, Object value) добавляет пару ключ + значение
remove(Object key) удаляет пару по ключу
clear() очищает коллекцию
size() возвращает размер коллекции
get(Object key) возвращает значение(Object value) по ключу

 */