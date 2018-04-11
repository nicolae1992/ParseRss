# Parser News
This app show last news from france, this project is written in the language Kotlin and parse information RSS XML
# How to
#### import
Use library [Retrofit2](http://square.github.io/retrofit/) ,so I added the dependency for request http(s):
```Gradle
dependencies {
  implementation 'com.squareup.retrofit2:retrofit:2.4.0' 
}
```
and for parser RSS with [Retrofit2](http://square.github.io/retrofit/) i use [simplexml](http://simple.sourceforge.net/) for convert into Object

```Gradle
dependencies {
  implementation 'com.squareup.retrofit2:converter-simplexml:2.3.0'
}
```
#### Use:
```kotlin
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

public class RetrofitClientt {
    companion object {
        private var retrofit: Retrofit? = null
        fun getClient(baseUrl: String): Retrofit? {
                retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                        .build()
            return retrofit
        }
}}
```
`.addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
`

this line help you parse XML RSS

MainActivity.kt
```kotlin
private fun getNews() {
        val call = ApiUtilss.getNewsService().news
        call.enqueue(object : Callback<RSS> {
            override fun onResponse(call: Call<RSS>?, response: Response<RSS>?) {
                val kk = response!!.body()
                if (kk != null) {
                    arrayNews?.addAll(kk.channel?.items!!)
                    adapter!!.notifyDataSetChanged()
                    listener()
                }
                progress.visibility = View.GONE
            }

            override fun onFailure(call: Call<RSS>?, t: Throwable?) {
                progress.visibility = View.GONE
            }

        })
    }
```
## Sample app
I wrote a simple app that shows latest News 

<img src="https://github.com/nicolae1992/ParseRss/blob/master/screen/Screenshot_20180411-193058.png" width="30%" height="30%">
<img src="https://github.com/nicolae1992/ParseRss/blob/master/screen/Screenshot_20180411-193103.png" width="30%" height="30%">
<img src="https://github.com/nicolae1992/ParseRss/blob/master/screen/Screenshot_20180411-193228.png" width="30%" height="30%">
