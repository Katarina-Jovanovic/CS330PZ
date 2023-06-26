package rs.ac.metropolitan.cs330_pz.Entiteti

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val price:Double,

)