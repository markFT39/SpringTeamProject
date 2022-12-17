package com.example.dao;

import com.example.vo.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    @Autowired
    SqlSessionTemplate sqlSession;
    public UserVO getUser(UserVO vo) {
        return sqlSession.selectOne("User.getUser", vo);
    }

    public UserVO useridCheck(UserVO vo) { return sqlSession.selectOne("User.useridCheck", vo); }

    public int addUser(UserVO vo) { return sqlSession.insert("User.addUser", vo); }

}
