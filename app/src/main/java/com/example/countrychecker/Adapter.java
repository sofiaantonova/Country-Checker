package com.example.countrychecker;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import io.github.fastily.jwiki.core.Wiki;

public class Adapter {
    public static String Pres(String name) throws IOException {
        Wiki wiki = new Wiki.Builder().build();
        String a = wiki.getPageText(name);
        String aa = a.substring(a.lastIndexOf("leader_name1"));
        aa = aa.substring(0, aa.indexOf('\n'));
        aa = aa.substring(aa.lastIndexOf('[') + 1, aa.indexOf(']'));
        return aa;
    }

    public static String Bio(String name) {
        Wiki wiki = new Wiki.Builder().build();
        return wiki.getTextExtract(name);
    }

    public static String Parliament(String name) {
        Wiki wiki = new Wiki.Builder().build();
        String a = wiki.getPageText(name);
        String aa;
        if (a.contains("lower_house")) {
            aa = a.substring(a.lastIndexOf("lower_house"));
            aa = aa.substring(0, aa.indexOf('\n'));
            try {
                aa = aa.substring(aa.lastIndexOf('[') + 1, aa.indexOf('|'));
            } catch(Exception e) {
                aa =  aa.substring(aa.lastIndexOf('[') + 1, aa.indexOf(']'));
            }

        } else {
            aa = a.substring(a.indexOf("legislature"));
            aa = aa.substring(0, aa.indexOf('\n'));
            aa = aa.substring(aa.indexOf("[[") + 2, aa.indexOf(']'));
        }
        return aa;
    }

    public static String Prime(String name) throws IOException {
        Wiki wiki = new Wiki.Builder().build();
        String a = wiki.getPageText(name);
        String aa = a.substring(a.lastIndexOf("leader_name2"));
        aa = aa.substring(0, aa.indexOf('\n'));
        aa = aa.substring(aa.lastIndexOf('[') + 1, aa.indexOf(']'));
        return aa;
    }

    public static String Photo(String name, String type) {
        Wiki wiki = new Wiki.Builder().build();
        String a = wiki.getPageText(name);
        String aa = a.substring(a.indexOf(type));
        aa = aa.substring(0, aa.indexOf('\n'));
        //aa = aa.substring(aa.lastIndexOf("= ")+1, aa.length());
        aa = aa.substring(aa.lastIndexOf("= ") + 2);
        String aaa = wiki.getImageInfo("File:" + aa).get(0).url.toString();
        System.out.println(aaa);
        return aaa;
    }
}
