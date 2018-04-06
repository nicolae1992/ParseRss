package nico.rss.com.pp.rest;

import nico.rss.com.pp.models.RSS;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("/rss/une.xml")
    Call<RSS> getNews();
}
