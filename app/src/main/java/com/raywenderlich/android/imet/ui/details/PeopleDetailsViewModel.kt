package com.raywenderlich.android.imet.ui.details

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.raywenderlich.android.imet.data.PeopleRepository
import com.raywenderlich.android.imet.data.model.People

class PeopleDetailsViewModel(private val repository: PeopleRepository) : ViewModel() {

    //  MutableLiveData is used for peopleId because this data will change for different people
    private val peopleId = MutableLiveData<Int>()

    fun getPeopleDetails(id: Int): LiveData<People> {
        peopleId.value = id

        //  Works a bit like RxJava switchMap. Converts peopleId to a People object
        return Transformations.switchMap<Int, People>(peopleId) {
            repository.findPeople(it)
        }
    }

}

class PeopleDetailsViewModelFactory(
    private val repository: PeopleRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PeopleDetailsViewModel(repository) as T
    }

}
