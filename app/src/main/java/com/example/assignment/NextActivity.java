package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Bundle bundle = getIntent().getExtras();
        TextView textView=findViewById(R.id.textV);

        String id="ID: "+bundle.getString("id");
        Log.e("HEEE", "onCreate: "+id);
        SpannableString ss1=new SpannableString(id+"\n\n");
        ss1.setSpan(new StyleSpan(Typeface.ITALIC), 0, 2, 0);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, 2, 0);

        String journal="JOURNAL: "+bundle.getString("journal");
        Log.e("HEEE", "onCreate: "+journal);
        SpannableString ss2=new SpannableString(journal+"\n\n");
        ss2.setSpan(new StyleSpan(Typeface.ITALIC), 0, 7, 0);
        ss2.setSpan(new StyleSpan(Typeface.BOLD), 0, 7, 0);

        String eissn="EISSN: "+bundle.getString("eissn");
        Log.e("HEEE", "onCreate: "+eissn);
        SpannableString ss3=new SpannableString(eissn+"\n\n");
        ss3.setSpan(new StyleSpan(Typeface.ITALIC), 0, 5, 0);
        ss3.setSpan(new StyleSpan(Typeface.BOLD), 0, 5, 0);

        String publication_date="PUBLICATION DATE: "+ bundle.getString("publication_date");
        Log.e("HEEE", "onCreate: "+publication_date);
        SpannableString ss4=new SpannableString(publication_date+"\n\n");
        ss4.setSpan(new StyleSpan(Typeface.ITALIC), 0, 16, 0);
        ss4.setSpan(new StyleSpan(Typeface.BOLD), 0, 16, 0);

        String article_type="ACTICLE TYPE: "+bundle.getString("article_type");
        Log.e("HEEE", "onCreate: "+article_type);
        SpannableString ss5=new SpannableString(article_type+"\n\n");
        ss5.setSpan(new StyleSpan(Typeface.ITALIC), 0, 12, 0);
        ss5.setSpan(new StyleSpan(Typeface.BOLD), 0, 12, 0);

//        String[] author_display=bundle.getStringArray("author_display");

        String abs="ABSTRACT: "+bundle.getString("abstract");
        Log.e("HEEE", "onCreate: "+abs);
        SpannableString ss6=new SpannableString(abs+"\n\n");
        ss6.setSpan(new StyleSpan(Typeface.ITALIC), 0, 8, 0);
        ss6.setSpan(new StyleSpan(Typeface.BOLD), 0, 8, 0);

        String title_display="TITLE: "+bundle.getString("title_display");
        Log.e("HEEE", "onCreate: "+title_display);
        SpannableString ss7=new SpannableString(title_display+"\n\n");
        ss7.setSpan(new StyleSpan(Typeface.ITALIC), 0, 5, 0);
        ss7.setSpan(new StyleSpan(Typeface.BOLD), 0, 5, 0);

        String score="SCORE: "+bundle.getString("score");
        Log.e("HEEE", "onCreate: "+score);
        SpannableString ss8=new SpannableString(score+"\n\n");
        ss8.setSpan(new StyleSpan(Typeface.ITALIC), 0, 5, 0);
        ss8.setSpan(new StyleSpan(Typeface.BOLD), 0, 5, 0);

        textView.setText(TextUtils.concat(ss1,ss2,ss3,ss4,ss5,ss6,ss7,ss8));

    }
}
