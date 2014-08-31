package ajtdd;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Debug {
	public static boolean on = false;
	
	public static Logger log;
	
	static {
		log = Logger.getGlobal();
		if (on) {
			log.setLevel(Level.INFO);
		} else {
			log.setLevel(Level.OFF);
		}
	}
}
