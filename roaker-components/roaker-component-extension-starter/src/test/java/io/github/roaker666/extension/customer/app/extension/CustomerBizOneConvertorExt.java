package io.github.roaker666.extension.customer.app.extension;

import io.github.roaker666.extension.Extension;
import io.github.roaker666.extension.customer.app.extensionpoint.CustomerConvertorExtPt;
import io.github.roaker666.extension.customer.client.AddCustomerCmd;
import io.github.roaker666.extension.customer.client.Constants;
import io.github.roaker666.extension.customer.client.CustomerDTO;
import io.github.roaker666.extension.customer.domain.CustomerEntity;
import io.github.roaker666.extension.customer.domain.SourceType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CustomerBizOneConvertorExt
 *
 * @author Frank Zhang
 * @date 2018-01-07 3:05 AM
 */
@Extension(bizId = Constants.BIZ_1)
public class CustomerBizOneConvertorExt  implements CustomerConvertorExtPt {

    @Autowired
    private CustomerConvertor customerConvertor;//Composite basic convertor to do basic conversion

    @Override
    public CustomerEntity clientToEntity(AddCustomerCmd addCustomerCmd){
        CustomerEntity customerEntity = customerConvertor.clientToEntity(addCustomerCmd);
        CustomerDTO customerDTO =addCustomerCmd.getCustomerDTO();
        //In this business, AD and RFQ are regarded as different source
        if(Constants.SOURCE_AD.equals(customerDTO.getSource()))
        {
            customerEntity.setSourceType(SourceType.AD);
        }
        if (Constants.SOURCE_RFQ.equals(customerDTO.getSource())){
            customerEntity.setSourceType(SourceType.RFQ);
        }
        return customerEntity;
    }
}
