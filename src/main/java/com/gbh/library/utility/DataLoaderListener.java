package com.gbh.library.utility;

import org.springframework.context.event.EventListener;

/**
 *
 * @author sinoa
 */

public class DataLoaderListener {

    @EventListener
    public void handleEvent(Object event) {
        System.out.println("event: " + event);
        System.out.println("event: " + event);
        System.out.println("event: " + event);
        System.out.println("event: " + event);
        System.out.println("event: " + event);

    }
}
