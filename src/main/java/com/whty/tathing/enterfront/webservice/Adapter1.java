
package com.whty.tathing.enterfront.webservice;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return (com.whty.tathing.enterfront.webservice.jaxb.XSDDateTimeCustomBinder.parseDateTime(value));
    }

    public String marshal(Date value) {
        return (com.whty.tathing.enterfront.webservice.jaxb.XSDDateTimeCustomBinder.printDateTime(value));
    }

}
