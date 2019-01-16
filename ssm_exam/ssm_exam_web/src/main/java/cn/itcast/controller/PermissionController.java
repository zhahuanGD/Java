package cn.itcast.controller;

import cn.itcast.pojo.Permission;
import cn.itcast.service.IPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAllPermission")
    public String findAllPermission(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<Permission> permissionList = permissionService.findPermissionAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(permissionList);
        model.addAttribute("permissionList", pageInfo);
        return "permission-list";

    }

    @RequestMapping("/savePermission")
    public String savePermission(Permission permission) throws Exception {
        int n = permissionService.savePermission(permission);
        if (n > 0) {
            return "redirect:/permission/findAllPermission";
        }
        return "permission-add";
    }
}
