package com.supwisdom.authenticationsecond;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: wxy
 * @create: 2024-05-09 16:53
 */

public class Teaa {
    public static void main(String args[]) {
//        String str = "operationId: view_foxtrot_kilo\n" +
//                "      deprecated: ''\n" +
//                "      tags:\n" +
//                "      - student\n" +
//                "      security:\n" +
//                "      - oauth2:\n" +
//                "        - dataMarket:v1:view_foxtrot_kilo\n" +
//                "      responses:";
//        Pattern pattern = Pattern.compile("operationId:.*?\\s");
//        String[] strs = pattern.split(str);
//        for (int i = 0; i < strs.length; i++) {
//            System.out.println(strs[i]);
//        }

        String aa = "operationId: view_foxtrot_november\n" +
                "\n" +
                "operationId: tgxxsbzksjxjxx\n";

        String[] aaaa = aa.split("operationId:");
        String re = "";
        for (int i = 0; i < aaaa.length; i++) {
            String cc = aaaa[i].replaceAll("\\s*","");
            re = re + "," + cc;
//            if (re == "") {
//            } else {
//                re = cc;
//            }

//            System.out.println(cc);
        }
        re = re.substring(2);
        System.out.println(re);
    }
}
