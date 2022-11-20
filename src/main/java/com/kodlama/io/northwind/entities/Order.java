package com.kodlama.io.northwind.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity {
	

	
	@Column(name = "local_date")
	private LocalDate date= LocalDate.now();
	
	@ManyToOne()
	@JoinColumn(name = "employe_id")
	private Employee employee;

}
