package com.example.seventhSem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        var arrayList = listdata();

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        val adapterRecycler = RecyclerAdapter(this, arrayList)
        recyclerView.adapter = adapterRecycler
    }

    private fun listdata() :   ArrayList<ListItemModel> {
        var arrayList = ArrayList<ListItemModel>();

        arrayList.add(ListItemModel("Android 11", "11", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 10", "11", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 9", "Pie", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 8", "Oreo", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 7", "Nougat", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 6", "Marshmallow", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 5", "Lollipop", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 4.4", "Kitkat", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 4.1", "Jellybean", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 4.0", "Ice cream sandwich", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 3.0", "Honeycomb", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 2.3", "ginger bread", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 2.2", "froyo", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 2.0", "eclair", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        arrayList.add(ListItemModel("Android 1.6", "donut", imgUrl = "https://cdn-icons-png.flaticon.com/512/2111/2111463.png"));
        return arrayList;
    }
}