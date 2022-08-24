package com.example.seventhSem

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ListViewActivity: AppCompatActivity() {

    private fun buildList( list: MutableList<ListItemModel>) {
        val listView = findViewById<ListView>(R.id.listview);

//        var ad =  CustomArrayAdaptar(this, R.layout.list_item_row, list)
        val ad = CustomBaseAdaptar(this, list, R.layout.list_item_row)

        listView.setOnItemClickListener{
                parent: AdapterView<*>,
                view:View,
                position:Int,
                id:Long ->
            Toast.makeText(this, list[position].title, Toast.LENGTH_LONG).show();
        }
        listView.adapter = ad;

        listView.onItemLongClickListener = AdapterView.OnItemLongClickListener {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        val list  = mutableListOf<ListItemModel>();

        list.add(ListItemModel("Facebook", "Facebook Details","https://cdn-icons-png.flaticon.com/512/2111/2111463.png" ))
        list.add(ListItemModel("Instagram", "Instagram Details","https://cdn-icons-png.flaticon.com/512/2111/2111463.png" ))
        list.add(ListItemModel("Twitter", "Twitter Details","https://cdn-icons-png.flaticon.com/512/2111/2111463.png" ))
        list.add(ListItemModel("Snapchat", "Snapchat Details","https://cdn-icons-png.flaticon.com/512/2111/2111463.png" ))

        buildList(list)
    }
}
