package rs.ac.metropolitan.cs330_pz.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import rs.ac.metropolitan.cs330_pz.Entiteti.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAllProducts(): List<Product>

    @Query("SELECT * FROM product WHERE id = :productId")
    fun getProductById(productId: Long): Product?

    @Insert
    fun insertProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)


}