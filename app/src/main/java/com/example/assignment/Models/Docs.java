package com.example.assignment.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Docs
{
    private String score;

    private String journal;

    private String article_type;

    private String title_display;

    private String[] author_display;

    private String publication_date;

    private String eissn;

    private String id;

    @SerializedName("abstract")
    @Expose
    private String[] abs;

    public String getScore ()
    {
        return score;
    }

    public void setScore (String score)
    {
        this.score = score;
    }

    public String getJournal ()
    {
        return journal;
    }

    public void setJournal (String journal)
    {
        this.journal = journal;
    }

    public String getArticle_type ()
    {
        return article_type;
    }

    public void setArticle_type (String article_type)
    {
        this.article_type = article_type;
    }

    public String getTitle_display ()
    {
        return title_display;
    }

    public void setTitle_display (String title_display)
    {
        this.title_display = title_display;
    }

    public String[] getAuthor_display ()
    {
        return author_display;
    }

    public void setAuthor_display (String[] author_display)
    {
        this.author_display = author_display;
    }

    public String getPublication_date ()
    {
        return publication_date;
    }

    public void setPublication_date (String publication_date)
    {
        this.publication_date = publication_date;
    }

    public String getEissn ()
    {
        return eissn;
    }

    public void setEissn (String eissn)
    {
        this.eissn = eissn;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String[] getAbstract ()
    {
        return abs;
    }

    public void setAbstract (String[] abs)
    {
        this.abs = abs;
    }

    @Override
    public String toString()
    {
        return "score = "+score+", journal = "+journal+", article_type = "+article_type+", title_display = "+title_display+", author_display = "+author_display+", publication_date = "+publication_date+", eissn = "+eissn+", id = "+id+", abstract = "+abs;
    }
}