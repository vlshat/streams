package com.github.vlshat.stepic.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
}