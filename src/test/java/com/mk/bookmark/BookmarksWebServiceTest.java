package com.mk.bookmark;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class BookmarksWebServiceTest {

    public static final String HOST = "https://mk-sas4ta.appspot.com";

    public static final String BOOKMARKS_API_METHOD = "/api/v1/bookmarks";

    public static final String TEST_BOOK_NAME_PATTERN = "Author: Book %s";

    public static final int TEST_PAGE_NUMBER = 23;

    @Test
    public void verifyBookmarksPosting() {
        Bookmark bookmark = new Bookmark();

        String bookName = String.format(TEST_BOOK_NAME_PATTERN, RandomStringUtils.randomAlphabetic(10));

        bookmark.setBookName(bookName);
        bookmark.setPageNumber(TEST_PAGE_NUMBER);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForEntity(HOST + BOOKMARKS_API_METHOD, bookmark, String.class);

        String bookmarksResponse = restTemplate.getForEntity(HOST + BOOKMARKS_API_METHOD, String.class).getBody();

        Assertions.assertTrue(bookmarksResponse.contains(bookName));
    }

}