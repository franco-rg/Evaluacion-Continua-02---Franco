package com.example.viajaperu.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.viajaperu.app.ViajaPApp;

/* gestion de imagenes */
public class ImageRequest {
    private static ImageRequest instance = null;
    private final Context context;

    /* saber que imagenes se encuentran en cola por procesar */
    private final RequestQueue requestQueue;
    private final ImageLoader imageLoader;
    private final int maxByteSize; /* peso de recurso (imagen misma) */

    private ImageRequest(){
        context = ViajaPApp.getAppContext();
        this.requestQueue = Volley.newRequestQueue(context);
        this.requestQueue.start(); /* inicializamos la cola */
        this.maxByteSize = calculateMaxSize();
        this.imageLoader =
                new ImageLoader(
                        requestQueue,
                        new ImageLoader.ImageCache() {
                        private final LruCache<String, Bitmap> imgCache =
                                new LruCache<String, Bitmap>(maxByteSize){
                                    @Override
                                    protected int sizeOf(String url, Bitmap bitmap){
                                        return bitmap.getByteCount();
                                    }
                                };

                    @Override
                    public synchronized Bitmap getBitmap(String url){
                        return imgCache.get(url);
                    }

                    @Override
                    public synchronized void putBitmap(String url, Bitmap bitmap){
                        imgCache.put(url, bitmap);
                    }
                });
    }

    public static ImageRequest getInstance(){
        if(instance == null){
            instance = new ImageRequest();
        }
        return instance;
    }

    public void setImageFromUrl(NetworkImageView networkImageView, String url){
        networkImageView.setImageUrl(url, imageLoader);
    }

    /* metodo para calular peso de imagen */
    private int calculateMaxSize(){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final int bytes = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        return bytes * 3;
    }
}
