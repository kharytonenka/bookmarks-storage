package com.mk.bookmark;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookmarksConfiguration {

    @Bean
    public Datastore getDatastore() {
        return DatastoreOptions.getDefaultInstance().getService();
    }

}
