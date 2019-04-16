package com.raywenderlich.android.imet.ui.add

import android.arch.lifecycle.ViewModel
import com.raywenderlich.android.imet.data.PeopleRepository
import com.raywenderlich.android.imet.data.model.People

class AddPeopleViewModel(private val repository: PeopleRepository) : ViewModel() {

    fun addPeople(people: People) {
        repository.insertPeople(people)
    }
}
