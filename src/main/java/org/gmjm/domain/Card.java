package org.gmjm.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="mtg.cards", type="string")
public class Card {
	
	@Id
	private String id;
	
	@Field(type=FieldType.Integer)
	private Integer cmc;
	
	@Field(type=FieldType.String)
	private List<String> colors;
	
	@Field(type=FieldType.String)
	private List<String> types;
	
	@Field(type=FieldType.Integer)
	private Integer power;

	@Field(type=FieldType.String)
	private String name;

	@Field(type=FieldType.String)
	private String setName;

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCmc() {
		return cmc;
	}

	public void setCmc(Integer cmc) {
		this.cmc = cmc;
	}
	
}
