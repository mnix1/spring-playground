package com.displate.javaenabling.springworkshop.restclient.app1retrofitget;

import com.displate.javaenabling.springworkshop.restclient.base.WiremockHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class App1Test {


	@Autowired
	MyService myService;


	@RegisterExtension
	static WiremockHelper wiremock = WiremockHelper.buildWiremock();

	@Test
	void contextLoads() throws IOException {
		wiremock.stubFor(get("/users").willReturn(okJson("""
				[
					{"name": "user1"},
					{"name": "user2"}
				]
				""")));

		assertEquals(List.of(new UserDTO("user1"), new UserDTO("user2")), myService.getUsers());
	}

}
