package ru.netology.homework26;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;


public class MagicBoxTest {

    @Test
    public void testIntegerGetItems() {
        final Integer[] argument = {-100, 0, 50, 100};
        final Integer[] expected = argument;

        MagicBox<Integer> magicBox = new MagicBox<>(argument.length);
        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }

        Object[] result = magicBox.getItems();
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    public void testStringGetItems() {
        final String[] argument = {"", "ABC", "154"};
        final String[] expected = argument;

        MagicBox<String> magicBox = new MagicBox<>(argument.length);
        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }

        Object[] result = magicBox.getItems();
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    public void testBooleanGetItems() {
        final Boolean[] argument = {true, true, false};
        final Boolean[] expected = argument;

        MagicBox<Boolean> magicBox = new MagicBox<>(argument.length);
        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }

        Object[] result = magicBox.getItems();
        Assertions.assertArrayEquals(expected, result);
    }


//надо ставить выбрасывание Исключения?
    @Test
    public <T> boolean testAdd(T item) throws Exception {

    final Integer[] original;
    final Integer[] argument;
    final Integer[] expected;



        return true;

        Assertions.assertArrayEquals();
    }

    //        @ParameterizedTest
//        @ValueSource(strings = { "Hello", "World" })
//        public void testWithStringParameter(String argument) {
//            Assertions.assertTrue(argument.contains("o"));
//        }
//    }
}
