package com.app.model.transformer;

import com.app.model.domain.Camera;
import com.app.model.dto.camera.CameraRequestDto;
import com.app.model.dto.camera.CameraResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class CameraTransformer {

    public static List<CameraResponseDto> cameraListToCameraResponseDtoList(final List<Camera> cameras) {
        return cameras.stream().map(camera -> CameraResponseDto
                        .builder()
                        .name(camera.getName())
                        .coordinateX(camera.getCoordinateX())
                        .coordinateY(camera.getCoordinateY())
                        .azimuth(camera.getAzimuth())
                        .fieldOfView(camera.getFieldOfView())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<Camera> CameraRequestDtoListToCameraList(final List<CameraRequestDto> cameraRequestDtos) {
        return cameraRequestDtos.stream().map(cameraRequestDto -> Camera
                        .builder()
                        .name(cameraRequestDto.getName())
                        .coordinateX(cameraRequestDto.getCoordinateX())
                        .coordinateY(cameraRequestDto.getCoordinateY())
                        .azimuth(cameraRequestDto.getAzimuth())
                        .fieldOfView(cameraRequestDto.getFieldOfView())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<CameraRequestDto> cameraListToCameraRequestDtoList(final List<Camera> cameras) {
        return cameras.stream().map(camera -> CameraRequestDto
                        .builder()
                        .name(camera.getName())
                        .coordinateX(camera.getCoordinateX())
                        .coordinateY(camera.getCoordinateY())
                        .azimuth(camera.getAzimuth())
                        .fieldOfView(camera.getFieldOfView())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<Camera> cameraResponseDtoListToCameraList(final List<CameraResponseDto> cameraResponseDtos) {
        return cameraResponseDtos.stream().map(cameraResponseDto -> Camera
                        .builder()
                        .name(cameraResponseDto.getName())
                        .coordinateX(cameraResponseDto.getCoordinateX())
                        .coordinateY(cameraResponseDto.getCoordinateY())
                        .azimuth(cameraResponseDto.getAzimuth())
                        .fieldOfView(cameraResponseDto.getFieldOfView())
                        .build())
                .collect(Collectors.toList());
    }
}
