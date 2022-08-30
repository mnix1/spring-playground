package com.displate.javaenabling.springworkshop.mongo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIn.in;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MongoTemplateTests extends MongoTest {
	@Autowired
	MyRepository repository;

	private MyDocument document;

	@BeforeEach
	void setup() {
		repository.save(new MyDocument("id1", BigDecimal.ONE, List.of(
				new MyNestedObject("text1"),
				new MyNestedObject("text2")
		)));
		document = new MyDocument("id2", BigDecimal.TEN, List.of(
				new MyNestedObject("text1"),
				new MyNestedObject("text2")
		));
		repository.save(document);
		repository.save(new MyDocument("id3", BigDecimal.ZERO, List.of(
				new MyNestedObject("text3"),
				new MyNestedObject("text4")
		)));
		repository.save(new MyDocument("id4", BigDecimal.ONE, List.of(
				new MyNestedObject("text5"),
				new MyNestedObject("text6")
		)));
	}

	@Test
	void canFindById() {
		assertEquals(document, repository.findById(document.id()).get());
	}

	@Test
	void canFindByValue() {
		assertEquals(document, repository.findBySomeValue(BigDecimal.TEN).get());
	}

	@Test
	void canFindByCollectionProperty() {
		assertThat(document, is(in(
				repository.findBySomeObjectsText("text2")
		)));
	}

}
