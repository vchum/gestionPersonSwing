package entity;

public class FileConfig {
	
	private String service;
	private String klass;
	
	public FileConfig() {
		
	}
	
	public FileConfig(String service, String klass) {
		this.service = service;
		this.klass = klass;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getKlass() {
		return klass;
	}

	public void setKlass(String klass) {
		this.klass = klass;
	}
	
	

}
