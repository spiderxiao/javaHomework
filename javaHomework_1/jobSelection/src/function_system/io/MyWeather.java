package function_system.io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.StringConcatFactory;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.TreeSet;

public class MyWeather
{
    private final static String KEY = "09b1aade9a9945729b904695f00fb88c";

    public void showWeather()
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("-------城市天气查询-------");
            System.out.println("请输入城市名称（中文）；99——退出");
            String city = sc.next();
            if (city.equals("99"))
            {
                break;
            }

            try {
                city = URLEncoder.encode(city, "utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            String uri = "https://geoapi.qweather.com/v2/city/lookup?location="+ city + "&key=" + KEY;

            NetDataAccess.getHttpResult(uri, new BackForResult() {
                @Override
                public void backForResult(String result) {
                    String cityCode = getCityCode(result);
                    //System.out.println(cityCode);
                    String uri1 = "https://devapi.qweather.com/v7/" + "weather/now?location=" + cityCode + "&key=" + KEY;
                    NetDataAccess.getHttpResult(uri1, new BackForResult() {
                        @Override
                        public void backForResult(String result) {

                            printWeather(result);
                        }
                    });

                }
            });
            while (Thread.activeCount() > 2)
                Thread.yield();

        }
    }


    private String getCityCode (String result)
    {
        JSONObject json = JSON.parseObject(result);
        JSONArray locations = (JSONArray) json.get("location");
        JSONObject location = locations.getJSONObject(0);
        String cityCode = location.getString("id");

        String country = location.getString("country");
        String adm1 = location.getString("adm1");
        String name = location.getString("name");
        System.out.println(country + adm1 + name);

        return cityCode;
    }

    private void printWeather(String result)
    {
        JSONObject json = JSON.parseObject(result);
        JSONObject now = (JSONObject) json.get("now");
        String temp = (String) now.get("temp");
        System.out.println("当前温度：" + temp + "℃");
        String text = now.getString("text");
        System.out.println("当前天气：" + text);
        String windDir = now.getString("windDir");
        System.out.println("风向：" + windDir);
        String vis = now.getString("vis");
        System.out.println("能见度：" + vis);
        String obsTime = now.getString("obsTime");
        System.out.println("数据观测时间" + obsTime);
    }


}
