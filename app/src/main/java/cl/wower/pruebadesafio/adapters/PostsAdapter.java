package cl.wower.pruebadesafio.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.wower.pruebadesafio.R;
import cl.wower.pruebadesafio.data.Queries;
import cl.wower.pruebadesafio.models.Post;

/**
 * Created by JuanCarlos on 15-08-17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {


    private List<Post> posts = new Queries().posts();

    private PostClickListener listener;

    public PostsAdapter(PostClickListener listener) {
        this.listener = listener;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_post, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Post post = posts.get(position);
        holder.textView.setText(post.getName());
        holder.checkBox.setChecked(post.isDone());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int auxPosition = holder.getAdapterPosition();
                            Post auxPost = posts.get(auxPosition);
                            auxPost.setDone(true);
                            auxPost.save();
                            posts.remove(auxPosition);
                            notifyItemRemoved(auxPosition);


                        }
                    }, 400);


                }
            }
        });


        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Post auxPost = posts.get(holder.getAdapterPosition());
                listener.clickedID(auxPost.getId());

            }
        });

    }

    @Override
    public int getItemCount() {

        return posts.size();
    }

    public void update(Post post) {
        posts.add(post);
        notifyDataSetChanged();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.postCb);
            textView = itemView.findViewById(R.id.postTv);

            System.currentTimeMillis();
        }
    }
}


