import WallService.add
import WallService.createComment
import WallService.reportComment
import WallService.update
import org.junit.Assert.*
import org.junit.Test

internal class WallServiceTest {

    @Test
    fun addTest() {
        val comments = Comments()
        val likes = Likes()
        val repost = Repost()
        val views = Views()
        val postSource = PostSource()
        val geo = Geo()
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)


        val post = Post(
            id = 0,
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            attachments = arrayOf(audio, photo),
            geo = geo,
            signerId = 0
        )

        val result = add(post).id

        assertEquals(1, result)
    }

    @Test
    fun updateWithoutExistingId() {
        val comments = Comments()
        val likes = Likes()
        val repost = Repost()
        val views = Views()
        val postSource = PostSource()
        val geo = Geo()
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)

        val post = Post(
            id = 1,
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            attachments = arrayOf(audio, photo),
            geo = geo,
            signerId = 0
        )

        val result = update(post)

        assertFalse(result)
    }

    @Test
    fun updateWithExistingId() {
        val comments = Comments()
        val likes = Likes()
        val repost = Repost()
        val views = Views()
        val postSource = PostSource()
        val geo = Geo()
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)

        val post = Post(
            id = 2,
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            attachments = arrayOf(audio, photo),
            geo = geo,
            signerId = 0
        )

        val addedPost = add(post)
        val result = update(addedPost)

        assertTrue(result)
    }

    @Test
    fun createCommentFoundPost() {
        val comments = Comments()
        val likes = Likes()
        val repost = Repost()
        val views = Views()
        val postSource = PostSource()
        val geo = Geo()
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)

        val post = Post(
            id = 3,
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            attachments = arrayOf(audio, photo),
            geo = geo,
            signerId = 0
        )

        val donut = Donut (
            isDon = true,
            placeholder = "donut comment"
                )

        val thread = Thread (
            count = 0,
            items = null,
            canPost = true,
            showReplyButton = true,
            groupsCanPost = false
                )

        val comment = Comment (
            id = 0,
            fromId = 1,
            date = 30052022,
            text = "content",
            donut = donut,
            replyToUser = 1,
            replyToComment = 1,
            attachments = arrayOf(audio, photo),
            parentsStack = null,
            thread = thread
                )

        add(post)
        val result = createComment(2, comment)

        assertEquals(comment, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentNotFoundPost() {
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)

        val donut = Donut (
            isDon = true,
            placeholder = "donut comment"
        )

        val thread = Thread (
            count = 0,
            items = null,
            canPost = true,
            showReplyButton = true,
            groupsCanPost = false
        )

        val comment = Comment (
            id = 1,
            fromId = 1,
            date = 30052022,
            text = "content",
            donut = donut,
            replyToUser = 1,
            replyToComment = 1,
            attachments = arrayOf(audio, photo),
            parentsStack = null,
            thread = thread
        )

        createComment(100, comment)
    }

    @Test
    fun reportCommentFoundComment() {
        val comments = Comments()
        val likes = Likes()
        val repost = Repost()
        val views = Views()
        val postSource = PostSource()
        val geo = Geo()
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)


        val post = Post(
            id = 4,
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            attachments = arrayOf(audio, photo),
            geo = geo,
            signerId = 0
        )

        val donut = Donut (
            isDon = true,
            placeholder = "donut comment"
        )

        val thread = Thread(
            count = 0,
            items = null,
            canPost = true,
            showReplyButton = true,
            groupsCanPost = false
        )

        val comment = Comment (
            id = 2,
            fromId = 2,
            date = 30052022,
            text = "content",
            donut = donut,
            replyToUser = 1,
            replyToComment = 1,
            attachments = arrayOf(audio, photo),
            parentsStack = null,
            thread = thread
        )

        add(post)
        createComment(3, comment)

        val result = reportComment(1, 2, 0)
        assertEquals(1, result)
    }

    @Test(expected = UnknownReasonException::class)
    fun reportCommentUnknownReason() {
        reportComment(1, 1, -1)
    }

    @Test(expected = CommentNotFoundException::class)
    fun reportCommentCommentNotFound() {
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)

        val donut = Donut (
            isDon = true,
            placeholder = "donut comment"
        )

        val thread = Thread(
            count = 0,
            items = null,
            canPost = true,
            showReplyButton = true,
            groupsCanPost = false
        )

        val comment = Comment (
            id = 1,
            fromId = 1,
            date = 30052022,
            text = "content",
            donut = donut,
            replyToUser = 1,
            replyToComment = 1,
            attachments = arrayOf(audio, photo),
            parentsStack = null,
            thread = thread
        )

        reportComment(1, 1, 0)
    }
}