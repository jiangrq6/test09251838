package com.unicom.beijing.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.unicom.beijing.dao.UserRepository;
import com.unicom.beijing.dao.VerifyCodeRepository;
import com.unicom.beijing.entity.User;
import com.unicom.beijing.entity.VerifyCode;
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

    @Autowired
    private VerifyCodeRepository verifyCodeRepository;

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
            if (isUser != null) {
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
    public ResultVO verify(String login) {
        if (login == null || login.equals("")) {
            return new ResultVO("error", "404", "信息错误！");
        }
        User user = userRepository.getAllByLogin(login);
        if (user == null) {
            return new ResultVO("error", "404", "用户名或密码错误！");
        }
        VerifyCode verifyCode = verifyCodeRepository.getAllByLogin(login);
        if (verifyCode != null) {
            verifyCode.setState("done");
            verifyCodeRepository.save(verifyCode);
        }
        VerifyCode newVerifyCode = new VerifyCode();
        newVerifyCode.setState("pending");
        newVerifyCode.setLogin(login);
        double code = Math.random() * 100000;
        String vCode = "" + (int) code;
        newVerifyCode.setvCode(vCode);
        Date date = new Date();
        newVerifyCode.setCreateTime(date);
        newVerifyCode.setUdpateTime(date);
        verifyCodeRepository.saveAndFlush(newVerifyCode);
        return new ResultVO("success", "200", vCode);
    }

    @Override
    public ResultVO changePassword(String login, String password) {
        if (login == null || login.equals("") || password == null || password.equals("")) {
            return new ResultVO("error", "404", "信息错误！");
        }
        User user = userRepository.getAllByLogin(login);
        if (user == null) {
            return new ResultVO("error", "404", "用户名或密码错误！");
        }
        user.setPassword(password);
        userRepository.saveAndFlush(user);
        return new ResultVO("success", "200", "密码更改成功！");
    }
}
