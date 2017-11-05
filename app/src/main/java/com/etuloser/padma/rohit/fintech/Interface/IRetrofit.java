package com.etuloser.padma.rohit.fintech.Interface;

import com.etuloser.padma.rohit.fintech.RequestObjects.cobrand;
import com.etuloser.padma.rohit.fintech.ResponseObjects.cobrandresponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Rohit on 11/5/2017.
 */

public interface IRetrofit {



    @POST("restserver/v1/cobrand/login")
    Call<cobrandresponse> login(@Body cobrand lr);


    /*@POST("api/register")
    Call<loginresponse> register(@Body user lr);


    @POST("api/view")
    Call<viewuser> viewuser(@Body loginresponse lr);
*/
}
