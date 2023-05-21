package com.felix.background.dto.out;

import com.felix.background.handle.ListTypeHandler;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.core.handler.Fastjson2TypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author imac
 */
@Data
public class UserOutputDto implements Serializable {
    private static final long serialVersionUID = -391385491898713818L;
    private Integer id;
    private Date lastLoginTime;
    private String username;
    private String name;
    private String email;
    private String mobile;
    @Column(typeHandler = ListTypeHandler.class)
    private List<String> roles;
    private Integer department;
    private Integer currentProjectId;
    private String description;
    private Integer createById;
    private String createByName;
    private Date createTime;
    private Integer updateById;
    private String updateByName;
    private Date updateTime;
    private Boolean isDelete;
}
