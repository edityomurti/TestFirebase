package com.example.acer1.testfirebase;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    EditText input_message;
    Button btn_send;
    // deklarasi recyclerView
    RecyclerView recyclerView;

    String username;

    //cariable list chat
    private List<Chat> dataChat;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataChat = new ArrayList<>();

        //ambil data dari activity sblmnya
        username = getIntent().getStringExtra("username");

        input_message = (EditText) findViewById(R.id.input_message);
        btn_send = (Button) findViewById(R.id.btn_send);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        final Firebase firebase = new Firebase("https://shining-torch-7386.firebaseio.com/chat");

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebase.push().setValue(new Chat(username, input_message.getText().toString()));
                //mengosongkan textbox
                input_message.setText("");
            }
        });

        adapter = new ChatAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setListChat(dataChat);

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataChat.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Chat chat = postSnapshot.getValue(Chat.class);
                    dataChat.add(chat);

                    Log.d("data", "chat->() returned:" + chat.message + "user->" + chat.user);
                }

                adapter.notifyDataSetChanged();

                recyclerView.scrollToPosition(adapter.getItemCount()-1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
