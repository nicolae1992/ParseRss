package nico.rss.com.pp.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import android.R.attr.name




@Root(name = "rss", strict = false)
public class RSS {
    @set:Element(name = "channel")
    @get:Element(name = "channel")
    public var channel: Channel? = null


   // @get:Element var channel: Channel? = null
    /*@set:Element(name = "channel")
    @get:Element var channel: Channel? = null*/

}