package com.displate.javaenabling.springworkshop.restclient.app4circuitbreaker;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

interface ExternalApi {

    @GET("users")
    Call<List<UserDTO>> getUsers();
}
