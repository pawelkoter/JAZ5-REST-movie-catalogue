package rest;


import domain.Comment;
import domain.Movie;
import service.MoviesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movies")
public class MoviesResources {
    private MoviesService moviesDB = new MoviesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAll() {
        return moviesDB.getAll();
    }

    @GET
    @Path( "/{id}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam( "id" ) int id){
        Movie result =  moviesDB.get( id );

        if (result != Movie.NULL ) {
            return Response.ok( result ).build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Movie movie) {
        moviesDB.add(movie);
        return Response.ok(movie.getId()).build();
    }

    @PUT
    @Path( "/{id}" )
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam( "id" ) int id, Movie movie) {
        movie.setId( id );
        try {
            moviesDB.update( movie );
            return Response.ok().build();
        } catch ( RuntimeException e ) {
            return Response.status( Response.Status.NOT_FOUND )
                    .entity( e.getMessage() )
                    .build();
        }
    }

    @DELETE
    @Path( "/{id}" )
    public Response delete(@PathParam( "id" ) int id) {
        if (moviesDB.delete( id )) {
            return Response.ok().build();
        }
        else {
            return Response.status( Response.Status.NOT_FOUND ).build();
        }
    }

    @GET
    @Path( "/{movieId}/comments" )
    @Produces(MediaType.APPLICATION_JSON)
    public List< Comment > getComments( @PathParam( "movieId" ) int movieId){
        return moviesDB.get( movieId ).getComments();
    }
}
