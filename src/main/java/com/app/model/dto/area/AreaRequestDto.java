package com.app.model.dto.area;

import com.app.model.dto.camera.CameraRequestDto;
import com.app.model.dto.radar.RadarRequestDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AreaRequestDto {

    @NotEmpty
    private String name;
    private Integer coordinateX;
    private Integer coordinateY;
    private List<RadarRequestDto> radars;
    private List<CameraRequestDto> cameras;
}
