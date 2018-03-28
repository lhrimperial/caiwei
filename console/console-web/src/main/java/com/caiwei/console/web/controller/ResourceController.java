package com.caiwei.console.web.controller;

import com.caiwei.console.common.domain.ResourceTreeNode;
import com.caiwei.console.web.domain.ResourceVO;
import com.caiwei.console.web.service.IMenuService;
import com.caiwei.console.web.service.IResourceService;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends AbstractController{
    private Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private IResourceService resourceService;

    @RequestMapping("/index")
    public String index() {
        return "/sysset/resource";
    }

    @ResponseBody
    @RequestMapping("/queryTreePathForName")
    public ResponseVO<List<ResourceTreeNode>> queryTreePathForName(@RequestBody String resourceName) {
        ResponseVO responseVO = returnSuccess();
        responseVO.setResult(resourceService.queryTreePathForName(resourceName));
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/queryResourceByParentRes")
    public List<ResourceTreeNode> queryResourceByParentRes(String node) {
        List<ResourceTreeNode> menuNodes = resourceService.queryResourceByParentRes(node);
        return menuNodes;
    }

    @ResponseBody
    @RequestMapping("/queryResourceByExample")
    public ResourceVO queryResourceByExample(@ModelAttribute ResourceVO resourceVO) {
        return resourceService.queryResourceByExample(resourceVO);
    }

    @ResponseBody
    @RequestMapping("/addResource")
    public ResponseVO<String> addResource(@RequestBody ResourceVO resourceVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            resourceService.addResource(resourceVO);
        } catch (BusinessException e) {
            logger.error("", e);
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/updateResource")
    public ResponseVO<String> updateResource(@RequestBody ResourceVO resourceVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            resourceService.updateResource(resourceVO);
        } catch (BusinessException e) {
            logger.error("", e);
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/deleteResource")
    public ResponseVO<String> deleteResource(@RequestBody ResourceVO resourceVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            resourceService.deleteResource(resourceVO);
        } catch (BusinessException e) {
            logger.error("", e);
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }


}
