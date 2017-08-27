package cn.g_open.game.privs.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.g_open.game.privs.dto.RoleDTO;
import cn.g_open.game.privs.dto.UserDTO;
import cn.g_open.game.privs.mapper.UserMapper;
import cn.g_open.game.privs.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO selectUserInfo(Map<String, Object> map)
    {
        // TODO Auto-generated method stub
        return userMapper.selectUserInfo(map);
    }

    @Override
    public int insertUserInfo(UserDTO user)
    {
        // TODO Auto-generated method stub
        return userMapper.insertUserInfo(user);
    }

    @Override
    public List<RoleDTO> selectUserRole(Map<String, Object> map)
    {
        // TODO Auto-generated method stub
        return userMapper.selectUserRole(map);
    }
    
   
}
