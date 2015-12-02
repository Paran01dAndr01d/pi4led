package com.homesense.pi4led.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting() {
        return "Hello World!";
    }

    @RequestMapping("/light")
    public String light() {
        if (pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        }

        pin.blink(100,1000);
        pin.blink(200,1000);
        pin.blink(500,1000);
        pin.blink(1000,2000);
        pin.blink(3000,3000);
        pin.toggle();

        return "OK";
    }

}