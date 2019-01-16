package cn.itcast.controller;

import cn.itcast.pojo.Role;
import cn.itcast.pojo.UserInfo;
import cn.itcast.service.IRoleService;
import cn.itcast.service.IUserInfoRoleService;
import cn.itcast.service.IUserInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserInfoRoleService userInfoRoleService;

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<UserInfo> userList = userInfoService.findAllUser(page, pageSize);
        //使用pageInfo对象将分页信息传递到页面
        PageInfo pageInfo = new PageInfo(userList);
        model.addAttribute("userList", pageInfo);
        return "user-list";
    }

    @RequestMapping("/saveUserInfo")
    public String saveUserInfo(UserInfo userInfo) throws Exception {
        userInfoService.saveUserInfo(userInfo);
        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/findUserById")
    public String findUserById(Model model, String id) throws Exception {
        UserInfo userInfo = userInfoService.findUserById(id);
        model.addAttribute("user", userInfo);
        return "user-show";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(Model model, String userid) throws Exception {
        List<Role> roleList = roleService.findOtherRole(userid);
        model.addAttribute("userid", userid);
        model.addAttribute("roleList", roleList);
        return "user-role-add";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, @RequestParam(name = "ids", required = true) List<String> ids) {
        try {
            userInfoRoleService.saveUserInfoRole(userId, ids);
            return "redirect:/user/findAllUser";
        } catch (Exception e) {
            return "user-role";
        }
    }
}
