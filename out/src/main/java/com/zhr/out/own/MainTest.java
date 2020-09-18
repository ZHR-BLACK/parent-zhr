package com.zhr.out.own;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MainTest
 * @Date 2020-09-17 10:39
 * @description 根据渠道和交易类型调用相应方法
 **/
public class MainTest {

    private static Map<String, IChannel> processorMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
//        final IChannel interByChannelCode = ChannelManager.getInterByChannelCode("zfb", "Singlepay");
//        Map<String, Object> map = interByChannelCode.genParamsMap("sss");
//        System.out.println("map==================" + map);

        ArrayList<Class> classList = ChannelManager.getAllClassByInterface(IChannel.class);
        for (Class classItem : classList) {
            processorMap.put(classItem.getSimpleName(), (IChannel)classItem.newInstance());
        }
        System.out.println("processorMap==================" + processorMap);
        Map<String, Object> stringObjectMap = processorMap.get("ZfbSinglepay").genParamsMap("sda");
        System.out.println("stringObjectMap==================" + stringObjectMap);

    }
}
