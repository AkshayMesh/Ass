package me.akshay.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BasicPreferencesDataStore @Inject constructor(
    private val context: Context
) {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "basic_preferences")
    private object Keys {
        val FIRST_TIME = booleanPreferencesKey("first_time")
    }

    val basicPreferences: Flow<BasicPreferences> = context.dataStore.data.catch { exception->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { preferences ->
        BasicPreferences(
            firstTime = preferences[Keys.FIRST_TIME] ?: true
        )
    }

    suspend fun firstTimeComplete(boolean: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[Keys.FIRST_TIME] = boolean
        }
    }

    suspend fun clearAll() {
        context.dataStore.edit { it.clear() }
    }
}