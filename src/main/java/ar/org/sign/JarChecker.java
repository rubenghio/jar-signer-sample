package ar.org.sign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class JarChecker {
	private Logger log = Logger.getLogger(JarChecker.class);
	private String command;

	public JarChecker(String command) {
		this.command = command;
	}

	public int verify(String fileName) throws IOException, InterruptedException {
		log.info("Verificando firmas de '" + log + "'");
		String line;
		Process process = Runtime.getRuntime().exec(command + " " + fileName);
		process.waitFor();
		InputStream stdout = process.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(stdout));
		String output = "";
		while ((line = reader.readLine()) != null) {
			output = output + line + "\n";
		}
		log.debug(output);
		return process.exitValue();
	}
}
