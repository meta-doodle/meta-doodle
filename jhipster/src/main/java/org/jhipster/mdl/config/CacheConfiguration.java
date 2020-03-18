package org.jhipster.mdl.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import org.hibernate.cache.jcache.ConfigSettings;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, org.jhipster.mdl.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, org.jhipster.mdl.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, org.jhipster.mdl.domain.User.class.getName());
            createCache(cm, org.jhipster.mdl.domain.Authority.class.getName());
            createCache(cm, org.jhipster.mdl.domain.User.class.getName() + ".authorities");
            createCache(cm, org.jhipster.mdl.domain.WorkflowModel.class.getName());
            createCache(cm, org.jhipster.mdl.domain.WorkflowModel.class.getName() + ".wfsinstances");
            createCache(cm, org.jhipster.mdl.domain.WorkflowInstance.class.getName());
            createCache(cm, org.jhipster.mdl.domain.WorkflowInstance.class.getName() + ".stepUserAnswers");
            createCache(cm, org.jhipster.mdl.domain.WorkflowInstance.class.getName() + ".steps");
            createCache(cm, org.jhipster.mdl.domain.WorkflowInstance.class.getName() + ".guests");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName());
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".workflows");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".stepUserAnswers");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".workflowInstances");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".participants");
            createCache(cm, org.jhipster.mdl.domain.Step.class.getName());
            createCache(cm, org.jhipster.mdl.domain.Answer.class.getName());
            createCache(cm, org.jhipster.mdl.domain.StepUserAnswerWfInstance.class.getName());
            createCache(cm, org.jhipster.mdl.domain.StepUserAnswerWfInstance.class.getName() + ".answers");
            createCache(cm, org.jhipster.mdl.domain.WorkflowModel.class.getName() + ".workflowInstances");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".wfModelCreateds");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".wfInstanceCreateds");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".wfInstanceParticipateds");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".createdWfModels");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".createdWfInstances");
            createCache(cm, org.jhipster.mdl.domain.MdlUser.class.getName() + ".memberWfInstances");
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache != null) {
            cm.destroyCache(cacheName);
        }
        cm.createCache(cacheName, jcacheConfiguration);
    }

}
