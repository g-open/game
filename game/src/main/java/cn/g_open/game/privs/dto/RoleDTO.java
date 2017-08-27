package cn.g_open.game.privs.dto;

import cn.g_open.game.common.dto.BaseDTO;

public class RoleDTO extends BaseDTO
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String roleid;
    
    private String rolename;
    
    private String roletype;

    public String getRoleid()
    {
        return roleid;
    }

    public void setRoleid(String roleid)
    {
        this.roleid = roleid;
    }

    public String getRolename()
    {
        return rolename;
    }

    public void setRolename(String rolename)
    {
        this.rolename = rolename;
    }

    public String getRoletype()
    {
        return roletype;
    }

    public void setRoletype(String roletype)
    {
        this.roletype = roletype;
    }
    
}
