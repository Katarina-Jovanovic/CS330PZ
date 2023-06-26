package rs.ac.metropolitan.cs330_pz.ViewModeli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import rs.ac.metropolitan.cs330_pz.DAO.UserDao
import rs.ac.metropolitan.cs330_pz.Entiteti.User
import rs.ac.metropolitan.cs330_pz.Event.UserEvent
import rs.ac.metropolitan.cs330_pz.State.UserState

class UserViewModel(private val dao: UserDao):ViewModel() {

    private val _state= MutableStateFlow(UserState())



    fun onEvent(event: UserEvent){
        when(event){
            UserEvent.SaveUser -> {
                val username=_state.value.username
                val password=_state.value.password
                val email=_state.value.email

                if(username.isBlank() || password.isBlank() || email.isBlank())
                {
                    return
                }
                val user= User(
                    username=username,
                    email = email,
                    password = password
                )
                viewModelScope.launch {
                    dao.insertUser(user)
                }
                _state.update {
                    it.copy(
                        username="",
                        email = "",
                        password = ""
                    )
                }

            }
            is UserEvent.SetEmail -> {
                _state.update {  it.copy(email=event.email)}
            }
            is UserEvent.SetPassword -> {
                _state.update {  it.copy(password=event.password)}
            }
            is UserEvent.SetUsername -> {
                _state.update {  it.copy(username=event.username)}
            }

        }


    }

}