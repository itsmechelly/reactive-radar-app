package com.app.controller;

import com.app.model.dto.area.AreaRequestDto;
import com.app.model.dto.area.AreaResponseDto;
import com.app.core.exception.AppErrorResponse;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.lang.Nullable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Tag(name = "Area Controller", description = "Area Controller")
@RequestMapping(path = "/api/v1/area", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE})
public interface AreaController {

    @PostMapping()
    @Operation(summary = "create area")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create area response"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Mono<AreaResponseDto> createArea(@RequestBody @Valid AreaRequestDto areaRequestDto);

    @PutMapping("{id}")
    @Operation(summary = "update area")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update area response"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Mono<UpdateResult> updateArea(@PathVariable(value = "id") String id, @RequestBody @Valid AreaRequestDto areaRequestDto);

    @DeleteMapping("{id}")
    @Operation(summary = "delete area by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete area response"),
            @ApiResponse(responseCode = "204", description = "No matching data", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Mono<DeleteResult> deleteAreaById(@PathVariable(value = "id") String id);

    @GetMapping("{id}")
    @Operation(summary = "get area by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get area by id response"),
            @ApiResponse(responseCode = "204", description = "No matching data", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "NOt Found", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Mono<AreaResponseDto> getAreaById(@PathVariable(value = "id") String id);

    @GetMapping()
    @Operation(summary = "get areas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get areas"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = AppErrorResponse.class)))})
    Flux<AreaResponseDto> getAreas(@RequestParam(value = "name") @Nullable String name, @RequestParam(value = "radarIds") @Nullable List<String> radarIds);
}
