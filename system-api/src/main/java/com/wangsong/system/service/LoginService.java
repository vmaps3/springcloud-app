package com.wangsong.system.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {


    void logoutJSON();

    String getStatus(HttpServletRequest request);
}
