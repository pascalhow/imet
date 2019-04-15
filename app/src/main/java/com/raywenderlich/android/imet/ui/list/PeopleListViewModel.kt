package com.raywenderlich.android.imet.ui.list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.raywenderlich.android.imet.IMetApp
import com.raywenderlich.android.imet.data.model.People

/**
 * PeopleListViewModel has the responsibility of handling data for PeopleListFragment
 */
class PeopleListViewModel(application: Application) : AndroidViewModel(application) {

    private val peopleRepository = (application as IMetApp).getPeopleRepository()
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    fun getPeopleList(): LiveData<List<People>> = peopleList

    fun getAllPeople() {
        peopleList.addSource(peopleRepository.getAllPeople()) { people ->
            peopleList.postValue(people)
        }
    }

    fun searchPeople(name: String) {
        peopleList.addSource(peopleRepository.findPeople(name)) { people ->
            peopleList.postValue(people)
        }
    }

}
