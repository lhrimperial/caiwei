package com.caiwei.console.common.define;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Constants {

    /**
     *
     */
    public static final byte Y = 0;

    public static final byte N = 0;

    public static enum PoStatus {
        ACTIVE("有效"),INACTIVE("无效");

        private String chName;

        private PoStatus(String chName) {
            this.chName = chName;
        }

        public static String getCnName(String code) {
            for (PoStatus item : PoStatus.values()) {
                if (item.name().equals(code)) {
                    return item.getChName();
                }
            }
            return code;
        }

        public static Map<String, String> toMap() {
            Map<String, String> map = new HashMap<String, String>();
            for (PoStatus t : values()) {
                map.put(t.name(), t.getChName());
            }
            return map;
        }

        public String getChName() {
            return chName;
        }

        public void setChName(String chName) {
            this.chName = chName;
        }
    }

}
