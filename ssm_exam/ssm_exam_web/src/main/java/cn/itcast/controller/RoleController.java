package cn.itcast.controller;

import cn.itcast.pojo.Permission;
import cn.itcast.pojo.Role;
import cn.itcast.pojo.UserInfo;
import cn.itcast.service.IPermissionService;
import cn.itcast.service.IRolePermissionService;
import cn.itcast.service.IRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IRolePermissionService rolePermissionService;

    @RequestMapping("/findRoleAll")
    public String findAll(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<Role> roleList = roleService.findRoleAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(roleList);
        model.addAttribute("roleList", pageInfo);
        return "role-list";
    }

    @RequestMapping("/saveRole")
    public String saveRole(Role role) throws Exception {
        int n = roleService.saveRole(role);
        if (n > 0) {
            return "redirect:/role/findRoleAll";
        }
        return "role-add";
    }

    @RequestMapping("/findByRoleId")
    public String findByRoleId(Model model, String id) throws Exception {
        Role roleList = roleService.findByRoleId(id);
        model.addAttribute("roleList", roleList);
        return "role-show";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(Model model, String roleid) throws Exception {
        List<Permission> permissionsList = permissionService.findOtherPermission(roleid);
        model.addAttribute("roleid", roleid);
        model.addAttribute("permissionsList", permissionsList);
        return "role-permission-add";
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleid", required = true) String roleid, @RequestParam(name = "ids", required = true) List<String> ids) {
        try {
            System.out.println(roleid);
            System.out.println(ids);
            rolePermissionService.addPermissionToRole(roleid, ids);
            return "redirect:/role/findRoleAll";
        } catch (Exception e) {
            e.printStackTrace();
            return "role-permission-add";
        }
    }
}
