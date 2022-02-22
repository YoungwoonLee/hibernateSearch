package com.chandler.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Entity @Table
@Indexed
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Contents {
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericField(sortable = Sortable.YES, searchable = Searchable.YES)
	private Long contentsId;
	
	@FullTextField(analyzer = "korea")
	private String title;
	
	@FullTextField(analyzer = "english") 
	private String subTitle; //임시로 테스트를위해 이건 영어 anlyzer
	
	@FullTextField(analyzer = "korea")
	private String contentHaha;
	
	private LocalDateTime startDt;
}