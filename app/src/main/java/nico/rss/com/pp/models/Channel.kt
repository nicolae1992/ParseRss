package nico.rss.com.pp.models

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
class Channel {
    @get:ElementList(name = "item", inline = true)
    @set:ElementList(name = "item", inline = true)
    internal var items: List<Item>? = null
}