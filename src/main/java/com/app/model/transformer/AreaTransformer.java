package com.app.model.transformer;

import com.app.model.domain.Area;
import com.app.model.dto.area.AreaRequestDto;
import com.app.model.dto.area.AreaResponseDto;


public class AreaTransformer {

    public static AreaResponseDto areaToAreaResponseDto(final Area area) {
        return AreaResponseDto
                .builder()
                .name(area.getName())
                .coordinateX(area.getCoordinateX())
                .coordinateY(area.getCoordinateY())
                .radars(RadarTransformer.radarListToRadarResponseDtoList(area.getRadars()))
                .cameras(CameraTransformer.cameraListToCameraResponseDtoList(area.getCameras()))
                .build();
    }

    public static Area areaRequestDtoToArea(final AreaRequestDto areaRequestDto) {
        return Area
                .builder()
                .name(areaRequestDto.getName())
                .coordinateX(areaRequestDto.getCoordinateX())
                .coordinateY(areaRequestDto.getCoordinateY())
                .radars(RadarTransformer.radarRequestDtoListToRadarList(areaRequestDto.getRadars()))
                .cameras(CameraTransformer.CameraRequestDtoListToCameraList(areaRequestDto.getCameras()))
                .build();
    }

    public static AreaRequestDto areaToAreaRequestDto(final Area area) {
        return AreaRequestDto
                .builder()
                .name(area.getName())
                .coordinateX(area.getCoordinateX())
                .coordinateY(area.getCoordinateY())
                .radars(RadarTransformer.radarListToRadarRequestDtoList(area.getRadars()))
                .cameras(CameraTransformer.cameraListToCameraRequestDtoList(area.getCameras()))
                .build();
    }

    public static Area areaResponseDtoToArea(final AreaResponseDto areaResponseDto) {
        return Area
                .builder()
                .name(areaResponseDto.getName())
                .coordinateX(areaResponseDto.getCoordinateX())
                .coordinateY(areaResponseDto.getCoordinateY())
                .radars(RadarTransformer.radarResponseDtoListToRadarList(areaResponseDto.getRadars()))
                .cameras(CameraTransformer.cameraResponseDtoListToCameraList(areaResponseDto.getCameras()))
                .build();
    }
}
