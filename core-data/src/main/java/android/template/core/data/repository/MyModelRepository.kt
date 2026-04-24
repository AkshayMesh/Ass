package android.template.core.data.repository

import kotlinx.coroutines.flow.Flow

interface MyModelRepository {
    val myModels: Flow<List<String>>

    suspend fun add(name: String)
}