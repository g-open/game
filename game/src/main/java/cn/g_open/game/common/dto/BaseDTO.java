package cn.g_open.game.common.dto;

import java.util.Date;

public class BaseDTO
{
    private String dataStatus;
    
    private String createBy;
    
    private Date createDate;
    
    private String updateBy;
    
    private Date updateDate;

    public String getDataStatus()
    {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus)
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
