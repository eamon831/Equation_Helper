package com.example.equationhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.equationhelper.database.AppDatabase;
import com.example.equationhelper.database.User;
import com.example.equationhelper.database.UserDao;

public class Add_equation extends AppCompatActivity {
    EditText f_name,l_name;
    int uid=2;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_equation);

        f_name=findViewById(R.id.f_name);
        l_name=findViewById(R.id.l_name);
        bt=findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                //new bgthread().start();

                AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"room_db").allowMainThreadQueries().build();
                UserDao userDao=db.userDao();
                while(userDao.is_exist(uid++));
                User user=new User(uid++,f_name.getText().toString(),l_name.getText().toString());
                // user.v.add("yess");
                userDao.insert(user);
                f_name.setText("");
                l_name.setText("");

            }
        });
    }
    class bgthread extends Thread{
        public void run()
        {
            super.run();
            AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"room_db").build();
            UserDao userDao=db.userDao();
            User user=new User(uid++,f_name.getText().toString(),l_name.getText().toString());
            // user.v.add("yess");
            userDao.insert(user);
            f_name.setText("");
            l_name.setText("");
        }
    }
}