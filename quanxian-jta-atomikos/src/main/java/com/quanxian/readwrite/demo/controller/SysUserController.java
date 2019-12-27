package com.quanxian.readwrite.demo.controller;


import com.quanxian.readwrite.demo.entity.SysResource;
import com.quanxian.readwrite.demo.entity.SysRole;
import com.quanxian.readwrite.demo.entity.SysUser;
import com.quanxian.readwrite.demo.service.ISysRoleService;
import com.quanxian.readwrite.demo.service.ISysUserService;
import com.quanxian.readwrite.demo.util.MD5Util;
import com.quanxian.readwrite.demo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author alin
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;

    @GetMapping("/user")
    public ResponseResult getById(Integer id) {
        SysUser byId = sysUserService.getById(id);
        return new ResponseResult(byId, "成功", 200);
    }

    @GetMapping("/testAddUser")
    public ResponseResult testAddUser(String username,String roleName,String rname) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);

        SysRole sysRole = new SysRole();
        sysRole.setName(roleName);

        SysResource sysResource = new SysResource();
        sysResource.setMethod(rname);

        sysUserService.testAddUser(sysUser,sysRole,sysResource);
        return new ResponseResult(sysUser.toString()+sysRole.toString(), "成功", 200);
    }



    @PostMapping("/addUser")
    public ResponseResult addUser(@RequestBody SysUser sysUser) {
        if (StringUtils.isEmpty(sysUser.getUserName())||StringUtils.isEmpty(sysUser.getPassword())){
            return new ResponseResult( "用户名或者密码不能为空", 400);
        }
        sysUser.setPassword(MD5Util.md5Encrypt32Lower(sysUser.getPassword()));
        sysUserService.addUser(sysUser);
        return new ResponseResult( "成功", 200);
    }



}
