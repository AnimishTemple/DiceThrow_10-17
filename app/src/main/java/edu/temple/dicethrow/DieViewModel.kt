package edu.temple.dicethrow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel : ViewModel {

    // Might need to change this
    private val dieRoll : MutableLiveData<Int> = MutableLiveData<Int>()

}