import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_project.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

/* Created by Taha https://github.com/tahaak67/ at 5/9/2024 */

class PostsViewModel: ViewModel() {
    val client: HttpClient = HttpClient() {

        //to map json objects returned from the api to a kotlin data class
        install(ContentNegotiation) {
            json(Json {
                //ignores json keys we have not included in our data class
                ignoreUnknownKeys = true
            })
        }
        //a logger to see logging information about every request we make using the client
        install(Logging) {
            level = LogLevel.ALL
        }

    }

    private var postsApi: PostsApi = PostsApi(client = client)

    var postsList by mutableStateOf(emptyList<Post>())
        private set

    init {
        viewModelScope.launch {
            postsList = postsApi.getPosts()
        }
    }

}