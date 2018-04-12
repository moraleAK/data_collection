package com.el.dc.admin.controller;

import com.el.dc.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/dc")
public class DataCollectionController {
    @Autowired
    UserService userService;

    Logger LOG = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/data_receive")
    public String dataReceive(@RequestBody String data){
        LOG.info(data);
        userService.addUser(System.currentTimeMillis() + "", System.currentTimeMillis() +"");
        return "success!";
    }
}
