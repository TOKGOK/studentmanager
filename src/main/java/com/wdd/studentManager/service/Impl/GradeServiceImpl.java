package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.entity.GradePo;
import com.wdd.studentManager.mapper.GradeMapper;
import com.wdd.studentManager.service.GradeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, GradePo> implements GradeService {

    @Resource
    private GradeMapper gradeMapper;
}
