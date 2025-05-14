package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.LeaveDto;
import com.wdd.studentManager.entity.LeavePo;
import com.wdd.studentManager.mapper.LeaveMapper;
import com.wdd.studentManager.service.LeaveService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname LeaveServiceImpl
 * @Description None
 * @Date 2019/7/2 15:54
 * @Created by WDD
 */
@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, LeavePo> implements LeaveService {

    @Resource
    private LeaveMapper leaveMapper;

    @Override
    public PageBean<LeaveDto> queryPage(Map<String, Object> paramMap) {
        PageBean<LeaveDto> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<LeaveDto> datas = leaveMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = leaveMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addLeave(LeaveDto leaveDto) {
        return leaveMapper.addLeave(leaveDto);
    }

    @Override
    public int editLeave(LeaveDto leaveDto) {
        return leaveMapper.editLeave(leaveDto);
    }

    @Override
    public int checkLeave(LeaveDto leaveDto) {
        return leaveMapper.checkLeave(leaveDto);
    }

    @Override
    public int deleteLeave(Integer id) {
        return leaveMapper.deleteLeave(id);
    }
}
