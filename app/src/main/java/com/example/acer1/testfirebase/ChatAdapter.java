package com.example.acer1.testfirebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Acer1 on 01/11/2015.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

    private Context context;
    private List<Chat> listChat;

    public ChatAdapter(Context context) {
        this.context = context;
    }

    public void setListChat(List<Chat> listChat) {
        this.listChat = listChat;
    }

    //milih data dan holdernya
    @Override
    public ChatHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ChatHolder(
                LayoutInflater.from(context).inflate(R.layout.item_chat, viewGroup, false));
    }

    //make data
    @Override
    public void onBindViewHolder(ChatHolder chatHolder, int i) {
        chatHolder.username.setText(listChat.get(i).user);
        chatHolder.message.setText(listChat.get(i).message);
    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }

    public class ChatHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView message;

        public ChatHolder(View itemView){
            super(itemView);

            username = (TextView) itemView.findViewById(R.id.username);
            message = (TextView) itemView.findViewById(R.id.message);
        }
    }

}
