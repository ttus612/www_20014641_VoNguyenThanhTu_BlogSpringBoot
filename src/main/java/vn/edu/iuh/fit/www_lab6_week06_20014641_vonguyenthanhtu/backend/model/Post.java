package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private Post post;
    @Column(length = 75, nullable = false)
    private String title;
    @Column(length = 100)
    private String metaTitle;
    @Column(length = 3000)
    private String summary;
    @Column(nullable = false)
    private boolean published;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;
    @Column(length = 5000)
    private String content;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostComment> postComments;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Post> posts;

    public Post() {
    }

    public Post(Long id, User user, Post post, String title, String metaTitle, String summary, boolean published, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime publishedAt, String content, List<PostComment> postComments, List<Post> posts) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.postComments = postComments;
        this.posts = posts;
    }

    public Post(User user, Post post, String title, String metaTitle, String summary, boolean published, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime publishedAt, String content, List<PostComment> postComments, List<Post> posts) {
        this.user = user;
        this.post = post;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.postComments = postComments;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostComment> postComments) {
        this.postComments = postComments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + (user != null ? user.getId() : "null") +
                ", post=" + (post != null ? post.getId() : "null") +
                ", title='" + title + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", published=" + published +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", postComments=" + postComments +
                ", posts=" + posts +
                '}';
    }
}
