package cn.itcast.service;

import cn.itcast.pojo.Role;

import java.util.List;

public interface IRoleService {
    /*
    查询所有角色信息
     */
    public List<Role> findRoleAll(Integer page, Integer pageSize) throws Exception;

    /*
    添加角色
     */
    public int saveRole(Role role) throws Exception;

    public Role findByRoleId(String id) throws Exception;

    /*
   根据用户id查询出当前用户所没有的角色信息
    */
    public List<Role> findOtherRole(String userid) throws Exception;
}
