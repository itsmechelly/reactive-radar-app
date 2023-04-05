package com.app.model.dto.radar;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RadarRequestDto {

    private String name;
    private Integer coordinateX;
    private Integer coordinateY;
    private Integer azimuth;
}
