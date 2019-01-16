package cn.itcast.service.impl;

import cn.itcast.pojo.Permission;
import cn.itcast.service.IPermissionService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_config_service.xml")
public class IPermissionServiceImplTest {
    @Autowired
    private IPermissionService permissionService;

    @Test
    public void findPermissionAll() throws Exception {
        List<Permission> permissionAll = permissionService.findPermissionAll(1,5);
        for (Permission permission : permissionAll) {
            System.out.println(permission);
        }
    }

}