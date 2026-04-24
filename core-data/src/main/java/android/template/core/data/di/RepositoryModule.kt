package android.template.core.data.di

import android.template.core.data.repository.BasicPreferencesRepository
import android.template.core.data.repository.impl.BasicPreferencesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserPreferencesRepository(
        impl: BasicPreferencesRepositoryImpl
    ): BasicPreferencesRepository
}