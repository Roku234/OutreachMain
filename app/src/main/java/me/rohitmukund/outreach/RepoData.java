package me.rohitmukund.outreach;

public class RepoData
{
    private String name;
    private String url;
    private int stars;
    private int forks;
    private String language;
    private String description;
    private String contributorsUrl;
    private String license;

    public RepoData(String name)
    {
        this.name = name;


    }

    public String getName()
    {
        return name;
    }


}
