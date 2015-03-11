package com.example.agdiagnose.database;

import java.sql.Blob;

public class DiseaseObj {

	private int _id;
	private String name_diseases;
	private String description_diseases;
	private Blob image_diseases;
	
	
	public DiseaseObj(){}


	public DiseaseObj(int _id, String name_diseases,
			String description_diseases, Blob image_diseases) {
		super();
		this._id = _id;
		this.name_diseases = name_diseases;
		this.description_diseases = description_diseases;
		this.image_diseases = image_diseases;
	}
	
	public DiseaseObj(String name_diseases,
			String description_diseases, Blob image_diseases) {
		
		this.name_diseases = name_diseases;
		this.description_diseases = description_diseases;
		this.image_diseases = image_diseases;
	}


	public int get_id() {
		return _id;
	}


	public void set_id(int _id) {
		this._id = _id;
	}


	public String getName_diseases() {
		return name_diseases;
	}


	public void setName_diseases(String name_diseases) {
		this.name_diseases = name_diseases;
	}


	public String getDescription_diseases() {
		return description_diseases;
	}


	public void setDescription_diseases(String description_diseases) {
		this.description_diseases = description_diseases;
	}


	public Blob getImage_diseases() {
		return image_diseases;
	}


	public void setImage_diseases(Blob image_diseases) {
		this.image_diseases = image_diseases;
	}


	
	
}
