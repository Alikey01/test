package mx.datafit.escolarex;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import retrofit2.Call;


/**
 * Created by Gerardo on 29/09/2017.
 */

public interface TareasServicio {

    @Headers({
            "Authorization: f6063c1a8e13664d698649a9590b45c9b9ce0546",
            "Content-Type: application/json"
    })
    @GET("/v1/homeworks")
    //Call<Tareas> getTarea(@Path("estudiante") String n);
    void getTarea(Callback<List<Tareas>> callback);
}
