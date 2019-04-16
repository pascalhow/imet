package com.raywenderlich.android.imet.ui.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.raywenderlich.android.imet.data.PeopleRepository
import com.raywenderlich.android.imet.data.model.People

/**
 * PeopleListViewModel has the responsibility of handling data for PeopleListFragment
 */
class PeopleListViewModel(private val repository: PeopleRepository) : ViewModel() {

    //  MediatorLiveData is a special type of LiveData that can hold data from multiple data sources
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    fun getPeopleList(): LiveData<List<People>> = peopleList

    fun getAllPeople() {
        peopleList.addSource(repository.getAllPeople()) { people ->
            peopleList.postValue(people)
        }
    }

    fun searchPeople(name: String) {
        peopleList.addSource(repository.findPeople(name)) { people ->
            peopleList.postValue(people)
        }
    }

}

class PeopleListViewModelFactory(
    private val repository: PeopleRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PeopleListViewModel(repository) as T
    }

}
