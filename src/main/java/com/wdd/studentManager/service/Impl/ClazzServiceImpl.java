package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.ClazzDto;
import com.wdd.studentManager.entity.ClazzPo;
import com.wdd.studentManager.mapper.ClazzMapper;
import com.wdd.studentManager.service.ClazzService;
import com.wdd.studentManager.util.PageBean;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Classname ClazzServiceImpl
 * @Description None
 * @Date 2019/6/26 10:14
 * @Created by WDD
 */
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, ClazzPo> implements ClazzService {

    @Resource
    private ClazzMapper clazzMapper;

    @Override
    public PageBean<ClazzDto> queryPage(Map<String, Object> paramMap) {
        PageBean<ClazzDto> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<ClazzDto> data = clazzMapper.queryList(paramMap);
        pageBean.setDatas(data);

        Integer totalSize = clazzMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalSize);
        return pageBean;
    }

    @Override
    public int addClazz(ClazzDto clazz) {
        ClazzPo clazzPo = new ClazzPo();
        BeanUtils.copyProperties(clazz,clazzPo);
        return save(clazzPo) ? 1 : 0;
    }

    @Override
    @Transactional
    public int deleteClazz(List<String> ids) {
        return clazzMapper.deleteClazz(ids);
    }

    @Override
    public int editClazz(ClazzDto clazz) {
        ClazzPo clazzPo = new ClazzPo();
        BeanUtils.copyProperties(clazz,clazzPo);
        return saveOrUpdate(clazzPo) ? 1 : 0;
    }

    @Override
    public ClazzDto findByName(String clazzName) {
        return clazzMapper.findByName(clazzName);
    }

}
