package com.app.service;

import com.app.model.domain.Area;
import com.app.repository.AreaRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    @Override
    public Mono<Area> createArea(final Area area) {
        log.info("createArea() for name: {}", area.getName());
        return areaRepository.createArea(area)
                .doOnNext(createdArea -> log.info("createArea()::ON_NEXT, area: {}", createdArea))
                .doOnError(throwable -> log.error("createArea()::ON_ERROR, throwable: {}", throwable.getMessage()));
    }

    @Override
    public Mono<UpdateResult> updateArea(final String id, final Area area) {
        log.info("updateArea() REQUEST: name: {}", area.getName());
        return areaRepository.updateArea(id, area)
                .doOnNext(updatedArea -> log.info("updateArea()::ON_NEXT area: {}, result: updatedArea: {}", area, updatedArea))
                .doOnError(throwable -> log.info("updateArea()::ON_ERROR throwable: {}", throwable.getMessage()));
    }

    @Override
    public Mono<DeleteResult> deleteAreaById(final String id) {
        log.info("deleteAreaById() REQUEST: id: {}", id);
        return areaRepository.deleteAreaById(id)
                .doOnNext(idToRemove -> log.info("deleteAreaById()::ON_NEXT id: {}, result: null", idToRemove))
                .doOnError(throwable -> log.info("deleteAreaById()::ON_ERROR throwable: {}", throwable.getMessage()));
    }

    @Override
    public Mono<Area> getAreaById(final String id) {
        log.info("getAreaById(), for id: {}", id);
        return areaRepository.getAreaById(id)
                .doOnNext(area -> log.info("getAreaById()::ON_NEXT, id: {}. result - area: {}", id, area))
                .doOnError(throwable -> log.error("getAreaById()::ON_ERROR, throwable: {}", throwable.getMessage()));
    }

    @Override
    public Flux<Area> getAreas(final String name, final List<String> radarIds) {
        log.info("getAreas() fetch from areaServiceImpl");
        return areaRepository.getAreas(name, radarIds)
                .doOnNext(area -> log.info("getAreas()::ON_NEXT, areas: {}", area))
                .doOnError(throwable -> log.error("getAreas()::ON_ERROR, throwable: {}", throwable.getMessage()));
    }
}
