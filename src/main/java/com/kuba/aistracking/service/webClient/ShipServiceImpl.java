package com.kuba.aistracking.service.webClient;

import com.kuba.aistracking.model.webClient.Ship;
import com.kuba.aistracking.model.webClient.Track;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ShipServiceImpl implements ShipService {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Ship> getShipPositions() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + getToken());
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<Track[]> exchange = restTemplate.exchange("https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?Xmin=10.09094&Xmax=10.67047&Ymin=63.3989&Ymax=63.58645",
                HttpMethod.GET,
                httpEntity,
                Track[].class);

        List<Ship> collect = Stream.of(exchange.getBody()).map(
                track -> new Ship(
                        track.getGeometry().getCoordinates().get(0),
                        track.getGeometry().getCoordinates().get(1),
                        track.getName()
                )
        ).collect(Collectors.toList());
        return collect;

    }

    private String getToken() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("client_id", "brozdajakub@gmail.com:norsu296");
        map.add("client_secret", "Kajtoszek123!");
        map.add("scope", "api");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange("https://id.barentswatch.no/connect/token",
                HttpMethod.POST,
                entity,
                String.class);
        String splitToken = response.getBody().split(":")[1].split(",")[0];
        return splitToken.substring(1, splitToken.length() - 1);
    }


}
