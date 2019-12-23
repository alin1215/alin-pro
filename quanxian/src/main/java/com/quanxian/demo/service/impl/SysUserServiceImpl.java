package com.quanxian.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quanxian.demo.entity.SysUser;
import com.quanxian.demo.mapper.SysUserMapper;
import com.quanxian.demo.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author alin
 * @since 2019-12-23
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
