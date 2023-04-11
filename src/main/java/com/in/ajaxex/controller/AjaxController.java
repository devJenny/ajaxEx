package com.in.ajaxex.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.in.ajaxex.dto.AjaxDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {
    @GetMapping("/ex01")
    public String ex01() {
        System.out.println("AjaxController.ex01");
        return "index"; // index.html에 작성된 내용이 출력됨
    }

    @PostMapping("/ex02") // HTTP POST 요청을 처리하는 메서드
    // @ResponseBody: 메서드가 반환하는 데이터를 HTTP 응답 본문(response body)으로 전송함을 나타냄
    public @ResponseBody String ex02() {
        System.out.println("AjaxController.ex02");
        return "안녕하세요"; // 리턴값이 그대로 출력됨
    }

    @GetMapping("/ex03")
    public @ResponseBody String ex03(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        System.out.println("");
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex03메서드 호출 완료"; // 리턴값이 그대로 출력됨
    }

    @PostMapping("/ex04")
    public @ResponseBody String ex04(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        System.out.println("");
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "ex04메서드 호출 완료"; // 리턴값이 그대로 출력됨
    }

    @GetMapping("/ex05")
    public @ResponseBody AjaxDTO ex05(@ModelAttribute AjaxDTO ajaxDTO) { // @modelAttribute: Model 객체에 추가하여 뷰에서 사용할 수 있도록 합니다.
        System.out.println("ajaxDTO = " + ajaxDTO);
        return ajaxDTO;
    }

    @PostMapping("/ex06")
    public @ResponseBody AjaxDTO ex06(@ModelAttribute AjaxDTO ajaxDTO) { // @modelAttribute: Model 객체에 추가하여 뷰에서 사용할 수 있도록 합니다.
        System.out.println("ajaxDTO = " + ajaxDTO);
        return ajaxDTO;
    }

    @PostMapping("/ex07")
    public @ResponseBody AjaxDTO ex07(@RequestBody AjaxDTO ajaxDTO) {
        System.out.println("ajaxDTO = " + ajaxDTO);
        return ajaxDTO;
    }

    private List<AjaxDTO> DTOList() {
        List<AjaxDTO> dtoList = new ArrayList<>();
        dtoList.add(new AjaxDTO("data1", "data11"));
        dtoList.add(new AjaxDTO("data2", "data22"));
        return dtoList;
    }

    @PostMapping("/ex08")
    public @ResponseBody List<AjaxDTO> ex08(@RequestBody AjaxDTO ajaxDTO) {
        System.out.println("ajaxDTO = " + ajaxDTO);
        List<AjaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);
        return dtoList;
    }

    @PostMapping("/ex09")
    public ResponseEntity ex09(@RequestBody AjaxDTO ajaxDTO) {
        System.out.println("ajaxDTO = " + ajaxDTO);
        return new ResponseEntity<>(ajaxDTO, HttpStatus.OK); // 데이터 리턴 ㄴㄴ, status code만 return
//        return new ResponseEntity<>(ajaxDTO, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/ex10")
    public ResponseEntity ex10(@RequestBody AjaxDTO ajaxDTO) {
        System.out.println("ajaxDTO = " + ajaxDTO);
        List<AjaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
