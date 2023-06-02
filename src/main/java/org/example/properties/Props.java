package org.example.properties;

import info.macias.kaconf.KA;
import info.macias.kaconf.Property;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Props {
    @Property("baseUrl")
    public static final String BASE_URL = KA.aString();
    @Property("browserName")
    public static final String BROWSER_NAME = KA.aString();
}
