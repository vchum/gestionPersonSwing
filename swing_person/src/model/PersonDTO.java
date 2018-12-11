package model;

public class PersonDTO {
	
	private String id;

	private String nom;
	private String prenom;
	private int age;
	
	
	public PersonDTO(String nom, String prenom, int age) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public PersonDTO(String id, String nom, String prenom, int age) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return nom + " " + prenom + "["+age+"]";
	}
	
	


}
