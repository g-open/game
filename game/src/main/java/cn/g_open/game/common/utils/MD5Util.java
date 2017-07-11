package cn.g_open.game.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
    public static String encrypt(String str){
        MessageDigest md = null;
        byte[] te = null;
        String mdStr = null;
        try
        {
            md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes(ConstUtil.charset));
            te = md.digest();
            mdStr = byteToString(te);
            md.update(mdStr.getBytes(ConstUtil.charset));
            te = md.digest();
            mdStr = byteToString(te);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return mdStr;
    }
    
    public static String byteToString(byte[] te){
        StringBuffer buffer = new StringBuffer("");
        byte t;
        for (int i = 0; i < te.length; i++)
        {
            t = te[i];
            if(t < 0)
            {
                t += 256;
            }
            if(t < 16)
            {
                buffer.append("0");
            }
            buffer.append(Integer.toHexString(t));
        }
        return buffer.toString();//32位加密
       // return buffer.toString().substring(8, 24); //16位加密
    }
}


