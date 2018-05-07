package com.example.samsung.UniTeach;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class CommentsRecyclerAdapter extends RecyclerView.Adapter<CommentsRecyclerAdapter.ViewHolder> {

    public List<Comments> commentsList;

    public Context context;

    public CommentsRecyclerAdapter(List<Comments> commentsList, List<User> user_list){

        this.commentsList = commentsList;
        //this.user_list = user_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CommentsRecyclerAdapter.ViewHolder holder, final int position) {

        holder.setIsRecyclable(false);

        String commentMessage = commentsList.get(position).getMessage();
        holder.setComment_message(commentMessage);

        /*String userName = user_list.get(position).getName();
        String userImage = user_list.get(position).getImage();
        holder.setCommentUserData(userName, userImage);*/

    }

    @Override
    public int getItemCount() {

        if(commentsList != null) {

            return commentsList.size();

        } else {

            return 0;

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;

        private TextView comment_message;

        private TextView commentUserName;
        private CircleImageView commentUserImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setComment_message(String message){

            comment_message = mView.findViewById(R.id.comment_message);
            comment_message.setText(message);

        }

        public void setCommentUserData(String name, String image){

            commentUserImage = mView.findViewById(R.id.comment_image);
            commentUserName = mView.findViewById(R.id.comment_username);

            commentUserName.setText(name);

            RequestOptions placeholderOption = new RequestOptions();
            placeholderOption.placeholder(R.drawable.web_hi_res_512);

            Glide.with(context).applyDefaultRequestOptions(placeholderOption).load(image).into(commentUserImage);
        }

    }
}
