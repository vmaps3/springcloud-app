package com.wangsong.system.vo;

import java.util.List;

import com.wangsong.system.entity.User;
import com.wangsong.system.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends User {
    private List<UserRole> UserRoleList;
}
