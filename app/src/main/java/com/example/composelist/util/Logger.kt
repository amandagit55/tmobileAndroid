package com.example.composelist.util

import android.util.Log
import com.example.composelist.util.ConstantStrings.Companion.DEBUG
import com.example.composelist.util.ConstantStrings.Companion.ERROR

class Logger {
    companion object{
        fun logError(error: String){
            Log.e(ERROR, error)
        }
        fun logMessage(message: String){
            Log.d(DEBUG, message)
        }
    }
}