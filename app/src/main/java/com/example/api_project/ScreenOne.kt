import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.ImageLoader
import coil.compose.AsyncImage
import com.google.ai.client.generativeai.type.content

@Composable
fun ScreenOneContent(modifier: Modifier = Modifier) {
    val postsViewModel: PostsViewModel = viewModel()
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically), modifier = Modifier.fillMaxSize()) {
        item {
            if (postsViewModel.postsList.isEmpty()) {
                // if list is empty show a progress indicator
                CircularProgressIndicator()
            }
        }
        items(postsViewModel.postsList){ post ->
            PostItem(modifier = Modifier.fillMaxWidth(), user = post.user, slug = post.slug, picture = post.picture , id = post.id)
        }
    }
}

@Composable
fun PostItem(modifier: Modifier = Modifier, user: String, slug: String , picture: String , id : Int) {
    Card (modifier = Modifier) {
        Column(modifier.padding(8.dp) .absolutePadding(0.dp,20.dp,0.dp,20.dp), verticalArrangement = Arrangement.spacedBy(16.dp),horizontalAlignment = Alignment.CenterHorizontally) {
            
            Text(id.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(user, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(slug, fontSize = 16.sp)
            AsyncImage(model = picture, contentDescription = "picture")

        }
    }
}