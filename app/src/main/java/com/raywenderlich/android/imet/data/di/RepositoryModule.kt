package com.raywenderlich.android.imet.data.di

import android.content.Context
import com.raywenderlich.android.imet.data.PeopleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(context: Context) = PeopleRepository(context)
}
