package py.edu.facitec.githubusers;

public class User {
    public String login;
    public int id;
    public String avatar_url;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public User(String login, int id, String node_id, String avatar_url, String gravatar_id, String url, String html_url, String followers_url, String following_url, String gists_url, String starred_url, String subscriptions_url, String organizations_url, String repos_url, String events_url, String received_events_url, String type, boolean site_admin) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return
                id + '\n' +
                login + '\n' +
                avatar_url;
    }

    public User() {
    }
}
