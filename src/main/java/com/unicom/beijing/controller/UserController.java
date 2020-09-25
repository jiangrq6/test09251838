package com.unicom.beijing.controller;

import com.alibaba.fastjson.JSONObject;
import com.unicom.beijing.service.UserService;
import com.unicom.beijing.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO login(@RequestParam String login,
                          @RequestParam String password){
        return userService.login(login,password);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO register(@RequestBody JSONObject jsonObject){
        return userService.register(jsonObject);
    }

    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO verify(@RequestParam String login,
                           @RequestParam String vCode){
        return userService.verify(login,vCode);
    }

    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO changePassword(){
        return null;
    }
}
