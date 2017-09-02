package cn.g_open.game.common.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.g_open.game.privs.dto.RoleDTO;
import cn.g_open.game.privs.dto.UserDTO;
import cn.g_open.game.privs.services.UserService;

public class AuthRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;
    //访问 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        String username = principals.fromRealm(this.getClass().getName()).iterator().next().toString();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid", username);
        List<RoleDTO> roles = userService.selectUserRole(map);
        if(CollectionUtils.isEmpty(roles)){
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (RoleDTO role : roles)
        {
            info.addRole(role.getRoleid());
        }
        return info;
    }
    
    //认证 登陆
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid", utoken.getUsername());
        UserDTO user = userService.selectUserInfo(map);
        if(null == user){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
   
}