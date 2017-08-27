package cn.g_open.game.privs.dto;

import org.hibernate.validator.constraints.Length;

import cn.g_open.game.common.dto.BaseDTO;

public class UserDTO extends BaseDTO
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Length(max=20,min=6,message="用户名长度在{max}与{min}之间")
    private String userid;
    
    private String username;
    @Length(max=20,min=8,message="密码长度在{max}与{min}之间")
    private String password;
    
    private String email;
    
    private String phone;

    
    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

}
