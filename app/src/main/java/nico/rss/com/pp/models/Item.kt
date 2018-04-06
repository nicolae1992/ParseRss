package nico.rss.com.pp.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item",strict = false)
class Item {

    @set:Element(name = "link")
    @get:Element(name = "link")
    var link: String? = null

    @set:Element(name = "title")
    @get:Element(name = "title")
    var title: String? = null

    @set:Element(name = "description")
    @get:Element(name = "description")
    var description: String? = null

    @set:Element(name = "pubDate")
    @get:Element(name = "pubDate")
    var pubDate: String? = null

    @set:Element(name = "enclosure")
    @get:Element(name = "enclosure")
    var enclosure: EncloSure? = null

}