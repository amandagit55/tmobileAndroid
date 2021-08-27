package com.example.composelist

//import com.example.composelist.mock_network.MockService
import com.example.composelist.viewmodel.CardViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CardViewModelTest {

    private val data_size = 6

    lateinit var viewModel: CardViewModel
    lateinit var testNetworkService: TestNetworkService

    @Before
    fun setUp(){
        viewModel = CardViewModel()
        testNetworkService = TestNetworkService()
        viewModel.initViewModel(TestRepo(testNetworkService))
    }

    @Test
    fun `check card at position one`(){
        runBlocking {
            val response = testNetworkService.getCardsAsync().page
            assertEquals(response.cards[0].card_type, "text")
        }
    }
}