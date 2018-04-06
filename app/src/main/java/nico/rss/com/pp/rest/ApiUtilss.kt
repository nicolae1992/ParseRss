package nico.rss.com.pp.rest

public class ApiUtilss {
    companion object {
        val BASE_URL = "http://lemonde.fr"
        fun getNewsService(): NewsService {
            return RetrofitClientt.getClient(BASE_URL)!!.create(NewsService::class.java)
        }
    }

}