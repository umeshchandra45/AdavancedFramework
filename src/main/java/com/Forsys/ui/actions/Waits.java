package com.Forsys.ui.actions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Forsys.api.report.ExtentReportListener;

public class Waits {
    private static final String TYPED = "<b>Typed</b> %s on %s";
    private static final int DEFAULT_PageLoad_TIMEOUT_IN_SECOND = 80;
    private static final int DEFAULT_Time_Interval_IN_MilliSECOND = 500;
    private static final int DEFAULT_Time_Interval_IN_LongMilliSECOND = 2000;
    private static final int DEFAULT_Element_TIMEOUT_IN_SECONDS = 5;
    private WebElement element;
    private WebDriver driver;
    private List<WebElement> elements;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageLoaded() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                                                .withTimeout(Duration.ofSeconds(DEFAULT_PageLoad_TIMEOUT_IN_SECOND))
                                                                .pollingEvery(Duration.ofMillis(DEFAULT_Time_Interval_IN_MilliSECOND))
                                                                .ignoring(NoSuchElementException.class)
                                                                .withMessage("The message you will see in if a TimeoutException is thrown");
        wait.until(AdditionalConditions.pageloadingFinished());
    }

    public void waitUntilElementReliableFound(By selector, int timeout) throws InterruptedException {
        long endTime = System.currentTimeMillis() + Duration.ofSeconds(timeout).toMillis();
        while (System.currentTimeMillis() < endTime) {
            try {
                if (driver.findElement(selector).isDisplayed()) {
                    return;
                }
            } catch (NoSuchElementException ignored) {
            }
            Thread.sleep(250);
        }
        ExtentReportListener.extent_test.get().info("Could not find " + selector);
        throw new NoSuchElementException("Could not find " + selector);
    }

    public void waitUntilElementReliableFound(WebElement selector, int timeout) throws InterruptedException {
        long endTime = System.currentTimeMillis() + Duration.ofSeconds(timeout).toMillis();
        while (System.currentTimeMillis() < endTime) {
            try {
                if (selector.isDisplayed()) {
                    return;
                }
            } catch (NoSuchElementException ignored) {
            }
            Thread.sleep(250);
        }
        ExtentReportListener.extent_test.get().info("Could not find " + selector);
        throw new NoSuchElementException("Could not find " + selector);
    }

    @SuppressWarnings("unchecked")
    public WebElement waitUntilElementFound(final By byelement, int timeout) {
        try {
            Wait fluentWait = getFluentWaitObject(driver, timeout);
            element = (WebElement) fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(byelement);
                }
            });
        } catch (TimeoutException ex) {
            ExtentReportListener.extent_test.get().info(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return element;
    }

    @SuppressWarnings("unchecked")
    public WebElement waitUntilElementFound(final WebElement byelement, int timeout) {
        try {
            Wait fluentWait = getFluentWaitObject(driver, timeout);
            element = (WebElement) fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return byelement;
                }
            });
        } catch (TimeoutException ex) {
            ExtentReportListener.extent_test.get().info(ex.getMessage());
        }
        return element;
    }

    public WebElement waitUntilElementTobeDisplayed(By byelement) {
        return waitUntilElementTobeDisplayed(byelement, DEFAULT_Time_Interval_IN_MilliSECOND);
    }

    /**
     * This method periodically checks for the clickability of the given element until either the
     * element is clickable or the given timeout exceeds. Once the element is clickable, it returns
     * back that element.
     **/
    public WebElement waitUntilElementTobeDisplayed(final By byelement, int timeout) {
        try {
            Wait<WebDriver> fluentWait = getFluentWaitObject(driver, timeout);
            element = fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    if (driver.findElement(byelement).isDisplayed()) {
                        return driver.findElement(byelement);
                    } else {
                        return null;
                    }
                }
            });
        } catch (TimeoutException ex) {
            ExtentReportListener.extent_test.get().info(ex.getMessage());
        }
        return element;
    }

    public WebElement waitUntilElementTobeDisplayed(final WebElement byelement, int timeout) {
        try {
            Wait<WebDriver> fluentWait = getFluentWaitObject(driver, timeout);
            element = fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    if (byelement.isDisplayed()) {
                        return byelement;
                    } else {
                        return null;
                    }
                }
            });
        } catch (TimeoutException ex) {
            ExtentReportListener.extent_test.get().info(ex.getMessage());
        }
        return element;
    }

    public List<WebElement> waitUntilElementsFound(By byelement) {
        return waitUntilElementsFound(byelement, DEFAULT_Element_TIMEOUT_IN_SECONDS);
    }

    @SuppressWarnings("unchecked")
    public List<WebElement> waitUntilElementsFound(final By byelement, int timeout) {
        try {
            Wait fluentWait = getFluentWaitObject(driver, timeout);
            elements = (List<WebElement>) fluentWait.until(new Function<WebDriver, List<WebElement>>() {
                @Override
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(byelement);
                }
            });
        } catch (TimeoutException ex) {
            ExtentReportListener.extent_test.get().info(ex.getMessage());
        }
        return elements;
    }

    private Wait getFluentWaitObject(WebDriver driver, int timeout) {
        Wait fluentWait = new FluentWait(driver).withTimeout(timeout, TimeUnit.SECONDS)
                                                .pollingEvery(DEFAULT_Time_Interval_IN_LongMilliSECOND,
                                                              TimeUnit.MILLISECONDS)
                                                .ignoring(NoSuchElementException.class);
        return fluentWait;
    }

    public void waitUntilElementDisappear(WebElement byelement) {
        waitUntilElementDisappear(byelement, DEFAULT_Element_TIMEOUT_IN_SECONDS);

    }

    public void waitUntilElementDisappear(final WebElement byelement, int timeout) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait(driver).withTimeout(timeout, TimeUnit.SECONDS)
                                                               .pollingEvery(DEFAULT_Time_Interval_IN_LongMilliSECOND,
                                                                             TimeUnit.MILLISECONDS)
                                                               .ignoring(NoSuchElementException.class);
            fluentWait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    try {
                        return !(byelement.isDisplayed());
                    } catch (NoSuchElementException e) {
                        // Returns true because the element is not present in DOM. The
                        // try block checks if the element is present but is invisible.
                        return true;
                    } catch (StaleElementReferenceException e) {
                        // Returns true because stale element reference implies that element
                        // is no longer visible.
                        return true;
                    }
                }
            });
        } catch (TimeoutException ex) {
            ExtentReportListener.extent_test.get().info(ex.getMessage());
        }
    }

    public void waitUntilElementDisappear(By byelement) {
        waitUntilElementDisappear(byelement, DEFAULT_Element_TIMEOUT_IN_SECONDS);
    }

    public void waitUntilElementDisappear(final By byelement, int timeout) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait(driver).withTimeout(timeout, TimeUnit.SECONDS)
                                                               .pollingEvery(DEFAULT_Time_Interval_IN_LongMilliSECOND,
                                                                             TimeUnit.MILLISECONDS)
                                                               .ignoring(NoSuchElementException.class);
            fluentWait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    try {
                        return !(driver.findElement(byelement).isDisplayed());
                    } catch (NoSuchElementException e) {
                        // Returns true because the element is not present in DOM. The
                        // try block checks if the element is present but is invisible.
                        return true;
                    } catch (StaleElementReferenceException e) {
                        // Returns true because stale element reference implies that element
                        // is no longer visible.
                        return true;
                    }
                }
            });
        } catch (TimeoutException ex) {
            ExtentReportListener.extent_test.get().info(ex.getMessage());
        }
    }

    public void waituntilElementIsDisplayedAndClick(final WebElement elementToWaitFor) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_PageLoad_TIMEOUT_IN_SECOND);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    Boolean flag = elementToWaitFor.isDisplayed() && elementToWaitFor.isEnabled();
                    if (flag) {
                        elementToWaitFor.click();
                    } else {
                        return (false);
                    }
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        });
    }

    public void waituntilElementIsDisplayedAndClick(final By elementToWaitFor) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_PageLoad_TIMEOUT_IN_SECOND);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    Boolean flag = driver.findElement(elementToWaitFor).isDisplayed() && driver.findElement(
                                                                                                            elementToWaitFor)
                                                                                               .isEnabled();
                    if (flag) {
                        driver.findElement(elementToWaitFor).click();
                    } else {
                        return (false);
                    }

                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        });
    }

    public void waituntilElementwritable(final WebElement byelement, final String value) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_PageLoad_TIMEOUT_IN_SECOND);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                if (byelement.isEnabled()) {
                    try {
                        byelement.sendKeys(value);
                        ExtentReportListener.extent_test.get().info(String.format(TYPED, value, byelement));
                    } catch (Exception e) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

    public void waituntilElementwritable(final By elementToWaitFor, final String value) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_PageLoad_TIMEOUT_IN_SECOND);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                if (driver.findElement(elementToWaitFor).isEnabled()) {
                    try {
                        driver.findElement(elementToWaitFor).sendKeys(value);
                        ExtentReportListener.extent_test.get().info(String.format(TYPED, value, elementToWaitFor));
                    } catch (Exception e) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

    public void elementWait(final By elemebt, int timeout) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
                                                                    .pollingEvery(Duration.ofMillis(DEFAULT_Time_Interval_IN_LongMilliSECOND))
                                                                    .ignoring(NoSuchElementException.class)
                                                                    .withMessage("The message you will see in if a TimeoutException is thrown");
            wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(elemebt);
                }
            });
        } catch (Exception e) {
        }
    }

    public void elementWait(final WebElement elemebt, int timeout) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
                                                                    .pollingEvery(Duration.ofMillis(DEFAULT_Time_Interval_IN_LongMilliSECOND))
                                                                    .ignoring(NoSuchElementException.class)
                                                                    .ignoring(NoSuchElementException.class)
                                                                    .withMessage("The message you will see in if a TimeoutException is thrown");
            wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return elemebt;
                }
            });
        } catch (Exception e) {
        }
    }

}
