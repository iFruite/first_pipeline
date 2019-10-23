package com.bytheone;

import com.blade.Blade;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * main portal
 */
public class Application {
    public static void main(String[] args) {
//        Blade.me().start(Application.class, args);

        String subject_51job = "(51job.com)申请贵公司[SQB28]电脑操作录入员（深圳）－肖星晨";
        String subject_zhaopin = "(Zhaopin.com) 应聘 [SCZ010]产品经理助理-深圳-黄震";
        String subject_chinahr = "应聘[SCR09]测试工程师/QA（辽宁)——王光耀";
        String subject_dajie = "文礼敏__应聘[SDB13]网站开发";

        String subject = subject_dajie;

        int startPos = 0;
        int endPos = 0;
        if (subject.contains("51job.com")) {
            startPos = subject.indexOf("申请贵公司") + 5;
            endPos = subject.indexOf("－");
        } else {
            if (subject.contains("应聘")) {
                startPos = subject.indexOf("应聘") + 2;
                if (subject.contains("-")) {
                    endPos = subject.indexOf("-");
                }
                if (subject.contains("——")) {
                    endPos = subject.indexOf("——");
                }
                if (subject.contains("_")) {
                    endPos = subject.length();
                }
            }
        }

        String position = subject.substring(startPos, endPos).trim();
        System.out.println(position);

        String ageText = "2010/9-2014/7";
        System.out.println(ageText.indexOf("-"));
        System.out.println(ageText.indexOf("]"));
        ageText = ageText.substring(ageText.indexOf("-"));

        System.out.println(ageText.trim());

        try {
            System.out.println(new SimpleDateFormat("yyyy/mm").parse(ageText));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
