package cn.itcast.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRolePermissionService {
    /*
   角色资源锁定
    */
    public void addPermissionToRole(String roleid, List<String> pags) throws Exception;
}
