package com.example.composelist.UITesting

import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.composelist.HomeActivity
import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITesting {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<HomeActivity>()

    @Test
    fun textIsDisplayed() {
        composeTestRule.onRoot().printToLog("TAG")
//        composeTestRule.
        composeTestRule.onNodeWithText("Check out our App every week for exciting offers.", useUnmergedTree = true).assertIsDisplayed()
    }

}