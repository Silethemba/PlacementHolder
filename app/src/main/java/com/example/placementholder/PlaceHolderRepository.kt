import com.example.placementholder.Albums
import com.example.placementholder.Comments
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

    fun getComments(): Comments? {
        val api: Call<Comments?> = placeHolderClient.getPlaceHolderComments()
        val commentsResponse: Response<Comments?> = api.execute()
        return commentsResponse.body()
    }

    fun getAlbums(): Albums? {
        val api: Call<Albums?> = placeHolderClient.getPlaceHolderAlbums()
        val albumResponse: Response<Albums?> = api.execute()
        return albumResponse.body()
    }

    fun createPost(post: Post) : Post? {
        val api: Call<Post?> = placeHolderClient.postPlaceHolderPosts(post)
        val postResponse: Response<Post?> = api.execute()
        return postResponse.body()
    }
}









