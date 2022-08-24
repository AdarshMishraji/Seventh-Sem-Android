package com.example.seventhSem

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GridViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4);

        val list  = mutableListOf<ListItemModel>();

        list.add(ListItemModel("Facebook", "Facebook Details","https://cdn-icons-png.flaticon.com/512/2111/2111463.png" ))
        list.add(ListItemModel("Instagram", "Instagram Details","https://cdn-icons-png.flaticon.com/512/2111/2111463.png" ))
        list.add(ListItemModel("Twitter", "Twitter Details","https://cdn-icons-png.flaticon.com/512/2111/2111463.png" ))
        list.add(ListItemModel("Snapchat", "Snapchat Details","https://cdn-icons-png.flaticon.com/512/2111/2111463.png" ))

        buildList(list)
    }

    private fun buildList( list: MutableList<ListItemModel>) {
        val gridView = findViewById<GridView>(R.id.gridView);

//        var ad =  CustomArrayAdaptar(this, R.layout.grid_item, list)
        val ad = CustomBaseAdaptar(this, list, R.layout.grid_item)

        gridView.setOnItemClickListener{
                parent: AdapterView<*>,
                view: View,
                position:Int,
                id:Long ->
            Toast.makeText(this, list[position].title, Toast.LENGTH_LONG).show();
        }
        gridView.adapter = ad;

        gridView.onItemClickListener = AdapterView.OnItemClickListener{
                adapterView: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ->
                val i = Intent(this, Preview::class.java);
            i.putExtra("title", list[position].title);
            startActivity(i);
        }

        gridView.onItemLongClickListener = AdapterView.OnItemLongClickListener {
                adapterView: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ->
            list.removeAt(position);
            ad.notifyDataSetChanged();
            true
        }
    }
}