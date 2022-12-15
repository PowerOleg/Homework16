package ru.netology.homework26;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;


public class MagicBoxTest<T> {

    @BeforeEach
//    T[] items;


    @Test
    public void testGetItems() {
        final T original;
        final T argument;
        final T expected;

        MagicBox<T> magicBox = new MagicBox();
        final T[] result = magicBox.getItems();

        assertEquals(expected, result);
   //то что я вызвал статический метод assertEquals, это что-то меняет?
    }
}
