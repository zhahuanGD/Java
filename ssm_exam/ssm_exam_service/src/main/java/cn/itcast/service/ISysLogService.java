package cn.itcast.service;

import cn.itcast.pojo.SysLog;

import java.util.List;

public interface ISysLogService {
    /*
  添加日志
   */
    public void saveSysLog(SysLog sysLog) throws Exception;

    /*
    查询所有日志信息
     */
    public List<SysLog> findLogAll(Integer page, Integer pageSize) throws Exception;
}
