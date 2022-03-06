package com.musin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
/* categoryDiv : 0 상위 카테고리
 * categoryDiv : 1 1차 카테고리
 */
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
	
	@Column(name = "categoryName")
	private String categoryName;
	
	@Column(name = "categoryDiv")
	private int categoryDiv;
	
	@Column(name = "subCategoryId")
	private Long subCategoryId;
}
