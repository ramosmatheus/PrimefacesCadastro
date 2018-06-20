package banco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {
	
	private static EntityManagerFactory fabrica;
	
	public static EntityManagerFactory get() {
		
		if(fabrica == null) {
			
			try {
				fabrica = Persistence.createEntityManagerFactory("aulaPU");
			}catch(Exception e){
				e.printStackTrace();
			}
			
		
		}
		return fabrica;
		
		
	}

}
