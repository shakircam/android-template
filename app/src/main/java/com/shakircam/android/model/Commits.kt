package com.shakircam.android.model

data class Commits(
    val commit : List<CommitsItem>
) {

    data class CommitsItem(
        val author: Author,
        val commit: Commit,
        val sha: String,
        val url: String
    )

    data class Author(
        val avatar_url: String
    )

    data class Commit(
        val author: AuthorX,
        val message: String,
    )

    data class AuthorX(
        val date: String?,
        val email: String,
        val name: String
    )
}
