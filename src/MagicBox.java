import java.util.Arrays;

public class MagicBox<T> {
    private T[] items;
    public MagicBox(int number) {
        items = (T[]) new Object[number];
    }
    public boolean add(T item) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    items[i] = item;
                    return true;
                }
            }
            System.out.println("The array is full");
            return false;
    }
//    public <T> T pick(T[] items) {
//        T[] array = items;
//        return array[0];                            //!
//    }
    public T[] getItems() {
        return items;
    }
}

