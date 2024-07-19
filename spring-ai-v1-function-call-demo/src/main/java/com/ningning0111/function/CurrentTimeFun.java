package com.ningning0111.function;


import java.util.Date;
import java.util.function.Function;

/**
 * @Project: com.ningning0111.function
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/7/19 12:37
 * @Description:
 */
public class CurrentTimeFun implements Function<CurrentTimeFun.Request, CurrentTimeFun.Response> {

    // 使用Record(jdk 17开始支持，17以下单独定义类亦可) 定义函数的请求对象和响应对象
    public record Request(String location) {}
    public record Response(String time) {}
    @Override
    public Response apply(Request request) {
        long currTime = System.currentTimeMillis();
        // 模拟根据location获取到了当地时间
        Date date = new Date(currTime);
        return new Response(date.toString());
    }
}
