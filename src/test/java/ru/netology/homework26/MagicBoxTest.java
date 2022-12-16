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


    //тест, что метод add проходит и возвращает true
    @Test
    public <T> void testTrueAdd() {
        final int magicBoxLength = 4;
        final Integer[] argument = {-1000, 100, 0};
        MagicBox<Integer> magicBox = new MagicBox<>(magicBoxLength);

        for (int i = 0; i < argument.length; i++) {
            final boolean result1 = magicBox.add(argument[i]);
            Assertions.assertTrue(result1);
        }
    }

    //тест, что метод add добавил в items нужные значения
    @Test
    public <T> void testIntegerAdd() {
        final int magicBoxLength = 4;
        final Integer[] argument = {-1000, 100, 0};
        final Integer[] expected = {-1000, 100, 0, null};
        MagicBox<Integer> magicBox = new MagicBox<>(magicBoxLength);

        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }
        final Object[] result2 = magicBox.getItems();
        Assertions.assertArrayEquals(expected, result2);
    }

    //тест что метод вернет false при добавлении  элементов больше чем можно
    @Test
    public <T> void testLimitAdd() {
        final int magicBoxLength = 4;
        final Integer[] argument = {-1000, 100, 0, 100500, -6845654};
        MagicBox<Integer> magicBox = new MagicBox<>(magicBoxLength);

        for (int i = 0; i < argument.length-1; i++) {
            magicBox.add(argument[i]);
        }
        Assertions.assertFalse(magicBox.add(argument[argument.length-1]));
    }







//тест что метод pick не достает элемент, если MagicBox не заполнен
    @Test
    public void testExceptionPick() {
        final int magicBoxLength = 3;
        final Integer[] argument = {0, -6845654};
        MagicBox<Integer> magicBox = new MagicBox<>(magicBoxLength);
        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }
        Assertions.assertThrows(RuntimeException.class, () -> magicBox.pick());
    }


//тест, что метод pick достает один элемент случайно, если массив заполнен
    @Test
    public void testIntegerPick() {
        final Integer[] argument = {-1, 2, 5, 10, 5};
        MagicBox<Integer> magicBox = new MagicBox<>(argument.length);
        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }
    Integer expected = null;
    final Integer result = magicBox.pick();
        for (Integer i : argument) {
            if (i.equals(result)) {
                expected = i;
            }
        }
        Assertions.assertEquals(expected, result);
}

//тест, что метод pick верно считает количество оставшихся слотов до заполнения и начала работы метода
// что метод не работает если там нет элементов


    //        @ParameterizedTest
//        @ValueSource(strings = { "Hello", "World" })
//        public void testWithStringParameter(String argument) {
//            Assertions.assertTrue(argument.contains("o"));
//        }
//    }
}
