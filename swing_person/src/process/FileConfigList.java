package process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.FileConfig;

public class FileConfigList {
	
	
	private List<FileConfig> list = new ArrayList<>();
	
	//public static boolean verif = false;
	
	
	public List<FileConfig> getConfigList() throws IOException {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			File file = new File("file/lister.cfg");		
			//FileInputStream fis = new FileInputStream(file);	
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String inputLine;
			
			while((inputLine = br.readLine()) != null) {
				
				String[] test = inputLine.split(",");
				String serv = test[0].substring(8, test[0].length());
				String kla = test[1].substring(6, test[1].length());
				
				list.add(new FileConfig(serv, kla));
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}

}
