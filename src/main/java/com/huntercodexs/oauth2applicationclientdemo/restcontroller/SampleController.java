package com.huntercodexs.oauth2applicationclientdemo.restcontroller;

import com.huntercodexs.oauth2applicationclientdemo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${api.prefix}")
@CrossOrigin(origins = "*")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping(path = "/admin")
    @ResponseBody
    public ResponseEntity<?> admin(HttpServletRequest headers) {
        sampleService.check(headers);
        return ResponseEntity.ok().body("Admin is running on OAUTH2-APPLICATION-CLIENT-DEMO");
    }

    @GetMapping(path = "/user")
    @ResponseBody
    public ResponseEntity<?> user(HttpServletRequest headers) {
        sampleService.check(headers);
        return ResponseEntity.ok().body("User is running on OAUTH2-APPLICATION-CLIENT-DEMO");
    }

    @GetMapping(path = "/others")
    @ResponseBody
    public ResponseEntity<?> others() {
        return ResponseEntity.ok().body("Others is running on OAUTH2-APPLICATION-CLIENT-DEMO");
    }

    @GetMapping(path = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> token(HttpServletRequest headers) {
        return sampleService.token(headers);
    }

}
