package cn.itcast.service.impl;

import cn.itcast.dao.SysLogMapper;
import cn.itcast.pojo.SysLog;
import cn.itcast.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ISysLogServiceImpl implements ISysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void saveSysLog(SysLog sysLog) throws Exception {
        sysLogMapper.saveSysLog(sysLog);

    }

    @Override
    public List<SysLog> findLogAll(Integer page, Integer pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return sysLogMapper.findLogAll();
    }
}
