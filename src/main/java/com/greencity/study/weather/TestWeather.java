package com.greencity.study.weather;

import java.util.Map;

import static com.greencity.study.weather.ZzWeather.getTodayWeather1;
import static com.greencity.study.weather.ZzWeather.getTodayWeather2;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/11/24/024 15:12
 */
public class TestWeather {

    public static void main(String[] args) {
        try {
            //测试获取实时天气1(包含风况，湿度)
            Map<String, Object> map = getTodayWeather1("101180101");
            System.out.println(map);


            //测试获取实时天气2(包含天气，温度范围)
            Map<String, Object> map2 = getTodayWeather2("101180101"); //这块填的是城市编码
            System.out.println(map2.get("city") + "\t" + map2.get("temp1")
                    + "\t" + map2.get("temp2") + "\t" + map2.get("weather")
                    + "\t" + map2.get("ptime"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}