package com.example.study_springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboot.dao.SharedDao;

@Service
@Transactional
public class CarCompanyService {
    @Autowired
    SharedDao sharedDao;

    public Object selectSearch(String search, String words) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarCompany.selectSearch_COM";
        HashMap<String, String> datatMap = new HashMap<String, String>();
        datatMap.put("search", search);
        datatMap.put("words", words);
        Object result = sharedDao.getList(sqlMapId, datatMap);
        return result;
    }

    public Object selectAll(String COMPANY_ID) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarCompany.selectAll_COM";
        HashMap<String, String> datatMap = new HashMap<String, String>();
        datatMap.put("COMPANY_ID", COMPANY_ID);
        Object result = sharedDao.getList(sqlMapId, datatMap);
        return result;
    }

    public Object selectDetail(String COMPANY_ID) {
        String sqlMapId = "CarCompany.selectDetail_COM";
        HashMap<String, String> datatMap = new HashMap<String, String>();
        datatMap.put("COMPANY_ID", COMPANY_ID);
        Object result = sharedDao.getOne(sqlMapId, datatMap);
        return result;
    }

    public Object insert(Map dataMap) {
        String sqlMapId = "CarCompany.insert_COM";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object update(Map dataMap) {
        String sqlMapId = "CarCompany.update_COM";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object delete(String COMPANY_ID) {
        String sqlMapId = "CarCompany.delete_COM";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    public Object insertDouble(Map dataMap) {
        String sqlMapId = "CarCompany.insert_COM";
        // sucess
        Object result = sharedDao.insert(sqlMapId, dataMap);
        // error
        result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }
}