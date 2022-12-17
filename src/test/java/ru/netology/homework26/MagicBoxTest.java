//разобраться с типом Double
//надо ставить выбрасывание Исключения? к примеру к testAdd?
//вынести из методов в класс все объявление экземпляров
//проверить все для Double
//нужно превратить в параметризованные тесты

package ru.netology.homework26;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


public class MagicBoxTest {



    //тест, что метод add возвращает true даже без заполнения items[]
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public <T> void testAddReturnTruePositive(T[] argument) {
        final int magicBoxLength = 5;
        MagicBox<T> magicBox = new MagicBox<>(magicBoxLength);

        for (int i = 0; i < argument.length; i++) {
            final boolean result1 = magicBox.add(argument[i]);
            Assertions.assertTrue(result1);
        }
    }
    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"A", "Book", "Comprehensive", "ZZZZZZZ"}),
                Arguments.of((Object) new Integer[]{1, 2, 3, 4}),
                Arguments.of((Object) new Double[]{0.1, 2.9, 500.5, 4.4}),
                Arguments.of((Object) new Boolean[]{true, true, true, false})
        );
    }


    //тест, что метод add добавил в items нужные значения
    @Test
    public <T> void testAddIntegerPositive() {
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

    //тест что метод вернет false при добавлении элементов больше чем можно
    @Test
    public <T> void testAddLimitNegative() {
        final int magicBoxLength = 4;
        final Integer[] argument = {-1000, 100, 0, 100500, -6845654};
        MagicBox<Integer> magicBox = new MagicBox<>(magicBoxLength);

        for (int i = 0; i < argument.length-1; i++) {
            magicBox.add(argument[i]);
        }
        Assertions.assertFalse(magicBox.add(argument[argument.length-1]));
    }









    //после того как проверили метод add, проверяем метод getItems для всех типов данных
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public <T> void testGetItemsWithMethodSourcePositive(T[] argument) {                   //
        final T[] expected = argument;

        final int magicBoxLength = 4;
        MagicBox<T> magicBox = new MagicBox<>(magicBoxLength);
        for (int i = 0; i < magicBoxLength; i++) {
            magicBox.add(argument[i]);
        }

        Object[] result = magicBox.getItems();
        Assertions.assertArrayEquals(expected, result);

    }




//тест что метод pick не достает элемент, если MagicBox не заполнен
    @Test
    public void testPickExceptionNegative() {
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
    public void testPickIntegerPositive() {
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
    @Test
    public void testPickSlotCheckingPositive() {
    final int magicBoxlength = 5;
    final int expected = 2;
    int result = -1;
    MagicBox<Integer> magicBox = new MagicBox<>(magicBoxlength);

    final Integer[] argument = {-1, 2, 5};
    for (int i = 0; i < argument.length; i++) {
        magicBox.add(argument[i]);
    }
    try {
        magicBox.pick();
    } catch (RuntimeException e) {
    String s = String.valueOf(e);
    String phrase = "There are ";
    int start = s.indexOf(phrase);
    start += phrase.length();
    result = Integer.parseInt(s.substring(start, start+1));
}
    Assertions.assertEquals(expected, result);
}



    //        @ParameterizedTest
//        @ValueSource(strings = { "Hello", "World" })
//        public void testWithStringParameter(String argument) {
//            Assertions.assertTrue(argument.contains("o"));
//        }
//    }
}
