package com.msa.app.lch.controller;

import com.msa.app.lch.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @Value("${lch.test}")
    private String str;

    @GetMapping("/test")
    public String test() {
        return str;
    }

    @GetMapping("/lch-msa/api/{param}")
    public String getLchMsa(@PathVariable String param){
        return "lch-msa Param : " + param;
    }

    @GetMapping("/lch-msa/call/support/{param}")
    public String getLchMsaSupport(@PathVariable String param){
        return testService.getLchMsaSupport(param);
    }

}
