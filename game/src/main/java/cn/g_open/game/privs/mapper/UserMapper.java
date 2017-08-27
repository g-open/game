package cn.g_open.game.privs.mapper;

import java.util.List;
import java.util.Map;

import cn.g_open.game.privs.dto.RoleDTO;
import cn.g_open.game.privs.dto.UserDTO;


public interface UserMapper
{
    public UserDTO selectUserInfo(Map<String,Object> map);
    
    public int insertUserInfo(UserDTO user);
    
    public List<RoleDTO> selectUserRole(Map<String,Object> map);
}
