package org.nekosoft.pdffer._misc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AppSecrets {

    @Value("${random.int}")
    private int secretRandomInt;

    @Value("${random.long(0,1000)}")
    private long secretRandomLong;

    @Value("${random.uuid}")
    private UUID secretRandomUUID;

    @Value("${random.anything}")
    private byte[] secretRandomBytes;

    // getters

    public int getSecretRandomInt() {
        return secretRandomInt;
    }

    public long getSecretRandomLong() {
        return secretRandomLong;
    }

    public UUID getSecretRandomUUID() {
        return secretRandomUUID;
    }

    public byte[] getSecretRandomBytes() {
        return secretRandomBytes;
    }

}
