package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IUserMenuService;
import com.caiwei.console.common.context.PermisUserContext;
import com.caiwei.console.common.define.ConsoleConstants;
import com.caiwei.console.common.define.DictionaryValueConstants;
import com.caiwei.console.common.domain.*;
import com.caiwei.console.common.exception.LoginException;
import com.caiwei.console.web.service.IMenuService;
import com.github.framework.server.context.UserContext;
import com.github.framework.server.shared.define.FunctionType;
import com.github.framework.util.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IUserMenuService userMenuService;

    @Override
    public List<ResourceTreeNode> loadTree(String node) {
        List<ResourceTreeNode> nodes = new ArrayList<>();
        nodes = findUserMenu();
        // 得到点击的节点下的子节点菜单集合
        List<ResourceNode> resources = findResources(node);
        for (ResourceNode res : resources) {
            // 转换菜单对象为节点对象
            ResourceTreeNode<ResourceNode> treeNode = ResourceTreeNode.changeResToTreeNode(res,false);
            nodes.add(treeNode);
        }
        return nodes;
    }

    private List<ResourceNode> findResources(String parentCode) {
        // 获得当前用户
        PermisUserDO user = PermisUserContext.getCurrentUser();
        // 当前用户当前部门功能编码集合
        Set<String> resCodes = user.getOrgResCodes();
        // 当前部门未配置角色
        if (resCodes == null) {
            throw new LoginException(LoginException.CURRENT_DEPT_NO_ROLE);
        }

        // 菜单对象集合
        List<ResourceNode> resNodes = new ArrayList<ResourceNode>();
        List<ResourceNode> childResources = userMenuService.queryResourcesByParentCode(parentCode,true);
        for (ResourceNode res : childResources) {
            // 判断权限是否为空
            if (res == null) {
                continue;
            }
            // 判断权限的类型是否为按钮
            if (StringUtils.equalsIgnoreCase(FunctionType.BUTTON,res.getResType())) {
                continue;
            }
            // 判断是否是WEB菜单
            if (StringUtils.equalsIgnoreCase(DictionaryValueConstants.BSE_RESOURCE_BELONG_SYSTEM_TYPE_APP,
                            res.getBelongSystemType())) {
                continue;
            }

            // 判断权限为非检查的权限时，直接增加到权限列表中
            if (StringUtils.equalsIgnoreCase(ConsoleConstants.NO, res.getChecked())) {
                resNodes.add(res);
                continue;
            }
            if (resCodes.contains(res.getCode())) {
                resNodes.add(res);
            }

        }
        return resNodes;
    }

    private List<ResourceTreeNode> findUserMenu() {
        Map<String, UserMenuDO> userMenusMap = this.createUserMenus();
        List<ResourceTreeNode> userMenusTreeNode = new ArrayList<ResourceTreeNode>();
        // 通过用户常用菜单中的权限集合，得到用户常用菜单对象
        List<ResourceNode> resList = userMenuService
                .queryResourceBatchByCode(userMenusMap.keySet().toArray(
                        new String[userMenusMap.size()]));
        if (resList != null && resList.size() > 0) {
            for (ResourceNode res : resList) {
                UserMenuDO userMenu = userMenusMap.get(res.getCode());
                res.setDisplayOrder(userMenu.getDisplayOrder().toString());
                ResourceTreeNode<ResourceNode> treeNode = ResourceTreeNode.changeResToTreeNode(res, false);
                treeNode.setId(res.getCode() + "_usermenu");
                String cls = treeNode.getCls();
                treeNode.setCls(cls.substring(0, cls.length() - 1) + "3");
                userMenusTreeNode.add(treeNode);
            }
            // 对常用菜单进行排序
            Collections.sort(userMenusTreeNode, new Comparator<ResourceTreeNode>() {
                        public int compare(ResourceTreeNode o1,
                                           ResourceTreeNode o2) {
                            Integer r1 = Integer.parseInt(o1.getDisplayOrder());
                            Integer r2 = Integer.parseInt(o2.getDisplayOrder());
                            return r1.compareTo(r2);
                        }
                    });
        }
        return userMenusTreeNode;
    }

    private Map<String, UserMenuDO> createUserMenus() {
        // 获得当前用户
        PermisUserDO user = (PermisUserDO) UserContext.getCurrentUser();
        // 获得当前用户当前所在部门的所有权限信息集合
        Set<String> userAccessResCodes = user.getOrgResCodes();
        // 用户菜单CODE与菜单MAP
        Map<String, UserMenuDO> userMenusMap = new HashMap<String, UserMenuDO>();
        // 用户已经设置的常用菜单对象
        List<UserMenuDO> userMenus = userMenuService
                .queryUserMenuByUserCode(user.getUserCode());
        if (userMenus != null) {
            String[] resCodes = new String[userMenus.size()];
            for (int i = 0, len = userMenus.size(); i < len; i++) {
                if (userAccessResCodes.contains(userMenus.get(i).getResourceCode())) {
                    resCodes[i] = userMenus.get(i).getResourceCode();
                    userMenusMap.put(resCodes[i], userMenus.get(i));
                }
            }
        }
        return userMenusMap;
    }

    @Override
    public List<ResourceTreeNode> queryTreePathForName(String menuName) {
        List<ResourceTreeNode> list = new ArrayList<>();
        ResourceDO resourceDO = new ResourceDO();
        resourceDO.setResName(menuName);
        List<ResourceDO> resourceDOS = userMenuService.queryResourcesByParam(resourceDO);
        for (ResourceDO res : resourceDOS) {
            list.add(ResourceTreeNode.changeResToTreeNode(ResourceDO.convert(res), true));
        }
        return list;
    }

    @Override
    public List<ResourceTreeNode> queryResourceByParentRes(String node) {
        List<ResourceTreeNode> nodes = new ArrayList<>();
        // 得到点击的节点下的子节点菜单集合
        List<ResourceNode> resources = findResources(node);
        for (ResourceNode res : resources) {
            // 转换菜单对象为节点对象
            ResourceTreeNode<ResourceNode> treeNode = ResourceTreeNode.changeResToTreeNode(res,true);
            nodes.add(treeNode);
        }
        return nodes;
    }


}
