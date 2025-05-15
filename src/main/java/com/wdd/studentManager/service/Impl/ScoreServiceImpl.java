package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.ScoreDto;
import com.wdd.studentManager.dto.ScoreStatsDto;
import com.wdd.studentManager.entity.ScorePo;
import com.wdd.studentManager.mapper.ScoreMapper;
import com.wdd.studentManager.service.ScoreService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname ScoreServiceImpl
 * @Description None
 * @Date 2019/7/3 11:45
 * @Created by WDD
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, ScorePo> implements ScoreService {

    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public PageBean<ScoreDto> queryPage(Map<String, Object> paramMap) {
        PageBean<ScoreDto> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<ScoreDto> datas = scoreMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = scoreMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public boolean isScore(ScoreDto scoreDto) {
        LambdaQueryWrapper<ScorePo> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(ScorePo::getCourseId,scoreDto.getCourseId())
                .eq(ScorePo::getStudentId,scoreDto.getStudentId());
        ScorePo scorePo = scoreMapper.selectOne(wrapper);
        return scorePo != null;
    }

    @Override
    public int addScore(ScoreDto scoreDto) {
        ScorePo scorePo = new ScorePo();
        BeanUtils.copyProperties(scoreDto,scorePo);
        return save(scorePo) ? 1 : 0;
    }

    @Override
    public int editScore(ScoreDto scoreDto) {
        ScorePo scorePo = new ScorePo();
        BeanUtils.copyProperties(scoreDto,scorePo);
        return saveOrUpdate(scorePo) ? 1 : 0;
    }

    @Override
    public int deleteScore(String id) {
        return removeById(id) ? 1 : 0;
    }

    @Override
    public List<ScoreDto> getAll(ScoreDto scoreDto) {
        return scoreMapper.getAll(scoreDto);
    }

    @Override
    public ScoreStatsDto getAvgStats(String courseId) {
        return scoreMapper.getAvgStats(courseId);
    }
}
