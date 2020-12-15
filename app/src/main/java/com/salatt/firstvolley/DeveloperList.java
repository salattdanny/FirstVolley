package com.salatt.firstvolley;

public class DeveloperList {

    private String login;
    private String avatar_url;
    private String html_url;
    public DeveloperList(String login,String avatar_url,String gitUrl){
        this.login=login;
        this.avatar_url=avatar_url;
        this.html_url= gitUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }
}
