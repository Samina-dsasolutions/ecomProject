package com.alibou.ecommerce.order;


import com.alibou.ecommerce.OrderLine.OrderLineRequest;
import com.alibou.ecommerce.OrderLine.OrderLineService;
import com.alibou.ecommerce.customer.CustomerClient;
import com.alibou.ecommerce.exception.BusinessException;
import com.alibou.ecommerce.kafka.OrderConfirmation;
import com.alibou.ecommerce.kafka.OrderProducer;
import com.alibou.ecommerce.product.ProductClient;
import com.alibou.ecommerce.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final Ordermapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    public Integer createOrder(@Valid OrderRequest request) {
       var customer=this.customerClient.findCustomerById(request.customerId())
               .orElseThrow(()-> new BusinessException("can not create order:: no customer exist with provided id"));


       var purchaseProducts =  this.productClient.purchaseProduct(request.products());
       var order=this.repository.save(mapper.toOrder(request));

       for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
       }



        //todo : start payment process

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchaseProducts
                )
        );


        return order.getId();
    }
}
