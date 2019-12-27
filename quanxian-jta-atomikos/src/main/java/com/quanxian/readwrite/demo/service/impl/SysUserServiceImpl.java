package com.quanxian.readwrite.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quanxian.readwrite.demo.entity.SysResource;
import com.quanxian.readwrite.demo.entity.SysRole;
import com.quanxian.readwrite.demo.entity.SysUser;
import com.quanxian.readwrite.demo.mapper.master.SysRoleMapper;
import com.quanxian.readwrite.demo.mapper.master.SysUserMapper;
import com.quanxian.readwrite.demo.mapper.slave1.SysResourceMapper;
import com.quanxian.readwrite.demo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysResourceMapper sysResourceMapper;

    public void addUser(SysUser sysUser){
        sysUserMapper.insert(sysUser);
    }

    @Override
    @Transactional/*(transactionManager = "xatx")*/
    public void testAddUser(SysUser sysUser, SysRole sysRole,SysResource sysResource) {
        sysResourceMapper.insert(sysResource);
        sysUserMapper.insert(sysUser);
        int i =1/0;
        sysRoleMapper.insert(sysRole);


    }
}
