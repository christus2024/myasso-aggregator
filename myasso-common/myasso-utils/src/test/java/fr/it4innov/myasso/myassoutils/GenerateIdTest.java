package fr.it4innov.myasso.myassoutils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class GenerateIdTest {

    @Test
    public void shouldGenerateId(){
        String generatedId = GenerateId.generateId("Association");
        log.info("generatedId : {}", generatedId);
        assertTrue(generatedId.contains("ASSOCIATION"));
    }

}