package cn.g_open.game.common.dto;

import cn.g_open.game.common.utils.ResultMsg;

public class ResultDTO
{
    private String code;
    
    private String msg;
    
    private Object data;

    public ResultDTO(){
        this.setResultMsg(ResultMsg.SUCC_MSG);
    }
    
    public void setResultMsg(ResultMsg result)
    {
        this.code = result.getCode();
        this.msg = result.getMsg();
    }
    
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

}
