package io.github.roaker666.extension.customer.app;

import io.github.roaker666.dto.Response;
import io.github.roaker666.dto.SingleResponse;
import io.github.roaker666.extension.customer.client.AddCustomerCmd;
import io.github.roaker666.extension.customer.client.CustomerDTO;
import io.github.roaker666.extension.customer.client.CustomerServiceI;
import io.github.roaker666.extension.customer.client.GetOneCustomerQry;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 *
 * @author Frank Zhang 2018-01-06 7:40 PM
 */
@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private AddCustomerCmdExe addCustomerCmdExe;

    @Resource
    private GetOneCustomerQryExe getOneCustomerQryExe;


    @Override
    public Response addCustomer(AddCustomerCmd addCustomerCmd) {
        return addCustomerCmdExe.execute(addCustomerCmd);
    }

    @Override
    public SingleResponse<CustomerDTO> getCustomer(GetOneCustomerQry getOneCustomerQry) {
        return getOneCustomerQryExe.execute(getOneCustomerQry);
    }
}
