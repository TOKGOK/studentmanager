package com.wdd.studentManager.enums;


public enum LeaveStatusEnum{
    LEAVE_STATUS_WAIT(0,"等待审核"),
    LEAVE_STATUS_AGREE(1,"同意"),
    LEAVE_STATUS_DISAGREE(-1,"不同意");


    private final int key;
    private final String value;

    LeaveStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


}
