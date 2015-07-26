package com.yuntong.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mylover on 7/22/15.
 */
@Entity
@Table(name = "YUNTONG_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "sequenceStyleGenerator")
    @GenericGenerator(
            name = "sequenceStyleGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "S_YUNTONG_USER")
            }
    )
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "password")
    private String password;
    
    @Column(name = "USERPHONE")
     private String userPhone;
    
    @Column(name = "IDCARD")
    private String userIdCard;
    
    @Column(name = "DEPARTMENT")
    private String department;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
