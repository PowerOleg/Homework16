package ru.netology.homework26;

import java.util.Random;

public class MagicBox<T> {
    private T[] items;
    private Random random = new Random();
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

    public T pick() throws RuntimeException {
        if (items[items.length - 1] != null) {
            return items[random.nextInt(items.length)];
        } else {
            int vacantSlot = items.length;
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) vacantSlot--;
            }
            throw new RuntimeException("The magic box isn't full. There are " + vacantSlot + " slots left");
        }
    }
    public T[] getItems() {
        return items;
    }
}

