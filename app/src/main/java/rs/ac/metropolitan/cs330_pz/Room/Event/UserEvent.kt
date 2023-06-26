package rs.ac.metropolitan.cs330_pz.Event

sealed interface UserEvent{
    object SaveUser: UserEvent
    data class SetUsername(val username:String):UserEvent
    data class SetPassword(val password:String):UserEvent
    data class SetEmail(val email:String):UserEvent
}