package com.caiwei.console.web.domain;

import com.caiwei.console.common.domain.DistrictDO;
import com.github.framework.server.shared.domain.vo.BaseVO;

import java.util.List;

/**
 *
 **/
public class DistrictVO extends BaseVO {
    private static final long serialVersionUID = -9009859554831994695L;

    private DistrictDO districtDO;
    private List<DistrictDO> districtDOS;

    public DistrictDO getDistrictDO() {
        return districtDO;
    }

    public void setDistrictDO(DistrictDO districtDO) {
        this.districtDO = districtDO;
    }

    public List<DistrictDO> getDistrictDOS() {
        return districtDOS;
    }

    public void setDistrictDOS(List<DistrictDO> districtDOS) {
        this.districtDOS = districtDOS;
    }
}
