package com.app.model.domain;

import com.app.core.model.domain.BaseDomain;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = Area.COLLECTION_NAME)
public class Area extends BaseDomain {

    public static final String COLLECTION_NAME = "area";
    public static final String NAME_FIELD = "name";
    public static final String COORDINATE_X_FIELD = "coordinateX";
    public static final String COORDINATE_Y_FIELD = "coordinateY";
    public static final String RADARS_FIELD = "radars";
    public static final String CAMERAS_FIELD = "cameras";

    @Field(NAME_FIELD)
    private String name;

    @Field(COORDINATE_X_FIELD)
    private Integer coordinateX;

    @Field(COORDINATE_Y_FIELD)
    private Integer coordinateY;

    @Field(RADARS_FIELD)
    private List<Radar> radars;

    @Field(CAMERAS_FIELD)
    private List<Camera> cameras;
}
