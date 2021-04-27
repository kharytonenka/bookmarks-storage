package com.mk.bookmark;

import com.google.cloud.datastore.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookmarksController {

    private final Datastore datastore;

    public BookmarksController(Datastore datastore) {
        this.datastore = datastore;
    }

    @GetMapping("/api/v1/bookmarks")
    public List<Bookmark> getBookmarks() {
        List<Bookmark> bookmarks = new ArrayList<>();

        Query<Entity> query = Query.newEntityQueryBuilder().setKind("Bookmarks").build();
        QueryResults<Entity> results = datastore.run(query);

        while (results.hasNext()) {
            Entity entity = results.next();

            Bookmark bookmark = new Bookmark();

            bookmark.setId(entity.getKey().getId());
            bookmark.setBookName(entity.getString("book_name"));
            bookmark.setPageNumber((int) entity.getLong("page_number"));

            bookmarks.add(bookmark);
        }

        return bookmarks;
    }

    @PostMapping("/api/v1/bookmarks")
    public void addBookmark(@RequestBody Bookmark bookmark) {
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Bookmarks");
        FullEntity<IncompleteKey> messageEntity = Entity.newBuilder(keyFactory.newKey())
                .set("book_name", bookmark.getBookName())
                .set("page_number", bookmark.getPageNumber())
                .build();

        datastore.put(messageEntity);
    }
}