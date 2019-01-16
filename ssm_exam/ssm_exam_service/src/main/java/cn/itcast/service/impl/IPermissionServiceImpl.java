package cn.itcast.service.impl;

import cn.itcast.dao.PermissionMapper;
import cn.itcast.pojo.Permission;
import cn.itcast.pojo.Product;
import cn.itcast.service.IPermissionService;
import cn.itcast.service.IProductservice;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("permissionService")
@Transactional
public class IPermissionServiceImpl implements IPermissionService {

    @Autowired
    @Qualifier("permissionMapper")
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> findPermissionAll(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return permissionMapper.findPermissionAll();
    }

    @Override
    public int savePermission(Permission permission) throws Exception {
        return permissionMapper.savePermission(permission);
    }

    @Override
    public List<Permission> findOtherPermission(String roleid) {
        return permissionMapper.findOtherPermission(roleid);
    }
}
