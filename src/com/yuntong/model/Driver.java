package com.yuntong.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "YUNTONG_DRIVER")
public class Driver implements Serializable{
	
	@Id
	@GeneratedValue(generator = "sequenceStyleGenerator")
	@GenericGenerator(
			name = "sequenceStyleGenerator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name = "sequence_name", value = "SSS_YYYUNTONG_DRIVER")
			}
			)
	@Column(name = "id")
	private Long id;
					
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "driverCard")
	private long driverCard;
	
	@Column(name = "idCard")
	private long idCard;
	
	@Column(name = "cellPhone")
	private long cellPhone;
	
	@OneToMany( fetch = FetchType.LAZY)
	@JoinColumn(name="DRIVER_ID")
	private Set<Organization> organizationList;
	
	
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORGANIZATION_ID")
	private  Organization organization;
*/
	
	public String getName() {
		return name;
	}

	public Set<Organization> getOrganizationList() {
		return organizationList;
	}

	public void setOrganizationList(Set<Organization> organizationList) {
		this.organizationList = organizationList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public long getDriverCard() {
		return driverCard;
	}

	public void setDriverCard(long driverCard) {
		this.driverCard = driverCard;
	}

	public long getIdCard() {
		return idCard;
	}

	public void setIdCard(long idCard) {
		this.idCard = idCard;
	}

	public long getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(long cellPhone) {
		this.cellPhone = cellPhone;
	}
/*
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
*/
}
