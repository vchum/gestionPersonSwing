package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

public class BagnoleModel extends AbstractListModel<PersonDTO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PersonDTO> list = new ArrayList<>();
	
	public BagnoleModel(List<PersonDTO> list) {
		this.list = list;
	}


	@Override
	public int getSize() {
		int size = 0;
		try {
			//list = service.list();
			size = list.size();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return size;
	}

	@Override
	public PersonDTO getElementAt(int index) {
		PersonDTO dto = null;
		if (index == -1) {
			return null;
		}
		try {
			dto = list.get(index);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dto;
	}

}
