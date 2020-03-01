package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
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

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private Context mContext;
    private ArrayList<String> mText=new ArrayList<>();

    public RecyclerViewAdapter(Context context, ArrayList<String> text) {
    this.mContext = context;
    mText=text;
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
        if(mText.get(position).length()!=0)
        {
            SpannableString ss=new SpannableString(mText.get(position).substring(0,500)+"... \n Read More");
            ClickableSpan clickableSpan=new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    Intent intent=new Intent(mContext,NextActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("abstract",mText.get(position));
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
        return mText.size();
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
