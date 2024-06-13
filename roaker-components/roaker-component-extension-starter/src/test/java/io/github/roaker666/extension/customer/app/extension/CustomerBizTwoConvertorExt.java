package io.github.roaker666.extension.customer.app.extension;

import io.github.roaker666.extension.Extension;
import io.github.roaker666.extension.customer.app.extensionpoint.CustomerConvertorExtPt;
import io.github.roaker666.extension.customer.client.AddCustomerCmd;
import io.github.roaker666.extension.customer.client.Constants;
import io.github.roaker666.extension.customer.domain.CustomerEntity;
import io.github.roaker666.extension.customer.domain.SourceType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CustomerBizTwoConvertorExt
 *
 * @author Frank Zhang
 * @date 2018-01-07 3:05 AM
 */
@Extension(bizId = Constants.BIZ_2)
public class CustomerBizTwoConvertorExt implements CustomerConvertorExtPt {

    @Autowired
    private CustomerConvertor customerConvertor;//Composite basic convertor to do basic conversion

    @Override
    public CustomerEntity clientToEntity(AddCustomerCmd addCustomerCmd){
        CustomerEntity customerEntity = customerConvertor.clientToEntity(addCustomerCmd);
        //In this business, if customers from RFQ and Advertisement are both regarded as Advertisement
        if(Constants.SOURCE_AD.equals(addCustomerCmd.getCustomerDTO().getSource()) || Constants.SOURCE_RFQ.equals(addCustomerCmd.getCustomerDTO().getSource()))
        {
            customerEntity.setSourceType(SourceType.AD);
        }
        return customerEntity;
    }

}
