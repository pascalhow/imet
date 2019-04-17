package com.raywenderlich.android.imet.di

import com.raywenderlich.android.imet.data.di.RepositoryModule
import com.raywenderlich.android.imet.ui.di.ViewModelModule
import com.raywenderlich.android.imet.ui.add.AddPeopleFragment
import com.raywenderlich.android.imet.ui.details.PeopleDetailsFragment
import com.raywenderlich.android.imet.ui.list.PeoplesListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ViewModelModule::class,
    RepositoryModule::class
])
interface AppComponent {

    fun inject(target: AddPeopleFragment)
    fun inject(target: PeoplesListFragment)
    fun inject(target: PeopleDetailsFragment)

}
