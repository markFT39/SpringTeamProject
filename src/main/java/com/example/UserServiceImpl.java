package com.example;

import com.example.dao.UserDAO;
import com.example.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    UserDAO userDAO;
    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }

    public int addUser(UserVO vo) { return userDAO.addUser(vo); }

    public UserVO useridCheck(UserVO vo) { return userDAO.useridCheck(vo); };
}
