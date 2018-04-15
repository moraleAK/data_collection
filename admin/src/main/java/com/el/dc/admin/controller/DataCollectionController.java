package com.el.dc.admin.controller;

import com.el.dc.api.entity.NodeInfo;
import com.el.dc.api.service.NodeInfoService;
import com.el.dc.api.service.NodeSensorDataService;
import com.el.dc.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping(value = "/dc")
public class DataCollectionController {
    @Autowired
    UserService userService;
    @Autowired
    NodeSensorDataService nodeSensorDataService;
    @Autowired
    NodeInfoService nodeInfoService;

    Logger LOG = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping(value = "/data_receive", produces = "application/json;charset=utf-8")
    public String dataReceive(@RequestBody String data) throws IOException {
        LOG.info(data);
        try {
            nodeSensorDataService.addNodeSensorData(data);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success!";
    }

    @ResponseBody
    @RequestMapping(value = "/node_info_add")
    public String nodeInfoAdd(@RequestBody NodeInfo nodeInfo) {
        nodeInfoService.nodeInfoAdd(nodeInfo);
        return "add success!";
    }

    @ResponseBody
    @RequestMapping(value = "/node_info_add_4_form_data")
    public void nodeInfoAdd2(NodeInfo nodeInfo, HttpServletResponse response) throws IOException {
        nodeInfoService.nodeInfoAdd(nodeInfo);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("node_info");
        response.sendRedirect("/dc/get_node_infos");
    }

    @ResponseBody
    @RequestMapping(value = "/get_node_infos")
    public ModelAndView loadNodeInfos(NodeInfo nodeInfo) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("node_info");
        mav.addObject("nodeInfos", nodeInfoService.loadNodeInfos());
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/get_node_sensor_datas")
    public ModelAndView loadNodeSensorDatas(NodeInfo nodeInfo) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("node_sensor_data");
        mav.addObject("nodeSensorDatas", nodeSensorDataService.loadNodeSensorDatas());
        return mav;
    }
}
