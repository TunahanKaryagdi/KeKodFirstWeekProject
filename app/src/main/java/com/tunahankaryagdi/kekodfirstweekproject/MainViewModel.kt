package com.tunahankaryagdi.kekodfirstweekproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _addedItems: MutableLiveData<MutableList<MenuItem>> =
        MutableLiveData(mutableListOf())
    val addedItems: LiveData<MutableList<MenuItem>> get() = _addedItems

    private val _egoSwitch: MutableLiveData<Boolean> = MutableLiveData(true)
    val egoSwitch: LiveData<Boolean> get() = _egoSwitch

    private val _happinessSwitch: MutableLiveData<Boolean> = MutableLiveData(false)
    val happinessSwitch: LiveData<Boolean> get() = _happinessSwitch

    private val _optimismSwitch: MutableLiveData<Boolean> = MutableLiveData(false)
    val optimismSwitch: LiveData<Boolean> get() = _optimismSwitch

    private val _kindnessSwitch: MutableLiveData<Boolean> = MutableLiveData(false)
    val kindnessSwitch: LiveData<Boolean> get() = _kindnessSwitch

    private val _givingSwitch: MutableLiveData<Boolean> = MutableLiveData(false)
    val givingSwitch: LiveData<Boolean> get() = _givingSwitch

    private val _respectSwitch: MutableLiveData<Boolean> = MutableLiveData(false)
    val respectSwitch: LiveData<Boolean> get() = _respectSwitch


    fun setEgoSwitch(value: Boolean) {
        _egoSwitch.value = value
    }

    fun setHappinessSwitch(value: Boolean) {
        _happinessSwitch.value = value
    }

    fun setOptimismSwitch(value: Boolean) {
        _optimismSwitch.value = value
    }

    fun setKindnessSwitch(value: Boolean) {
        _kindnessSwitch.value = value
    }

    fun setGivingSwitch(value: Boolean) {
        _givingSwitch.value = value
    }

    fun setRespectSwitch(value: Boolean) {
        _respectSwitch.value = value
    }

    fun addItem(item: MenuItem) {
        val currentList = _addedItems.value ?: mutableListOf()
        currentList.add(item)
        _addedItems.value = currentList
    }

    fun clearItems() {
        _addedItems.value = mutableListOf()
    }

    fun isAdded(menuItem: MenuItem): Boolean {
        return _addedItems.value?.contains(menuItem) ?: false
    }

    fun removeItem(item: MenuItem) {
        val currentList = _addedItems.value ?: mutableListOf()
        currentList.remove(item)
        _addedItems.value = currentList
    }
}