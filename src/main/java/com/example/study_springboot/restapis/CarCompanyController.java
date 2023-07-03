package com.example.study_springboot.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboot.service.CarCompanyService;

@RestController
public class CarCompanyController {
    @Autowired
    CarCompanyService carCompanyService;

    // /selectSearch_COM/NAME/자
    // /selectSearch_COM/ID/1
    @GetMapping("/selectSearch_COM/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) {
        Object result = carCompanyService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
    }

    // /selectAll_COM/C001
    @GetMapping("/selectAll_COM/{COMPANY_ID}")
    public ResponseEntity selectAll(@PathVariable String COMPANY_ID) {
        Object result = carCompanyService.selectAll(COMPANY_ID);
        return ResponseEntity.ok().body(result);
    }

    // /selectDetail_COM/C002
    @GetMapping("/selectDetail_COM/{COMPANY_ID}")
    public ResponseEntity selectDetail(@PathVariable String COMPANY_ID) {
        Object result = carCompanyService.selectDetail(COMPANY_ID);
        return ResponseEntity.ok().body(result);
    }

    // /폭스바겐, C006
    @PostMapping("/insert_COM")
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carCompanyService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // 폭스바겐을 페라리 변경
    @PutMapping("/update_COM")
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carCompanyService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // C006 삭제
    // /delete_COM/C006
    @DeleteMapping("/delete_COM/{COMPANY_ID}")
    public ResponseEntity delete(@PathVariable String COMPANY_ID) {
        Object result = carCompanyService.delete(COMPANY_ID);
        return ResponseEntity.ok().body(result);
    }

    
    @PostMapping("/insertDouble_COM") // 원래는 url 부분에 단어를 넣어주지 않는다.
    public ResponseEntity insertDouble(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carCompanyService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }

}
