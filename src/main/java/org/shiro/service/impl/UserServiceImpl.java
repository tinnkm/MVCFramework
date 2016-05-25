package org.shiro.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.shiro.dao.UserMapper;
import org.shiro.generic.GenericDao;
import org.shiro.generic.GenericServiceImpl;
import org.shiro.model.User;
import org.shiro.model.UserExample;
import org.shiro.service.UserService;
import org.springframework.stereotype.Service;


/**
 * 用户Service实现类
 *
 * @author StarZou
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User model) {
        return userMapper.insertSelective(model);
    }

    @Override
    public int update(User model) {
        return userMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User authentication(User user) {
        return userMapper.authentication(user);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public GenericDao<User, Long> getDao() {
        return userMapper;
    }

    @Override
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        final List<User> list = userMapper.selectByExample(example);
        return list.get(0);
    }

    @Override
    public User selectByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey((long) userId);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.selectByExample(null);
    }
}
