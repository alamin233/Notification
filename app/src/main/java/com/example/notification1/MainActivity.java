package com.example.notification1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button noty;
    public String CHANEL_ID="Notificatoin channel";
    public int NOTIFICATION__ID=01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noty = findViewById(R.id.noti);

        noty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 notificationMethod();
                notification_channelmfthod();

            }
        });

    }

    private void notificationMethod(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANEL_ID)
                .setContentTitle("Notification Titel")
                .setContentText("notification massage")
                .setSmallIcon(R.drawable.asad)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION__ID,builder.build());

    }

    private void notification_channelmfthod(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name = "notification";
            String discription = "notification massege";
            int importence = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new  NotificationChannel(CHANEL_ID,name,importence);
            notificationChannel.setDescription(discription);
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);


        }
    }
}
