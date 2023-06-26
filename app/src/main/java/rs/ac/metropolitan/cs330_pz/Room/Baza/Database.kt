package rs.ac.metropolitan.cs330_pz.Baza


import androidx.room.Database
import androidx.room.RoomDatabase
import rs.ac.metropolitan.cs330_pz.DAO.ProductDao
import rs.ac.metropolitan.cs330_pz.DAO.UserDao
import rs.ac.metropolitan.cs330_pz.Entiteti.Product
import rs.ac.metropolitan.cs330_pz.Entiteti.User


@Database(entities = [User::class, Product::class], version = 1)

abstract class Database:RoomDatabase() {

    abstract fun userdao():UserDao
    abstract fun productDao():ProductDao

}