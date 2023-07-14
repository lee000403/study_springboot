package com.example.study_springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboot.dao.SharedDao;

@Service
@Transactional
public class CarInforsService {
    @Autowired // 네이밍 룰이 안겹치게 설정해주기.
    SharedDao sharedDao;

    // foreach HashMap.put("CAR_INFOR_ID_LIST", CAR_INFOR_ID_LIST)
    public Object selectInUID(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectInUID";

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // 검색(조건-search : YEAR, CAR_NAME)
    public Object selectSearch(Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectSearch";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    // 검색(조건-search : YEAR, CAR_NAME)
    public Object selectSearch(String search, String words) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectSearch";
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("search", search);
        dataMap.put("words", words);
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectAll(String CAR_INFOR_ID) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectAll";
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectDetail(String CAR_INFOR_ID) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarInfors.selectByUID"; // xml 파일에서 namespace 랑 해당 id를 결합해서 유니크한 id를 만들어서 사용한다.
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);
        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object insert(Map dataMap) {
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object update(Map dataMap) {
        String sqlMapId = "CarInfors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    // MVC VIEW에 사용된다.
    public Object delete(Map dataMap) {
        String sqlMapId = "CarInfors.delete";

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    // MVC (delete and select 함께 프로젝트에 이런 방식 사용 사용. 위의 delete 함수를 활용한 것)
    public Object deleteAndSelectSearch(Map dataMap) { // 원자화된 delete 나 selectSearch 등의 함수를 사용하는 것이다.
        HashMap result = new HashMap<>();
        // String sqlMapId = "CarInfors.delete";
        // result.put("deletecount", sharedDao.delete(sqlMapId, dataMap));
        result.put("deletecount", this.delete(dataMap));

        // sqlMapId = "CarInfors.search";
        // result.put("resultList", sharedDao.getOne(sqlMapId, dataMap));
        result.put("resultList", this.selectSearch(dataMap));
        return result;
    }

    // Rest API 에 사용
    public Object delete(String CAR_INFOR_ID) {
        String sqlMapId = "CarInfors.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    // 2PC create
    public Object insertDouble(Map dataMap) {
        String sqlMapId = "CarInfors.insert";
        // sucess
        Object result = sharedDao.insert(sqlMapId, dataMap);
        // error
        result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

}
