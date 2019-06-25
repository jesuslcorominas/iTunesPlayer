package com.talkao.lopezcorominas.data.di.module;

import org.modelmapper.ModelMapper;

import dagger.Module;
import dagger.Provides;

/**
 * @author Jesús López Corominas
 */
@Module
public class MapperModule {

    @Provides
    ModelMapper provideModelMapper() {
        return new ModelMapper();
    }


}
