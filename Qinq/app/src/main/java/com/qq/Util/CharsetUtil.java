package com.qq.Util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by qq on 2015/5/25.
 * compileOptions
 * {
 * encoding "GBK"
 * }
 */
public class CharsetUtil {
    /**
     * �ַ�������ת����ʵ�ַ���
     *
     * @param str        ��ת��������ַ���
     * @param newCharset Ŀ�����
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String URLDecoder(String str, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            return URLDecoder.decode(str, newCharset);
        }
        return null;
    }


    public static String URLEncoder(String str, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            return URLEncoder.encode(str, newCharset);
        }
        return null;
    }

}
