package com.jianyu.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianyu.dao.UserMapper;
import com.jianyu.entity.UserEntity;

@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper mapper;

    public List<UserEntity> queryList() {
        List<UserEntity> userList = mapper.queryList();
        return userList;
    }

    public UserEntity findById(long userId) {
        System.out.println("userId:" + userId);
        return mapper.findById(userId);
    }

    public int insertEntity() {
        UserEntity entity = new UserEntity();
        entity.setUserName("霍金");
        entity.setUserCode("H00003213");
        entity.setNickName("霍师傅");
        entity.setUserPwd("Root@$^GJK");
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        return mapper.insertEntity(entity);
    }

    public int insertParam() {
        return mapper.insertParam("旺福", "K56632781321");
    }

    public int insertByMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nickName", "老司机");
        map.put("userCode", "L789437432");
        return mapper.insertByMap(map);
    }

    public int updateEntity() {
        UserEntity entity = new UserEntity();
        entity.setUserId(10000006);
        entity.setNickName("林梦");
        return mapper.updateEntity(entity);
    }

    public int deleteEntity() {
        UserEntity entity = new UserEntity();
        entity.setUserId(10000002);
        return mapper.deleteEntity(entity);
    }
}
