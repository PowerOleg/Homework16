public class MagicBox<T> {
    T[] items;
    public <T> boolean add (T item) {

        return true;                                //!
    }
    public <T> T pick(T[] items) {
    T[] array = items;
        return array[0];                            //!
    }
    public MagicBox(int number) {
        items = (T[]) new Object[number];
    }
}
