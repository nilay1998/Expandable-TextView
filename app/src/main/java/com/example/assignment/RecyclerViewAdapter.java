package com.example.assignment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Models.Docs;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private Context mContext;
    private ArrayList<Docs> mDocs=new ArrayList<>();

    public RecyclerViewAdapter(Context context,ArrayList<Docs> docs) {
    this.mContext = context;
    mDocs=docs;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Intent intent=new Intent(mContext,NextActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id",mDocs.get(position).getId());
        intent.putExtra("journal",mDocs.get(position).getJournal());
        intent.putExtra("eissn",mDocs.get(position).getEissn());
        intent.putExtra("publication_date",mDocs.get(position).getPublication_date());
        intent.putExtra("article_type",mDocs.get(position).getArticle_type());
        intent.putExtra("author_display",mDocs.get(position).getAuthor_display());
        intent.putExtra("abstract", mDocs.get(position).getAbstract()[0].trim());
        intent.putExtra("title_display",mDocs.get(position).getTitle_display());
        intent.putExtra("score",mDocs.get(position).getScore());

        final String text ="ABSTRACT: "+ mDocs.get(position).getAbstract()[0].trim();
        final String title="TITLE: "+mDocs.get(position).getTitle_display();

        if(text.length()>500)
        {
            SpannableString ss=new SpannableString(title+"\n\n"+text.substring(0,500)+"... \n Read More");
            ss.setSpan(new RelativeSizeSpan(1.25f), 0,title.length(), 0);
            ss.setSpan(new StyleSpan(Typeface.ITALIC), 0, title.length(), 0);
            ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 6, 0);
            ss.setSpan(new StyleSpan(Typeface.ITALIC),  title.length(),title.length()+11, 0);
            ss.setSpan(new StyleSpan(Typeface.BOLD),  title.length(),title.length()+11, 0);
            ClickableSpan clickableSpan=new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {

                    mContext.startActivity(intent);
                }
                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }
            };
            ss.setSpan(clickableSpan,ss.length()-9,ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.expandableTextView.setText(ss);
            holder.textView.setMovementMethod(LinkMovementMethod.getInstance());
            holder.textView.setHighlightColor(Color.TRANSPARENT);
        }
        else
        {
            SpannableString ss=new SpannableString(title+"\n\n"+text+"... \n Read More");
            ss.setSpan(new RelativeSizeSpan(1.25f), 0,title.length(), 0);
            ss.setSpan(new StyleSpan(Typeface.ITALIC), 0, title.length(), 0);
            ss.setSpan(new StyleSpan(Typeface.BOLD), 0, 6, 0);
            ss.setSpan(new StyleSpan(Typeface.ITALIC),  title.length(),title.length()+11, 0);
            ss.setSpan(new StyleSpan(Typeface.BOLD),  title.length(),title.length()+11, 0);
            ClickableSpan clickableSpan=new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    mContext.startActivity(intent);
                }
                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(false);
                }
            };
            ss.setSpan(clickableSpan,ss.length()-9,ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.expandableTextView.setText(ss);
            holder.textView.setMovementMethod(LinkMovementMethod.getInstance());
            holder.textView.setHighlightColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return mDocs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ExpandableTextView expandableTextView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expandableTextView=itemView.findViewById(R.id.expand_text_view) ;
            textView=itemView.findViewById(R.id.expandable_text);
        }
    }
}
