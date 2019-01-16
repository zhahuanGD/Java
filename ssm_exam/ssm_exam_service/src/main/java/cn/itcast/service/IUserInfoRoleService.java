package cn.itcast.service;

import java.util.List;

public interface IUserInfoRoleService {
    /*
    将用户和角色id添加到关联表中
     */
    public void saveUserInfoRole(String userid, List<String> roleid) throws Exception;
}
