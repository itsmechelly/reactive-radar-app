package com.app.model.dto.camera;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CameraRequestDto {

    private String name;
    private Integer coordinateX;
    private Integer coordinateY;
    private Integer azimuth;
    private double fieldOfView;
}
