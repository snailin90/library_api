package com.gbh.library;

import com.gbh.library.utility.DataLoaderListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author sinoa
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public DataLoaderListener dataLoaderListener() {
        return new DataLoaderListener();
    }
}
