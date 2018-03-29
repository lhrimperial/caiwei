package com.caiwei.console.web.controller;

import com.caiwei.console.business.service.IRoleService;
import com.caiwei.console.business.service.IUserMenuService;
import com.caiwei.console.common.define.ConsoleConstants;
import com.caiwei.console.common.domain.ResourceNode;
import com.caiwei.console.common.domain.ResourceTreeNode;
import com.caiwei.console.common.domain.RoleDO;
import com.caiwei.console.web.domain.RoleVO;
import com.caiwei.console.web.service.ISystemSetService;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import com.github.framework.util.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 **/
@Controller
@RequestMapping("/role")
public class RoleController extends AbstractController {

    @Autowired
    private ISystemSetService systemSetService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserMenuService userMenuService;

    @RequestMapping("/index")
    public String index() {
        return "/sysset/role";
    }

    @ResponseBody
    @RequestMapping("/findRole")
    public ResponseVO<RoleVO> findRole(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        responseVO.setResult(systemSetService.findRole(roleVO));
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/listRole")
    public RoleVO findRoles(@ModelAttribute RoleVO roleVO) {
        return systemSetService.queryRoleList(roleVO);

    }

    @ResponseBody
    @RequestMapping("/addRole")
    public ResponseVO<String> addRole(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.addRole(roleVO);
        return responseVO;
    }

    @ResponseBody
    @RequestMapping("/updateRole")
    public ResponseVO<String> updateRole(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.updateRole(roleVO);
        return responseVO;
    }


    @ResponseBody
    @RequestMapping("/deleteRole")
    public ResponseVO<String> deleteRoles(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        systemSetService.deleteRole(roleVO);
        return responseVO;
    }

    /**
     * config resource
     */
    @ResponseBody
    @RequestMapping("/queryResourceByParentResChecked")
    public List<ResourceTreeNode<ResourceNode>> queryResourceByParentResChecked(String node, RoleVO roleVO) {
        boolean hasChecked = true;
        String parentCode = node;
        String roleCode = null;
        if (roleVO != null) {
            roleCode = roleVO.getRoleDO().getRoleCode();
        }
        // 根据父节点查询资源权限
        List<ResourceNode> childResources = userMenuService.queryResourcesByParentCode(parentCode, false);
        List<ResourceTreeNode<ResourceNode>> returnTreeNodeCodes = new ArrayList<ResourceTreeNode<ResourceNode>>();
        // 查出角色所包含的所有权限
        Set<String> set = null;

        if (hasChecked && StringUtils.isNotBlank(roleCode)) {
            // 根据角色编码查询角色信息，包含角色权限数据
            RoleDO role = roleService.findByCode(roleCode);
            set = role.getResCodes();
        }
        for (ResourceNode resNode : childResources) {
            if (hasChecked) {
                // 如果角色包含该权限
                if (!CollectionUtils.isEmpty(set)
                        && set.contains(resNode.getCode())) {
                    resNode.setChecked("Y");
                } else {
                    resNode.setChecked("N");
                }
            }
            // 转换菜单对象为节点对象
            ResourceTreeNode<ResourceNode> treeNode = ResourceTreeNode.changeResToTreeNode(resNode,true);
            treeNode.setChecked(ConsoleConstants.YES.equalsIgnoreCase(resNode.getChecked()));
            returnTreeNodeCodes.add(treeNode);
        }
        return returnTreeNodeCodes;
    }


    @ResponseBody
    @RequestMapping("/updateRoleResource")
    public ResponseVO<String> updateRoleResource(@RequestBody RoleVO roleVO) {
        ResponseVO responseVO = returnSuccess();
        try {
            systemSetService.updateRoleResource(roleVO);
        } catch (Exception e) {
            responseVO = returnError(e.getMessage());
        }
        return responseVO;
    }
}
