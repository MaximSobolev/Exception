data class Comment(
    val id : Int,
    val fromId : Int,
    val date : Int,
    val text : String,
    val donut : Donut,
    val replyToUser : Int,
    val replyToComment : Int,
    val attachments: Array<Attachments>,
    val parentsStack : Array<Comment>?,
    val thread : Thread
)

data class Donut (
    val isDon : Boolean,
    val placeholder : String
        )

data class Thread (
    val count : Int,
    val items : Array<Comment>?,
    val canPost : Boolean,
    val showReplyButton : Boolean,
    val groupsCanPost : Boolean
        )