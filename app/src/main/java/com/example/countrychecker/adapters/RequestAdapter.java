package com.example.countrychecker.adapters;


import java.io.IOException;

import io.github.fastily.jwiki.core.Wiki;

public class RequestAdapter {
    public static String Pres(String name, String type) throws IOException {
        Wiki wiki = new Wiki.Builder().build();
        String a = wiki.getPageText(name);
        String aa = a.substring(a.lastIndexOf(type));
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

    public static String Photo(String name, String type) {
        Wiki wiki = new Wiki.Builder().build();
        String a = wiki.getPageText(name);
        String aa = a.substring(a.indexOf(type));
        aa = aa.substring(0, aa.indexOf('\n'));
        if (aa.contains("<!--")){
            aa = aa.substring(0, aa.indexOf("<!--"));
        }
        if (aa.contains("File:")){
            aa = aa.substring(aa.indexOf("File:")+4, aa.indexOf("|"));
        }
        //aa = aa.substring(aa.lastIndexOf("= ")+1, aa.length());
        aa = aa.substring(aa.lastIndexOf("= ") + 2);
        String aaa = wiki.getImageInfo("File:" + aa).get(0).url.toString();
        //System.out.println(aa);
        return aaa;
    }
}
