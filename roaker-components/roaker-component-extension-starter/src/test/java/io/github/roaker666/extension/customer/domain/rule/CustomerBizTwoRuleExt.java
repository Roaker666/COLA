package io.github.roaker666.extension.customer.domain.rule;

import io.github.roaker666.extension.Extension;
import io.github.roaker666.extension.customer.client.Constants;
import io.github.roaker666.extension.customer.domain.CustomerEntity;

/**
 * CustomerBizTwoRuleExt
 *
 * @author Frank Zhang
 * @date 2018-01-07 12:10 PM
 */
@Extension(bizId = Constants.BIZ_2)
public class CustomerBizTwoRuleExt implements CustomerRuleExtPt{

    @Override
    public boolean addCustomerCheck(CustomerEntity customerEntity) {
        //Any Customer can be added
        return true;
    }
}
