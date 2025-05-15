package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.LeaveDto;
import com.wdd.studentManager.entity.LeavePo;
import com.wdd.studentManager.mapper.LeaveMapper;
import com.wdd.studentManager.service.LeaveService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
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
        List<LeaveDto> data = leaveMapper.queryList(paramMap);
        pageBean.setDatas(data);

        Integer totalSize = leaveMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalSize);
        return pageBean;
    }

    @Override
    public int addLeave(LeaveDto leaveDto) {
        LeavePo leavePo = new LeavePo();
        BeanUtils.copyProperties(leaveDto,leavePo);
        return save(leavePo) ? 1 : 0;
    }

    @Override
    public int editLeave(LeaveDto leaveDto) {
        LeavePo leavePo = new LeavePo();
        BeanUtils.copyProperties(leaveDto,leavePo);
        return saveOrUpdate(leavePo) ? 1 : 0;
    }

    @Override
    public int checkLeave(LeaveDto leaveDto) {
        return leaveMapper.checkLeave(leaveDto);
    }

    @Override
    public int deleteLeave(String id) {
        return removeById(id) ? 1 : 0;
    }
}
