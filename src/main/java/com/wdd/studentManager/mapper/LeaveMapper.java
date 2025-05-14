package com.wdd.studentManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdd.studentManager.dto.LeaveDto;
import com.wdd.studentManager.entity.LeavePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname LeaveMapper
 * @Description None
 * @Date 2019/7/2 15:55
 * @Created by WDD
 */
@Mapper
public interface LeaveMapper extends BaseMapper<LeavePo> {
    List<LeaveDto> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addLeave(LeaveDto leaveDto);

    int editLeave(LeaveDto leaveDto);

    int checkLeave(LeaveDto leaveDto);

    int deleteLeave(Integer id);
}
