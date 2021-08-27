package com.example.composelist.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelist.model.Card
import com.example.composelist.repository.Repository
import com.example.composelist.util.Logger.Companion.logError
import com.example.composelist.util.Logger.Companion.logMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CardViewModel: ViewModel() {
    //special observable data structure built for compose
    //it subscribes to recomposescope, when a composable is rebuilt it will then update any of other compose scopes that use that value
    val cards: MutableState<List<Card>> = mutableStateOf(listOf())

    fun initViewModel(repository:Repository) {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                logMessage("Data received")
                cards.value = repository.getCards().page.cards
            } catch(e: Exception){
                logError(e.localizedMessage)
            }
        }
    }


}




