package com.caiwei.console.web.controller;

import com.caiwei.console.common.domain.ResourceTreeNode;
import com.caiwei.console.web.service.IMenuService;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RestController
public class MenuController extends AbstractController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/loadTree")
    public List<ResourceTreeNode> loadTree(String node) {
        List<ResourceTreeNode> menuNodes = menuService.loadTree(node);
        return menuNodes;
    }

    /**
     * 功能菜单树的节点查询与展开路径加载
     * @return
     */
    @RequestMapping("/queryTreePathForName")
    public List<ResourceTreeNode> queryTreePathForName(String menuName) {
        return null;
    }
}
