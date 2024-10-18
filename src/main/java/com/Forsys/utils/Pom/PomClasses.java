package com.Forsys.utils.Pom;

import org.openqa.selenium.WebDriver;

import com.Forsys.exceptions.DriverNotCreatedException;
import com.Forsys.ui.actions.BrowserAction;

public class PomClasses {
    private WebDriver driver;
    private LoginUser browser;
    private QuoteCreation1 quote1;
    private OpportunityCreation1 opportunity1;
    private OrderActivation activation;
    private ProductConfigure configure1;
    private InvoiceCreation invoice;

    public PomClasses(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driver;
    }

    /**
     * Allows performing chainable actions on browser.
     * 
     * @return {@link BrowserAction}
     */
    public LoginUser loginuser() {
        if (browser == null) {
            browser = new LoginUser(driver);
        }
        return browser;
    }

    public OpportunityCreation1 opportunityCreation() {
        if (opportunity1 == null) {
            opportunity1 = new OpportunityCreation1(driver);
        }
        return opportunity1;
    }

    public QuoteCreation1 quoteCreation() {
        if (quote1 == null) {
            quote1 = new QuoteCreation1(driver);
        }
        return quote1;
    }

    public ProductConfigure productconfiguration() {
        if (configure1 == null) {
            configure1 = new ProductConfigure(driver);
        }
        return configure1;
    }

    public OrderActivation orderactivation() {
        if (activation == null) {
            activation = new OrderActivation(driver);
        }
        return activation;
    }

    public InvoiceCreation invoicecreation() {
        if (invoice == null) {
            invoice = new InvoiceCreation(driver);
        }
        return invoice;
    }

}
