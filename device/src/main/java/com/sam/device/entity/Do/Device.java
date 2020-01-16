package com.sam.device.entity.Do;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sam
 * @since 2020-01-13
 */
public class Device implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String name;

    private String code;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Device{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        "}";
    }
}
