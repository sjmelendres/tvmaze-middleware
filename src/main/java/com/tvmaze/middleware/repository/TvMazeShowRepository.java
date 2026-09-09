package com.tvmaze.middleware.repository;

import com.tvmaze.middleware.document.TvMazeShowDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TvMazeShowRepository extends MongoRepository<TvMazeShowDocument, Long> {
}