package org.nekosoft.pdffer.props;

import java.util.Properties;

public class SmtpServerInfo {
    // field declarations
    private String host;
    private int port;
    private String username;
    private String password;
    private Properties javaMailProperties;

    public SmtpServerInfo(String host, int port, String username, String password, Properties javaMailProperties) {
        // set field values
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.javaMailProperties = javaMailProperties;
    }

    // getters only

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Properties getJavaMailProperties() {
        return javaMailProperties;
    }
}
