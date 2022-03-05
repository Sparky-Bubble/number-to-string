package com.sparkybubble.numbertostring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sparkybubble.numbertostring.NumberToStringApplication.readIntoFile;
import static org.junit.jupiter.api.Assertions.*;

class NumberToStringApplicationTest {


    @BeforeEach
    void setUp() {
         NumberToStringApplication object = new NumberToStringApplication();
    }

    @Test
    void testDisplay() throws IOException {
        NumberToStringApplication object = null;
        assertNull(object);

        File file = new File("src/main/resources/nums.txt");
        assertTrue(file.exists());
    }

    @Test
    void testReadIntoFile() throws IOException {

        File file = new File("src/main/resources/nums.txt");
        assertTrue(file.exists());
        assertTrue(file.canRead());

        File file2 = file;
        assertTrue(file2.exists());

        assertTrue(file.getAbsoluteFile().equals(file2.getAbsoluteFile()));

        assertFalse(readIntoFile().isEmpty());
        assertTrue(readIntoFile().size() == 7);

        readIntoFile().add("eight");
        assertFalse(readIntoFile().size() == 8);


    }

    @Test
    void testSortArray() {
        String [][] array;

    }
}