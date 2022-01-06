package org.nekosoft.pdffer.props;

/**
 * The type Email address info.
 */
public class EmailAddressInfo {
    // field declarations
    private String name;
    private String address;

    /**
     * Instantiates a new Email address info.
     *
     * @param name    the name
     * @param address the address
     */
    public EmailAddressInfo(String name, String address) {
        // set field values
        this.name = name;
        this.address = address;
    }

    // getters only

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }
}
