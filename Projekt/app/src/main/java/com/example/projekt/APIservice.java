package com.example.projekt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIservice {
    @GET("index")
    public Call<List<Client>> getClients();

    @GET("showclient/{id}")
    public Call<Client> getStudentWithID(@Path("id") int id);

    //Insert new client
    @FormUrlEncoded
    @POST("addclient")
    public Call<Client> createClient(
            @Field("username") String name,
            @Field("password") String password,
            @Field("tel") String tel,
            @Field("country") String country,
            @Field("locality") String locality,
            @Field("adress") String adress,
            @Field("client_id") Integer clientid,
            @Field("client_secret") String clientsecret);


    //update client
    @FormUrlEncoded
    @POST("update/{id}")
    public Call<Client> updateClient(
            @Field("username") String name,
            @Field("tel") String tel,
            @Field("country") String country,
            @Field("locality") String locality,
            @Field("adress") String adress,
            @Field("client_id") Integer clientid,
            @Field("client_secret") String clientsecret);

    //Delete client
    @DELETE("delete/{id}")
    public Call<Client> deleteClientWithID(
            @Path("id") int id,
            @Field("client_id") Integer clientid,
            @Field("client_secret") String clientsecret);
}
