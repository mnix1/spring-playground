package com.displate.javaenabling.springworkshop.mongo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MongoTemplateTests extends MongoTest {
	@Autowired
	MongoOperations operations;

	@Test
	void indexCreated() {
		Optional<IndexInfo> someValueIndex = operations.indexOps(MyIndexedDocument.class)
				.getIndexInfo()
				.stream()
				.filter((indexInfo -> indexInfo.isIndexForFields(Collections.singletonList("someValue"))))
				.findFirst();

		assertTrue(someValueIndex.isPresent());
	}

	@Test
	void compoundIndexCreated() {
		Optional<IndexInfo> someValueIndex = operations.indexOps(MyIndexedDocument.class)
				.getIndexInfo()
				.stream()
				.filter((indexInfo -> indexInfo.isIndexForFields(List.of("someValue", "otherValue"))))
				.findFirst();

		assertTrue(someValueIndex.isPresent());
	}

	@Test
	void indexedQueryTest() {
		for (int i = 0; i < 100; i++) {
			operations.save(new MyIndexedDocument(UUID.randomUUID().toString(),
					BigDecimal.valueOf(i), BigDecimal.ZERO));
		}

		List<MyIndexedDocument> myIndexedDocuments = operations.find(Query.query(
						Criteria.where("someValue").gt("20").lt("30")),
				MyIndexedDocument.class);

		assertEquals(10, myIndexedDocuments.size());
	}
}
