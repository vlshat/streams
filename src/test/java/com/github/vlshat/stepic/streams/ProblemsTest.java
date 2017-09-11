package com.github.vlshat.stepic.streams;

import com.github.vlshat.stepic.streams.entitites.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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

}