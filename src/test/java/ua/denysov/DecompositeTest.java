package ua.denysov;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecompositeTest {

    String[] words = {"qwe", "asd","qwerty","rty","asdaaaa"};
    String[] anotherWords = {"qwe", "asd","qwertyu","rty","asdaaaa"};

    @Test
    public void testFindLongestComplexWord(){
        assertEquals(Decomposite.findLongestComplexWord(words), 2);
    }

    @Test
    public void testFindLongestComplexWord1(){
        assertEquals(Decomposite.findLongestComplexWord(anotherWords), -1);
    }

    @Test(expected = NullPointerException.class)
    public void testFindLongestComplexWord2(){
        Decomposite.findLongestComplexWord(null);
    }

    @Test
    public void testIsComplex(){
        assertTrue(Decomposite.isComplex(words, 2, 0));
    }

    @Test
    public void testIsComplex1(){
        assertFalse(Decomposite.isComplex(words, 4, 0));
    }

}