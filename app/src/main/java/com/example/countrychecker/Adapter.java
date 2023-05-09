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
        //System.out.println(aa);
        return aa;
        //System.out.println(aa);
        //System.out.println(a);
    }
    public static String Photo(String name) {
        Wiki wiki = new Wiki.Builder().build();
        String a = wiki.getPageText("United States");
        String aa = a.substring(a.lastIndexOf("image_flag"));
        aa = aa.substring(0, aa.indexOf('\n'));
        aa = aa.substring(aa.lastIndexOf("= ")+1, aa.length());
        aa = aa.substring(aa.lastIndexOf("= ") + 2);
        String aaa = wiki.getImageInfo("File:" + aa).get(0).url.toString();
        return aaa;
        //System.out.println(aa);
        //System.out.println(a);
    }
}
