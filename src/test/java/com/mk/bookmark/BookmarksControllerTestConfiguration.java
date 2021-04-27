package com.mk.bookmark;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.testing.LocalDatastoreHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class BookmarksControllerTestConfiguration {

    public static final double DATASTORE_TEST_CONSISTENCY = 1.0;

    private Datastore datastore;

    @Bean
    public Datastore getDatastore() throws IOException, InterruptedException {
        LocalDatastoreHelper localDatastoreHelper = LocalDatastoreHelper.create(DATASTORE_TEST_CONSISTENCY);
        localDatastoreHelper.start();

        datastore = localDatastoreHelper.getOptions().getService();

        return datastore;
    }

    @Bean
    public BookmarksController getBookmarksController() {
        return new BookmarksController(datastore);
    }
}
