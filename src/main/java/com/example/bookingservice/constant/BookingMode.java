package com.example.bookingservice.constant;


import lombok.Getter;

@Getter
public enum BookingMode {
    ocean(1, "ocean"),
    air(2, "air"),
    //road(3, "road")
    ;


    private final int modeCode;
    private final String modeName;

    BookingMode(int modeCode, String modeName) {
        this.modeCode = modeCode;
        this.modeName = modeName;
    }
}
