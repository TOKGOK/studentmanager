package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.ScoreDto;
import com.wdd.studentManager.dto.ScoreStatsDto;
import com.wdd.studentManager.entity.ScorePo;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname ScoreService
 * @Description None
 * @Date 2019/7/3 11:45
 * @Created by WDD
 */
public interface ScoreService extends IService<ScorePo> {
    PageBean<ScoreDto> queryPage(Map<String, Object> paramMap);

    boolean isScore(ScoreDto scoreDto);

    int addScore(ScoreDto scoreDto);

    int editScore(ScoreDto scoreDto);

    int deleteScore(String id);

    List<ScoreDto> getAll(ScoreDto scoreDto);

    ScoreStatsDto getAvgStats(String courseid);
}
