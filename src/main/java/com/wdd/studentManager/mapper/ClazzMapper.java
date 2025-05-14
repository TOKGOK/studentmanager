package com.wdd.studentManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdd.studentManager.dto.ClazzDto;
import com.wdd.studentManager.entity.ClazzPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname ClazzMapper
 * @Description None
 * @Date 2019/6/24 20:09
 * @Created by WDD
 */
@Mapper
public interface ClazzMapper extends BaseMapper<ClazzPo> {
    List<ClazzDto> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int deleteClazz(List<String> ids);

    ClazzDto findByName(String clazzName);
}
