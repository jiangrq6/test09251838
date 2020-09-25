package com.unicom.beijing.service;

import com.alibaba.fastjson.JSONObject;
import com.unicom.beijing.util.ResultVO;

public interface UserService {

    ResultVO login(String login,String password);
    ResultVO register(JSONObject jsonObject);
    ResultVO verify(String login,String vCode);
    ResultVO changePassword(String login,String password);

}
