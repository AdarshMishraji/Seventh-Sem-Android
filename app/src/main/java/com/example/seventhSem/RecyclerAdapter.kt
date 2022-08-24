package com.example.seventhSem

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors
import java.util.logging.Handler

class RecyclerAdapter(var context: Context, var arrayList: List<ListItemModel>) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.version.text = arrayList[position].title
        holder.versionName.text = arrayList[position].desc

        val executor = Executors.newSingleThreadExecutor()
        val handler = android.os.Handler(Looper.getMainLooper())

        executor.execute {
            try {
                val `in` = java.net.URL(arrayList[position].imgUrl).openStream()
                val image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    holder.image.setImageBitmap(image)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_item_row, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size;
    }

    class RecyclerViewHolder(var view: View) : RecyclerView.ViewHolder(view){
        var versionName:TextView;
        var version:TextView
        var image: ImageView

        init {
            version = view.findViewById<TextView>(R.id.title)
            versionName = view.findViewById<TextView>(R.id.desc)
            image = view.findViewById<ImageView>(R.id.image)
        }
    }

}