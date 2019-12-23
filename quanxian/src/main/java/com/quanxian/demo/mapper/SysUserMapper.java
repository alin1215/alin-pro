package com.quanxian.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quanxian.demo.entity.SysUser;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author alin
 * @since 2019-12-23
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

}
