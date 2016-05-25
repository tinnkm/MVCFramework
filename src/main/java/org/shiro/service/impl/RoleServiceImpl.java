package org.shiro.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.shiro.dao.RoleMapper;
import org.shiro.generic.GenericDao;
import org.shiro.generic.GenericServiceImpl;
import org.shiro.model.Role;
import org.shiro.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public GenericDao<Role, Long> getDao() {
        return roleMapper;
    }

    @Override
    public List<Role> selectRolesByUserId(Long userId) {
        return roleMapper.selectRolesByUserId(userId);
    }

}
