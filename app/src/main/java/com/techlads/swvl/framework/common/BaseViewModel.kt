package com.techlads.swvl.framework.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.framework.common
 */


class BaseViewModel<ViewState> : ViewModel(){
    private val _viewState: MutableLiveData<ViewState> = MutableLiveData()
}