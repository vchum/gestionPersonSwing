package service;

import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;

import Business.entitie.Person;
import model.PersonDTO;

public class PersonDtoService {
	
	
	
	public Person fromDto(PersonDTO pdto) {
		Person p = new Person();
		p.setId(Integer.valueOf(pdto.getId()));
		p.setNom(pdto.getNom());
		p.setPrenom(pdto.getPrenom());
		p.setAge(pdto.getAge());
		return p;
		
	}
	
	public PersonDTO fromEntity(Person p) {
		PersonDTO pdo = new PersonDTO();
		pdo.setId(String.valueOf(p.getId()));
		pdo.setNom(p.getNom());
		pdo.setPrenom(p.getPrenom());
		pdo.setAge(p.getAge());
		return pdo;
		
	}
	
	public PersonDTO fromMap(Map<String, Object> pMap) {
		PersonDTO p = new PersonDTO();
		p.setId(pMap.get("_id").toString());
		p.setNom(pMap.get("nom").toString());
		p.setPrenom(pMap.get("prenom").toString());
		p.setAge(Integer.valueOf(pMap.get("age").toString()));
		
		return p;
		
	}
	
	public Map<String, Object> fromEntityNoSql(PersonDTO pdto) {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("_id", new ObjectId(pdto.getId()));
		pMap.put("nom", pdto.getNom());
		pMap.put("prenom", pdto.getPrenom());
		pMap.put("age", pdto.getAge());
		return pMap;
		
	}
	
	public Map<String, Object> fromEntityNoSqlForCreate(PersonDTO pdto) {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("nom", pdto.getNom());
		pMap.put("prenom", pdto.getPrenom());
		pMap.put("age", pdto.getAge());
		return pMap;
		
	}

}
