object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()

    fun add (post : Post) : Post {
        val postWithId = post.copy(id = posts.size + 1)
        posts += postWithId
        return posts.last()
    }

    fun update (post : Post) : Boolean {
        for ((index, oldPost) in posts.withIndex()) {
            if (post.id == oldPost.id) {
                posts[index] = post.copy(ownerId = oldPost.ownerId, date = oldPost.date)
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, post) in posts.withIndex()) {
            if (postId == post.id) {
                posts[index] = post.copy(comments = Comments(post.comments.count + 1))
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("No post with $postId")
    }

    fun reportComment (ownerId : Int, commentId : Int, reason : Int) : Int {
        if ((reason < 0) or (reason > 8)) {
            throw UnknownReasonException ("Unknown reason, please try again")
        }

        for ((index, comment) in comments.withIndex()) {
            if (commentId == comment.id) {
                val report = Report (ownerId, commentId, reason)
                reports += report
                return 1
            }
        }

        throw CommentNotFoundException("No comment with $commentId")
    }
}