package cn.itcast.service;

import cn.itcast.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


public interface IUserService extends UserDetailsService {

}
