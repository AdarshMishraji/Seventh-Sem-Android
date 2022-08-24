package com.example.seventhSem

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.io.InputStream
import java.lang.Exception
import java.net.URL
import java.util.concurrent.Executors
import java.util.logging.Handler

class CustomArrayAdaptar(var mCtx: Context, var resouce:Int,var listItems: List<ListItemModel>) : ArrayAdapter<ListItemModel>(mCtx, resouce, listItems) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(mCtx)
        var view = layoutInflater.inflate(resouce, null)

//        val imageView = view.findViewById<ImageView>(R.id.image)
        val titleView = view.findViewById<TextView>(R.id.title)
//        val descView = view.findViewById<TextView>(R.id.desc)

        val item = listItems[position]
//            val url = item.imgUrl;
//            try{
//                val content = URL(url).openStream()
//               val image = BitmapFactory.decodeStream(content)
//                Log.d("image",image.toString());
//                imageView.setImageBitmap(image);
//            }catch (e: Exception){
//                Log.e("image", e.toString());
//            }

        titleView.text = item.title;
//        descView.text = item.desc;

        return view;
    }
}
