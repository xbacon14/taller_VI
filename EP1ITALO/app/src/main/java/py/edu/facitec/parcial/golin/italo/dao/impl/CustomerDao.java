package py.edu.facitec.parcial.golin.italo.dao.impl;

import android.content.Context;

import py.edu.facitec.parcial.golin.italo.dao.DBA;
import py.edu.facitec.parcial.golin.italo.model.Customer;

public class CustomerDao extends DBA<Customer> {
    public CustomerDao(Context context){
        init(context, Customer.class);
    }
}
