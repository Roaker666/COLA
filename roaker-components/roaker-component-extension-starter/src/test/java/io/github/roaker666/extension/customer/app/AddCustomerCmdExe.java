package io.github.roaker666.extension.customer.app;

import io.github.roaker666.dto.Response;
import io.github.roaker666.extension.ExtensionExecutor;
import io.github.roaker666.extension.customer.app.extensionpoint.AddCustomerValidatorExtPt;
import io.github.roaker666.extension.customer.app.extensionpoint.CustomerConvertorExtPt;
import io.github.roaker666.extension.customer.client.AddCustomerCmd;
import io.github.roaker666.extension.customer.domain.CustomerEntity;
import io.github.roaker666.extension.customer.infrastructure.DomainEventPublisher;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AddCustomerCmdExe
 *
 * @author Frank Zhang 2018-01-06 7:48 PM
 */
@Component
public class AddCustomerCmdExe {

    private Logger logger = LoggerFactory.getLogger(AddCustomerCmd.class);

    @Resource
    private ExtensionExecutor extensionExecutor;

    @Resource
    private DomainEventPublisher domainEventPublisher;


    public Response execute(AddCustomerCmd cmd) {
        logger.info("Start processing command:" + cmd);

        //validation
        extensionExecutor.executeVoid(AddCustomerValidatorExtPt.class, cmd.getBizScenario(), extension -> extension.validate(cmd));

        //Convert CO to Entity
        CustomerEntity customerEntity = extensionExecutor.execute(CustomerConvertorExtPt.class, cmd.getBizScenario(), extension -> extension.clientToEntity(cmd));

        //Call Domain Entity for business logic processing
        logger.info("Call Domain Entity for business logic processing..."+customerEntity);
        customerEntity.addNewCustomer();

        //domainEventPublisher.publish(new CustomerCreatedEvent());
        logger.info("End processing command:" + cmd);
        return Response.buildSuccess();
    }
}
