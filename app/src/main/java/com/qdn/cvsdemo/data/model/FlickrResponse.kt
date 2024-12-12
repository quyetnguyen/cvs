package com.qdn.cvsdemo.data.model

import com.squareup.moshi.Json
import org.jsoup.Jsoup

data class FlickrResponse(
    val items: List<FlickrItem>
)

data class FlickrItem(
    val title: String,
    val link: String,
    val media: Media,
    val date_taken: String,
    val description: String,
    val published: String,
    val author: String,
    val author_id: String,
    val tags: String
)

data class Media(
    @Json(name = "m") val imageUrl: String
)

/**
 * There are some properties that we don't need that comes down from the API
 * We'll clean it up here
 */
fun FlickrItem.toDomainModel(): FlickrImage {
    val dimensions = extractDimensions(description) ?: (640 to 480)
    return FlickrImage(
        title = title,
        imageUrl = media.imageUrl,
        width = dimensions.first,
        height = dimensions.second,
        published = published,
        tags = tags
    )
}

/**
 * Since Flickr doesn't provide width & height in the JSON fields we'll need to extract
 * Extracts width and height attributes from the first <img> tag in the HTML description.
 * Returns a pair of (width, height) or null if not found.
 */
private fun extractDimensions(description: String): Pair<Int, Int>? {
    val doc = Jsoup.parse(description)
    val img = doc.select("img").first() ?: return null
    val width = img.attr("width").toIntOrNull()
    val height = img.attr("height").toIntOrNull()
    return if (width != null && height != null) width to height else null
}

data class FlickrImage(
    val title: String,
    val imageUrl: String,
    val width: Int,
    val height: Int,
    val published: String,
    val tags: String
)