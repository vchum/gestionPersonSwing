package process;

import model.PersonDTO;
import service.IService;


public class MyPersonFactory {
	
	
	@SuppressWarnings("unchecked")
	public static IService<PersonDTO> newInstance() throws Exception {
				
		Class<?> klass = Class.forName(CfgManager.getInstance().loadCfg());
		
		Object o = klass.newInstance();
		
		return (IService<PersonDTO>) o;
		
	}

}

