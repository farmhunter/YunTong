package com.yuntong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;





@Entity
@Table(name = "YUNTONG_PRIVILEGE")
public class Privilege {
	
	@Id
	@GeneratedValue(generator = "sequenceStyleGenerator")
	@GenericGenerator(
			name = "sequenceStyleGenerator",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@org.hibernate.annotations.Parameter(name = "sequence_name", value = "S_YUNTONG_PRIVIGE"),
			}
			)
	private int id;
	
	@Column(name = "PRIVILEGE_NAME")
	private String name;
	
	
}
