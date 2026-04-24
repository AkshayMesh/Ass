package me.akshay.datastore.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.akshay.datastore.BasicPreferencesDataStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    @Provides
    @Singleton
    fun provideBasicDataStore(
        @ApplicationContext context: Context): BasicPreferencesDataStore{
        return BasicPreferencesDataStore(context)
    }
}