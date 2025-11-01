package com.xq.io;

import java.io.InputStream;

public class Resources {

    public static InputStream getResourceAsStream(String fileName) {
        return Resources.class.getClassLoader().getResourceAsStream(fileName);
    }
}
