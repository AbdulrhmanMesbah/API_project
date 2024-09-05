import android.util.Log
import com.example.api_project.Post
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.*


class PostsApi(
    private val client: HttpClient
) {

    suspend fun getPosts(): List<Post> {
        return try {
            client.get {
                url(Routes.POSTS)
            }.body()
        } catch (e: RedirectResponseException) {
            Log.e("PostsApi", "3XX Error: ${e.message}")
            emptyList()
        } catch (e: ClientRequestException) {
            Log.e("PostsApi", "4XX Error: ${e.message}")
            emptyList()
        } catch (e: ServerResponseException) {
            Log.e("PostsApi", "5XX Error: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("PostsApi", "Error: ${e.message}")
            emptyList()
        }
    }
}