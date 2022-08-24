package com.example.seventhSem

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity

class MainActivity2: AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationBuilder: Notification.Builder
    private val channelId = "com.example.seventhSem"
    private val title = "Sample Notification"
    private val description = "Sample Notification description"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn = findViewById<Button>(R.id.btn)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(this, afterNotification::class.java)

        btn.setOnClickListener{
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val contentView = RemoteViews(packageName, R.layout.activity_after_notification)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                notificationChannel = NotificationChannel(channelId, title, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.description = description
                notificationManager.createNotificationChannel(notificationChannel)

                notificationBuilder = Notification.Builder(this, channelId)
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentIntent(pendingIntent)
                    .setContentText(description)
            } else {
                notificationBuilder = Notification.Builder(this)
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentIntent(pendingIntent)
                    .setContentText(description)
            }
            notificationManager.notify(1234, notificationBuilder.build())
        }

    }

}