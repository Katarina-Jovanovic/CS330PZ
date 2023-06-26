package rs.ac.metropolitan.cs330_pz.State

import rs.ac.metropolitan.cs330_pz.Entiteti.User

data class UserState(
    val users:List<User> = emptyList(),
    val username:String="",
    val password:String="",
    val email:String=""
)
