package aiss.gitminer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Issue")
public class Issue {

    @Id
    private String id;

    @Column(name = "title")
    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @Column(name = "state")
    private String state;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "closed_at")
    private String closed_at;

    @ElementCollection
    @CollectionTable(name = "issue_labels", joinColumns = @JoinColumn(name = "issue_id"))
    @Column(name = "label")
    private List<String> labels;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @Column(name = "votes")
    private Integer votes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "html_url")
    private String htmlUrl;

    @Column(name = "author_association")
    private String authorAssociation;

    @Column(name = "kind")
    private String kind;

    @Column(name="watches")
    private Integer watches;

    public Issue() {

    }

    public Issue(String id, String title, String description, String state,
                 String created_at, String updated_at, String closed_at,
                 List<String> labels, User author, User assignee,
                 Integer votes, List<Comment> comments, String htmlUrl, String authorAssociation
                    , String kind, Integer watches) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.state = state;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.closed_at = closed_at;
        this.labels = labels;
        this.author = author;
        this.assignee = assignee;
        this.votes = votes;
        this.comments = comments;
        this.htmlUrl = htmlUrl;
        this.authorAssociation = authorAssociation;
        this.kind = kind;
        this.watches = watches;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getCreated_at() { return created_at; }

    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }

    public String getClosed_at() { return closed_at; }

    public void setClosed_at(String closed_at) { this.closed_at = closed_at; }

    public List<String> getLabels() { return labels; }

    public void setLabels(List<String> labels) { this.labels = labels; }

    public Integer getVotes() { return votes; }

    public void setVotes(Integer votes) { this.votes = votes; }

    public User getAuthor() { return author; }

    public void setAuthor(User author) { this.author = author; }

    public User getAssignee() { return assignee; }

    public void setAssignee(User assignee) { this.assignee = assignee; }

    public Project getProject() { return project; }

    public void setProject(Project project) { this.project = project; }

    public List<Comment> getComments() { return comments; }

    public void setComments(List<Comment> comments) { this.comments = comments; }

    public String getHtmlUrl() { return htmlUrl; }

    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public String getAuthorAssociation() { return authorAssociation; }

    public void setAuthorAssociation(String authorAssociation) { this.authorAssociation = authorAssociation; }

    public String getKind() { return kind; }
    public void setKind(String kind) { this.kind = kind; }

    public Integer getWatches() { return watches; }
    public void setWatches(Integer watches) { this.watches = watches; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Issue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null) ? "<null>" : this.state));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.created_at == null) ? "<null>" : this.created_at));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updated_at == null) ? "<null>" : this.updated_at));
        sb.append(',');
        sb.append("closedAt");
        sb.append('=');
        sb.append(((this.closed_at == null) ? "<null>" : this.closed_at));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null) ? "<null>" : this.labels));
        sb.append(',');
        sb.append("author");
        sb.append('=');
        sb.append(((this.author == null) ? "<null>" : this.author));
        sb.append(',');
        sb.append("assignee");
        sb.append('=');
        sb.append(((this.assignee == null) ? "<null>" : this.assignee));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null) ? "<null>" : this.comments));
        sb.append(',');
        sb.append("htmlUrl");
        sb.append('=');
        sb.append(((this.htmlUrl == null) ? "<null>" : this.htmlUrl));
        sb.append(',');
        sb.append("authorAssociation");
        sb.append('=');
        sb.append(((this.authorAssociation == null) ? "<null>" : this.authorAssociation));
        sb.append(',');
        sb.append("kind");
        sb.append('=');
        sb.append(((this.kind == null) ? "<null>" : this.kind));
        sb.append(',');
        sb.append("watches");
        sb.append('=');
        sb.append(((this.watches == null) ? "<null>" : this.watches));
        sb.append(',');

        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}

