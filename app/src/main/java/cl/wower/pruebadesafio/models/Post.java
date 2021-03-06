package cl.wower.pruebadesafio.models;

import com.orm.SugarRecord;

/**
 * Created by JuanCarlos on 15-08-17.
 */

public class Post extends SugarRecord {

    private String name, description;
    private boolean done;

    public Post() {
    }

    public Post(String name, String description, boolean done) {
        this.name = name;
        this.description = description;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
