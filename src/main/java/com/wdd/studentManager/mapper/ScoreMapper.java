package com.wdd.studentManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wdd.studentManager.dto.ScoreDto;
import com.wdd.studentManager.dto.ScoreStatsDto;
import com.wdd.studentManager.entity.ScorePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname ScoreMapper
 * @Description None
 * @Date 2019/7/3 11:47
 * @Created by WDD
 */
@Mapper
public interface ScoreMapper extends BaseMapper<ScorePo> {
    List<ScoreDto> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    List<ScoreDto> getAll(ScoreDto scoreDto);

    ScoreStatsDto getAvgStats(String courseid);
}
