package process;

import java.util.List;

import Persistence.manager.exception.ManagerException;
import entity.FileConfig;

public class CfgManager {
	
	
	private FileConfigList fcl = new FileConfigList();
	
	public static boolean verif = false;
		
	private static CfgManager instance = null;
	
	private CfgManager()  {
		
	}
	
	public static CfgManager getInstance() throws ManagerException {
		
		if(instance == null) {
			instance = new CfgManager();
		}
		
		return instance;
	}

	public String loadCfg() {
		
		String o = null;
		
		try {
			
			List<FileConfig> listCfg = fcl.getConfigList();
			
			if(verif == true) {
				
				return listCfg.get(0).getKlass();
			}
													
			else  {	
				
				return listCfg.get(1).getKlass();

			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}
