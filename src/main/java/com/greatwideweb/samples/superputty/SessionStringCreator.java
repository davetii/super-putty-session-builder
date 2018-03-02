package com.greatwideweb.samples.superputty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SessionStringCreator {
    private static final String BASE_SESSION ="<SessionData SessionId=\"<<sessionId>>/<<sessionName>>\" SessionName=\"<<sessionName>>\" ImageKey=\"computer\" Host=\"<<hostName>>\" Port=\"22\" Proto=\"SSH\" PuttySession=\"Default Settings\" Username=\"<<userName>>\" ExtraArgs=\"\" />";
    private final static Pattern SESSION_NAME_PATTERN = Pattern.compile("<<sessionName>>");
    private final static Pattern USER_NAME_PATTERN = Pattern.compile("<<userName>>");
    private final static Pattern HOST_NAME_PATTERN = Pattern.compile("<<hostName>>");

    public static String parse(SessionData data) {
        String baseString = BASE_SESSION.replace("<<sessionId>>", data.getSessionId());
        Matcher matcher = SESSION_NAME_PATTERN.matcher(baseString);
        matcher = USER_NAME_PATTERN.matcher(matcher.replaceAll(data.getSessionName()));
        matcher = HOST_NAME_PATTERN.matcher(matcher.replaceAll(data.getUserName()));
        return matcher.replaceAll(data.getHostName());
    }
}
