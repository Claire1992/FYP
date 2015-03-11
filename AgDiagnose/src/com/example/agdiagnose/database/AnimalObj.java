package com.example.agdiagnose.database;

public class AnimalObj {

	private int id_animals;
	private String type_animals;
	
	
	public AnimalObj(){}


	public AnimalObj(int id_animals, String type_animals) {
		super();
		this.id_animals = id_animals;
		this.type_animals = type_animals;
	}
	
	public AnimalObj(String type_animals){
		this.type_animals = type_animals;
	}


	public int getId_animals() {
		return id_animals;
	}


	public void setId_animals(int id_animals) {
		this.id_animals = id_animals;
	}


	public String getType_animals() {
		return type_animals;
	}


	public void setType_animals(String type_animals) {
		this.type_animals = type_animals;
	}
	
	
}
