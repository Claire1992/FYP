package com.example.agdiagnose.database;

public class MyMarkerObj {
	
	private long id_vet;
	private String title;
	private String snippet;
	private String position;
	
	
	public MyMarkerObj(){	
	}
	
	public MyMarkerObj(long id_vet, String title, String snippet, String position ) {

		this.id_vet = id_vet;
		this.title = title;
		this.snippet = snippet;
		this.position = position;
		
	}
	public MyMarkerObj(String title, String snippet, String position) {

		
		this.title = title;
		this.snippet = snippet;
		this.position = position;
		
	}

	public long getId_vet() {
		return id_vet;
	}

	public void setId_vet(long id_vet) {
		this.id_vet = id_vet;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	

}
