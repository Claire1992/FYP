package com.example.agdiagnose.database;

import java.sql.Blob;

public class ReproductionObj {
	
	private int id_reproduction;
	private String breeding_intro_reproduction;
	private String breeding_reproduction;
	private String gestation_intro_reproduction;
	private String gestation_reproduction;
	private String birth_intro_reproduction;
	private String birth_reproduction;
	private byte[] image_reproduction;
	private String animal_reproduction;
	
	
	
	
	public ReproductionObj() {}
	
	public ReproductionObj(int id_reproduction,
			String breeding_intro_reproduction, String breeding_reproduction,
			String gestation_intro_reproduction, String gestation_reproduction,
			String birth_intro_reproduction, String birth_reproduction, byte[] image_reproduction,
			String animal_reproduction) {
		super();
		this.id_reproduction = id_reproduction;
		this.breeding_intro_reproduction = breeding_intro_reproduction;
		this.breeding_reproduction = breeding_reproduction;
		this.gestation_intro_reproduction = gestation_intro_reproduction;
		this.gestation_reproduction = gestation_reproduction;
		this.birth_intro_reproduction = birth_intro_reproduction;
		this.birth_reproduction = birth_reproduction;
		this.image_reproduction = image_reproduction;
		this.animal_reproduction = animal_reproduction;
		
	}
		
		public ReproductionObj(
				String breeding_intro_reproduction, String breeding_reproduction,
				String gestation_intro_reproduction, String gestation_reproduction,
				String birth_intro_reproduction, String birth_reproduction, byte[] image_reproduction,
				String animal_reproduction) {
			this.breeding_intro_reproduction = breeding_intro_reproduction;
			this.breeding_reproduction = breeding_reproduction;
			this.gestation_intro_reproduction = gestation_intro_reproduction;
			this.gestation_reproduction = gestation_reproduction;
			this.birth_intro_reproduction = birth_intro_reproduction;
			this.birth_reproduction = birth_reproduction;
			this.image_reproduction = image_reproduction;
			this.animal_reproduction = animal_reproduction;
			
	}

		public int getId_reproduction() {
			return id_reproduction;
		}

		public void setId_reproduction(int id_reproduction) {
			this.id_reproduction = id_reproduction;
		}

		public String getBreeding_intro_reproduction() {
			return breeding_intro_reproduction;
		}

		public void setBreeding_intro_reproduction(String breeding_intro_reproduction) {
			this.breeding_intro_reproduction = breeding_intro_reproduction;
		}

		public String getBreeding_reproduction() {
			return breeding_reproduction;
		}

		public void setBreeding_reproduction(String breeding_reproduction) {
			this.breeding_reproduction = breeding_reproduction;
		}

		public String getGestation_intro_reproduction() {
			return gestation_intro_reproduction;
		}

		public void setGestation_intro_reproduction(String gestation_intro_reproduction) {
			this.gestation_intro_reproduction = gestation_intro_reproduction;
		}

		public String getGestation_reproduction() {
			return gestation_reproduction;
		}

		public void setGestation_reproduction(String gestation_reproduction) {
			this.gestation_reproduction = gestation_reproduction;
		}

		public String getBirth_intro_reproduction() {
			return birth_intro_reproduction;
		}

		public void setBirth_intro_reproduction(String birth_intro_reproduction) {
			this.birth_intro_reproduction = birth_intro_reproduction;
		}

		public String getBirth_reproduction() {
			return birth_reproduction;
		}

		public void setBirth_reproduction(String birth_reproduction) {
			this.birth_reproduction = birth_reproduction;
		}

		public byte[] getImage_reproduction() {
			return image_reproduction;
		}

		public void setImage_reproduction(byte[] image_reproduction) {
			this.image_reproduction = image_reproduction;
		}

		public String getAnimal_reproduction() {
			return animal_reproduction;
		}

		public void setAnimal_reproduction(String animal_reproduction) {
			this.animal_reproduction = animal_reproduction;
		}

		
	
	
	
	
	
	
	

}
