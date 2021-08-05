package com.example.booksv1.jsonmodels.modelbestseller


import com.google.gson.annotations.SerializedName

data class LibroNY(
    @SerializedName("age_group")
    val ageGroup: String,
    @SerializedName("amazon_product_url")
    val amazonProductUrl: String,
    @SerializedName("article_chapter_link")
    val articleChapterLink: String,
    @SerializedName("asterisk")
    val asterisk: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("book_image")
    val bookImage: String,
    @SerializedName("book_image_height")
    val bookImageHeight: Int,
    @SerializedName("book_image_width")
    val bookImageWidth: Int,
    @SerializedName("book_review_link")
    val bookReviewLink: String,
    @SerializedName("book_uri")
    val bookUri: String,
    @SerializedName("buy_links")
    val buyLinks: List<BuyLink>,
    @SerializedName("contributor")
    val contributor: String,
    @SerializedName("contributor_note")
    val contributorNote: String,
    @SerializedName("dagger")
    val dagger: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("first_chapter_link")
    val firstChapterLink: String,
    @SerializedName("isbns")
    val isbns: List<Isbn>,
    @SerializedName("price")
    val price: String,
    @SerializedName("primary_isbn10")
    val primaryIsbn10: String,
    @SerializedName("primary_isbn13")
    val primaryIsbn13: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("rank_last_week")
    val rankLastWeek: Int,
    @SerializedName("sunday_review_link")
    val sundayReviewLink: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("weeks_on_list")
    val weeksOnList: Int
)