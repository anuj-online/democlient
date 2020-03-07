package com.example.demo.controllers;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ClientController {


    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<DataObject> callServer(){

        WebClient webClient = WebClient.create("http://localhost:8081");

        Flux<DataObject> dataObjectFlux = webClient.get().uri("/all/1").retrieve().bodyToFlux(DataObject.class);

        dataObjectFlux.delayElements(Duration.ofSeconds(1L)).doOnNext(
                System.out::println

        ).subscribe();

        return dataObjectFlux;

    }
}
@Data
class DataObject{
    private Long id;
    private String nameNow;
    private String designationNow;

}
