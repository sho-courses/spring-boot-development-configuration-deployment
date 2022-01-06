package org.nekosoft.pdffer.props;

public class EmailAddressInfo {
    // field declarations
    private String name;
    private String address;

    public EmailAddressInfo(String name, String address) {
        // set field values
        this.name = name;
        this.address = address;
    }

    // getters only

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
