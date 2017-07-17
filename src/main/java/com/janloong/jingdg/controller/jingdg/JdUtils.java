package com.janloong.jingdg.controller.jingdg;


import com.janloong.jingdg.utils.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Janloong
 * @create 2017-07-12 下午5:16
 **/
public class JdUtils {
    private static final Logger logger = LoggerFactory.getLogger(JdUtils.class);

    /**
     * des: map字典排序
     *
     * @author Janloong
     * @create 17-7-12 下午5:16
     **/
    public static Map sortMap(Map<String, Object> map) {
        Set<Map.Entry<String, Object>> strings = map.entrySet();
        List list = new ArrayList<Map.Entry<String, Object>>(strings);
        Collections.sort(list, (Comparator<Map.Entry<String, Object>>) (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        Map<String, Object> map1 = new HashMap<>();
        Stream<Map.Entry<String, Object>> s = list.stream();
        s.forEach((k) -> {
            map1.put(k.getKey(), k.getValue());
        });
        return map1;
    }

    /**
     * des: 京东参数签名
     *
     * @author Janloong
     * @create 17-7-12 下午4:15
     **/
    public static String signParams(Map<String, String> map, String secret) {
        StringBuilder builder = new StringBuilder();
        builder.append(secret);
        map.forEach((k, v) -> {
            builder.append(k);
            builder.append(v.toString());
        });
        builder.append(secret);
        String s = builder.toString();
        logger.info("\n参数签名拼接前-JdUtils-signParams：" + "\n" +
                "s:" + s + "\n"
        );
        String reuslt = MD5.MD5Encode(s).toUpperCase();
        return reuslt;
    }
}
