package com.example.composelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import com.example.composelist.network.CardRetrofitService
import com.example.composelist.repository.Repository
import com.example.composelist.ui.theme.ComposeListTheme
import com.example.composelist.viewmodel.CardViewModel

class HomeActivity : ComponentActivity() {

    private val viewModel: CardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Given more time, I would have implementented this with DI
        viewModel.initViewModel(Repository(CardRetrofitService.cardService))

        setContent {
            val cards = viewModel.cards.value

            LazyColumn{
                itemsIndexed(items = cards){ index, item ->
                    if(item.card_type == "image_title_description"){
                        ImageCard(card =item, onClick = {})
                    } else {
                        TextCard(
                            card = item
                        ){}
                    }
                }
            }
        }
    }
}
