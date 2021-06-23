package com.app.WeatherAPI.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.app.WeatherAPI.config.Configuration;

@RestController
public class WeatherController {

    @RequestMapping(method = RequestMethod.GET, value = "/byCity/{country}/{city}")
    public @ResponseBody Object getWeatherByCity(@PathVariable String city, @PathVariable String country) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Object> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country +
                        "&APPID=c3636a4bf66b92c86a9d711a9ef24732",
                Object.class);

        return response;
    }

 }



