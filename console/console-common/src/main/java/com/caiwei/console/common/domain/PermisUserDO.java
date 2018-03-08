package com.caiwei.console.common.domain;

import com.caiwei.console.common.context.PermisUserContext;
import com.github.framework.server.cache.CacheManager;
import com.github.framework.server.cache.ICache;
import com.github.framework.server.shared.domain.BaseDO;
import com.github.framework.server.shared.entity.IUser;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 用户业务实体
 */
public class PermisUserDO extends BaseDO implements IUser {

    /**
     * 登录用户名
     */
    private String userCode;

    /**
     * 登录密码
     */
    private String passWord;

    /**
     * 员工工号
     */
    private String empCode;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 组织编码
     */
    private String deptCode;

    /**
     * 上次登录时间
     */
    private Date lastLogin;

    /**
     * 备注
     */
    private String notes;

    /**
     * 员工信息
     */
    private EmployeeDO employeeDO;

    /**
     * 角色ID列表
     */
    private Set<String> roleCodes;

    /**
     * 用户所拥有的部门信息ID集合
     */
    private Set<String> deptCodes;

    /**
     * 用户当前部门对应权限编码
     */
    private Set<String> orgResCodes;

    /**
     * 用户当前部门对应权限Uri
     */
    private Set<String> orgResUris;

    public Set<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(Set<String> roleCodes) {
        this.roleCodes = roleCodes;
    }

    public Set<String> getDeptCodes() {
        return deptCodes;
    }

    public void setDeptCodes(Set<String> deptCodes) {
        this.deptCodes = deptCodes;
    }

    public EmployeeDO getEmployeeDO() {
        return employeeDO;
    }

    public void setEmployeeDO(EmployeeDO employeeDO) {
        this.employeeDO = employeeDO;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public void setRoleids(Set<String> paramSet) {

    }

    @Override
    public Set<String> getRoleids() {
        return null;
    }

    @Override
    public Set<String> queryAccessUris() {
        return orgResUris;
    }

    public void loadAccess() {
        String currentDeptCode = PermisUserContext.getCurrentDeptCode();
        String currentUserCode = PermisUserContext.getCurrentUser().getUserCode();
        if(this.orgResCodes==null||this.orgResUris==null){
            ICache<String, List<Set<String>>> userOrgRoleResCache = CacheManager.getInstance().getCache("userOrgRoleResource");
            List<Set<String>> userOrgResUriCodes = userOrgRoleResCache.get(currentUserCode+"#"+currentDeptCode);
            this.setOrgResCodes(userOrgResUriCodes.get(0));
            this.setOrgResUris(userOrgResUriCodes.get(1));
        }
    }

    public Set<String> getOrgResCodes() {
        return orgResCodes;
    }

    public void setOrgResCodes(Set<String> orgResCodes) {
        this.orgResCodes = orgResCodes;
    }

    public Set<String> getOrgResUris() {
        return orgResUris;
    }

    public void setOrgResUris(Set<String> orgResUris) {
        this.orgResUris = orgResUris;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }
}
