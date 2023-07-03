package com.example.study_springboot.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SharedDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate; // mybatis
    SharedDao sharedDao;

    public Object getList(String sqlMapId, Object dataMap){ // 레코드 여러개 가져올 때 getList 호출
        Object result = sqlSessionTemplate.selectList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(String sqlMapId, Object dataMap){ // 레코드 하나일때 getone 호출
        Object result = sqlSessionTemplate.selectOne(sqlMapId, dataMap);
        return result;
    }

    public Object update(String sqlMapId, Object dataMap){ // 수정할때
        Object result = sqlSessionTemplate.update(sqlMapId, dataMap);
        return result;
    }
    
    public Object insert(String sqlMapId, Object dataMap){ // 만듦
        Object result = sqlSessionTemplate.insert(sqlMapId, dataMap);
        return result;
    }

    public Object delete(String sqlMapId, Object dataMap){ // 삭제
        Object result = sqlSessionTemplate.delete(sqlMapId, dataMap);
        return result;
    }
}
