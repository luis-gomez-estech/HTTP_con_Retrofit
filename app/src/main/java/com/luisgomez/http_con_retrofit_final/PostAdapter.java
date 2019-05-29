package com.luisgomez.http_con_retrofit_final;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    //private ArrayList<Post> listaPost=new ArrayList<>();

    List<Post> listaPost;
    private Context context;

    public PostAdapter(List<Post> listaPost, Context context) {
        this.context=context;
        this.listaPost = listaPost;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder postViewHolder, final int i) {

        final Integer userId= listaPost.get(i).getUserId();
        final Integer id= listaPost.get(i).getId();
        final String title= listaPost.get(i).getTitle();
        final String body= listaPost.get(i).getBody();

        postViewHolder.userId.setText(userId.toString());
        postViewHolder.id.setText(id.toString());
        postViewHolder.title.setText(title);
        postViewHolder.body.setText(body);

    }

    @Override
    public int getItemCount() {
        return listaPost.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        TextView userId;
        TextView id;
        TextView title;
        TextView body;

        public PostViewHolder(View view) {
            super(view);

            userId = (TextView)view.findViewById(R.id.tvUserId);
            id = (TextView)view.findViewById(R.id.tvId);
            title = (TextView)view.findViewById(R.id.tvTitle);
            body = (TextView)view.findViewById(R.id.tvBody);
        }
    }

}
