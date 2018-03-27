package com.caiwei.console.web.controller;

import com.caiwei.console.common.domain.ResourceTreeNode;
import com.caiwei.console.web.domain.ResourceVO;
import com.caiwei.console.web.service.IMenuService;
import com.caiwei.console.web.service.IResourceService;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
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
    @Autowired
    private IMenuService menuService;

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
        List<ResourceTreeNode> menuNodes = menuService.queryResourceByParentRes(node);
        return menuNodes;
    }

    @ResponseBody
    @RequestMapping("/queryResourceByExample")
    public ResourceVO queryResourceByExample(@ModelAttribute ResourceVO resourceVO) {
        return resourceService.queryResourceByExample(resourceVO);
    }


}
