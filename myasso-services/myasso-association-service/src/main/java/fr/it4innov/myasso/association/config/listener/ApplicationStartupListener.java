package fr.it4innov.myasso.association.config.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Christus
 * @date 21/07/2024
 */
@Component
public class ApplicationStartupListener {

    private LocalDateTime startupDate;

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {
        this.startupDate = LocalDateTime.now();
        System.out.println("Application started at: " + startupDate);
    }

    public LocalDateTime getStartupDate() {
        return startupDate;
    }
}