package com.yoho.springbootdemo.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BLF_ROLE_PERMISSION")
@Data
public class RolePermission implements Serializable{

    private static final long serialVersionUID = 1366565234878366550L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    private Integer id;

    @Basic
    @Column(name = "STATE")
    private Boolean state;

    @Basic
    @Column(name = "IS_DELETE")
    private Boolean isDelete;

    @Basic
    @Column(name = "CREATE_BY")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATE_DATE", nullable = false, length = 11)
    private Date createDate;

    @Basic
    @Column(name = "LAST_UPDATE_BY")
    private String lastUpdateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = 11)
    private Date lastUpdateDate;

    @Basic
    @Column(name = "BACK_UP")
    private String backUp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERMISSION_ID",referencedColumnName = "ID")
    private Permission permission;
}