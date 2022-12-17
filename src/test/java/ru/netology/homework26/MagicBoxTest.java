package ru.netology.homework26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class MagicBoxTest {
    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"A", "Book", "Comprehensive", "ZZZZZZZ"}),
                Arguments.of((Object) new Integer[]{1, 2, 3, 4}),
                Arguments.of((Object) new Double[]{0.1, 2.9, 500.5, 4.4}),
                Arguments.of((Object) new Boolean[]{true, true, true, false})
        );
    }

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

    //проверяем метод add, что добавил элементы в items[] и проверяем метод getItems что вернул массив
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public <T> void testGetItemsWithMethodSourcePositive(T[] argument) {
        final T[] expected = argument;
        final int magicBoxLength = 4;
        MagicBox<T> magicBox = new MagicBox<>(magicBoxLength);
        for (int i = 0; i < magicBoxLength; i++) {
            magicBox.add(argument[i]);
        }
        Object[] result = magicBox.getItems();
        Assertions.assertArrayEquals(expected, result);
    }

    //тест что метод вернет false при добавлении элементов больше чем можно
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public <T> void testAddLimitNegative(T[] argument) {
        final int magicBoxLength = 3;
        MagicBox<T> magicBox = new MagicBox<>(magicBoxLength);
        for (int i = 0; i < magicBoxLength; i++) {
            magicBox.add(argument[i]);
        }
        Assertions.assertFalse(magicBox.add(argument[argument.length - 1]));
    }

    //тест что метод pick не достает элемент, если MagicBox не заполнен
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public <T> void testPickExceptionNegative(T[] argument) {
        final int magicBoxLength = 5;
        MagicBox<T> magicBox = new MagicBox<>(magicBoxLength);
        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }
        Assertions.assertThrows(RuntimeException.class, () -> magicBox.pick());
    }

    //тест, что метод pick достает один элемент случайно, если массив заполнен
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public <T> void testPickIntegerPositive(T[] argument) {
        MagicBox<T> magicBox = new MagicBox<>(argument.length);
        for (int i = 0; i < argument.length; i++) {
            magicBox.add(argument[i]);
        }
        T expected = null;
        final T result = magicBox.pick();
        for (T t : argument) {
            if (t.equals(result)) {
                expected = t;
            }
        }
        Assertions.assertEquals(expected, result);
    }

    //тест, что метод pick верно считает количество оставшихся слотов до заполнения и начала работы метода
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public <T> void testPickSlotCheckingPositive(T[] argument) {
        final int magicBoxlength = 6;
        final int expected = 2;
        int result = -1;
        MagicBox<T> magicBox = new MagicBox<>(magicBoxlength);

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
            result = Integer.parseInt(s.substring(start, start + 1));
        }
        Assertions.assertEquals(expected, result);
    }
}
