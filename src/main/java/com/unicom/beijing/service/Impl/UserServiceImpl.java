package com.unicom.beijing.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.unicom.beijing.dao.UserRepository;
import com.unicom.beijing.entity.User;
import com.unicom.beijing.service.UserService;
import com.unicom.beijing.util.ResultVO;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResultVO login(String login, String password) {
        if (login == null || login.equals("") || password == null || password.equals("")) {
            return new ResultVO("error", "404", "用户名或密码错误！");
        }
        User user = userRepository.getAllByLogin(login);
        if (user == null) {
            return new ResultVO("error", "404", "用户名或密码错误！");
        }
        if (password.equals(user.getPassword())) {
            return new ResultVO("error", "200", "登录成功！");
        }
        return new ResultVO("error", "404", "用户名或密码错误！");
    }

    @Override
    public ResultVO register(JSONObject jsonObject) {
        try {
            String login = jsonObject.getString("login");
            User isUser = userRepository.getAllByLogin(login);
            if (isUser != null){
                return new ResultVO("error", "200", "用户已存在！");
            }
            String name = jsonObject.getString("name");
            String password = jsonObject.getString("password");
            String identity = jsonObject.getString("identity");
            String phone = jsonObject.getString("phone");
            String company = jsonObject.getString("company");
            String village = jsonObject.getString("address");
            String gender = jsonObject.getString("gender");
            String address = jsonObject.getString("address");

            User user = new User();
            user.setAddress(address);
            user.setCompany(company);
            user.setGender(gender);
            user.setName(name);
            user.setPassword(password);
            user.setIdentity(identity);
            user.setPhone(phone);
            user.setVillage(village);
            user.setLogin(login);
            Date date = new Date();
            user.setCreateTime(date);
            user.setUpdateTime(date);
            userRepository.saveAndFlush(user);
            return new ResultVO("success", "200", "注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVO("error", "404", e.toString());
        }
    }

    @Override
    public ResultVO verify(String login, String password) {
        return null;
    }

    @Override
    public ResultVO changePassword(String login, String password) {
        return null;
    }
}
