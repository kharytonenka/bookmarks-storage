package com.mk.bookmark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = BookmarksControllerTestConfiguration.class)
class BookmarksControllerTest {

    public static final String TEST_BOOK_NAME = "Diana Murray: Unicorn Day";

    public static final int TEST_PAGE_NUMBER = 17;

    @Autowired
    private BookmarksController bookmarksController;

    @Test
    void verifyBookmarkPosting() {
        Bookmark bookmark = new Bookmark();
        bookmark.setBookName(TEST_BOOK_NAME);
        bookmark.setPageNumber(TEST_PAGE_NUMBER);

        bookmarksController.addBookmark(bookmark);

        Bookmark expectedBookmark = bookmarksController.getBookmarks().get(0);

        Assertions.assertEquals(TEST_BOOK_NAME, expectedBookmark.getBookName());
        Assertions.assertEquals(TEST_PAGE_NUMBER, expectedBookmark.getPageNumber());
    }

}