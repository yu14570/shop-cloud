package com.yxd.order.service.impl;

import com.yxd.bo.UserBO;
import com.yxd.enmus.Sex;
import com.yxd.mapper.UsersMapper;
import com.yxd.pojo.Users;
import com.yxd.order.service.UserService;
import com.yxd.utils.DateUtil;
import com.yxd.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;
    @Autowired
    private Sid sid;

    private String face = "https://profile.csdnimg.cn/E/E/F/3_yjn1995";

    @Transactional(propagation = Propagation.SUPPORTS)//查询用事务
    @Override//查询用户名是否存在
    public boolean queryUserNameIsExist(String username) {
        //可以使用Example条件查询
        Example userExample = new Example(Users.class);
        //即为条件对象，可以设置各个字段条件
        Example.Criteria userCreteria = userExample.createCriteria();
            //andEqualTo 判断是否等于的条件
        userCreteria.andEqualTo("username", username);
        Users result = usersMapper.selectOneByExample(userExample);
        return result == null ? false : true;
    }

    @Override //使用BO对象承接用户上传数据
    public Users createUse(UserBO userBO) {
        //获取用户信息保存进数据库
        Users users = new Users();
        users.setId(sid.nextShort());//设置ID
        users.setUsername(userBO.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        users.setNickname(userBO.getUsername());
//        users.setRealname();
        users.setFace(face);
//        users.setMobile();
//        users.setEmail();
        users.setSex(Sex.secret.type); //使用枚举性别
        users.setBirthday(DateUtil.stringToDate("1994-01-01"));
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());
        int res = usersMapper.insert(users);
        if(res != 1){
//            log.info("新增用户失败");
        }
        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override//根据用户名和密码查询用户，登录验证
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        //多个条件查询数据
        userCriteria.andEqualTo("username",username);
        userCriteria.andEqualTo("password",password);
        Users result = usersMapper.selectOneByExample(userExample);
        return result;
    }
}
