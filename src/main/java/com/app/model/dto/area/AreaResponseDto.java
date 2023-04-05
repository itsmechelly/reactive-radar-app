package com.app.model.dto.area;

import com.app.model.dto.camera.CameraResponseDto;
import com.app.model.dto.radar.RadarResponseDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AreaResponseDto {

    @NotEmpty
    private String name;
    private Integer coordinateX;
    private Integer coordinateY;
    private List<RadarResponseDto> radars;
    private List<CameraResponseDto> cameras;
}
