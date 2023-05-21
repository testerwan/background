package com.felix.background.entity;


import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Felix
 * @since 2023-05-21
 */
@Table("tb_project")
@Data
public class Project implements Serializable {

    private static final long serialVersionUID = 6103949559299632026L;
    @Id(keyType = KeyType.Auto)
    private Integer id;
    private String name;
    private Integer ownerId;
    private String ownerName;
    private String projectDesc;
    private Integer createById;
    private String createByName;
    private Date createTime;
    private Integer updateById;
    private String updateByName;
    private Date updateTime;
    private Boolean isDelete;
}
