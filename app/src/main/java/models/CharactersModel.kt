package models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.singleactivity.data.APIService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import com.example.singleactivity.data.Character



class CharactersModel(): ViewModel(){
    private val _todoList = mutableStateListOf<Character>()
    var errorMessage: String by mutableStateOf("")
    val todoList: List<Character>
        get() = _todoList

    fun getChars() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _todoList.clear()
                _todoList.addAll(apiService.getTodos().results)

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun characterInfo(characterID: Int): Character{
        return _todoList.filter{ it.id == characterID }.first()
    }
}
