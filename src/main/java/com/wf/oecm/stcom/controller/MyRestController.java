package com.wf.oecm.stcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wf.oecm.stcom.model.OECMAddUser;
import com.wf.oecm.stcom.service.OECMService;

@RestController
public class MyRestController {
	
	@Autowired
    private OECMService service;

    @GetMapping("/getrainbow")
    public List<String> getRainbow(){
       return service.getRainbow();
    }
    
    @PostMapping("/users")
    public String createUJser(@RequestBody OECMAddUser userRequestBody) {
        // Handle the incoming POST request here
        return "Received POST request with body: " + userRequestBody.getUsername() + ", " +userRequestBody.getEmail();
    }

}
