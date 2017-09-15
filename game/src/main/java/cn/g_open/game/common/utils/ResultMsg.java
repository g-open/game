package cn.g_open.game.common.utils;

public enum ResultMsg
{
    SUCC_MSG("000000","成功"),
    
    FAIL_MSG("999999","系统错误"),
    
    ERR_LOGIN_PASSWORD("000002","用户名或密码错误"),
    
    ERR_LOGIN_EMPTY("000001","用户名或密码为空");
    
    
    
    private String code;
   
    private String msg;
    
    private ResultMsg(String code,String msg)
    {
        this.code = code;
        this.msg = msg;
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
   
}
