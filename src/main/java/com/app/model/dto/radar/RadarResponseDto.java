package com.app.model.dto.radar;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RadarResponseDto {

    private String name;
    private Integer coordinateX;
    private Integer coordinateY;
    private Integer azimuth;
}
