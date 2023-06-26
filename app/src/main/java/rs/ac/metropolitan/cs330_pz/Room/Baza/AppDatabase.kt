package rs.ac.metropolitan.cs330_pz.Baza


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import rs.ac.metropolitan.cs330_pz.DAO.ProductDao
import rs.ac.metropolitan.cs330_pz.DAO.UserDao
import rs.ac.metropolitan.cs330_pz.Entiteti.Product
import rs.ac.metropolitan.cs330_pz.Entiteti.User


@Database(entities = [User::class, Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
