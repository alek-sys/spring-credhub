package org.springframework.credhub.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.credhub.configuration.CredHubAutoConfigurationTest.TestConfig;
import org.springframework.credhub.core.CredHubTemplate;
import org.springframework.credhub.core.OAuth2CredHubTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Daniel Lavoie
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class, value = "spring.credhub.url=http://localhost")
public class CredHubAutoConfigurationTest {
	@Autowired
	private CredHubTemplate credHubTemplate;
	
	@Autowired(required = false)
	private OAuth2CredHubTemplate oauth2CredHubTemplate;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(credHubTemplate);
		Assert.assertNull(oauth2CredHubTemplate);
	}

	@SpringBootApplication
	public static class TestConfig {

	}
}