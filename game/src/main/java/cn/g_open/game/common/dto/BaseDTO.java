package cn.g_open.game.common.dto;

import java.io.Serializable;
import java.util.Date;

import cn.g_open.game.common.utils.ConstUtil;

public class BaseDTO implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int dataStatus = 1;
    
    private String createBy = ConstUtil.sysName;
    
    private Date createDate = new Date();
    
    private String updateBy = ConstUtil.sysName;
    
    private Date updateDate = new Date();


    public int getDataStatus()
    {
        return dataStatus;
    }

    public void setDataStatus(int dataStatus)
    {
        this.dataStatus = dataStatus;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }
    
}
