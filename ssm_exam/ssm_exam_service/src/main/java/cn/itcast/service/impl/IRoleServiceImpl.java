package cn.itcast.service.impl;

import cn.itcast.dao.RoleMapper;
import cn.itcast.pojo.Role;
import cn.itcast.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleAll(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return roleMapper.findRoleAll();
    }

    @Override
    public int saveRole(Role role) throws Exception {
        return roleMapper.saveRole(role);
    }

    @Override
    public Role findByRoleId(String id) throws Exception {
        return roleMapper.findByRoleId(id);
    }

    @Override
    public List<Role> findOtherRole(String userid) throws Exception {
        return roleMapper.findOtherRole(userid);
    }

}
