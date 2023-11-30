package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.services.OrderService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Path("/orders")
public class OrderResources {
    @Inject
    private OrderService orderService;
    @POST
    @Produces("application/json")
    public Response insertOrder(Order o){
        orderService.insertOrder(o);
        return Response.ok(o).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getEmployeeById(@PathParam("id") long id) {
        Order o = orderService.getOrderById(id);
        if (o != null) {
            return Response.ok(o).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @POST
    @Produces("application/json")
    public Response updateOrder( Order order, LocalDate date) {
        orderService.updateOrder(order, date);
        return Response.ok(order).build();
    }

    @GET
    @Path("/by-date")
    public Response getOrdersByDate(@QueryParam("orderDate") LocalDate date) {

        List<Order> orders = orderService.getOrderByDate(date);

        return Response.ok(orders).build();
    }

}
