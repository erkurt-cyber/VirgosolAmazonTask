package com.virgosol.pages;

import com.virgosol.utulities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage{

    public BasePage(){

        PageFactory.initElements(Driver.get(),this);
    }


}

