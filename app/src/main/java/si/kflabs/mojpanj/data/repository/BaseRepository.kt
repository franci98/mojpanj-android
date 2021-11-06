package si.kflabs.mojpanj.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import si.kflabs.mojpanj.data.remote.Resource

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ) : Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(true, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Failure(false, null, null)
                    }
                }
            }
        }
    }
}