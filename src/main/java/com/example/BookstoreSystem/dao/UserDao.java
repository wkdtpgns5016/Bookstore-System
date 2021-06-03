package com.example.BookstoreSystem.dao;

import com.example.BookstoreSystem.model.UserAddressDto;
import com.example.BookstoreSystem.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public class UserDao {
    private SqlSession sqlSession;
    public UserDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public List<UserDto> selectUserList() {
        return sqlSession.selectList("com.example.BookstoreSystem.dao.UserDao.selectUserList");
    }

    public UserDto selectUserInfo(String userId) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("userId",userId);
        return sqlSession.selectOne("com.example.BookstoreSystem.dao.UserDao.selectUserInfo",param);
    }

    public List<UserAddressDto> selectUserAddressList() {
        return sqlSession.selectList("com.example.BookstoreSystem.dao.UserDao.selectUserAddressList");
    }

    public List<UserAddressDto> selectUserAddressInfo(String userId) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("userId",userId);
        return sqlSession.selectList("com.example.BookstoreSystem.dao.UserDao.selectUserAddressInfo",param);
    }
}