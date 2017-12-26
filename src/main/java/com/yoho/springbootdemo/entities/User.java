package com.yoho.springbootdemo.entities;

import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BLF_USER")
@Data
public class User implements Serializable{

    private static final long serialVersionUID = 3808724081999970297L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID",unique = true,nullable = false)

    private Integer id;

    @Column(name = "USER_NAME", nullable = false, length = 16)
    private String name;

    @Column(name = "SEX", nullable = false)
    private Boolean sex;

    @Column(name = "PASSWORD", nullable = false, length = 256)
    private String password;

    @Column(name = "MOBILE", nullable = false, length = 15,unique = true)
    private String mobile;

    @Column(name = "EMAIL", nullable = false, length = 64)
    private String email;

    @Column(name = "CODE_PREFIX", nullable = false, length = 8)
    private String codePrefix;

    @Column(name = "STATE",nullable = false)
    private Boolean state;

    @Column(name = "IS_DELETE",nullable = false)
    private Boolean isDelete;

    @Column(name = "CREATE_BY", nullable = false, length = 16)
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATE_DATE", nullable = false, length = 11)
    private Date createDate;

    @Column(name = "LAST_UPDATE_BY", nullable = false, length = 16)
    private String lastUpdateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = 11)
    private Date lastUpdateDate;

    @Column(name = "BACK_UP",length = 128)
    private String backUp;

    @Column(name = "CODE_SUFFIX", nullable = false, length = 8)
    private Integer codeSuffix;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
    private Set<UserRole> userRoles = new HashSet<>();

}