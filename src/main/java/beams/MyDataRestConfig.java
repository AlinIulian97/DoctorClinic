package beams;

import beams.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        System.out.println("configureRepositoryRestConfiguration method called!");
        //disable HTTP methods for Product: PUTT , POST and DELETE
        ExposureConfiguration configuration = config.getExposureConfiguration();

        configuration.forDomainType(Doctor.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(HttpMethod.POST))
                .disablePutForCreation();

        //callan internal helper method
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity ids
        //

        // get a list of all enity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array of the entity type
        List<Class> entityClasses = new ArrayList<>();

        // get the entity types for rhe  entities
        for (EntityType<?> tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // - expose the enitity ids for the array of entity/domain types
        Class[] domaintTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domaintTypes);

    }
}

