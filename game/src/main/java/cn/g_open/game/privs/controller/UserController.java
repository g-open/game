package cn.g_open.game.privs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.g_open.game.common.dto.ResultDTO;
import cn.g_open.game.common.utils.CommonUtil;
import cn.g_open.game.common.utils.ConstUtil;
import cn.g_open.game.common.utils.ResultMsg;
import cn.g_open.game.privs.dto.UserDTO;
import cn.g_open.game.privs.services.UserService;

@RestController
@RequestMapping("user")
public class UserController
{   
    
    @Autowired
    public UserService userService;
    
    @RequestMapping("login")
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResultDTO result = new ResultDTO();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
        {
            result.setResultMsg(ResultMsg.ERR_LOGIN_EMPTY);
            CommonUtil.responseMsg(response, result);
            return ;
        }
        Subject  subject = SecurityUtils.getSubject();
        Md5Hash md5 = new Md5Hash(password,username);
        UsernamePasswordToken token = new UsernamePasswordToken(username, md5.toHex(), true);
        try{
            subject.login(token);
            response.sendRedirect(ConstUtil.INDEX_VIEW);
            return;
        }catch(Exception e){
            result.setResultMsg(ResultMsg.ERR_LOGIN_EMPTY);
        }
        CommonUtil.responseMsg(response, result);
    }
    
    @RequestMapping("register")
    public void register(HttpServletRequest request,HttpServletResponse response,@Valid UserDTO userDTO) throws IOException{
        ResultDTO result = new ResultDTO();
        if(userDTO == null || StringUtils.isEmpty(userDTO.getUsername()) || StringUtils.isEmpty(userDTO.getPassword()))
        {
            result.setResultMsg(ResultMsg.ERR_LOGIN_EMPTY);
            CommonUtil.responseMsg(response, result);
            return;
        }
        userDTO.setUserid(userDTO.getUsername());
        Md5Hash md5 = new Md5Hash(userDTO.getPassword(),userDTO.getUsername());
        userDTO.setPassword(md5.toHex());
        userService.insertUserInfo(userDTO);
        response.sendRedirect(ConstUtil.LOGIN_VIEW);
    }
    
}
