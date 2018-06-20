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

    /**
     * 接收 socket 转发过来的传感器信息
     * @param data 参数信息
     * @return success
     * @throws IOException JSON 转换类形成
     */
    @ResponseBody
    @RequestMapping(value = "/data_receive", produces = "application/json;charset=utf-8")
    public String dataReceive(@RequestBody String data) throws IOException {
        LOG.info(data);
        try {
            nodeSensorDataService.addNodeSensorData(data);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }

    /**
     * 后台添加传感器信息接口
     * post/json 方式
     * @param nodeInfo 传感器设备信息
     * @return success
     */
    @ResponseBody
    @RequestMapping(value = "/node_info_add")
    public String nodeInfoAdd(@RequestBody NodeInfo nodeInfo) {
        nodeInfoService.nodeInfoAdd(nodeInfo);
        return "success";
    }

    /**
     * 前台界面添加传感器信息
     * form-data 方式
     *
     * @param nodeInfo 设备信息
     * @param response 重定向刷新设备信息列表
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/node_info_add_4_form_data")
    public void nodeInfoAdd2(NodeInfo nodeInfo, HttpServletResponse response) throws IOException {
        nodeInfoService.nodeInfoAdd(nodeInfo);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("node_info");
        response.sendRedirect("/dc/get_node_infos");
    }

    /**
     * 获取设备信息列表
     * @return 设备信息界面
     */
    @ResponseBody
    @RequestMapping(value = "/get_node_infos")
    public ModelAndView loadNodeInfos() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("node_info");
        mav.addObject("nodeInfos", nodeInfoService.loadNodeInfos());
        return mav;
    }

    /**
     * 获取传感器节点设备信息
     *
     * @return 节点信息列表
     */
    @ResponseBody
    @RequestMapping(value = "/get_node_sensor_datas")
    public ModelAndView loadNodeSensorDatas() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("node_sensor_data");
        mav.addObject("nodeSensorDatas", nodeSensorDataService.loadNodeSensorDatas());
        return mav;
    }
}
