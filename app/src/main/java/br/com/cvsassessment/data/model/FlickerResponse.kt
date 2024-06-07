package br.com.cvsassessment.data.model

data class FlickerResponse(
    val items: List<FlickerItem>
)

data class FlickerItem(
    val title: String,
    val media: Media,
    val description: String,
    val author: String,
    val published: String
)

data class Media(
    val m: String
)

