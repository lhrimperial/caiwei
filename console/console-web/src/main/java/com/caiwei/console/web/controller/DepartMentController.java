package com.caiwei.console.web.controller;

import com.caiwei.console.business.service.IDepartmentService;
import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.web.domain.DepartTreeNode;
import com.caiwei.console.web.domain.DepartmentNode;
import com.caiwei.console.web.domain.DepartmentVO;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import com.github.framework.util.serializer.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 **/
@Controller
@RequestMapping("/department")
public class DepartMentController extends AbstractController{

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/index")
    public String index() {
        return "/dataset/department";
    }

    @ResponseBody
    @RequestMapping("/loadDepartmentTree")
    public List<DepartTreeNode<DepartmentNode>> loadDepartmentTree(String node) {
        List<DepartmentDO> list = departmentService.findByParentCode(node);
        // 树结点：
        List<DepartTreeNode<DepartmentNode>> nodes = new ArrayList<>();
        DepartTreeNode<DepartmentNode> treeNode = null;
        DepartmentNode departmentNode = null;
        for (DepartmentDO res : list) {
            departmentNode = new DepartmentNode();
            treeNode = new DepartTreeNode<>();
            treeNode.setId(res.getDeptCode());
            treeNode.setText(res.getDeptName());
            if (res.getChildren() == null || res.getChildren().size() == 0) {
                treeNode.setLeaf(true);
            }
            if (res.getParentCode() != null) {
                treeNode.setParentId(res.getParentCode());
            } else {
                treeNode.setParentId(null);
            }
            BeanCopyUtils.copyBean(res, departmentNode);
            treeNode.setEntity(departmentNode);
            nodes.add(treeNode);
        }
        return nodes;
    }

    @ResponseBody
    @RequestMapping("/loadDepartment")
    public ResponseVO<DepartmentVO> loadDepartment(@RequestBody DepartmentVO departmentVO) {
        if (departmentVO == null) {
            return returnError("param is null");
        }
        ResponseVO responseVO = returnSuccess();
        try {
            DepartmentDO departmentDO = departmentService.findByDeptCode(departmentVO.getDeptCode());
            departmentVO.setDepartmentDO(departmentDO);

            responseVO.setResult(departmentVO);
        } catch (Exception e) {
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/queryTreePathForName")
    public ResponseVO<Set<String>> queryTreePathForName(@RequestBody DepartmentVO departmentVO) {
        if (departmentVO == null) {
            return returnError("param is null");
        }
        ResponseVO responseVO = returnSuccess();
        try {
            Set<String> pathList = new HashSet<>();
            List<DepartmentDO> list = departmentService.findByParams(departmentVO.getDepartmentDO());
            String path = null;
            for (DepartmentDO departmentDO : list) {
                path = expendTreePath(departmentDO.getDeptCode());
                if (path != null && path != "" && !"root".equals(path)) {
                    pathList.add(path);
                }
                path = "";
            }

            responseVO.setResult(pathList);
        } catch (Exception e) {
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }

    private String expendTreePath(String deptCode) {
        DepartmentDO departmentDO = null;
        String parentCode = deptCode;
        String path = "";
        while (parentCode != null && parentCode != "" && !"root".equals(parentCode) ) {
            path = "/" + parentCode + path;
            departmentDO = departmentService.findByDeptCode(parentCode);
            if (departmentDO == null) {
                path = "";
                break;
            }
            parentCode = departmentDO.getParentCode();
        }
        path = "/root" + path;
        return path;
    }
}
