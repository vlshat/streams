package com.github.vlshat.stepic.streams;

import com.github.vlshat.stepic.streams.entitites.Account;
import com.github.vlshat.stepic.streams.entitites.Department;
import com.github.vlshat.stepic.streams.entitites.LogEntry;
import com.github.vlshat.stepic.streams.entitites.State;
import com.github.vlshat.stepic.streams.entitites.Transaction;
import com.github.vlshat.stepic.streams.entitites.TransactionCollector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summingLong;

public class Problems {

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        IntPredicate intPredicate = p -> false;

        if(!predicates.isEmpty()){
            for (IntPredicate predicate : predicates) {
                intPredicate = intPredicate.or(predicate);
            }
        }

        return intPredicate;
    }

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

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    public static boolean isPrime(final long number) {
        return LongStream.rangeClosed(1, number).filter(n -> number % n == 0).count() <= 2;
    }

    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .reduce(0, (acc, number) -> number % 2 != 0 ? acc + number : acc);
    }

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold is lower edge of salary
     *
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(department -> department.getCode().startsWith("111-"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }

    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> a.getBalance() > 0)
                .flatMap(a -> a.getTransactions().stream())
                .filter(t -> t.getState() == State.canceled)
                .map(Transaction::getSum)
                .reduce(0L, Long::sum);
    }

    public static long collectorExample(List<Integer> numbers) {
        return numbers.stream().reduce(1, (acc, number) -> acc * number * number);
    }

    public static Map<Boolean, List<String>> palindromeOrNot(String[] words) {
        return Arrays.stream(words).collect(Collectors.partitioningBy(word ->
                word.equals(new StringBuilder(word).reverse().toString())));
    }

    public static Map<String, Long> totalSumOfTransByEachAccount(List<TransactionCollector> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getAccount().getNumber(),
                        summingLong(TransactionCollector::getSum)
                        ));
    }

    public static Map<String, Long> clickCount(List<LogEntry> logs) {
        return new HashMap<>();
    }

    public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
        return LongStream.rangeClosed(rangeBegin, rangeEnd).parallel().filter(Problems::isPrime);
    }

    public static Function<Integer, Function<Integer, Function<Integer, Integer>>> curriedFunction() {
        return x -> y -> z -> x + y * y + z * z * z;
    }

    public static Function< String, Function<String, Function<String, Function<String, String>>>> stringConverter() {
        return fst -> snd -> trd -> frt -> fst.toLowerCase()
                .concat(trd.toUpperCase())
                .concat(snd.toLowerCase())
                .concat(frt.toUpperCase());
    }
}