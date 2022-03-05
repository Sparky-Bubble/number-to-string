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

        /*Tests whether the file is located and also can be read.*/
        assertTrue(file.exists());
        assertTrue(file.canRead());

        /*Create another file equal to the first*/
        File file2 = file;
        assertTrue(file2.exists());

        /*Test to make sure both refer to same file*/
        assertTrue(file.getAbsoluteFile().equals(file2.getAbsoluteFile()));

        /*Test to see if the readIntoFile method is not empty when called.*/
        assertFalse(readIntoFile().isEmpty());
        /*Assert that the size of the file is the same*/
        assertTrue(readIntoFile().size() == 7);

        /*Try to add to the file, then call method again to make sure nothing is changed.*/
        readIntoFile().add("eight");
        assertFalse(readIntoFile().size() == 8);


    }

    @Test
    void testSortArray() {
        String [][] array;

    }
}