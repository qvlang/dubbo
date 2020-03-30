package com.lang.dubbo.service.impl;

import com.lang.dubbo.mapper.IUserMapper;
import com.lang.dubbo.model.User;
import com.lang.dubbo.service.IUserService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper mapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public boolean login(String username, String password) {
        return mapper.findUser(username, password) != null;
    }

    //插入一个用户
    @Override
    @Transactional
    public boolean register(User user) {
        int row = mapper.insertUser(user);
        return row > 0;
    }

    //批量插入
    @Override
    public boolean resgisterBatch(List<User> users) {
        //创建一个可以批处理的sqlsession 默认回滚策略： 出现一个错误全部回滚
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        IUserMapper proxyMapper = sqlSession.getMapper(IUserMapper.class);
        int affectRow = 0;
        try {
            for (User user : users) {
                affectRow = proxyMapper.insertUser(user);
            }
            // sqlSession.commit();
        } catch (Exception e) {
            // sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return affectRow > 0;
    }
}
