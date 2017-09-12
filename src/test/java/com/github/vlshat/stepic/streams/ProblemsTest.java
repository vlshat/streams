package com.github.vlshat.stepic.streams;

import com.github.vlshat.stepic.streams.entitites.AccountCollector;
import com.github.vlshat.stepic.streams.entitites.LogEntry;
import com.github.vlshat.stepic.streams.entitites.TransactionCollector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProblemsTest {
    @Test
    public void collectorExample() throws Exception {
        final List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        assertThat(Problems.collectorExample(list1), is(0L));
        list1.clear();
        list1.add(1);
        list1.add(2);
        assertThat(Problems.collectorExample(list1), is(4L));
    }

    @Test
    public void factorial() throws Exception {
        assertThat(Problems.factorial(0), is(1L));
        assertThat(Problems.factorial(1), is(1L));
        assertThat(Problems.factorial(2), is(2L));
    }

    @Test
    public void sumOfOddNumbersInRange() throws Exception {
        assertThat(Problems.sumOfOddNumbersInRange(0, 0), is(0L));
        assertThat(Problems.sumOfOddNumbersInRange(7, 9), is(16L));
        assertThat(Problems.sumOfOddNumbersInRange(21, 30), is(125L));
    }

    @Test
    public void palindromeOrNot() throws Exception {
        final String[] input1 = {"aaaa", "aaa", "a", "aa"};
        final String[] input2 = {"level", "bbaa", "ac"};

        assertThat(Problems.palindromeOrNot(input1).get(Boolean.TRUE).contains("aaaa"), is(true));
        assertThat(Problems.palindromeOrNot(input2).get(Boolean.FALSE).contains("bbaa"), is(true));

    }

    @Test
    public void totalSumOfTransByEachAccount() throws Exception {
        final AccountCollector acc1 = new AccountCollector("1", 1000L);
        acc1.setBalance(1000L);
        acc1.setNumber("1");
        final AccountCollector acc2 = new AccountCollector("2", 2000L);

        final List<TransactionCollector> transactions = new ArrayList<>();
        transactions.add(new TransactionCollector(10L, acc1));
        transactions.add(new TransactionCollector(11L, acc1));
        transactions.add(new TransactionCollector(15L, acc2));

        final Map<String, Long> resultMap = Problems.totalSumOfTransByEachAccount(transactions);
        assertThat(resultMap.get(acc1.getNumber()), is(21L));
        assertThat(resultMap.get(acc2.getNumber()), is(15L));
    }

    @Test
    public void clickCountTest() throws Exception {
        final List<LogEntry> logs = new ArrayList<>();
        logs.add(new LogEntry("nagibator", "url1"));
        logs.add(new LogEntry("wasa", "url2"));
        logs.add(new LogEntry("qq", "url1"));

        final Map<String, Long> clickCount = Problems.clickCount(logs);

        assertThat(clickCount.get("url1"), is(2L));
        assertThat(clickCount.get("url2"), is(1L));
    }

    @Test
    public void isPrime() throws Exception {
        assertThat(Problems.isPrime(2), is(true));
        assertThat(Problems.isPrime(3), is(true));
        assertThat(Problems.isPrime(4), is(false));
    }
}