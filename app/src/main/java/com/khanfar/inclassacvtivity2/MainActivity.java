package com.khanfar.inclassacvtivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Button add , saveAll ;
private EditText title , author , pages ;
private Switch aSwitch ;
private List<Book> list = new LinkedList<>() ;
private SharedPreferences sharedPreferences ; // read Only
    private  SharedPreferences.Editor editor ; // Write Only
private  boolean flag = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpComponent () ;

    }
    @Override
    protected void onStop() {
        if (flag == false) {
            saveAllOnAction(getCurrentFocus());
        }
        super.onStop();
    }


    private void setUpComponent() {
        add = findViewById(R.id.add);
        saveAll = findViewById(R.id.saveAll);
        title = findViewById(R.id.title);
        pages = findViewById(R.id.pages);
        author = findViewById(R.id.name);
        aSwitch= findViewById(R.id.avaliable);
    }

    public void addOnAction(View view) {

        list.add(new Book(title.getText().toString() ,author.getText().toString() , Integer.parseInt(pages.getText().toString().trim()) ,aSwitch.isChecked()  ));
        Toast.makeText(this, "Added book ...done", Toast.LENGTH_SHORT).show();

    }

    public void saveAllOnAction(View view) {
        flag = true ;
       Gson gson = new Gson() ;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this) ;
        editor = sharedPreferences.edit();
       String str = gson.toJson(list); ;

        System.out.println(str);
        editor.putBoolean("flag" , flag );
       editor.putString("DATA" , str );

       editor.commit() ;

        Toast.makeText(this, "All data is saved successfully", Toast.LENGTH_SHORT).show();


    }
}