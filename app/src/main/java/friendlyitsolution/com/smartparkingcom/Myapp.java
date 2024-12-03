package friendlyitsolution.com.smartparkingcom;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Map;


public class Myapp extends Application {
    public static FirebaseDatabase db;
    public static DatabaseReference ref;
    public static SharedPreferences pref;
    public static String mynumber,myname;
    public static DatabaseReference myref;
    public static Map<String, Object> userdata;
    public static Context con;

    private static final Object TAG = "ss";
    private static Myapp sInstance;


    static FirebaseMessaging msg;

    @Override
    public void onCreate() {
        super.onCreate();
        db= FirebaseDatabase.getInstance();
        db.setPersistenceEnabled(true);
        ref=db.getReference();
        con=getApplicationContext();
        sInstance=this;
        msg=FirebaseMessaging.getInstance();
        pref=getSharedPreferences("myinfo",MODE_PRIVATE);
         mynumber=pref.getString("mynumber","");
        if(!mynumber.equals(""))
        {
            getUserdata();
         }
    }

    public static void setNotification(String topic)
    {
        msg.subscribeToTopic(topic);
        Myapp.myref.child(topic).setValue("on");
    }
    public static void removeNotification(String topic)
    {
        Myapp.myref.child(topic).setValue("off");
        msg.unsubscribeFromTopic(topic);
    }

    void getUserdata()
    {
        myref=db.getReference("users").child(mynumber);
        myref.keepSynced(true);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                userdata=(Map<String, Object>)dataSnapshot.getValue();
                myname=userdata.get("name")+"";




                //   Toast.makeText(getApplicationContext(),"Data : "+userdata,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public static void showMsg(String st)
    {
        Toast.makeText(con,st, Toast.LENGTH_LONG).show();
    }
}
