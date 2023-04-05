package com.app.repository;

import com.app.model.domain.Area;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Repository
public class AreaRepositoryImpl implements AreaRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Area> createArea(final Area area) {
        log.info("createArea() for area: {}", area);
        return reactiveMongoTemplate.save(area, Area.COLLECTION_NAME);
    }

    @Override
    public Mono<UpdateResult> updateArea(final String id, final Area area) {
        log.info("updateArea(), for id: {}", id);

        Criteria criteria = Criteria.where("id").is(id);
        Query query = Query.query(criteria);

        Update update = new Update();
        update.set(Area.NAME_FIELD, area.getName());
        update.set(Area.COORDINATE_X_FIELD, area.getCoordinateX());
        update.set(Area.COORDINATE_Y_FIELD, area.getCoordinateY());
        update.set(Area.RADARS_FIELD, area.getRadars());
        update.set(Area.CAMERAS_FIELD, area.getCameras());

        return reactiveMongoTemplate.updateFirst(query, update, Area.class, Area.COLLECTION_NAME);
    }

    @Override
    public Mono<DeleteResult> deleteAreaById(final String id) {
        log.info("deleteAreaById(), for id: {}", id);

        final Criteria criteria = Criteria.where("id").is(id);
        final Query query = Query.query(criteria);

        return reactiveMongoTemplate.remove(query, Area.class, Area.COLLECTION_NAME);
    }

    @Override
    public Mono<Area> getAreaById(final String id) {
        log.info("getAreaById(), for id: {}", id);
        return reactiveMongoTemplate.findById(id, Area.class, Area.COLLECTION_NAME);
    }

    @Override
    public Flux<Area> getAreas(final String name, final List<String> radarIds) {
        log.info("getAreas() fetch from areaRepositoryImpl");

        final Criteria criteria = new Criteria();
        final Query query = Query.query(criteria);

        if (name != null) {
            log.info("getAreasByName, for name: {}", name);
            criteria.and(Area.NAME_FIELD).is(name);
            return reactiveMongoTemplate.find(query, Area.class, Area.COLLECTION_NAME);
        } else if (radarIds != null) {
            log.info("getAreasByRadarIds, for radarIds: {}", radarIds);
            criteria.and("radars._id").in(radarIds);
            return reactiveMongoTemplate.find(query, Area.class, Area.COLLECTION_NAME);
        } else
            log.info("getAreas() from areaRepositoryImpl");
        return reactiveMongoTemplate.findAll(Area.class, Area.COLLECTION_NAME);
    }
}
