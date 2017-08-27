package cn.g_open.game.privs.services;

import java.util.List;
import java.util.Map;

import cn.g_open.game.privs.dto.RoleDTO;
import cn.g_open.game.privs.dto.UserDTO;


public interface UserService
{
    public UserDTO selectUserInfo(Map<String,Object> map);
    
    public int insertUserInfo(UserDTO user);
    
    public List<RoleDTO> selectUserRole(Map<String,Object> map);

}
