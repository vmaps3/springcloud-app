package com.wangsong.system.api;

import com.wangsong.common.model.Result;
import com.wangsong.system.model.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("system")
public interface SystemAPI extends UserDetailsService {


    @RequestMapping(value = "/api/getUser", method = RequestMethod.POST)
    Result<UserDetails> getUser(String user);


}