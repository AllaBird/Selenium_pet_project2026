package com.ecommerce.trait;

import com.ecommerce.components.LeftSideBar;
import com.ecommerce.page.BaseSalesPage;

public interface HasLeftSideBarTrait<Self extends BaseSalesPage> {

   @SuppressWarnings("unchecked")
    default LeftSideBar<Self> getLeftSideBar() {
        return new LeftSideBar<>((Self) this);
    }
}
