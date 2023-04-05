package com.app.model.transformer;

import com.app.model.domain.Radar;
import com.app.model.dto.radar.RadarRequestDto;
import com.app.model.dto.radar.RadarResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class RadarTransformer {

    public static List<RadarResponseDto> radarListToRadarResponseDtoList(final List<Radar> radars) {
        return radars.stream().map(radar -> RadarResponseDto
                        .builder()
                        .name(radar.getName())
                        .coordinateX(radar.getCoordinateX())
                        .coordinateY(radar.getCoordinateY())
                        .azimuth(radar.getAzimuth())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<Radar> radarRequestDtoListToRadarList(final List<RadarRequestDto> radarRequestListDto) {
        return radarRequestListDto.stream().map(radarRequestDto -> Radar
                        .builder()
                        .name(radarRequestDto.getName())
                        .coordinateX(radarRequestDto.getCoordinateX())
                        .coordinateY(radarRequestDto.getCoordinateY())
                        .azimuth(radarRequestDto.getAzimuth())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<RadarRequestDto> radarListToRadarRequestDtoList(final List<Radar> radars) {
        return radars.stream().map(radar -> RadarRequestDto
                        .builder()
                        .name(radar.getName())
                        .coordinateX(radar.getCoordinateX())
                        .coordinateY(radar.getCoordinateY())
                        .azimuth(radar.getAzimuth())
                        .build())
                .collect(Collectors.toList());
    }

    public static List<Radar> radarResponseDtoListToRadarList(final List<RadarResponseDto> radarResponseDtoList) {
        return radarResponseDtoList.stream().map(radarResponseDto -> Radar
                        .builder()
                        .name(radarResponseDto.getName())
                        .coordinateX(radarResponseDto.getCoordinateX())
                        .coordinateY(radarResponseDto.getCoordinateY())
                        .azimuth(radarResponseDto.getAzimuth())
                        .build())
                .collect(Collectors.toList());
    }
}
