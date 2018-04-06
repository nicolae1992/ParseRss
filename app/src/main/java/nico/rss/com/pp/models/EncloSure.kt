package nico.rss.com.pp.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "enclosure",strict = false)
class EncloSure {

    @set:Attribute(name = "url")
    @get:Attribute(name = "url")
    var url: String? = null

}