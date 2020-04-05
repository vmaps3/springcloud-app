package com.wangsong.system.service;

import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.system.model.User;
import com.wangsong.system.model.UserAddModel;
import com.wangsong.system.model.UserPage;
import com.wangsong.system.model.UserRole;
import com.wangsong.system.vo.UserVO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User selectByPrimaryKey(String id);

    void insertUser(UserAddModel muser);

    void updateUser(UserAddModel muser);

    void deleteUser(String[] id);

    void updatePassword(UserAddModel u);

    GetEasyUIData findTByPage(UserPage user);

    UserVO selectVOByPrimaryKey(String id);

    User findTByT(User user);

    void deleteByT(UserRole[] u);


}
