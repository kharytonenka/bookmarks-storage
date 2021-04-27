package com.mk.bookmark;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.testing.LocalDatastoreHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class BookmarksControllerTestConfiguration {

    public static final double DATASTORE_TEST_CONSISTENCY = 1.0;

    @Bean
    public BookmarksController getBookmarksController() throws IOException, InterruptedException {
        LocalDatastoreHelper localDatastoreHelper = LocalDatastoreHelper.create(DATASTORE_TEST_CONSISTENCY);
        localDatastoreHelper.start();

        Datastore datastore = localDatastoreHelper.getOptions().getService();

        return new BookmarksController(datastore);
    }
}
