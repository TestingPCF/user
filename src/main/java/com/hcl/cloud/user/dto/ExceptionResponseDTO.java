/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.dto;

import org.springframework.stereotype.Component;

/**
 * com.hcl.cloud.user.exception. abhishek_sin
 */
@Component
public class ExceptionResponseDTO {
    /**
     * code
     */
    private int code;
    /**
     * Description
     */
    private String description;

    /**
     *
     * @return the code.
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     *            the code to set.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *            the description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
