package android.template.core.data.repository.impl

import android.template.core.data.repository.BasicPreferencesRepository
import kotlinx.coroutines.flow.Flow
import me.akshay.datastore.BasicPreferences
import me.akshay.datastore.BasicPreferencesDataStore
import javax.inject.Inject

class BasicPreferencesRepositoryImpl @Inject constructor(
    private val dataStore: BasicPreferencesDataStore
) : BasicPreferencesRepository{
    override val basicPreferences: Flow<BasicPreferences> = dataStore.basicPreferences
    override suspend fun firstTimeComplete(boolean: Boolean) = dataStore.firstTimeComplete(boolean)
    override suspend fun clearAll() = dataStore.clearAll()
}