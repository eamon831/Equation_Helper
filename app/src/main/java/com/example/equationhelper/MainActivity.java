package com.example.equationhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.equationhelper.database.AppDatabase;
import com.example.equationhelper.database.User;
import com.example.equationhelper.database.UserDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Dialog dialog;
    RecyclerView lv;

    int uid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab=findViewById(R.id.fab);
        dialog=new Dialog(this);
        lv=findViewById(R.id.ls) ;
        lv.setLayoutManager(new LinearLayoutManager(this));

        AppDatabase db=Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Room_db").allowMainThreadQueries().build();
        UserDao userDao=db.userDao();
        List<User> list=userDao.getalltittle();
        adapter a=new adapter(list,MainActivity.this);
        lv.setAdapter(a);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();

                dialog.setContentView(R.layout.tittle_insert);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button ok=dialog.findViewById(R.id.add);



                dialog.show();
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText tittle=dialog.findViewById(R.id.tittle);
                        if(tittle.getText().toString().length()>0)
                        {

                            while(userDao.is_exist(uid))
                            {
                                uid++;
                            }
                            User user=new User(uid,tittle.getText().toString(),"baal");
                            userDao.insert(user);
                            AppDatabase db=Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"Room_db").allowMainThreadQueries().build();
                            UserDao userDao=db.userDao();
                            List<User> list=userDao.getalltittle();
                            adapter a=new adapter(list,MainActivity.this);
                            lv.setAdapter(a);


                            dialog.dismiss();
                        }else
                        {
                            tittle.setError("Invalid Tittle");
                            tittle.requestFocus();
                        }



                    }
                });


            }
        });
        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "listener", Toast.LENGTH_SHORT).show();
            }
        });




    }

}