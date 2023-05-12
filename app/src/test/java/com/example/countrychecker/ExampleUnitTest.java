package com.example.countrychecker;

import com.example.countrychecker.adapters.RequestAdapter;

import org.junit.Test;

import java.io.IOException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        System.out.println(RequestAdapter.Pres("United States", "leader_name1"));
    }
}