package uy.com.arnaldocastro.servicedesk.otros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DireccionConsumo {

	private static DireccionConsumo instance;
	
	private DireccionConsumo(){		
	}
	
	public static DireccionConsumo getInstance(){
		
		if (instance == null)
			instance = new DireccionConsumo();
		
		return instance;
		
	}
	
	public String direccionIP(){

		Properties defaultProps = new Properties();
		  String home=System.getProperty("user.home");
		  
		  System.out.println(home);
        FileInputStream in = null;
		try {
			
			String os = System.getProperty("os.name").toLowerCase();
			if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0)
			in = new FileInputStream(home+"/configuraciones.properties");
			else
				in = new FileInputStream("C:/configuraciones.properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			defaultProps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String dir=defaultProps.getProperty("ip");
		return dir;
		
	}
}
