package cn.g_open.game.common.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.g_open.game.common.dto.ResultDTO;

public class CommonUtil
{
    public static void responseMsg(HttpServletResponse response,ResultDTO result)
    {
        PrintWriter writer = null;
        try
        {
            response.setCharacterEncoding(ConstUtil.charset);
            writer = response.getWriter();
            writer.write(JSON.toJSONString(result));
            writer.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally 
        {
            if(writer != null)
            {
                writer.close();
            }
        }
    }
}
