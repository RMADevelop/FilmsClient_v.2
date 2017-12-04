package com.example.romanm.filmsclientv2.data.source.remote;

import com.example.romanm.filmsclientv2.data.source.remote.models.Movie;
import com.example.romanm.filmsclientv2.data.source.remote.models.ReviewsWrapper;
import com.example.romanm.filmsclientv2.data.source.remote.models.SessionId;
import com.example.romanm.filmsclientv2.data.source.remote.models.TokenLoginPass;
import com.example.romanm.filmsclientv2.data.source.remote.models.TokenRequest;
import com.example.romanm.filmsclientv2.data.source.remote.models.filmDetail.FilmDetail;

import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.example.romanm.filmsclientv2.utils.Const.API_v3;


public interface Server {

    @GET("authentication/token/new")
    Single<TokenRequest> getTokenReauest(@Query("api_key") String key);

    @GET("authentication/token/validate_with_login")
    Single<TokenLoginPass> getTokenLoginPass(@Query("api_key") String key,
                                             @Query("username") String login,
                                             @Query("password") String pass,
                                             @Query("request_token") String requestToken);

    @GET("authentication/session/new")
    Single<SessionId> getSessionId(@Query("api_key") String key,
                                   @Query("request_token") String requestToken);


    @GET("movie/now_playing?api_key=0a94b53a493baafc9c1434714336e957&language=en-US&page=1")
    Single<Movie> getMovie();

    @GET("movie/popular?api_key=0a94b53a493baafc9c1434714336e957&language=en-US")
    Single<Movie> getPopular(@Query("page") int page);

    @GET("movie/top_rated?api_key=0a94b53a493baafc9c1434714336e957&language=en-US&page=1")
    Single<Movie> getTopRated();

    @GET("movie/upcoming?api_key=0a94b53a493baafc9c1434714336e957&language=en-US&page=1")
    Single<Movie> getUpcoming();

    @GET("movie/now_playing")
    Single<Movie> getMoviewNowShow(@Query("api_key") String key,
                                   @Query("language") String lang,
                                   @Query("page") String page);

    @GET("movie/{movie_id}/recommendations?api_key=0a94b53a493baafc9c1434714336e957&language=en-US&page=1")
    Single<Movie> getRecommended(@Path("movie_id") int id);

    @GET("movie/{movie_id}/reviews?api_key=" + API_v3)
    Single<ReviewsWrapper> getReviews(@Path("movie_id") int idFilm);


    @GET("search/movie?api_key=0a94b53a493baafc9c1434714336e957&language=en-US")
    Single<Movie> getSearchFilms(@Query("query") String query,
                                 @Query("page") int page);

    @GET("movie/{movie_id}?api_key=" + API_v3)
    Maybe<FilmDetail> getFilmInfo(@Path("movie_id") int idd);

}
