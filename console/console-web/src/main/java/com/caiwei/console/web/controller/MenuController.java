package com.caiwei.console.web.controller;

import com.caiwei.console.common.domain.ResourceTreeNode;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class MenuController extends AbstractController {


    /**
     * 功能菜单树的节点查询与展开路径加载
     * @return
     */
    public ResponseVO<ResourceTreeNode> queryTreePathForName() {
        return returnSuccess();
    }
}
