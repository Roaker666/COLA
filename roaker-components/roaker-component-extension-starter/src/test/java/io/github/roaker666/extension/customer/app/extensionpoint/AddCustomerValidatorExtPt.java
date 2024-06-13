package io.github.roaker666.extension.customer.app.extensionpoint;

import io.github.roaker666.extension.ExtensionPointI;
import io.github.roaker666.extension.customer.client.AddCustomerCmd;

/**
 * AddCustomerValidatorExtPt
 *
 * @author Frank Zhang
 * @date 2018-01-07 1:27 AM
 */
public interface AddCustomerValidatorExtPt extends ExtensionPointI {

    public void validate(AddCustomerCmd addCustomerCmd);
}
