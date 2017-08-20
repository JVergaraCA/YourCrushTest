package cl.wower.pruebadesafio.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.wower.pruebadesafio.R;
import cl.wower.pruebadesafio.adapters.PostClickListener;
import cl.wower.pruebadesafio.adapters.PostsAdapter;
import cl.wower.pruebadesafio.models.Post;
import cl.wower.pruebadesafio.views.details.DetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements PostClickListener {
    public static final String PENDING_ID = "com.example.adacher.stressless.views.KEY.SHORT_DESCRIPTIVE";
    private PostsAdapter adapter;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView recyclerView = view.findViewById(R.id.postRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        for (int i = 0; i < 0; i++) {

            Post post = new Post();
            post.setName(String.valueOf(i));
            post.setDone(false);
            post.save();
        }


        adapter = new PostsAdapter(this);
        recyclerView.setAdapter(adapter);


    }

    public void updateList(Post post) {

        adapter.update(post);
    }

    @Override
    public void clickedID(long id) {

        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(PENDING_ID, id);
        startActivity(intent);

    }
}
