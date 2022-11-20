package rest.utillities;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;
import io.swagger.jaxrs.config.BeanConfig;
import rest.ressource.GestionEmployé;

@ApplicationPath("/api")
public class RestActivator {

	public RestActivator() {
		super();
BeanConfig beanConfig = new BeanConfig();
		
		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8090");
		beanConfig.setBasePath("arije_grissiaa/api");
		beanConfig.setResourcePackage("rest.ressources");
		beanConfig.setScan(true);

		// TODO Auto-generated constructor stub
	}
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(GestionEmployé.class);
        // Available at localhost:port/swagger.json
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;

    }

}
