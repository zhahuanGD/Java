package cn.itcast.dao;

import cn.itcast.pojo.Role;

import java.util.List;

public interface RoleMapper {
    /*
    根据用户id的查询角色信息
     */
    public List<Role> findRoleByUserId(String userid) throws Exception;

    /*
    查询所有角色信息
     */
    public List<Role> findRoleAll() throws Exception;

    /*
    添加用户
     */
    public int saveRole(Role role) throws Exception;

    public Role findByRoleId(String id) throws Exception;

    /*
    根据用户id查询出当前用户所没有的角色信息
     */
    public List<Role> findOtherRole(String userid) throws Exception;
}
