package com.bjsxt.service.impl;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuxw
 * @Date: 2020-10-10
 * @Description: com.bjsxt.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void showUser(Users user) {
        System.out.println(user);
    }
}
