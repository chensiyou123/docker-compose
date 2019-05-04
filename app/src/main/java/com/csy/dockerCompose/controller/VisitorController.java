package com.csy.dockerCompose.controller;

import com.csy.dockerCompose.entity.Visitor;
import com.csy.dockerCompose.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class VisitorController {
    @Autowired
    private VisitorRepository repository;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String ip=request.getRemoteAddr();
        List<Visitor> visitors=repository.findByIp(ip);
        Visitor visitor;
        if(visitors==null){
            visitor=new Visitor();
            visitor.setIp(ip);
            visitor.setTimes(1);
        }else {
            visitor = visitors.get(0);
            visitor.setTimes(visitor.getTimes()+1);
        }
        repository.save(visitor);
        return "I have been seen ip "+visitor.getIp()+" "+visitor.getTimes()+" times.";
    }
}
