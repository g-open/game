package cn.g_open.game.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.g_open.game.common.dto.ResultDTO;
import cn.g_open.game.common.utils.CommonUtil;
import cn.g_open.game.common.utils.ResultMsg;

@Controller
@RequestMapping("login")
public class LoginController
{   
    @RequestMapping("in")
    public void login(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResultDTO result = new ResultDTO();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
        {
            result.setResultMsg(ResultMsg.ERR_LOGIN_EMPTY);
            CommonUtil.responseMsg(response, result);
            return;
        }
    }
}
