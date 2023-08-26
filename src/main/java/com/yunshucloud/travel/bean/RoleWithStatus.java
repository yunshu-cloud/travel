package com.yunshucloud.travel.bean;

import lombok.Data;

@Data
public class RoleWithStatus {
    private Integer rid;
    private String roleName;
    private String roleDesc;
    private Boolean adminHas;
}
