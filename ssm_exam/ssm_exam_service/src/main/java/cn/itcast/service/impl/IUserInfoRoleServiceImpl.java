package cn.itcast.service.impl;

import cn.itcast.dao.UserInfoRoleMapper;
import cn.itcast.service.IUserInfoRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userinfoRoleService")
@Transactional
public class IUserInfoRoleServiceImpl implements IUserInfoRoleService {
    @Autowired
    @Qualifier("userInfoRoleMapper")
    private UserInfoRoleMapper userInfoRoleMapper;

    @Override
    public void saveUserInfoRole(String userid, List<String> roleid) throws Exception {
        for (String rid : roleid) {
            userInfoRoleMapper.saveUserInfoRole(userid, rid);
        }
    }
}
