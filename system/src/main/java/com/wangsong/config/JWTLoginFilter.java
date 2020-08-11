package com.wangsong.config;


import com.wangsong.system.model.CustomUserDetails;
import com.wangsong.system.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 * @author zhaoxinguo on 2017/9/12.
 */

public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;
  private UserService userService;
  public JWTLoginFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  public JWTLoginFilter(AuthenticationManager authenticationManager, UserService userService) {
    this.authenticationManager = authenticationManager;
    this.userService = userService;
  }

  // 接收并解析用户凭证
  @Override
  public Authentication attemptAuthentication(HttpServletRequest req,
                                              HttpServletResponse res) throws AuthenticationException {
    String username =  req.getParameter("username");
    String password = req.getParameter("password");

    UserDetails userDetails = userService.loadUserByUsername(username);
    return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities()));
  }

  // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
  @Override
  protected void successfulAuthentication(HttpServletRequest req,
                                          HttpServletResponse res,
                                          FilterChain chain,
                                          Authentication auth) throws IOException, ServletException {

    String token = Jwts.builder()
        .setSubject(((CustomUserDetails) auth.getPrincipal()).getUsername())
        .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
        .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
        .compact();
    res.addHeader("Authorization", "Bearer " + token);
  }

}

