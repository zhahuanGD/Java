package cn.itcast.controller;

import cn.itcast.pojo.SysLog;
import cn.itcast.service.ISysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/showLogList")
    public String showLogList(Model model, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        List<SysLog> sysLogsList = sysLogService.findLogAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(sysLogsList);
        model.addAttribute("sysLogs", pageInfo);
        return "syslog-list";
    }
}
