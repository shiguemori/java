package br.com.cod3r.app.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Shiguemori
 *
 */
public class Logger {

	/**
	 * @param msg
	 */
	public static void info(String msg) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("[INFO] " + sdf.format(new Date()) + " - " + msg);
	}
}
