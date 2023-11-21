package com.xelanac.beer_catalogue.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xelanac.beer_catalogue.data.local.BeerEntity.Companion.TABLE_NAME
import com.xelanac.beer_catalogue.data.remote.dto.BeerDto

@Entity(
    tableName = TABLE_NAME
)
data class BeerEntity(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val abv: Double?,
    val description: String?,
    val firstBrewed: String?,
    val imageUrl: String?
){
    companion object {
       const val TABLE_NAME = "beer_entity"
    }
}