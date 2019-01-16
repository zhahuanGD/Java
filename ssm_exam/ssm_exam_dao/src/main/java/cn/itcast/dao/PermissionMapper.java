package cn.itcast.dao;

import cn.itcast.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("permissionMapper")
public interface PermissionMapper {
    /*
    根据角色id查询资源信息
     */
    public List<Permission> findPermissionByRoleId(String roleId) throws Exception;

    /*
    查询所有资源信息
     */
    public List<Permission> findPermissionAll() throws Exception;

    /*
    添加资源信息
     */
    public int savePermission(Permission permission) throws Exception;

    /*
    根据角色id查询当前角色所没有的资源
     */
    public List<Permission> findOtherPermission(String roleid);
}
