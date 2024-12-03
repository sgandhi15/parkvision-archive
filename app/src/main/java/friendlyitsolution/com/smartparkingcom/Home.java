package friendlyitsolution.com.smartparkingcom;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.jackandphantom.customtogglebutton.CustomToggle;

import java.util.Map;

public class Home extends AppCompatActivity {
    ImageView iv;
    TextView tv, editpro;

    ImageView car1,car2,car3,car4;

    DatabaseReference ref;

    ValueEventListener vals;

    ToggleButton btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView lgout = (ImageView) findViewById(R.id.lgbtn);
        ImageView backbtn = (ImageView) findViewById(R.id.backbtn);
        iv = (ImageView) findViewById(R.id.profile_image);
        tv = (TextView) findViewById(R.id.name);
        editpro = (TextView) findViewById(R.id.editpro);

        ref=Myapp.ref.child("parking");
        car1=findViewById(R.id.car1);
        car2=findViewById(R.id.car2);
        car3=findViewById(R.id.car3);
        car4=findViewById(R.id.car4);



        setprofile();

        lgout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logOut();
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home.super.onBackPressed();
            }
        });


        editpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this,profile.class);
                startActivity(i);
            }
        });

        vals=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue()!=null)
                {

                    Map<String,String> data=(Map<String, String>)dataSnapshot.getValue();

                    if(data.get("car1").equals("on"))
                    {
                        car1.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        car1.setVisibility(View.INVISIBLE);
                    }

                    if(data.get("car2").equals("on"))
                    {
                        car2.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        car2.setVisibility(View.INVISIBLE);
                    }

                    if(data.get("car3").equals("on"))
                    {
                        car3.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        car3.setVisibility(View.INVISIBLE);
                    }

                    if(data.get("car4").equals("on"))
                    {
                        car4.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        car4.setVisibility(View.INVISIBLE);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };


        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);


         btn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notioff));
        btn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notioff));
        btn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notioff));
        btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notioff));

        clicks();

        if(Myapp.userdata.get("car1").toString().equals("on"))
        {
           btn1.setChecked(true);
           //btn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));
           btn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));
        }

        if(Myapp.userdata.get("car2").toString().equals("on"))
        {
            btn2.setChecked(true);
            btn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));

        }

        if(Myapp.userdata.get("car3").toString().equals("on"))
        {
            btn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));

            btn3.setChecked(true);
        }

        if(Myapp.userdata.get("car4").toString().equals("on"))
        {
            btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));

            btn4.setChecked(true);
        }

    }




    void clicks()
    {
        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Myapp.setNotification("car1");
                    btn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));



                }
                else
                {
                    Myapp.removeNotification("car1");
                    btn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notioff));

                }
            }
        });

        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Myapp.setNotification("car2");
                    btn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));

                }
                else
                {
                    Myapp.removeNotification("car2");
                    btn2.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notioff));

                }
            }
        });
        btn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Myapp.setNotification("car3");
                    btn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));

                }
                else
                {
                    Myapp.removeNotification("car3");
                    btn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notioff));

                }
            }
        });

        btn4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Myapp.setNotification("car4");
                    btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notion));

                }
                else
                {
                    Myapp.removeNotification("car4");
                    btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_notioff));

                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setprofile();
        ref.addValueEventListener(vals);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ref.removeEventListener(vals);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setprofile();
    }
    void setprofile()
    {
        try
        {

            if(!Myapp.userdata.get("imgurl").toString().equals(" "))
            {
                Glide.with(iv.getContext()).load(Myapp.userdata.get("imgurl").toString())
                        .override(200, 200)
                        .fitCenter()
                        .into(iv);
            }
            tv.setText(Myapp.myname);

        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Something went wrong please reopen app",Toast.LENGTH_LONG).show();
        }

    }
    void logOut()
    {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialoug_logout);
        dialog.show();

        final Button btnInDialog = (Button) dialog.findViewById(R.id.btn);
        btnInDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = Myapp.pref.edit();
                editor.clear();
                editor.commit();
                finish();
                Myapp.mynumber = "";
                Myapp.myname = "";
                Myapp.userdata = null;

                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        });
        final ImageView btnClose = (ImageView) dialog.findViewById(R.id.canclebtn);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }
}
