package com.app.provider;

import com.app.model.dto.area.AreaRequestDto;
import com.app.model.dto.area.AreaResponseDto;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AreaProvider {

    Mono<AreaResponseDto> createArea(AreaRequestDto areaRequestDto);

    Mono<UpdateResult> updateArea(String id, AreaRequestDto areaRequestDto);

    Mono<DeleteResult> deleteAreaById(String id);

    Mono<AreaResponseDto> getAreaById(String id);

    Flux<AreaResponseDto> getAreas(String name, List<String> radarIds);
}
