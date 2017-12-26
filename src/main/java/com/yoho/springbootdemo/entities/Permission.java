package com.yoho.springbootdemo.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BLF_PERMISSION")
@Data
public class Permission implements Serializable{

    private static final long serialVersionUID = 120853184938729318L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, precision = 22)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "URL")
    private String url;

    @Column(name = "STATE")
    private Boolean state;

    @Column(name = "IS_DELETE")
    private Boolean isDelete;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATE_DATE", nullable = false, length = 11)
    private Date createDate;

    @Column(name = "LAST_UPDATE_BY")
    private String lastUpdateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = 11)
    private Date lastUpdateDate;

    @Column(name = "BACK_UP")
    private String backUp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Permission parentPermission;

    @Column(name = "SEQ")
    private Integer seq;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "parentPermission")
    private Set<Permission> permissions = new HashSet<>();

}