package uz.texnopos.phonesinfo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characterisics")
data class Characteristics(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "OC")
    var oc: String,
    var screen: String,
    var weight: String,
    @ColumnInfo(name = "CPU")
    var cpu: String,
    @ColumnInfo(name = "Memory")
    var memory: String,
    @ColumnInfo(name = "YearOfIssue")
    var yearOfIssue: Int,
    var phoneId: Int,
    var fingerprint: Int
)