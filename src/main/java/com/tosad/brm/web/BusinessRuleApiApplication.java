package com.tosad.brm.web;

import org.glassfish.jersey.server.ResourceConfig;

public class BusinessRuleApiApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public BusinessRuleApiApplication() {

        packages("com.tosad.brm.web");

//		// register exception mappers
//		register(GenericExceptionMapper.class);
//		register(AppExceptionMapper.class);
//      register(CustomReasonPhraseExceptionMapper.class);
//		register(NotFoundExceptionMapper.class);
//
//		// register features
//		register(JacksonFeature.class);
        register(CORSResponseFilter.class);
//		property(EntityFilteringFeature.ENTITY_FILTERING_SCOPE, new Annotation[] {PodcastDetailedView.Factory.get()});
    }
}