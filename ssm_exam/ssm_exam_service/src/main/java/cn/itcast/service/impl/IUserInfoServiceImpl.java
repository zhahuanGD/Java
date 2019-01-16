package cn.itcast.service.impl;

import cn.itcast.dao.UserInfoMapper;
import cn.itcast.pojo.UserInfo;
import cn.itcast.service.IUserInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userInfoService")
@Transactional
public class IUserInfoServiceImpl implements IUserInfoService {
    @Autowired
    @Qualifier("userInfoMapper")
    private UserInfoMapper userInfoMapper;

    @Autowired(required = false)
    @Qualifier("passwordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserInfo> findAllUser(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return userInfoMapper.findAllUser();
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoMapper.saveUserInfo(userInfo);
    }

    @Override
    public UserInfo findUserById(String id) throws Exception {
        return userInfoMapper.findUserById(id);
    }
}
