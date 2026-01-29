import com.example.placementholder.Album
import com.example.placementholder.Comment
import com.example.placementholder.Post
import com.example.placementholder.RetrofitClient.placeHolderClient
import retrofit2.Call
import retrofit2.Response

class PlaceHolderRepository {
    fun placeholderNetworkCall(): Post? {
        val apiCall: Call<Post?> = placeHolderClient.getPlaceHolderPosts()
        val placeHolderPostResponse: Response<Post?> = apiCall.execute()
        return placeHolderPostResponse.body()
    }

    fun getComments(): Comment? {
        val api: Call<Comment?> = placeHolderClient.getPlaceHolderComments()
        val commentsResponse: Response<Comment?> = api.execute()
        return commentsResponse.body()
    }

    fun getAlbums(): Album? {
        val api: Call<Album?> = placeHolderClient.getPlaceHolderAlbums()
        val albumResponse: Response<Album?> = api.execute()
        return albumResponse.body()
    }

    fun createPost(post: Post) : Post? {
        val api: Call<Post?> = placeHolderClient.postPlaceHolderPosts(post)
        val postResponse: Response<Post?> = api.execute()
        return postResponse.body()
    }
}









