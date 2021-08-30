package com.polofox.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author Write By SunChengXin
 * @title: ZhToEn
 * @projectName polofox
 * @Modifier: SunChengXin
 * @date 2021/8/30-9:54
 */
public class ChToEn {
    public static String chineseToFirstLetter(String c) {
        StringBuilder string = new StringBuilder();
        char b;
        int a = c.length();
        for (int k = 0; k < a; k++) {
            b = c.charAt(k);
            String d = String.valueOf(b);
            String str = converterToFirstSpell(d);
            String g = str.toUpperCase();
            char h;
            for (int y = 0; y <= 0; y++) {
                h = g.charAt(0);
                string.append(h);
            }
        }
        return string.toString();
    }

    public static String converterToFirstSpell(String chines) {
        StringBuilder pinyinName = new StringBuilder();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat;
        defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : nameChar) {
            String s = String.valueOf(c);
            if (!s.matches("[\\u4e00-\\u9fa5]")) {
                pinyinName.append(c);
            } else {
                try {
                    String[] mPinyinArray = PinyinHelper
                            .toHanyuPinyinStringArray(c,
                                    defaultFormat);
                    pinyinName.append(mPinyinArray[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            }
        }
        return pinyinName.toString();
    }

    public static void main(String[] args) {
        System.err.println(chineseToFirstLetter("犯我中华者虽远必诛！"));
    }

}
