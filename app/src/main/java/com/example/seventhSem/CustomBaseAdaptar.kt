package com.example.seventhSem

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception
import java.net.URL

class CustomBaseAdaptar(val mCtx: Context, val list: List<ListItemModel>, val resouce: Int) : BaseAdapter() {
    override fun getCount(): Int {
        return this.list.size;
    }

    override fun getItem(p0: Int): Any {
        return list[p0];
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mCtx)
        var view = layoutInflater.inflate(resouce, null)

//        val imageView = view.findViewById<ImageView>(R.id.image)
        val titleView = view.findViewById<TextView>(R.id.title)
//        val descView = view.findViewById<TextView>(R.id.desc)

        val item = list[p0]
        val url = item.imgUrl;
//        try{
//            val content = URL(url).openStream()
//            val image = BitmapFactory.decodeStream(content)
//            Log.d("image",image.toString());
//            imageView.setImageBitmap(image);
//        }catch (e: Exception){
//            Log.e("image", e.toString());
//        }

        titleView.text = item.title;
//        descView.text = item.desc;

        return view;
    }
}