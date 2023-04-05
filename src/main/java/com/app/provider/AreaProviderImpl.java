package com.app.provider;

import com.app.model.domain.Area;
import com.app.model.dto.area.AreaRequestDto;
import com.app.model.dto.area.AreaResponseDto;
import com.app.model.transformer.AreaTransformer;
import com.app.service.AreaService;
import com.app.core.exception.NoContentException;
import com.app.core.exception.provider.ResourceNotFoundException;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class AreaProviderImpl implements AreaProvider {

    private final AreaService areaService;

    @Override
    public Mono<AreaResponseDto> createArea(final AreaRequestDto areaRequestDto) {
        log.info("createArea() REQUEST: areaRequestDto: {}", areaRequestDto);
        final Area newArea = AreaTransformer.areaRequestDtoToArea(areaRequestDto);
        return areaService.createArea(newArea)
                .doOnNext(area -> log.info("createArea()::ON_NEXT areaRequestDto: {}, result: area: {}", areaRequestDto, area))
                .doOnError(throwable -> log.info("createArea()::ON_ERROR throwable: {}", throwable.getMessage()))
                .map(AreaTransformer::areaToAreaResponseDto);
    }

    @Override
    public Mono<UpdateResult> updateArea(final String id, final AreaRequestDto areaRequestDto) {
        log.info("createArea() REQUEST: areaRequestDto: {}", areaRequestDto);
        final Area newArea = AreaTransformer.areaRequestDtoToArea(areaRequestDto);
        return areaService.updateArea(id, newArea)
                .doOnNext(updatedArea -> log.info("updateArea()::ON_NEXT areaRequestDto: {}, result: area: {}", areaRequestDto, updatedArea))
                .doOnError(throwable -> log.info("updateArea()::ON_ERROR throwable: {}", throwable.getMessage()));
    }

    @Override
    public Mono<DeleteResult> deleteAreaById(final String id) {
        log.info("deleteAreaById() REQUEST: id: {}", id);
        return areaService.deleteAreaById(id)
                .doOnNext(idToRemove -> log.info("deleteAreaById()::ON_NEXT id: {}, result: null", idToRemove))
//                .doOnError(throwable -> log.info("deleteAreaById()::ON_ERROR throwable: {}", throwable.getMessage()));
                //todo todo todo (:
                .onErrorMap(throwable -> new ResourceNotFoundException(id));
    }

    @Override
    public Mono<AreaResponseDto> getAreaById(final String id) {
        log.info("getAreaById() REQUEST: id: {}", id);
        return areaService.getAreaById(id)
                .doOnNext(area -> log.info("getAreaById()::ON_NEXT id: {}, result: area: {}", id, area))
                .doOnError(throwable -> log.info("getAreaById()::ON_ERROR throwable: {}", throwable.getMessage()))
                .switchIfEmpty(Mono.error(NoContentException::new))
                .map(AreaTransformer::areaToAreaResponseDto);
    }

    @Override
    public Flux<AreaResponseDto> getAreas(final String name, final List<String> radarIds) {
        log.info("getAreas() fetch from areaProviderImpl");
        return areaService.getAreas(name, radarIds)
                .doOnNext(areas -> log.info("getAreas() result: areas {}", areas))
                .doOnError(throwable -> log.info("getAreas()::ON_ERROR throwable: {}", throwable.getMessage()))
                .map(AreaTransformer::areaToAreaResponseDto);
    }
}
