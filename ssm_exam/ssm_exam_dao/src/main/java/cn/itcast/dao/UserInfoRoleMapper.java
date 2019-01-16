package cn.itcast.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/userInfoRoleMapper")
public interface UserInfoRoleMapper {
    /*
    将用户和角色id添加到关联表
     */
    public void saveUserInfoRole(@Param("userid") String userid, @Param("roleid") String roleid) throws Exception;
}
