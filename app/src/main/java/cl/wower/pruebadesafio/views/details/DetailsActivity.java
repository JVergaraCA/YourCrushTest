package cl.wower.pruebadesafio.views.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

import cl.wower.pruebadesafio.R;
import cl.wower.pruebadesafio.models.Post;
import cl.wower.pruebadesafio.views.main.MainActivityFragment;

public class DetailsActivity extends AppCompatActivity {

    private Post post;

    private EditText editText;

    public static final String PENDING_ID = "the.host.class.package.WHAT_IT_DOES.SHORT_DESCRIPTIVE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long id = getIntent().getLongExtra(MainActivityFragment.PENDING_ID, 0);

        post = Post.findById(Post.class, id);

        editText = (EditText) findViewById(R.id.detailsEt);

        getSupportActionBar().setTitle(post.getName());

        long millis = 0;
        String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        String description = post.getDescription();
        if (description != null) {

            editText.setText(description);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        post.setDescription(editText.getText().toString());
        post.save();
    }


}