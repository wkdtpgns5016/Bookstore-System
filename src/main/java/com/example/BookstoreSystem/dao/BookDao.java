package com.example.BookstoreSystem.dao;

import com.example.BookstoreSystem.model.BookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public class BookDao {
    private SqlSession sqlSession;
    public BookDao(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public List<BookDto> selectBookList() {
        return sqlSession.selectList("com.example.BookstoreSystem.dao.BookDao.selectBookList");
    }

    public BookDto selectBookInfo(int bookId) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("bookId",bookId);
        return sqlSession.selectOne("com.example.BookstoreSystem.dao.BookDao.selectBookInfo",param);
    }

    public int insertBookInfo(BookDto book) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("book",book);
        return sqlSession.insert("com.example.BookstoreSystem.dao.BookDao.insertBookInfo",param);
    }

    public int updateBookInfo(BookDto book) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("book",book);
        return sqlSession.insert("com.example.BookstoreSystem.dao.BookDao.updateBookInfo",param);
    }

    public int deleteBookInfo(int bookId) {
        HashMap<String, Object> param = new HashMap<>();
        param.put("bookId",bookId);
        return sqlSession.delete("com.example.BookstoreSystem.dao.BookDao.deleteBookInfo",param);
    }
}
