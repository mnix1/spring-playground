/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomUser {

	private final long id;

	private final String email;
	private final boolean admin;

	@JsonIgnore
	private final String password;

	@JsonCreator
	public CustomUser(long id, String email, boolean admin, String password) {
		this.id = id;
		this.email = email;
		this.admin = admin;
		this.password = password;
	}

	public long getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public boolean isAdmin() {
		return admin;
	}
}
