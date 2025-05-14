package com.wdd.studentManager.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wdd.studentManager.dto.AdminDto;
import com.wdd.studentManager.entity.AdminPo;
import com.wdd.studentManager.mapper.AdminMapper;
import com.wdd.studentManager.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description None
 * @Date 2019/6/25 11:08
 * @Created by WDD
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminPo> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public AdminDto findByAdmin(AdminDto admin){
        if (admin==null){
            log.error("admin is null");
            throw new RuntimeException("admin is null");
        }
        if (admin.getPassword()==null || admin.getUsername()==null){
            log.error("admin password is null");
            throw new RuntimeException("admin password is null");
        }
        LambdaQueryWrapper<AdminPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(AdminPo::getUsername,admin.getUsername());
        queryWrapper.eq(AdminPo::getPassword,admin.getPassword());
        AdminPo adminPo = adminMapper.selectOne(queryWrapper);
        if (adminPo==null){
            log.error("admin is null");
            throw new RuntimeException("admin is null");
        }
        AdminDto adminDto = new AdminDto();
        BeanUtils.copyProperties(adminPo,adminDto);
        return adminDto;
    }

    public int editPasswordByAdmin(AdminPo admin){
        return saveOrUpdate(admin) ? 1 : 0;
    }



}
