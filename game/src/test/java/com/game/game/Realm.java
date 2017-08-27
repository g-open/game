package com.game.game;

import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.g_open.game.common.shiro.AuthRealm;

public class Realm
{
    @Qualifier("")
    static PrincipalCollection principalCollection ;
   public static void main(String[] args)
{
       AuthRealm ss = new AuthRealm();
       System.out.println(principalCollection.toString());
       
       
       
       
}
}
