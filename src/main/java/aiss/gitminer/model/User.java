package aiss.gitminer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "GMUser")     // Watch out: User is a reserved keyword in H2
public class User {

    @Id
    private String id;

    @Column(name = "username")
    @NotEmpty(message = "The username cannot be empty")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar_url")
    private String avatar_url;

    @Column(name = "web_url")
    private String web_url;

    @OneToMany(mappedBy = "author")
    private List<Comment> authoredComments;

    @Column(name = "html_url")
    private String htmlUrl;

    @Column(name = "followers")
    private Integer followers;

    @Column(name="nickname")
    private String nickname;

    @Column(name="account_status")
    private Integer accountStatus;








    public User() {
    }

    public User(String id, String username, String name, String avatar_url,
                String web_url, String htmlUrl, Integer followers, String nickname, Integer accountStatus) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatar_url = avatar_url;
        this.web_url = web_url;
        this.htmlUrl = htmlUrl;
        this.followers = followers;
        this.nickname = nickname;
        this.accountStatus = accountStatus;

    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getHtml_url() { return htmlUrl; }

    public void setHtml_url(String html_url) { this.htmlUrl = html_url; }

    public Integer getFollowers() { return followers; }

    public void setFollowers(Integer followers) { this.followers = followers; }


    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public Integer getAccountStatus() { return accountStatus; }
    public void setAccountStatus(Integer accountStatus) { this.accountStatus = accountStatus; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("username");
        sb.append('=');
        sb.append(((this.username == null) ? "<null>" : this.username));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("avatar_url");
        sb.append('=');
        sb.append(((this.avatar_url == null) ? "<null>" : this.avatar_url));
        sb.append(',');
        sb.append("web_url");
        sb.append('=');
        sb.append(((this.web_url == null) ? "<null>" : this.web_url));
        sb.append(',');
        sb.append("html_url");
        sb.append('=');
        sb.append(((this.htmlUrl == null) ? "<null>" : this.htmlUrl));
        sb.append(',');
        sb.append("followers");
        sb.append('=');
        sb.append(((this.followers == null) ? "<null>" : this.followers));
        sb.append(',');
        sb.append("nickname");
        sb.append('=');
        sb.append(((this.nickname == null) ? "<null>" : this.nickname));
        sb.append(',');
        sb.append("accountStatus");
        sb.append('=');
        sb.append(((this.accountStatus == null) ? "<null>" : this.accountStatus));
        sb.append(',');


        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}

