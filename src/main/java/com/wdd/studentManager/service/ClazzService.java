package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.ClazzDto;
import com.wdd.studentManager.entity.ClazzPo;
import com.wdd.studentManager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname ClazzService
 * @Description None
 * @Date 2019/6/26 10:14
 * @Created by WDD
 */
public interface ClazzService extends IService<ClazzPo> {
    PageBean<ClazzDto> queryPage(Map<String, Object> paramMap);

    int addClazz(ClazzDto clazz);

    int deleteClazz(List<String> ids);

    int editClazz(ClazzDto clazz);

    ClazzDto findByName(String clazzName);

}
