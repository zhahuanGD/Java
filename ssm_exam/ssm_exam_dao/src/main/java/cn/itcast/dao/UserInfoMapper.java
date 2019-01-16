package cn.itcast.dao;

import cn.itcast.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userInfoMapper")
public interface UserInfoMapper {
    /*
    根据用户查询用户信息
     */
    public UserInfo findUserInfoByName(String userName) throws Exception;

    /*
    查询所有用户
     */
    public List<UserInfo> findAllUser() throws Exception;

    /*
    添加用户
     */
    public void saveUserInfo(UserInfo userInfo) throws Exception;

    /*
    根据id查询用户信息
     */
    public UserInfo findUserById(String id) throws Exception;


    public UserInfo findUserInfoById(String id) throws Exception;

}
