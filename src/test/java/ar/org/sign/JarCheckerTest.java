package ar.org.sign;

import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.junit.Test;

import ar.org.sign.JarChecker;

public class JarCheckerTest {
	@Test
	public void testSignPassed() throws IOException, InterruptedException {
		JarChecker checker = new JarChecker("jarsigner -verify -verbose -certs");
		URL url = Thread.currentThread().getContextClassLoader()
				.getResource("SignedJarSampleValido.jar");
		int result = checker.verify(url.getPath());
		Assert.assertEquals("El valor NO es el esperado", 0, result);
	}

	@Test
	public void testSignFailed() throws IOException, InterruptedException {
		JarChecker checker = new JarChecker("jarsigner -verify -verbose -certs");
		URL url = Thread.currentThread().getContextClassLoader()
				.getResource("SignedJarSampleInvalido.jar");
		int result = checker.verify(url.getPath());
		Assert.assertEquals("El valor NO es el esperado", 1, result);
	}

	@Test(expected = IOException.class)
	public void testSignError() throws IOException, InterruptedException {
		JarChecker checker = new JarChecker("/usr/java/jdk1.6.0_45/bin/error");
		checker.verify("NO FILE");
		Assert.fail("El test debería haber fallado");
	}
}
