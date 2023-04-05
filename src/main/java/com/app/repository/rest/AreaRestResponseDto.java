package com.app.repository.rest;

import com.app.model.domain.Radar;
import com.app.model.dto.camera.CameraRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaRestResponseDto {

    private String id;
    private String name;
    private Integer coordinateX;
    private Integer coordinateY;
    private List<Radar> radars;
    private List<CameraRequestDto> cameras;
}
