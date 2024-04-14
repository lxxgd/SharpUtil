package com.zerobyte.sharputil;

import java.util.UUID;

public class UUIDUtil {
    public static UUID uuidFromIntArray(int[] p_235886_) {
        return new UUID((long)p_235886_[0] << 32 | (long)p_235886_[1] & 4294967295L, (long)p_235886_[2] << 32 | (long)p_235886_[3] & 4294967295L);
    }

    public static int[] uuidToIntArray(UUID pUuid) {
        long i = pUuid.getMostSignificantBits();
        long j = pUuid.getLeastSignificantBits();
        return leastMostToIntArray(i, j);
    }

    private static int[] leastMostToIntArray(long pMost, long pLeast) {
        return new int[]{(int)(pMost >> 32), (int)pMost, (int)(pLeast >> 32), (int)pLeast};
    }
}
