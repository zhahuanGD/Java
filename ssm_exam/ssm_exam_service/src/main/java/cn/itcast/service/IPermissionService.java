package cn.itcast.service;

import cn.itcast.pojo.Permission;

import java.util.List;

public interface IPermissionService {
    /*
    查询所有资源信息
     */
    public List<Permission> findPermissionAll(Integer page, Integer pageSize) throws Exception;

    /*
    添加资源信息
     */
    public int savePermission(Permission permission) throws Exception;
    /*
    根据角色id查询当前角色所没有的资源
     */
    public List<Permission> findOtherPermission(String roleid);
}
