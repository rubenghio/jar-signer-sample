package ar.com.atos.sign;

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
		Process process = Runtime.getRuntime().exec(command	+ " " +  fileName);
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

	public static void main(String[] args) {
		JarChecker checker = new JarChecker(
				"/usr/java/jdk1.6.0_45/bin/jarsigner -verify -verbose -certs");
		try {
			int value = checker
					.verify("/home/rghio/Encrypted/Projects/Nacion/atos-signed-sample/target/AtosSignedJar.jar");
			System.out.println("Result: " + value);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
