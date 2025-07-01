package aiss.gitminer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    private String id;

    @Column(name="name")
    @NotEmpty(message = "The name of the project cannot be empty")
    public String name;

    @Column(name="web_url")
    @NotEmpty(message = "The URL of the project cannot be empty")
    public String web_url;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commit> commits;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Issue> issues;

    @Column(name = "html_url")
    private String htmlUrl;

    @Column(name = "stargazers_count")
    private Integer stargazersCount;

    @Column(name= "language")
    private String language;

    @Column(name="is_private")
    private Boolean isPrivate;


    public Project() {

    }

    public Project(String id, String name, String web_url, String htmlUrl, Integer stargazersCount,
                    String language, Boolean isPrivate) {
        this.id = id;
        this.name = name;
        this.web_url = web_url;
        this.commits = new ArrayList<>();
        this.issues = new ArrayList<>();
        this.htmlUrl = htmlUrl;
        this.stargazersCount = stargazersCount;
        this.language = language;
        this.isPrivate = isPrivate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebUrl() {
        return web_url;
    }

    public void setWebUrl(String webUrl) {
        this.web_url = webUrl;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public String getHtmlUrl() { return htmlUrl; }

    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public Integer getStargazersCount() { return stargazersCount; }

    public void setStargazersCount(Integer stargazersCount) {this.stargazersCount = stargazersCount;}

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public Boolean getIsPrivate() { return isPrivate; }
    public void setIsPrivate(Boolean isPrivate) { this.isPrivate = isPrivate; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Project.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("commits");
        sb.append('=');
        sb.append(((this.commits == null)?"<null>":this.commits));
        sb.append(',');
        sb.append("issues");
        sb.append('=');
        sb.append(((this.issues == null)?"<null>":this.issues));
        sb.append(',');
        sb.append("htmlUrl");
        sb.append('=');
        sb.append(((this.htmlUrl == null)?"<null>":this.htmlUrl));
        sb.append(',');
        sb.append("stargazersCount");
        sb.append('=');
        sb.append(((this.stargazersCount) == null)?"<null>":this.stargazersCount);
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("isPrivate");
        sb.append('=');
        sb.append(((this.isPrivate == null)?"<null>":this.isPrivate));
        sb.append(',');

        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}

