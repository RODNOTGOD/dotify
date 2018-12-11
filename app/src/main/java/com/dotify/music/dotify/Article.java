package com.dotify.music.dotify;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Article extends AppCompatActivity {

    private int id;
    private String title;

    public Article() {
        id = -1;
        title = "";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            id = b.getInt("id");
            title = b.getString("title");
        }

        TextView header = findViewById(R.id.article_header);
        TextView body = findViewById(R.id.article_text);
        String text = getArticleText();

        System.out.println(text);

        header.setText(title);
        body.setText(text);
        body.setMovementMethod(new ScrollingMovementMethod());
    }

    private String getArticleText() {
        JSONArray article = getArticle();
        String text = null;
        try {
            for (int i = 0; i < article.length(); i++) {
                JSONObject object = article.getJSONObject(i);
                text = object.getString("Body");
            }
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }
        return text;
    }

    private JSONArray getArticle() {
        JSONArray rv = null;
        try {
            DatabaseRetriever retriever = new DatabaseRetriever();
            retriever.execute("GET", "getArticleText.php?id=" + id);
            rv = retriever.get(1000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
        return rv;
    }
}
