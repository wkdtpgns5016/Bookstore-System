package com.example.BookstoreSystem.dao;

import com.example.BookstoreSystem.model.UserAddressDto;
import com.example.BookstoreSystem.model.UserCardDto;
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

    public List<UserAddressDto> selectUserAddressInfo(String userId) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("userId",userId);
        return sqlSession.selectList("com.example.BookstoreSystem.dao.UserDao.selectUserAddressInfo",param);
    }

    public List<UserCardDto> selectUserCardInfo(String userId) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("userId",userId);
        return sqlSession.selectList("com.example.BookstoreSystem.dao.UserDao.selectUserCardInfo",param);
    }

    public int insertUserInfo(UserDto user) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("user",user);
        return sqlSession.insert("com.example.BookstoreSystem.dao.UserDao.insertUserInfo",param);
    }

    public int insertUserAddressInfo(UserAddressDto address) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("address",address);
        return sqlSession.insert("com.example.BookstoreSystem.dao.UserDao.insertUserAddressInfo",param);
    }

    public int insertUserCardInfo(UserCardDto card) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("card",card);
        return sqlSession.insert("com.example.BookstoreSystem.dao.UserDao.insertUserCardInfo",param);
    }

    public int updateUserInfo(UserDto user) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("user",user);
        return sqlSession.update("com.example.BookstoreSystem.dao.UserDao.updateUserInfo",param);
    }

    public int updateUserAddressInfo(UserAddressDto address) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("address",address);
        return sqlSession.update("com.example.BookstoreSystem.dao.UserDao.updateUserAddressInfo",param);
    }

    public int updateUserCardInfo(UserCardDto card) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("card",card);
        return sqlSession.update("com.example.BookstoreSystem.dao.UserDao.updateUserCardInfo",param);
    }

    public int deleteUserInfo(String userId) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("userId",userId);
        return sqlSession.delete("com.example.BookstoreSystem.dao.UserDao.deleteUserInfo",param);
    }

    public int deleteUserAddressInfo(String userId) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("userId",userId);
        return sqlSession.delete("com.example.BookstoreSystem.dao.UserDao.deleteUserAddressInfo",param);
    }

    public int deleteUserCardInfo(String userId) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("userId",userId);
        return sqlSession.delete("com.example.BookstoreSystem.dao.UserDao.deleteUserCardInfo",param);
    }
}