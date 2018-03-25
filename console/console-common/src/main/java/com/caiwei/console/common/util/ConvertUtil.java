package com.caiwei.console.common.util;

import com.caiwei.console.common.define.ConsoleConstants;
import com.github.framework.server.shared.define.Constants;
import com.github.framework.util.string.StringUtils;

/**
 *
 **/
public class ConvertUtil {

    public static Byte activeToStatus(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return ConsoleConstants.YES.equals(value) ? Constants.PO_ACTIVE : Constants.PO_INACTIVE;
    }

    public static String statusToActive(Byte status) {
        if (status == null) {
            return "";
        }
        return Constants.PO_ACTIVE == status ? ConsoleConstants.YES : ConsoleConstants.NO;
    }
}
