package cn.itcast.service.impl;

import cn.itcast.dao.RolePermissionMapper;
import cn.itcast.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("/RolePermissionMapperServiceImpl")
@Transactional
public class RolePermissionMapperServiceImpl implements IRolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public void addPermissionToRole(String roleid, List<String> pags) throws Exception {
        for (String permissionId : pags) {
            rolePermissionMapper.addPermissionToRole(roleid, permissionId);
        }
    }
}
