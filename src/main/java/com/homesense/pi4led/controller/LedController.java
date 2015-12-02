package com.homesense.pi4led.controller;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;
import org.springframework.web.bind.annotation.RequestMapping;

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
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "led1", PinState.LOW);
        }

        pin.toggle();

        return "OK";
    }
}