package com.mightyjava.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BookTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Book}
     *   <li>{@link Book#setAuthor(String)}
     *   <li>{@link Book#setGenre(String)}
     *   <li>{@link Book#setId(Long)}
     *   <li>{@link Book#setIsbnNumber(Double)}
     *   <li>{@link Book#setLanguage(String)}
     *   <li>{@link Book#setPrice(Double)}
     *   <li>{@link Book#setTitle(String)}
     * </ul>
     */
    @Test
    void testConstructor() {
        Book actualBook = new Book();
        actualBook.setAuthor("JaneDoe");
        actualBook.setGenre("Genre");
        actualBook.setId(123L);
        actualBook.setIsbnNumber(10.0d);
        actualBook.setLanguage("en");
        actualBook.setPrice(10.0d);
        actualBook.setTitle("Dr");
        assertEquals("JaneDoe", actualBook.getAuthor());
        assertNull(actualBook.getCoverPhotoURL());
        assertEquals("Genre", actualBook.getGenre());
        assertEquals(123L, actualBook.getId().longValue());
        assertEquals(10.0d, actualBook.getIsbnNumber().doubleValue());
        assertEquals("en", actualBook.getLanguage());
        assertEquals(10.0d, actualBook.getPrice().doubleValue());
        assertEquals("Dr", actualBook.getTitle());
    }
}
