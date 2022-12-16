package ru.netology.homework26;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;


public class MagicBoxTest<T> {

//    @BeforeEach
//    T[] items;

//надо сделать для всех типов данных
    @Test
    public void testGetItems() {
        final int magicLength = 4;
//        final T original;
        final Integer[] argument = {-100, 0, 50, 100};
        final Integer[] expected = {-100, 0, 50, 100};

        MagicBox<Integer> magicBox = new MagicBox<>(magicLength);
        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }


        T[] result = (T[]) magicBox.getItems();
        Assertions.assertArrayEquals(expected, result);


    }



//    @Test
//    public boolean addTest(T item) {
//
//    }

}
