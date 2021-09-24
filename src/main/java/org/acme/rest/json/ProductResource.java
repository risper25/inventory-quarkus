package org.acme.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private Set<Product> products = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    public ProductResource() {
        products.add(new Product(1,"bag"));
        products.add(new Product(2, "chair"));
    }

    @GET
    public Set<Product> list() {
        return products;
    }

    @POST
    public Set<Product> add(Product product) {
        products.add(product);
        return products;
    }
    @PUT
    

    @DELETE
    public Set<Product> delete(Product product) {
        products.removeIf(existingProduct -> existingProduct.productname.contentEquals(product.productname));
        return products;
    }

}