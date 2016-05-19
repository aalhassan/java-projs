package java112.project3;

import java.util.*;
import java.io.*;

/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    mAlhassan
 */
public class PropertyBeans extends java.lang.Object {

    private  Set<String>  properyKeys;


    /**
     *  Defualt Constructor for the PropertyBeans object
     */
    public PropertyBeans() {
        properyKeys  = new TreeSet<String>();
    }
    
    /**
     *  Constructor for the PropertyBeans object
     */
    public PropertyBeans(Set<String>  properyKeys) {
        this();
        this.properyKeys  =  properyKeys;
    }

    /**
     *  Gets the properyKeys attribute of the PropertyBeans object
     *
     *@return    The properyKeys value
     */
    public  Set<String>  getProperyKeys() {
        return properyKeys;
    }


    /**
     *  Sets the properyKeys attribute of the PropertyBeans object
     *
     *@param  properyKeys  The new properyKeys value
     */
    public void setProperyKeys( Set<String>  properyKeys) {
        this.properyKeys = properyKeys;
    }

}
