package com.ecommerce.components;

import com.ecommerce.page.base.BaseModel;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent extends BaseModel {

    public BaseComponent(WebDriver driver) {
        super(driver);
    }
}
