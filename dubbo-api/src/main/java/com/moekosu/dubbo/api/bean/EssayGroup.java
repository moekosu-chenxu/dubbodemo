package com.moekosu.dubbo.api.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author chenxu
 * @date 2018/03
 */
public class EssayGroup implements Serializable {

    private static final long serialVersionUID = -1713338329505435284L;

    private String groupId;

    private String groupName;

    private String groupStatus;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }
}
