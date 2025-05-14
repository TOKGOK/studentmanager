package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.ScoreDto;
import com.wdd.studentManager.domain.ScoreStats;
import com.wdd.studentManager.entity.ScorePo;
import com.wdd.studentManager.mapper.ScoreMapper;
import com.wdd.studentManager.service.ScoreService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
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
        ScoreDto sc = scoreMapper.isScore(scoreDto);
        if(sc != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int addScore(ScoreDto scoreDto) {
        return scoreMapper.addScore(scoreDto);
    }

    @Override
    public int editScore(ScoreDto scoreDto) {
        return scoreMapper.editScore(scoreDto);
    }

    @Override
    public int deleteScore(Integer id) {
        return scoreMapper.deleteScore(id);
    }

    @Override
    public List<ScoreDto> getAll(ScoreDto scoreDto) {
        return scoreMapper.getAll(scoreDto);
    }

    @Override
    public ScoreStats getAvgStats(Integer courseid) {
        return scoreMapper.getAvgStats(courseid);
    }
}
