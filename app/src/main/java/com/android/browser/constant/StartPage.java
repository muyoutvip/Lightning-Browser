/*
 * Copyright 2014 A.C.R. Development
 */
package com.android.browser.constant;

import android.app.Application;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.WeakReference;

import javax.inject.Inject;

import com.android.browser.R;
import com.android.browser.app.BrowserApp;
import com.android.browser.preference.PreferenceManager;
import com.android.browser.utils.Utils;
import com.android.browser.view.LightningView;

public class StartPage extends AsyncTask<Void, Void, Void> {

    public static final String FILENAME = "homepage.html";

//    private static final String HEAD_1 = "<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml\">"
//            + "<head>"
//            + "<meta content=\"en-us\" http-equiv=\"Content-Language\" />"
//            + "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />"
//            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">"
//            + "<title>";
//
//    private static final String HEAD_2 = "</title>"
//            + "</head>"
//            + "<style>body{background:#f5f5f5;text-align:center;margin:0px;}#search_input{height:35px; "
//            + "width:100%;outline:none;border:none;font-size: 16px;background-color:transparent;}"
//            + "span { display: block; overflow: hidden; padding-left:5px;vertical-align:middle;}"
//            + ".search_bar{display:table;vertical-align:middle;width:90%;height:35px;max-width:500px;margin:0 auto;background-color:#fff;box-shadow: 0px 2px 3px rgba( 0, 0, 0, 0.25 );"
//            + "font-family: Arial;color: #444;-moz-border-radius: 2px;-webkit-border-radius: 2px;border-radius: 2px;}"
//            + "#search_submit{outline:none;height:37px;float:right;color:#404040;font-size:16px;font-weight:bold;border:none;"
//            + "background-color:transparent;}.outer { display: table; position: absolute; height: 100%; width: 100%;}"
//            + ".middle { display: table-cell; vertical-align: middle;}.inner { margin-left: auto; margin-right: auto; "
//            + "margin-bottom:10%; width: 100%;}img.smaller{width:50%;max-width:300px;}"
//            + ".box { vertical-align:middle;position:relative; display: block; margin: 10px;padding-left:10px;padding-right:10px;padding-top:5px;padding-bottom:5px;"
//            + " background-color:#fff;box-shadow: 0px 3px rgba( 0, 0, 0, 0.1 );font-family: Arial;color: #444;"
//            + "font-size: 12px;-moz-border-radius: 2px;-webkit-border-radius: 2px;"
//            + "border-radius: 2px;}</style><body> <div class=\"outer\"><div class=\"middle\"><div class=\"inner\"><img class=\"smaller\" src=\"";
//
//    private static final String MIDDLE = "\" ></br></br><form onsubmit=\"return search()\" class=\"search_bar\" autocomplete=\"off\">"
//            + "<input type=\"submit\" id=\"search_submit\" value=\"Search\" ><span><input class=\"search\" type=\"text\" value=\"\" id=\"search_input\" >"
//            + "</span></form></br></br></div></div></div><script type=\"text/javascript\">function search(){if(document.getElementById(\"search_input\").value != \"\"){window.location.href = \"";
//
//    private static final String END = "\" + document.getElementById(\"search_input\").value;document.getElementById(\"search_input\").value = \"\";}return false;}</script></body></html>";

    private static final String HEAD_1 = "<html>" +
            "    <head>" +
            "        <meta content=\"en-us\" http-equiv=\"Content-Language\" >" +
            "        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" >" +
            "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" >" +
            "        <title></title>" +
            "        <style>" +
            "            #search_input{height:45px; width: 60%;border:0px #cecece solid; outline:none;font-size: 16px;background-color:transparent; padding-left: 0px; float:left;color: #878787}\n" +
            "            a:link {font-size: 12px;color: #000000;text-decoration: none;} \n" +
            ".zheng_1 {float: left; width: 20%; margin-left: 0px; margin-bottom:10px;}\n" +
            ".fan_1 {float: left; width: 10%; margin-left: 0px;margin-bottom:10px;}\n" +
            ".zheng_2 {float: left; width: 20%; margin-left: 6.5%;margin-bottom:10px;}\n" +
            ".fan_2 {float: left; width: 10%; margin-left: 20%;margin-bottom:10px;}" +
//            "img {height:60px;}" +

