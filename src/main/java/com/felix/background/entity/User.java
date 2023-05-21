package com.felix.background.entity;

import com.felix.background.handle.ListTypeHandler;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Felix
 * @since 2023-05-14
 */
@Table("tb_user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -3084683726412550148L;
    @Id(keyType = KeyType.Auto)
    private Integer id;
    private String password;
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
