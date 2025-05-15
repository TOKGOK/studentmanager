package com.wdd.studentManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdd.studentManager.dto.StudentDto;
import com.wdd.studentManager.entity.StudentPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname StudenetMapper
 * @Description None
 * @Date 2019/6/24 20:09
 * @Created by WDD
 */
@Mapper
public interface StudenetMapper extends BaseMapper<StudentPo> {
    List<StudentDto> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

}
