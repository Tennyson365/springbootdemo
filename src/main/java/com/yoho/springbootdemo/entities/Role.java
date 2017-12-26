package com.yoho.springbootdemo.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BLF_ROLE")
@Data
public class Role implements Serializable{

    private static final long serialVersionUID = 7763413225596767115L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "STATE",nullable = false)
    private Boolean state;

    @Column(name = "IS_DELETE",nullable = false)
    private Boolean isDelete;

    @Column(name = "CREATE_BY",nullable = false)
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATE_DATE", nullable = false, length = 11)
    private Date createDate;

    @Column(name = "LAST_UPDATE_BY",nullable = false)
    private String lastUpdateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = 11)
    private Date lastUpdateDate;

    @Column(name = "BACK_UP")
    private String backUp;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "role")
    private Set<RolePermission> rolePermissions = new HashSet<>();
}