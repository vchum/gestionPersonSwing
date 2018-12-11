package service;

import java.util.ArrayList;
import java.util.List;

import Business.entitie.Person;
import Persistence.dao.PersonDao;
import Persistence.exception.DaoException;
import model.PersonDTO;

public class PersonSqlService implements IService<PersonDTO>{
	
	PersonDao psd = new PersonDao();
	PersonDtoService pds = new PersonDtoService();	
	
	public List<PersonDTO> list() throws DaoException{
		
		List<PersonDTO> list = new ArrayList<>();
		List<Person> l = psd.findList();
		for(Person p : l) {
			list.add(new PersonDTO(String.valueOf(p.getId()), p.getNom(), p.getPrenom(), p.getAge()));
		}		
		return list;	
		
	}
	
	public void add(PersonDTO pdto) throws DaoException {
		Person p = new Person();
		
		p = pds.fromDto(pdto);
		
		psd.create(p);
	}
	
	public void update(PersonDTO pdto) throws DaoException {
		Person p = new Person();
		p = pds.fromDto(pdto);		
		psd.updateById(p);
	}
	
	
	public PersonDTO getById(String id) throws NumberFormatException, DaoException {
		Person p = psd.findById(Long.valueOf(id));
		PersonDTO pdto = new PersonDTO(String.valueOf(p.getId()), p.getNom(), p.getPrenom(), p.getAge());
		return pdto;
	}
	
	public void delete(String id) throws Exception {
		
		psd.deleteById(Long.valueOf(id));
	}
	
	

}
