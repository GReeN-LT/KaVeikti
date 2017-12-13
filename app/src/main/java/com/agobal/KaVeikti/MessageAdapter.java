package com.agobal.KaVeikti;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.*;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Vaidas on 2017-12-13.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{

    private List<Messages> mMessageList;

    public MessageAdapter(List<Messages> mMessageList) {
        this.mMessageList = mMessageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // System.out.println("Printing parent view +++++" + parent.toString());
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_single_layout,parent,false);

      //  System.out.println("Printing parent view +++++" + parent.toString());

        return new MessageViewHolder(v);
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{
        public TextView messageText;
        public CircleImageView profileImage;

        public MessageViewHolder(View view){
            super(view);
           // System.out.println("Printingview +++++" + view.toString());

            messageText = (TextView)view.findViewById(R.id.message_text_layout);
            profileImage = (CircleImageView)view.findViewById(R.id.message_profile_layout);

        }
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int i) {

        Messages c = mMessageList.get(i);
        holder.messageText.setText(c.getMessage());
       // System.out.println("Printing +++++" + c.getMessage() + ":" + holder.toString());
        //Toast.makeText( ChatActivity.this, c.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }


}
