package cn.itcast.service;

import cn.itcast.pojo.UserInfo;

import java.util.List;

public interface IUserInfoService {
    /*
    查询所有用户
     */
    public List<UserInfo> findAllUser(Integer page, Integer pageSize) throws Exception;

    /*
    添加用户
     */
    public void saveUserInfo(UserInfo userInfo) throws Exception;

    /*
    根据id查询用户信息
     */
    public UserInfo findUserById(String id) throws Exception;
}
