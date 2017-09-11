package com.github.vlshat.stepic.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Problems {

    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Arrays.stream(text.split(" "))
                .distinct()
                .filter(badWords::contains)
                .sorted(String::compareTo);
    }

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream)
                .filter(number -> number % 15 == 0)
                .sorted()
                .skip(2);
    }

    public static long factorial(long n) {
        return LongStream.rangeClosed(0, n)
                .reduce(0, (acc, number) -> number == 1
                        || number == 0 ? acc = 1 : acc * number);
    }

    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .reduce(0, (acc, number) -> number % 2 != 0 ? acc + number : acc);
    }
}