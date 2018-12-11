package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Persistence.exception.DaoException;
import model.PersonDTO;
import persistence.dao.PersonDao;

public class BagnoleNoSqlService implements IService<PersonDTO> {
	
	PersonDao psd = new PersonDao();
	PersonDtoService pds = new PersonDtoService();

	@Override
	public List<PersonDTO> list() throws DaoException {
		
		List<PersonDTO> list = new ArrayList<>();
	
		
		for (Map<String, Object> p : psd.findAll()) {
			
			
			list.add(pds.fromMap(p));
		}
		
		return list;
	}

	@Override
	public void add(PersonDTO pdto) throws DaoException {
		// TODO Auto-generated method stub
		Map<String, Object> pMap = new HashMap<>();
		pMap = pds.fromEntityNoSqlForCreate(pdto);
		
		psd.create(pMap);
	}

	@Override
	public void update(PersonDTO pdto) throws DaoException {
		// TODO Auto-generated method stub
		
		Map<String, Object> pMap = new HashMap<>();
		pMap = pds.fromEntityNoSql(pdto);		
		psd.updateById(pMap);
		
	}

	@Override
	public PersonDTO getById(String id) throws NumberFormatException, DaoException {
		// TODO Auto-generated method stub
		Map<String, Object> pMap = new HashMap<>();
		pMap = psd.getById(id);		
		PersonDTO pdto = pds.fromMap(pMap);		
		return pdto;
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		psd.deleteById(id);
		
	}

}
