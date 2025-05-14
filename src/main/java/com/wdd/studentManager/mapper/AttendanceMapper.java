package com.wdd.studentManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdd.studentManager.dto.AttendanceDto;
import com.wdd.studentManager.entity.AttendancePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname AttendanceMapper
 * @Description None
 * @Date 2019/7/1 15:49
 * @Created by WDD
 */
@Mapper
public interface AttendanceMapper extends BaseMapper<AttendancePo> {
    List<AttendanceDto> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int deleteAttendance(String id);
}