            "        </style> <script type=\"text/javascript\" src=\"file:///android_asset/js/jquery-1.7.1.min.js\"></script>" +
            "<script type=\"text/javascript\">    \n" +
            "                 $(document).ready(function(){\n" +
            "  window.addEventListener(\"orientationchange\", function() {\n" +
            "var fan = window.orientation;\n" +
            "if(fan == 0){\n" +
            "$(\".list_one\").attr(\"class\",\"zheng_1 list_one\");\n" +
            "$(\".list_two\").attr(\"class\",\"zheng_2 list_two\");\n" +
            "}else{\n" +
            "$(\".list_one\").attr(\"class\",\"fan_1 list_one\");\n" +
            "$(\".list_two\").attr(\"class\",\"fan_2 list_two\");\n" +
            "}\n" +
            "}, false);\n" +
            "});\n" +
            "</script>" +
            "    </head>" +
            "    " +
            "    <body>" +
            "        <div style=\"width:90%; margin-left: 5%; margin-top: 30px; float: left;border:1px #cecece solid;\">" +
            "           <img style=\"width:26px; height:26px; margin:9px 4px 9px 4px; float:left;\" src=\"file:///android_asset/ic_search_engine_google.png\">" +
            " <form onsubmit=\"return search()\" class=\"search_bar\" autocomplete=\"off\">" +
            "                <input type=\"text\" name=\"search_input\" id=\"search_input\" onfocus=\"if (value =='search'){value =''}\" onblur=\"if (value ==''){value='search'}\" value=\"search\">" +
            "            </form>" +
            "        </div>" +
            "        <div id=\"doufu\" class=\"zheng\" style=\"width:90%; margin-left: 5%; margin-top: 30px; float: left;\">" +
            "            <a href=\"http://www.topsite.com\">" +
            "                <div class=\"zheng_1 list_one\">" +
            "                    <img src=\"file:///android_asset/m_top.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Top Sites" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://www.google.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_google.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Google" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://www.facebook.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_face.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Facebook" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"https://www.youtube.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_youtube.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        YouTube" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"https://twitter.com\">" +
            "                <div class=\"zheng_1 list_one\">" +
            "                    <img src=\"file:///android_asset/m_twitter.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Twitter" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"https://mail.google.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_gmail.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Gmail" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://www.my1search.com/?pubid=MI\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_mi.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        MI" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://www.miui.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_miui.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        MIUI" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://www.bbc.co.uk\">" +
            "                <div class=\"zheng_1 list_one\">" +
            "                    <img src=\"file:///android_asset/m_news.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        BBC" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"https://www.yahoo.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_yahoo.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Yahoo" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://briefing.wsj.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_wsj.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        WSJ" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://edition.cnn.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_cnn.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        CNN" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://vimeo.com\">" +
            "                <div class=\"zheng_1 list_one\">" +
            "                    <img src=\"file:///android_asset/m_v.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Vimeo" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"https://www.linkedin.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_in.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Linkedin" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"http://plus.google.com\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_google_plus.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Google+" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "            <a href=\"https://www.wikipedia.org\">" +
            "                <div class=\"zheng_2 list_two\">" +
            "                    <img src=\"file:///android_asset/m_wiki.png\" style=\"width: 100%;\">" +
            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
            "                        Wikipedia" +
            "                    </div>" +
            "                </div>" +
            "            </a>" +
            "        </div>" +
            "        <script type=\"text/javascript\">" +
            "            function search(){" +
            "                if(document.getElementById(\"search_input\").value != \"\"){" +
            "                    window.location.href = \"";

//    private static final String HEAD_1 = "<html>" +
//            "    <head>" +
//            "        <meta content=\"en-us\" http-equiv=\"Content-Language\" >" +
//            "        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" >" +
//            "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" >" +
//            "        <title></title>" +
//            "        <style>" +
//            "            #search_input{height:45px; width: 60%;border:0px #cecece solid; outline:none;font-size: 16px;background-color:transparent; padding-left: 10px; float:left;}\n" +
//            "            a:link {font-size: 12px;color: #000000;text-decoration: none;} \n" +
//            ".zheng_1 {float: left; width: 20%; margin-left: 0px;}\n" +
//            ".fan_1 {float: left; width: 10%; margin-left: 0px;}\n" +
//            ".zheng_2 {float: left; width: 20%; margin-left: 6.5%;}\n" +
//            ".fan_2 {float: left; width: 10%; margin-left: 20%;}" +
//
//            "        </style> <script type=\"text/javascript\" src=\"file:///android_asset/js/jquery-1.7.1.min.js\"></script>" +
//            "<script type=\"text/javascript\">    \n" +
//            "                 $(document).ready(function(){\n" +
//            "  window.addEventListener(\"orientationchange\", function() {\n" +
//            "var fan = window.orientation;\n" +
//            "if(fan == 0){\n" +
//            "$(\".list_one\").attr(\"class\",\"zheng_1 list_one\");\n" +
//            "$(\".list_two\").attr(\"class\",\"zheng_2 list_two\");\n" +
//            "}else{\n" +
//            "$(\".list_one\").attr(\"class\",\"fan_1 list_one\");\n" +
//            "$(\".list_two\").attr(\"class\",\"fan_2 list_two\");\n" +
//            "}\n" +
//            "}, false);\n" +
//            "});\n" +
//            "</script>" +
//            "    </head>" +
//            "    " +
//            "    <body>" +
//            "        <div style=\"width:80%; margin-left: 10%; margin-top: 30px; float: left;border:1px #cecece solid;\">" +
//            "           <img style=\"width:35px; height:35px; margin:5px 10px 5px 5px; float:left;\" src=\"file:///android_asset/amazon.png\">" +
//            " <form onsubmit=\"return search()\" class=\"search_bar\" autocomplete=\"off\">" +
//            "                <input type=\"text\" name=\"search_input\" id=\"search_input\" onfocus=\"if (value =='search'){value =''}\" onblur=\"if (value ==''){value='search'}\" value=\"search\">" +
//            "            </form>" +
//            "        </div>" +
//            "        <div id=\"doufu\" class=\"zheng\" style=\"width:80%; margin-left: 10%; margin-top: 30px; float: left;\">" +
////            "            <a href=\"http://www.topsite.com\">" +
////            "                <div style=\"float: left; width: 20%; margin-left: 0px;\"><!-- 每一行的开头一个图标margin-left都是0px，其他的都是6% -->" +
////            "                    <img src=\"file:///android_asset/m_top.png\" style=\"width: 100%;\">" +
////            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
////            "                        Top Sites" +
////            "                    </div>" +
////            "                </div>" +
////            "            </a>" +
//            "            <a href=\"http://www.amazon.com\">" +
//            "                <div class=\"zheng_1 list_one\">" +
//            "                    <img src=\"file:///android_asset/amazon.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Amazon" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"http://www.my1search.com/?pubid=facebook1923\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/facebook.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Facebook" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://www.youtube.com\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/youtube.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        YouTube" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://twitter.com\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/twitter.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Twitter" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://mail.google.com\">" +
//            "                <div class=\"zheng_1 list_one\">" +
//            "                    <img src=\"file:///android_asset/gmail.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Gmail" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
////            "            <a href=\"http://www.my1search.com/?pubid=MI\">" +
////            "                <div style=\"float: left; width: 20%; margin-left: 6%;\">" +
////            "                    <img src=\"file:///android_asset/mi.png\" style=\"width: 100%;\">" +
////            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
////            "                        MI" +
////            "                    </div>" +
////            "                </div>" +
////            "            </a>" +
////            "            <a href=\"http://www.miui.com\">" +
////            "                <div style=\"float: left; width: 20%; margin-left: 6%;\">" +
////            "                    <img src=\"file:///android_asset/miui.png\" style=\"width: 100%;\">" +
////            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
////            "                        MIUI" +
////            "                    </div>" +
////            "                </div>" +
////            "            </a>" +
//            "            <a href=\"http://www.bbc.co.uk\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/bbc.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        BBC" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
////            "            <a href=\"https://www.yahoo.com\">" +
////            "                <div style=\"float: left; width: 20%; margin-left: 6%;\">" +
////            "                    <img src=\"file:///android_asset/yahoo.png\" style=\"width: 100%;\">" +
////            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
////            "                        Yahoo" +
////            "                    </div>" +
////            "                </div>" +
////            "            </a>" +
//            "            <a href=\"http://briefing.wsj.com\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/wsj.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        WSJ" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"http://edition.cnn.com\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/cnn.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        CNN" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"http://vimeo.com\">" +
//            "                <div class=\"zheng_1 list_one\">" +
//            "                    <img src=\"file:///android_asset/vimeo.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Vimeo" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://www.linkedin.com\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/linkedin.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Linkedin" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"http://plus.google.com\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/google_add.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Google+" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://www.wikipedia.org\">" +
//            "                <div class=\"zheng_2 list_two\">" +
//            "                    <img src=\"file:///android_asset/wikipedia2.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Wikipedia" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "        </div>" +
//            "        <script type=\"text/javascript\">  $(document).ready(function(){\n" +
//            "    window.addEventListener(\"orientationchange\", function() {\n" +
//            "         var fan = window.orientation;\n" +
//            "         if(fan == 0){\n" +
//            "\t    $(\"#doufu\").attr(\"class\",\"zheng\");\n" +
//            "         }else{\n" +
//            "\t    $(\"#doufu\").attr(\"class\",\"fan\");\n" +
//            "         }\n" +
//            "    }, false);\n" +
//            "});" +
//
//            "            function search(){" +
//            "                if(document.getElementById(\"search_input\").value != \"\"){" +
//            "                    window.location.href = \"";

//    private static final String HEAD_1 = "<html>" +
//            "    <head>" +
//            "        <meta content=\"en-us\" http-equiv=\"Content-Language\" >" +
//            "        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" >" +
//            "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" >" +
//            "        <title></title>" +
//            "        <style>" +
//            "            #search_input{height:45px; width:100%;outline:none;border:1px #cecece solid;font-size: 16px;background-color:transparent; padding-left: 10px;}" +
//            "            a:link {font-size: 12px;color: #000000;text-decoration: none;} .daxiong{margin-bottom:15px;float: left; width: 15%;}" +
//
//            "        </style>" +
//            "    </head>" +
//            "    " +
//            "    <body>" +
////            "        <div style=\"width:80%; margin-left: 10%; margin-top: 30px; float: left;\">" +
////            "            <form onsubmit=\"return search()\" class=\"search_bar\" autocomplete=\"off\">" +
////            "                <input type=\"text\" name=\"search_input\" id=\"search_input\" onfocus=\"if (value =='search'){value =''}\" onblur=\"if (value ==''){value='search'}\" value=\"search\">" +
////            "            </form>" +
////            "        </div>" +
//            "        <div style=\"width:90%; margin-left: 5%; margin-top: 40px; float: left;\">" +
//            "            <a href=\"http://www.bbc.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 0px; \"><!-- 每一行的开头一个图标margin-left都是0px，其他的都是6% -->" +
//            "                    <img src=\"file:///android_asset/m_bbc.jpg\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        BBC" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"http://www.usatoday.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_usatody.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        USAToday" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://mobile.nytimes.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_ny.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        NY Times" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://mobile.twitter.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_twitter.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Twitter" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://www.tumblr.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 0px;\">" +
//            "                    <img src=\"file:///android_asset/m_tumblr.jpg\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Tumblr" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://www.facebook.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_face.jpg\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Facebook" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"http://www.mtv.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_mtv.jpg\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        MTV" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://www.netflix.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_netflix.jpg\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Netflix" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"http://www.my1search.com/?pubid=yahoo\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 0px;\">" +
//            "                    <img src=\"file:///android_asset/m_yahoo.jpg\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Y!Music" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://www.hulu.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_hulu.jpg\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Hulu" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"http://m.imdb.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_imdb.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        IMDB" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "            <a href=\"https://www.amazon.com\">" +
//            "                <div class=\"daxiong\" style=\" margin-left: 13%;\">" +
//            "                    <img src=\"file:///android_asset/m_amazon.png\" style=\"width: 100%;\">" +
//            "                    <div style=\"width: 100%; height: 30px; line-height: 30px; text-align: center;\">" +
//            "                        Amazon" +
//            "                    </div>" +
//            "                </div>" +
//            "            </a>" +
//            "        </div>" +
//            "        <script type=\"text/javascript\">" +
//            "            function search(){" +
//            "                if(document.getElementById(\"search_input\").value != \"\"){" +
//            "                    window.location.href = \"";

