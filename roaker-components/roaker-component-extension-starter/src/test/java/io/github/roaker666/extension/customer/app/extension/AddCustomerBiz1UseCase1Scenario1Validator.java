package io.github.roaker666.extension.customer.app.extension;

import io.github.roaker666.extension.Extension;
import io.github.roaker666.extension.customer.client.AddCustomerCmd;
import io.github.roaker666.extension.customer.client.Constants;
import io.github.roaker666.extension.customer.app.extensionpoint.AddCustomerValidatorExtPt;

/**
 * AddCustomerBiz1UseCase1Scenario1Validator
 *
 * @author Frank Zhang
 * @date 2020-08-20 1:01 PM
 */
@Extension(bizId = Constants.BIZ_1, useCase = Constants.USE_CASE_1, scenario = Constants.SCENARIO_1)
public class AddCustomerBiz1UseCase1Scenario1Validator implements AddCustomerValidatorExtPt {
    public void validate(AddCustomerCmd addCustomerCmd) {
        System.out.println("Do validation for Biz_One's Use_Case_One's Scenario_One");
    }
}
