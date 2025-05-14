package com.wdd.studentManager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wdd.studentManager.dto.AdminDto;
import com.wdd.studentManager.entity.AdminPo;

/**
 * @Classname AdminService
 * @Description None
 * @Date 2019/6/25 11:07
 * @Created by WDD
 */
public interface AdminService extends IService<AdminPo> {

    AdminDto findByAdmin(AdminDto admin);

    int editPasswordByAdmin(AdminPo admin);
}
