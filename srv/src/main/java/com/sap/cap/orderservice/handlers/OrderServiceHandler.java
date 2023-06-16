package com.sap.cap.orderservice.handlers;

import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsDeleteEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import cds.gen.productservice.ProductService_;
import cds.gen.productservice.Products_;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@ServiceName(ProductService_.CDS_NAME)
public class OrderServiceHandler implements EventHandler {

    @On(event = CqnService.EVENT_CREATE, entity = Products_.CDS_NAME)
    public void onCreate(CdsCreateEventContext context) {
        log.info(" --- INFO --- [ Product is publishing! ] ");
        log.info(context.getCqn().entries().toString());
    }

    @On(event = CqnService.EVENT_READ, entity = Products_.CDS_NAME)
    public void onRead(CdsReadEventContext context) {
        log.info(" --- INFO --- [ Products are fetching! ] ");
    }

    @On(event = CqnService.EVENT_DELETE, entity = Products_.CDS_NAME)
    public void onDelete(CdsDeleteEventContext context) {
        log.info(" --- INFO --- [ Product deleted! ] ");
        log.info(context.getCqn().asDelete().toString());
    }
}
