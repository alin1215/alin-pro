package com.quanxian.demo.controller;


import com.quanxian.demo.entity.SysUser;
import com.quanxian.demo.service.ISysUserService;
import com.quanxian.demo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/user")
    public ResponseResult getById(Integer id) {
        SysUser byId = sysUserService.getById(id);

        return new ResponseResult(byId, "成功", 200);
    }

}
