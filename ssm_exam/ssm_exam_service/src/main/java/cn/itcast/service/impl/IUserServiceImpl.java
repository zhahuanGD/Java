package cn.itcast.service.impl;

import cn.itcast.dao.UserInfoMapper;
import cn.itcast.pojo.Role;
import cn.itcast.pojo.UserInfo;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userInfoMapper")
    private UserInfoMapper userInfoMapper;

    /**
     * 参数为用户名
     * 传递过来的用户名
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        User user = null;
        try {
            userInfo = userInfoMapper.findUserInfoByName(username);
            List<Role> roleList = userInfo.getRoles();
            List<SimpleGrantedAuthority> authorities = getAuthority(roleList);
            user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, authorities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 模拟权限
     *
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authorities;
    }
}
