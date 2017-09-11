package com.github.vlshat.stepic.streams;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProblemsTest {

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
}