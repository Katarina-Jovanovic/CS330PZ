package rs.ac.metropolitan.cs330_pz.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import rs.ac.metropolitan.cs330_pz.Entiteti.User


@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user WHERE username=:username")
    fun getUser(username:String): User?

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun getUserByUsernameAndPassword(username: String, password: String): User?
}