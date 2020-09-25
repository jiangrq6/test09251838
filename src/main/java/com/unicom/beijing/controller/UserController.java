package com.unicom.beijing.controller;

import com.unicom.beijing.util.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO login(@RequestParam String login,
                          @RequestParam String password){
        return null;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO register(){
        return null;
    }

    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO verify(){
        return null;
    }

    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO changePassword(){
        return null;
    }
}
