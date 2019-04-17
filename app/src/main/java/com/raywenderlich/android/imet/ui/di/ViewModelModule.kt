package com.raywenderlich.android.imet.ui.di

import com.raywenderlich.android.imet.data.PeopleRepository
import com.raywenderlich.android.imet.ui.add.AddPeopleViewModel
import com.raywenderlich.android.imet.ui.details.PeopleDetailsViewModelFactory
import com.raywenderlich.android.imet.ui.list.PeopleListViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun providePeopleListViewModelFactory(repository: PeopleRepository): PeopleListViewModelFactory {
        return PeopleListViewModelFactory(repository)
    }

    @Provides
    @Singleton
    fun providePeopleDetailsViewModelFactory(repository: PeopleRepository): PeopleDetailsViewModelFactory {
        return PeopleDetailsViewModelFactory(repository)
    }

    @Provides
    @Singleton
    fun provideAddPeopleViewModel(repository: PeopleRepository): AddPeopleViewModel = AddPeopleViewModel(repository)
}
