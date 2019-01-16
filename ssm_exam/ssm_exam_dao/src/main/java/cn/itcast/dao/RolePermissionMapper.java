package cn.itcast.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/RolePermissionMapper")
public interface RolePermissionMapper {
    /*
    角色资源锁定
     */
    public void addPermissionToRole(@Param("roleid") String roleid, @Param("permissionId") String permissionId) throws Exception;
}
