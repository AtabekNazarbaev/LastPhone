package uz.texnopos.phonesinfo.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phones")
data class Model(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val markId: Int,
    val image: String
)