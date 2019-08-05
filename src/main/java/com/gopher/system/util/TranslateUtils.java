package com.gopher.system.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TranslateUtils {

    public static void main(String[] args) {
        try {
            System.out.println(translate("en","zh-CN","coupon"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String translate(String langFrom, String langTo,
                            String word)  {
       try {
           String url = "https://translate.googleapis.com/translate_a/single?" +
                   "client=gtx&" +
                   "sl=" + langFrom +
                   "&tl=" + langTo +
                   "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");

           URL obj = new URL(url);
           HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           con.setRequestProperty("User-Agent", "Mozilla/5.0");
           BufferedReader in = new BufferedReader(
                   new InputStreamReader(con.getInputStream()));
           String inputLine;
           StringBuffer response = new StringBuffer();
           while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
           }
           in.close();
           Thread.sleep(500);//避免封IP
           return parseResult(response.toString());
       }catch (Throwable t){
           return "";
       }
    }

    private static String parseResult(String inputJson) throws Exception {

        JSONArray jsonArray = JSON.parseArray(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        String result ="";
        for(int i =0;i < jsonArray2.size();i++){
            result += ((JSONArray) jsonArray2.get(i)).get(0).toString();
        }
        return result;
    }

}

