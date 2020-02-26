package com.example.assignment.Models;

public class Response
{
    private Docs[] docs;

    private String numFound;

    private String start;

    private String maxScore;

    public Docs[] getDocs ()
    {
        return docs;
    }

    public void setDocs (Docs[] docs)
    {
        this.docs = docs;
    }

    public String getNumFound ()
    {
        return numFound;
    }

    public void setNumFound (String numFound)
    {
        this.numFound = numFound;
    }

    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    public String getMaxScore ()
    {
        return maxScore;
    }

    public void setMaxScore (String maxScore)
    {
        this.maxScore = maxScore;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [docs = "+docs+", numFound = "+numFound+", start = "+start+", maxScore = "+maxScore+"]";
    }
}