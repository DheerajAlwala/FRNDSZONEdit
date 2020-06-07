package com.example.frndszone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context mContext;
    List<User>  mUsers;
    public UserAdapter(Context ct,List<User> mu){
        mContext=ct;
        mUsers=mu;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_contact,parent,false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User user=mUsers.get(position);
        holder.con_name.setText(user.getFname());
        holder.con_img.setImageResource(R.drawable.profile);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView con_name;
        CircleImageView con_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            con_name=itemView.findViewById(R.id.con_name);
            con_img=itemView.findViewById(R.id.con_img);

        }
    }
}
