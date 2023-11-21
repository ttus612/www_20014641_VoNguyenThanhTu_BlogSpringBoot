package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private PostComment postComment;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(nullable = false)
    private boolean published;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime publishedAt;
    @Column(length = 5000)
    private String content;
    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    List<PostComment> postComments;

    public PostComment() {
    }

    public PostComment(long id, Post post, PostComment postComment, User user, String title, boolean published, LocalDateTime createdAt, LocalDateTime publishedAt, String content, List<PostComment> postComments) {
        this.id = id;
        this.post = post;
        this.postComment = postComment;
        this.user = user;
        this.title = title;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.postComments = postComments;
    }

    public PostComment(Post post, PostComment postComment, User user, String title, boolean published, LocalDateTime createdAt, LocalDateTime publishedAt, String content, List<PostComment> postComments) {
        this.post = post;
        this.postComment = postComment;
        this.user = user;
        this.title = title;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.postComments = postComments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostComment getPostComment() {
        return postComment;
    }

    public void setPostComment(PostComment postComment) {
        this.postComment = postComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", post=" + (post != null ? post.getId() : "null") +
                ", postComment=" + postComment +
                ", user=" + (user != null ? user.getId() : "null") +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", createdAt=" + createdAt +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", postComments=" + postComments +
                '}';
    }
}
