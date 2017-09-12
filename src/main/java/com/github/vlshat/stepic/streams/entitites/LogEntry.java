package com.github.vlshat.stepic.streams.entitites;

import lombok.Data;

import java.util.Date;

@Data
public class LogEntry {
    private Date created;
    private String login;
    private String url;

    public LogEntry(String login, String url) {
        this.created = new Date();
        this.login = login;
        this.url = url;
    }
}
