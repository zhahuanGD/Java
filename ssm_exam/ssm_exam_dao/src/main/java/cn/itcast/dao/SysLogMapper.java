package cn.itcast.dao;

import cn.itcast.pojo.SysLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/sysLogMapper")
public interface SysLogMapper {
    /*
    添加日志
     */
    public void saveSysLog(SysLog sysLog) throws Exception;

    /*
    查询所有日志信息
     */
    public List<SysLog> findLogAll() throws Exception;
}
