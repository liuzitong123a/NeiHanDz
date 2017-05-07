package com.lzt.neihandzclient.retrofit;

import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.model.Collection;
import com.lzt.neihandzclient.model.Comment;
import com.lzt.neihandzclient.model.DisLike;
import com.lzt.neihandzclient.model.HomeCount;
import com.lzt.neihandzclient.model.HomeModel;
import com.lzt.neihandzclient.model.Like;
import com.lzt.neihandzclient.model.SendModel;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 *
 */
public interface ApiService {

    String API_SERVER_URL = "http://192.168.1.102:8080/NeiHanDZ/";
    String HOME = "HomePageServlet";
    String SENDPIC = "PostHomeServlet";
    String SENDVIDEO = "PostVideoServlet";
    String SENDTEXT = "PostTextServlet";
    String COMMENT = "CommentServlet";
    String LIKE = "FavourServlet";
    String DISLIKE = "StampServlet";
    String ATTENTION = "AttentionServlet";
    String COLLECTION = "CollectionServlet";


    @FormUrlEncoded
    @POST(HOME)
    Observable<HomeModel> getHomeList(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(HOME)
    Observable<HomeCount> getHomeCount(@FieldMap Map<String, Object> params);


    @POST(SENDPIC)
    @Multipart
    Observable<SendModel> sendPic(@PartMap Map<String, RequestBody> params);

    @POST(SENDVIDEO)
    @Multipart
    Observable<SendModel> sendVideo(@PartMap Map<String, RequestBody> params);

    @FormUrlEncoded
    @POST(SENDTEXT)
    Observable<SendModel> sendText(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(COMMENT)
    Observable<Comment> getComment(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(LIKE)
    Observable<Like> getLike(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(DISLIKE)
    Observable<DisLike> getDisLike(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(COLLECTION)
    Observable<Collection> getCollection(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(ATTENTION)
    Observable<Attention> getAttention(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(COMMENT)
    Observable<Comment> addComment(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(LIKE)
    Observable<Like> addLike(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(DISLIKE)
    Observable<DisLike> addDisLike(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(COLLECTION)
    Observable<Collection> addCollection(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(COLLECTION)
    Observable<Collection> delCollection(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(ATTENTION)
    Observable<Attention> addAttention(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(ATTENTION)
    Observable<Attention> delAttention(@FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @POST(ATTENTION)
    Observable<Attention> getFans(@FieldMap Map<String, Object> params);
}