    private static final String END = "\"+document.getElementById(\"search_input\").value;" +
            "                    document.getElementById(\"search_input\").value = \"\";" +
            "                }" +
            "                return false;" +
            "            }" +
            "        </script>" +
            "    </body>" +
            "</html>";
    @NonNull private final String mTitle;
    @NonNull private final Application mApp;
    @NonNull private final WeakReference<LightningView> mTabReference;

    @Inject PreferenceManager mPreferenceManager;

    private String mStartpageUrl;

    public StartPage(LightningView tab, @NonNull Application app) {
        BrowserApp.getAppComponent().inject(this);
        mTitle = app.getString(R.string.home);
        mApp = app;
        mTabReference = new WeakReference<>(tab);
    }

    @Nullable
    @Override
    protected Void doInBackground(Void... params) {
        mStartpageUrl = getHomepage();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        LightningView tab = mTabReference.get();
        if (tab != null) {
            tab.loadUrl(mStartpageUrl);
        }
    }

    /**
     * This method builds the homepage and returns the local URL to be loaded
     * when it finishes building.
     *
     * @return the URL to load
     */
    @NonNull
    private String getHomepage() {
        StringBuilder homepageBuilder = new StringBuilder(HEAD_1 );
//        StringBuilder homepageBuilder = new StringBuilder(HEAD_1 + mTitle + HEAD_2);
        String icon;
        String searchUrl;
//        switch (mPreferenceManager.getSearchChoice()) {
//            case 0:
//                // CUSTOM SEARCH
//                icon = "file:///android_asset/lightning.png";
//                searchUrl = mPreferenceManager.getSearchUrl();
//                break;
//            case 1:
//                // GOOGLE_SEARCH;
        icon = "file:///android_asset/google.png";
//                // "https://www.google.com/images/srpr/logo11w.png";
//                searchUrl = Constants.GOOGLE_SEARCH;
//                break;
//            case 2:
//                // ANDROID SEARCH;
//                icon = "file:///android_asset/ask.png";
//                searchUrl = Constants.ASK_SEARCH;
//                break;
//            case 3:
//                // BING_SEARCH;
//                icon = "file:///android_asset/bing.png";
//                // "http://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Bing_logo_%282013%29.svg/500px-Bing_logo_%282013%29.svg.png";
//                searchUrl = Constants.BING_SEARCH;
//                break;
//            case 4:
//                // YAHOO_SEARCH;
//                icon = "file:///android_asset/yahoo.png";
//                // "http://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Yahoo%21_logo.svg/799px-Yahoo%21_logo.svg.png";
//                searchUrl = Constants.YAHOO_SEARCH;
//                break;
//            case 5:
//                // STARTPAGE_SEARCH;
//                icon = "file:///android_asset/startpage.png";
//                // "https://com/graphics/startp_logo.gif";
//                searchUrl = Constants.STARTPAGE_SEARCH;
//                break;
//            case 6:
//                // STARTPAGE_MOBILE
//                icon = "file:///android_asset/startpage.png";
//                // "https://com/graphics/startp_logo.gif";
//                searchUrl = Constants.STARTPAGE_MOBILE_SEARCH;
//                break;
//            case 7:
//                // DUCK_SEARCH;
//                icon = "file:///android_asset/duckduckgo.png";
//                // "https://duckduckgo.com/assets/logo_homepage.normal.v101.png";
//                searchUrl = Constants.DUCK_SEARCH;
//                break;
//            case 8:
//                // DUCK_LITE_SEARCH;
//                icon = "file:///android_asset/duckduckgo.png";
//                // "https://duckduckgo.com/assets/logo_homepage.normal.v101.png";
//                searchUrl = Constants.DUCK_LITE_SEARCH;
//                break;
//            case 9:
//                // BAIDU_SEARCH;
//                icon = "file:///android_asset/baidu.png";
//                // "http://www.baidu.com/img/bdlogo.gif";
//                searchUrl = Constants.BAIDU_SEARCH;
//                break;
//            case 10:
//                // YANDEX_SEARCH;
//                icon = "file:///android_asset/yandex.png";
//                // "http://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Yandex.svg/600px-Yandex.svg.png";
//                searchUrl = Constants.YANDEX_SEARCH;
//                break;
//            default:
//                // DEFAULT GOOGLE_SEARCH;
//                icon = "file:///android_asset/google.png";
//                searchUrl = Constants.GOOGLE_SEARCH;
//                break;
//
//        }
//        searchUrl = "http://www.my1search.com/?pubid="+Constants.CHANNEL+"&q=";
        searchUrl="http://www.my1search.com/?pubid=hv02012018&q=";

//        homepageBuilder.append(icon);
//        homepageBuilder.append(MIDDLE);
        homepageBuilder.append(searchUrl);
        homepageBuilder.append(END);

        File homepage = new File(mApp.getFilesDir(), FILENAME);
        FileWriter hWriter = null;
        try {
            //noinspection IOResourceOpenedButNotSafelyClosed
            hWriter = new FileWriter(homepage, false);
            hWriter.write(homepageBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Utils.close(hWriter);
        }

        return Constants.FILE + homepage;
    }

    public void load() {
        executeOnExecutor(BrowserApp.getIOThread());
    }

}
//public class StartPage extends AsyncTask<Void, Void, Void> {
//    public static final String FILENAME = "homepage.html";
//    private static final String HEAD_1 = "<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml\">"
//            + "<head>"
//            + "<meta content=\"en-us\" http-equiv=\"Content-Language\" />"
//            + "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />"
//            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">"
//            + "<title>";
//    private static final String HEAD_2 = "</title>"
//            + "</head>"
//            + "<style>body{background:#f5f5f5;text-align:center;margin:0px;}#search_input{height:35px; "
//            + "width:100%;outline:none;border:none;font-size: 16px;background-color:transparent;}"
//            + "span { display: block; overflow: hidden; padding-left:5px;vertical-align:middle;}"
//            + ".search_bar{display:table;vertical-align:middle;width:90%;height:35px;max-width:500px;margin:0 auto;background-color:#fff;box-shadow: 0px 2px 3px rgba( 0, 0, 0, 0.25 );"
//            + "font-family: Arial;color: #444;-moz-border-radius: 2px;-webkit-border-radius: 2px;border-radius: 2px;}"
//            + "#search_submit{outline:none;height:37px;float:right;color:#404040;font-size:16px;font-weight:bold;border:none;"
//            + "background-color:transparent;}.outer { display: table; position: absolute; height: 100%; width: 100%;}"
//            + ".middle { display: table-cell; vertical-align: middle;}.inner { margin-left: auto; margin-right: auto; "
//            + "margin-bottom:10%; width: 100%;}img.smaller{width:50%;max-width:300px;}"
//            + ".box { vertical-align:middle;position:relative; display: block; margin: 10px;padding-left:10px;padding-right:10px;padding-top:5px;padding-bottom:5px;"
//            + " background-color:#fff;box-shadow: 0px 3px rgba( 0, 0, 0, 0.1 );font-family: Arial;color: #444;"
//            + "font-size: 12px;-moz-border-radius: 2px;-webkit-border-radius: 2px;"
//            + "border-radius: 2px;}</style><body> <div class=\"outer\"><div class=\"middle\"><div class=\"inner\"><img class=\"smaller\" src=\"";
//    private static final String MIDDLE = "\" ></br></br><form onsubmit=\"return search()\" class=\"search_bar\" autocomplete=\"off\">"
//            + "<input type=\"submit\" id=\"search_submit\" value=\"Search\" ><span><input class=\"search\" type=\"text\" value=\"\" id=\"search_input\" >"
//            + "</span></form></br></br></div></div></div><script type=\"text/javascript\">function search(){if(document.getElementById(\"search_input\").value != \"\"){window.location.href = \"";
//    //    private static final String MIDDLE = "</br><form onsubmit=\"return search()\" class=\"search_bar\" autocomplete=\"off\">"
////            + "<input type=\"submit\" id=\"search_submit\" value=\"Search\" ><span><input class=\"search\" type=\"text\" value=\"\" id=\"search_input\" >"
////            + "</span></form></br></br></div></div></div><script type=\"text/javascript\">function search(){if(document.getElementById(\"search_input\").value != \"\"){window.location.href = \"";
//    private static final String END = "\" + document.getElementById(\"search_input\").value;document.getElementById(\"search_input\").value = \"\";}return false;}</script></body></html>";
//    @NonNull
//    private final String mTitle;
//    @NonNull private final Application mApp;
//    @NonNull private final WeakReference<LightningView> mTabReference;
//    @Inject
//    PreferenceManager mPreferenceManager;
//    private String mStartpageUrl;
//    public StartPage(LightningView tab, @NonNull Application app) {
//        BrowserApp.getAppComponent().inject(this);
//        mTitle = app.getString(R.string.home);
//        mApp = app;
//        mTabReference = new WeakReference<>(tab);
//    }
//    @Nullable
//    @Override
//    protected Void doInBackground(Void... params) {
//        mStartpageUrl = getHomepage();
//        return null;
//    }
//    @Override
//    protected void onPostExecute(Void aVoid) {
//        super.onPostExecute(aVoid);
//        LightningView tab = mTabReference.get();
//        if (tab != null) {
//            tab.loadUrl(mStartpageUrl);
//        }
//    }
//    /**
//     * This method builds the homepage and returns the local URL to be loaded
//     * when it finishes building.
//     *
//     * @return the URL to load
//     */
//    @NonNull
//    private String getHomepage() {
//        StringBuilder homepageBuilder = new StringBuilder(HEAD_1 + mTitle + HEAD_2);
//        String icon;
//        String searchUrl;
////
//        icon = "file:///android_asset/baidu.png";
//        searchUrl = Constants.BAIDU_SEARCH;
////
//        homepageBuilder.append(icon);
//        homepageBuilder.append(MIDDLE);
//        homepageBuilder.append(searchUrl);
//        homepageBuilder.append(END);
//        File homepage = new File(mApp.getFilesDir(), FILENAME);
//        FileWriter hWriter = null;
//        try {
//            //noinspection IOResourceOpenedButNotSafelyClosed
//            hWriter = new FileWriter(homepage, false);
//            hWriter.write(homepageBuilder.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            Utils.close(hWriter);
//        }
//        return Constants.FILE + homepage;
//    }
//    public void load() {
//        executeOnExecutor(BrowserApp.getIOThread());
//    }
//
//}
