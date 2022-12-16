//разобраться с типом Double
//надо ставить выбрасывание Исключения? к примеру к testAdd?
//вынести из методов в класс все объявление экземпляров

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



    @Test
    public <T> void testAdd() throws Exception {

        final int magicBoxLength = 4;
        final Integer[] argument = {-1000, 100, 0};
        final Integer[] expected2 = {-1000, 100, 0, null};


        MagicBox<Integer> magicBox = new MagicBox<>(magicBoxLength);
//тест что метод add проходит возвраая true
        for (int i = 0; i < argument.length; i++) {
            final boolean result1 = magicBox.add(argument[i]);
            Assertions.assertTrue(result1);
        }
//тест что метод add добавил в items нужные значения
        final Object[] result2 = magicBox.getItems();

        Assertions.assertArrayEquals(expected2, result2);

//тест что метод add не добавит больше значений чем нужно

    }

    //        @ParameterizedTest
//        @ValueSource(strings = { "Hello", "World" })
//        public void testWithStringParameter(String argument) {
//            Assertions.assertTrue(argument.contains("o"));
//        }
//    }
}
