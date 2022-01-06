package org.nekosoft.pdffer.props;

import java.util.Properties;

/**
 * The type Smtp server info.
 */
public class SmtpServerInfo {
    // field declarations
    private String host;
    private int port;
    private String username;
    private String password;
    private Properties javaMailProperties;

    /**
     * Instantiates a new Smtp server info.
     *
     * @param host               the host
     * @param port               the port
     * @param username           the username
     * @param password           the password
     * @param javaMailProperties the java mail properties
     */
    public SmtpServerInfo(String host, int port, String username, String password, Properties javaMailProperties) {
        // set field values
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.javaMailProperties = javaMailProperties;
    }

    // getters only

    /**
     * Gets host.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets java mail properties.
     *
     * @return the java mail properties
     */
    public Properties getJavaMailProperties() {
        return javaMailProperties;
    }
}
