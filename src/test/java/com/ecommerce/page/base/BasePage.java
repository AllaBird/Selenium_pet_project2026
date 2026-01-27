package com.ecommerce.page.base;

import com.ecommerce.components.Header;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseModel{

    private Header header;

    public BasePage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    public Header getHeader() {
        return header;
    }
}
