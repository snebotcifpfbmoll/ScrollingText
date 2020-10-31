package com.serafinebot.dint.scrollingtext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addComment = findViewById(R.id.edit_comment);
        addComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewSwitcher vs = findViewById(R.id.view_switcher);
                View current = vs.getCurrentView();

                if (current instanceof EditText) {
                    EditText editArticle = findViewById(R.id.edit_article);
                    TextView article = findViewById(R.id.article);
                    article.setText(editArticle.getText());

                    Button button = findViewById(R.id.edit_comment);
                    button.setText("EDIT COMMENT");
                } else if (current instanceof TextView) {
                    TextView article = findViewById(R.id.article);
                    EditText editArticle = findViewById(R.id.edit_article);
                    editArticle.setText(article.getText());
                    Button button = findViewById(R.id.edit_comment);
                    button.setText("SAVE COMMENT");
                } else {
                    return;
                }

                vs.showNext();
            }
        });
    }
}