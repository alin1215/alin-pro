package com.quanxian.jtaatomikos.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.quanxian.jtaatomikos.demo.entity.SysResource;
import com.quanxian.jtaatomikos.demo.entity.SysRole;
import com.quanxian.jtaatomikos.demo.entity.SysUser;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author alin
 * @since 2019-12-23
 */
public interface ISysUserService extends IService<SysUser> {
    public void addUser(SysUser sysUser);

    public void testAddUser(SysUser sysUser, SysRole sysRole, SysResource sysResource);

}
