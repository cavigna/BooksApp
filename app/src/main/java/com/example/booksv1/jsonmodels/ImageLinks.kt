package com.example.booksv1.jsonmodels


import com.google.gson.annotations.SerializedName

data class ImageLinks(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)

//{
// Books{
// "Ttiulo": "EL aleph"
// "Autor": "Jorge Luis Borges"// }
//
/*
data class Books{
    val titulo : String,
    val autor: String

}
    id | nombre | precio | cantidad

@Entity ( tableName "producto")
class Producto{
    @PrimaryKey not null
    val id: Int,
    val nombre: String,
    val cantidad: Int,
}



 */

// }