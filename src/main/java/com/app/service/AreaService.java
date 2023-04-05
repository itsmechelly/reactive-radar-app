package com.app.service;

import com.app.model.domain.Area;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AreaService {

    Mono<Area> createArea(Area area);

    Mono<UpdateResult> updateArea(String id, Area area);

    Mono<DeleteResult> deleteAreaById(String id);

    Mono<Area> getAreaById(String id);

    Flux<Area> getAreas(String name, List<String> radarIds);
}
