package org.wefine.ums.config.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyLoginFailHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpservletrequest,
                                        HttpServletResponse httpservletresponse,
                                        AuthenticationException authenticationexception)
            throws IOException, ServletException {
        System.out.println("登录失败");
    }

}
