package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String middleName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 15, unique = true)
    private String mobile;
    @Column(length = 50, unique = true)
    private String email;
    @Column(length = 32, nullable = false)
    private String passwordHash;
    @Column(nullable = false)
    private LocalDateTime registerAt;
    private LocalDateTime lastLogin;
    @Column(length = 3000)
    private String intro;
    @Column(length = 5000)
    private String profile;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Post> posts;
    @OneToMany(mappedBy = "user")
    private List<PostComment> postComments;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "account_authority",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_name", referencedColumnName = "name")
    )
    private Set<Authority> authorities = new HashSet<>();

    public User() {
    }


    public User(Long id, String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, LocalDateTime registerAt, LocalDateTime lastLogin, String intro, String profile, List<Post> posts, List<PostComment> postComments, Set<Authority> authorities) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registerAt = registerAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
        this.posts = posts;
        this.postComments = postComments;
        this.authorities = authorities;
    }

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, LocalDateTime registerAt, LocalDateTime lastLogin, String intro, String profile, List<Post> posts, List<PostComment> postComments, Set<Authority> authorities) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registerAt = registerAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
        this.posts = posts;
        this.postComments = postComments;
        this.authorities = authorities;
    }

    public User(long id, String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, LocalDateTime registerAt, LocalDateTime lastLogin, String intro, String profile, List<Post> posts, List<PostComment> postComments) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registerAt = registerAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
        this.posts = posts;
        this.postComments = postComments;
    }

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, LocalDateTime registerAt, LocalDateTime lastLogin, String intro, String profile, List<Post> posts, List<PostComment> postComments) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registerAt = registerAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
        this.posts = posts;
        this.postComments = postComments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(LocalDateTime registerAt) {
        this.registerAt = registerAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostComment> postComments) {
        this.postComments = postComments;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", registerAt=" + registerAt +
                ", lastLogin=" + lastLogin +
                ", intro='" + intro + '\'' +
                ", profile='" + profile + '\'' +
                ", posts=" + posts +
                ", postComments=" + postComments +
                ", authorities=" + authorities +
                '}';
    }
}
