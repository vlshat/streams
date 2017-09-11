package com.github.vlshat.stepic.streams;

import com.github.vlshat.stepic.streams.entitites.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void calcSumOfCanceledTransOnNonEmptyAccounts() throws Exception {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        final String req = "[\n" +
                "  {\n" +
                "    \"number\": \"1001\",\n" +
                "    \"balance\": 0,\n" +
                "    \"transactions\": [\n" +
                "      {\n" +
                "        \"uuid\": \"774cedda-9cde-4f53-8bc2-5b4d4859772a\",\n" +
                "        \"state\": \"canceled\",\n" +
                "        \"sum\": 1000,\n" +
                "        \"created\": \"2016.12.12 18:30:05\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"number\": \"1002\",\n" +
                "    \"balance\": 8000,\n" +
                "    \"transactions\": [\n" +
                "      {\n" +
                "        \"uuid\": \"337868a7-f469-43c0-9042-3422ce37ee26a\",\n" +
                "        \"state\": \"finished\",\n" +
                "        \"sum\": 8000,\n" +
                "        \"created\": \"2016.12.12 17:30:55\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"uuid\": \"f8047f86-89e7-4226-8b75-74c55a4d7e31\",\n" +
                "        \"state\": \"canceled\",\n" +
                "        \"sum\": 10000,\n" +
                "        \"created\": \"2016.12.12 18:10:18\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        List<Account> account = gson.fromJson(req, new TypeToken<List<Account>>(){}.getType());
        System.out.println(account);
    }
}