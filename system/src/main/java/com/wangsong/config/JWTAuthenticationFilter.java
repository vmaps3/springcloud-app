package com.wangsong.config;


import com.wangsong.system.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 * @author zhaoxinguo on 2017/9/13.
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
  private UserService userService;
  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    super(authenticationManager);
  }

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
    super(authenticationManager);
    this.userService=userService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    String header = request.getHeader("Authorization");

    if (header == null || !header.startsWith("Bearer ")) {
      chain.doFilter(request, response);
      return;
    }

    UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(request, response);

  }

  private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    if (token != null) {
      // parse the token.
      String user = Jwts.parser()
          .setSigningKey("MyJwtSecret")
          .parseClaimsJws(token.replace("Bearer ", ""))
          .getBody()
          .getSubject();

      if (user != null) {
        UserDetails userDetails = userService.loadUserByUsername(user);
        return new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities());
      }
      return null;
    }
    return null;
  }

}

