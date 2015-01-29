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
	
	@Field(type=FieldType.String)
	private Integer multiverseid;
	
	@Field(type=FieldType.String)
	private String name;
	
	@Field(type=FieldType.String)
	private String setName;
	
	@Field(type=FieldType.String)
	private List<String> types;
	
	@Field(type=FieldType.String)
	private List<String> superTypes;
	
	@Field(type=FieldType.String)
	private List<String> subTypes;
	
	@Field(type=FieldType.String)
	private List<String> names;
	
	@Field(type=FieldType.String)
	private List<String> variations;
	
	@Field(type=FieldType.String)
	private String text;
	
	@Field(type=FieldType.String)
	private String setCode;
	
	@Field(type=FieldType.String)
	private String rarity;
	
	@Field(type=FieldType.String)
	private String type;
	
	@Field(type=FieldType.String)
	private String imageName;
	
	@Field(type=FieldType.String)
	private String layout;
	
	@Field(type=FieldType.String)
	private String flavor;
	
	@Field(type=FieldType.String)
	private String border;
	
	@Field(type=FieldType.String)
	private String loyalty;
	
	@Field(type=FieldType.Integer)
	private Integer number;
	
	@Field(type=FieldType.String)
	private String artist;
	
	@Field(type=FieldType.String)
	private String watermark;
	
	@Field(type=FieldType.String)
	private Integer toughness;
	
	
	@Field(type=FieldType.String)
	private String manaCost;
	
	@Field(type=FieldType.Integer)
	private Integer cmc;
	
	@Field(type=FieldType.String)
	private List<String> colors;
	
	
	
	@Field(type=FieldType.Integer)
	private Integer power;

	

	

	
	
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

	public Integer getMultiverseid() {
		return multiverseid;
	}

	public void setMultiverseid(Integer multiverseid) {
		this.multiverseid = multiverseid;
	}

	public List<String> getSuperTypes() {
		return superTypes;
	}

	public void setSuperTypes(List<String> superTypes) {
		this.superTypes = superTypes;
	}

	public List<String> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(List<String> subTypes) {
		this.subTypes = subTypes;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<String> getVariations() {
		return variations;
	}

	public void setVariations(List<String> variations) {
		this.variations = variations;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSetCode() {
		return setCode;
	}

	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public String getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	public Integer getToughness() {
		return toughness;
	}

	public void setToughness(Integer toughness) {
		this.toughness = toughness;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	@Override
	public String toString() {
		return String
				.format("Card [\n"
						+ "\tid = %s,\n"
						+ "\tmultiverseid = %s,\n"
						+ "\tname = %s,\n"
						+ "\tsetName = %s,\n"
						+ "\ttypes = %s,\n"
						+ "\tsuperTypes = %s,\n"
						+ "\tsubTypes = %s,\n"
						+ "\tnames = %s,\n"
						+ "\tvariations = %s,\n"
						+ "\ttext = %s,\n"
						+ "\tsetCode = %s,\n"
						+ "\trarity = %s,\n"
						+ "\ttype = %s,\n"
						+ "\timageName = %s,\n"
						+ "\tlayout = %s,\n"
						+ "\tflavor = %s,\n"
						+ "\tborder = %s,\n"
						+ "\tloyalty = %s,\n"
						+ "\tnumber = %s,\n"
						+ "\tartist = %s,\n"
						+ "\twatermark = %s,\n"
						+ "\ttoughness = %s,\n"
						+ "\tmanaCost = %s,\n"
						+ "\tcmc = %s,\n"
						+ "\tcolors = %s,\n"
						+ "\tpower = %s\n]\n",
						
						
						id, multiverseid, name, setName, types, superTypes,
						subTypes, names, variations, text, setCode, rarity,
						type, imageName, layout, flavor, border, loyalty,
						number, artist, watermark, toughness, manaCost, cmc,
						colors, power);
	}
	
	
	
}
