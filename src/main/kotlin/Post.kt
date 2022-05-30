data class Post(
    val id: Int,
    val ownerId: Int = 1,
    val fromId: Int = 1,
    val createdBy : Int = 0,
    val date : Int,
    val text : String,
    val replyOwnerId : Int = 1,
    val replyPostId : Int = 1,
    val friendsOnly : Boolean = false,
    val comments : Comments,
    val copyright: String?,
    val likes : Likes,
    val repost : Repost?,
    val views : Views,
    val postType : String = "post",
    val postSource : PostSource,
    val attachments: Array<Attachments>,
    val geo : Geo?,
    val signerId : Int?,
    val copyHistory : Array<String> = arrayOf(),
    val canPin : Boolean = true,
    val canDelete : Boolean = true,
    val canEdit : Boolean = true,
    val isPinned : Boolean = false,
    val markedAsAds : Boolean = false,
    val isFavorite : Boolean = false,
    val postponedId : Int = 1
)

data class Comments (
    var count : Int = 0,
    val canPost : Boolean = true
)

data class Likes(
    val count : Int = 0,
    val userLikes : Boolean = false
)

data class Repost (
    val count : Int = 0,
    val userReposted : Boolean = false
)

data class Views(val count : Int = 0)

data class PostSource(
    val type : String = "vk",
    val platform : String = "android",
    val data : String = "profile_activity",
    val url : String = "0"
)

data class Geo(
    val type: String = "Home",
    val coordinates : String = "0"
)
