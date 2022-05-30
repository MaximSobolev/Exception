interface Attachments {
    val type : String
}

data class PhotoAttachments (
    override val type: String = "photo",
    private val id: Int,
    private val albumId: Int,
    private val ownerId: Int,
    private val userId: Int,
    private val text : String,
    private val date : Int,
    val photo : Photo = Photo (id, albumId, ownerId, userId, text, date)
) : Attachments

data class VideoAttachments (
    override val type: String = "video",
    private val id: Int,
    private val ownerId: Int,
    private val title : String,
    private val description : String,
    private val date : Int,
    val video : Video = Video (id,ownerId, title, description, date)
) : Attachments

data class AudioAttachments (
    override val type: String = "audio",
    private val id: Int,
    private val ownerId: Int,
    private val artist : String,
    private val title : String,
    private val date: Int,
    val audio : Audio = Audio (id,ownerId, artist, title, date)
) : Attachments

data class DocAttachments (
    override val type: String = "doc",
    private val id: Int,
    private val ownerId: Int,
    private val title : String,
    private val size : Int,
    private val date: Int,
    val doc : Doc = Doc (id,ownerId, title, size, date)
) : Attachments

data class LinkAttachments (
    override val type: String = "link",
    private val url: String,
    private val title : String,
    val link : Link = Link (url, title)
) : Attachments

data class Photo (
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text : String,
    val date : Int
)

data class Video (
    val id: Int,
    val ownerId: Int,
    val title : String,
    val description : String,
    val date : Int
)

data class Audio (
    val id: Int,
    val ownerId: Int,
    val artist : String,
    val title : String,
    val date: Int
)

data class Doc (
    val id: Int,
    val ownerId: Int,
    val title : String,
    val size : Int,
    val date: Int
)

data class Link (
    val url: String,
    val title : String
)