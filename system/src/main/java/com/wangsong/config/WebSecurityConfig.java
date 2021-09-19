package com.wangsong.config;


import com.wangsong.system.service.IUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 * @author zhaoxinguo on 2017/9/13.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled =true)//激活方法上的PreAuthorize注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private IUserService userService;


  public WebSecurityConfig(IUserService userService) {
    this.userService = userService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.headers().frameOptions().disable();
    http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers("/html/**","/api/**","/hystrix.stream","/actuator/health").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JWTLoginFilter(authenticationManager(),userService))
        .addFilter(new JWTAuthenticationFilter(authenticationManager(),userService));
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
      //对密码进行加密
      @Override
      public String encode(CharSequence charSequence) {
        System.out.println(charSequence.toString());
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
      }
      //对密码进行判断匹配
      @Override
      public boolean matches(CharSequence charSequence, String s) {
        String encode = DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
        boolean res = s.equals( encode );
        return res;
      }
    } );
  }


}


