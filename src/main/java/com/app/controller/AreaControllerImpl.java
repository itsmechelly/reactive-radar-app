package com.app.controller;

import com.app.model.dto.area.AreaRequestDto;
import com.app.model.dto.area.AreaResponseDto;
import com.app.provider.AreaProvider;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
public class AreaControllerImpl implements AreaController {

    private final AreaProvider areaProvider;

    @Override
    public Mono<AreaResponseDto> createArea(final AreaRequestDto areaRequestDto) {
        return areaProvider.createArea(areaRequestDto);
    }

    @Override
    public Mono<UpdateResult> updateArea(final String id, final AreaRequestDto areaRequestDto) {
        return areaProvider.updateArea(id, areaRequestDto);
    }

    @Override
    public Mono<DeleteResult> deleteAreaById(final String id) {
        return areaProvider.deleteAreaById(id);
    }

    @Override
    public Mono<AreaResponseDto> getAreaById(final String id) {
        return areaProvider.getAreaById(id);
    }

    @Override
    public Flux<AreaResponseDto> getAreas(final String name, final List<String> radarIds) {
        return areaProvider.getAreas(name, radarIds);
    }
}
