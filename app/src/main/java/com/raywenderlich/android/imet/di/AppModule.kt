package com.raywenderlich.android.imet.di

import android.app.Application
import android.content.Context
import com.raywenderlich.android.imet.ui.details.PeopleDetailsFragment
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideFragmentContext(): PeopleDetailsFragment = PeopleDetailsFragment()
}
