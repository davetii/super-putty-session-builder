package com.greatwideweb.samples.superputty;

public class SessionData {

    private final String sessionId;
    private final String userName;
    private final String sessionName;
    private final String hostName;

    public SessionData(String[] text) {
        this.sessionId = text[0].trim();
        this.userName = text[1].trim();
        this.sessionName = text[2].trim();
        this.hostName = text[3].trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getHostName() {
        return hostName;
    }

    @Override
    public String toString() {
        return "SessionData{" +
                "sessionId='" + sessionId + '\'' +
                ", userName='" + userName + '\'' +
                ", sessionName='" + sessionName + '\'' +
                ", hostName='" + hostName + '\'' +
                '}';
    }
}
