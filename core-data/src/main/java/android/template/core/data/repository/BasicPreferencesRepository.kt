package android.template.core.data.repository

import kotlinx.coroutines.flow.Flow
import me.akshay.datastore.BasicPreferences

interface BasicPreferencesRepository {
    val basicPreferences: Flow<BasicPreferences>
    suspend fun firstTimeComplete(boolean: Boolean)
    suspend fun clearAll()
}